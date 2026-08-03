package edu.eci.arsw.threads;

public class CountThreadsMain {
    private static int start;
    private static int last;
    private static int last2;
    private static int last3;

	public static void main(String args[]) {
        CountThread t = new CountThread(0, 99);
        CountThread l = new CountThread(t.getFinal(), 199);
        CountThread s = new CountThread(l.getFinal(), 299);
		Thread thread = new Thread(t);
        Thread thread2 = new Thread(l);
        Thread thread3 = new Thread(s);

		thread.start();
        thread2.start();
        thread3.start();

        /* Parte solicitada por el profesor */
        int start = 0, upto = 1;
        CountThread x = new CountThread(start, upto);
        Thread xx = new Thread(x);
        xx.start();
	}
}
