package edu.eci.arsw.threads;

import java.lang.Thread;

public class CountThreadsMain {
	public static void main(String args[]) {
		CountThread t = new CountThread(10);
		Thread thread = new Thread(t);

		thread.start();
	}
}
