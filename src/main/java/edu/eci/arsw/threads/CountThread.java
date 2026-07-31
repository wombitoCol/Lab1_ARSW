package edu.eci.arsw.threads;

public class CountThread implements Runnable {
	private int start;
	private int amount;
	private int finals;

	public CountThread (int start, int amount) {
		this.start = start;
		this.amount = amount;
	}

	@Override
	public void run () {
		for (int i = this.start; i < this.amount; i++) {
			System.out.println("counting: " + i);
			finals = i;
		}
	}

	public int getFinal () {
		return this.finals;
	}
}
