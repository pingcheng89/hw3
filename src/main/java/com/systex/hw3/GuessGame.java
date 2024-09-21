package com.systex.hw3;

public class GuessGame {
	
	private int remains;
	private int luckyNumber;
	private int range;
	
	public GuessGame(int range,int remains){
		this.range = range;
		this.luckyNumber =  (int) (Math.random()*range) + 1;
		this.remains = remains;
	}

	public boolean guess(int number) {

		if (remains <= 0) {
            return false;
        }
		remains--;
        return number == luckyNumber;
	}

	public int getRemains() {
		return remains;
	}
	
	public int getRange() {
		return range;
	}

	public int getLuckyNumber() {
		return luckyNumber;
	}
	
}
