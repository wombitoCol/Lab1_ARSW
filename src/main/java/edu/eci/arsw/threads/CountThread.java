package edu.eci.arsw.threads;

public class CountThread implements Runnable {
	private int upto;

	public CountThread (final int upto) {
		this.upto = upto;
	}

	@Override
	public void run () {
		for (int i = 0; i < this.upto; i++) {
			System.out.println("counting: " + i);
		}
	}
}
