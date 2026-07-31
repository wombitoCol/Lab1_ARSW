package edu.eci.arsw.blacklistvalidator;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;


public class SearchIP implements Runnable{
    private int instances = 0;
    private int from;
    private int upto;
    private String ip;

    public SearchIP (int f, int u, String ip) {
        this.from = f;
        this.upto = u;
        this.ip = ip;
        this.instances = 0;
    }

    public int getInstances () {
        return this.instances;
    }

    @Override
    public void run () {
        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        for (int i = this.from; i < skds.getRegisteredServersCount() && i < this.upto; i++) {
            if (skds.isInBlackListServer(i, this.ip)) {
                this.instances++;
            }
        }
    }
}
