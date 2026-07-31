package edu.eci.arsw.blacklistvalidator;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Range {

    private int from;
    private int upto;

    public Range (int f, int u) {
        this.from = f;
        this.upto = u;
    }

    public int getFrom () {
        return this.from;
    }

    public int getUpto () {
        return this.upto;
    }

    public void addToUpTo (int plus) {
        this.upto += plus;
    }
}

public class SearchByChunks {
    private static final int BLACK_LIST_ALARM_COUNT=5;

    public static boolean checkHosts (String whatIp, int chunks) {
        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        int nIPs = skds.getRegisteredServersCount();

        int each = nIPs / chunks;
        List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < chunks * each; i += each) {
            ranges.add(new Range(i, i + each));
        }

        Range last = ranges.get(ranges.size() - 1);
        last.addToUpTo(nIPs % chunks);

        List<SearchIP> sips = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < ranges.size(); i += 1) {
            Range range = ranges.get(i);
            SearchIP sip = new SearchIP(range.getFrom(), range.getUpto(), whatIp);

            Thread t = new Thread(sip);
            threads.add(t);
            sips.add(sip);
        }

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int total = 0;
        for (int i = 0; i < sips.size(); i++) {
            total += sips.get(i).getInstances();
        }

        boolean isSafe = total < BLACK_LIST_ALARM_COUNT;
        if (!isSafe) {
            skds.reportAsNotTrustworthy(whatIp);
        }
        else {
            skds.reportAsTrustworthy(whatIp);
        }
        return isSafe;
    }

    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
}
