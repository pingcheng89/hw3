package com.systex.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class LotteryService {

	private int group;
	private String exclude;
	ArrayList<LinkedList<String>> result;
	
	public LotteryService(){	
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getExclude() {
		return exclude;
	}

	public void setExclude(String exclude) {
		this.exclude = exclude;
	}
	
	public ArrayList<LinkedList<String>> getResult() {
		return result;
	}

	public void setResult(ArrayList<LinkedList<String>> result) {
		this.result = result;
	}

	public ArrayList<LinkedList<String>> getNumbers(int groups,LinkedList<String> excludes) {
		ArrayList<LinkedList<String>> totallotteryNum = new ArrayList<>();
		
		for(int i = 0 ; i< groups ; i++) {
			LinkedList<String> lotteryNum = new LinkedList<>();
			while (lotteryNum.size() < 6) {
				int num = (int) (Math.random() * 49) + 1;
				if (!excludes.contains(Integer.toString(num)) &&!lotteryNum.contains(Integer.toString(num))) {
	                lotteryNum.add(Integer.toString(num));
	            }
			}
			Collections.sort(lotteryNum);
			totallotteryNum.add(lotteryNum);
		}
		return totallotteryNum;

	}
}
