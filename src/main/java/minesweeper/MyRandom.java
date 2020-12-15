package minesweeper;

import java.util.Random;

public class MyRandom {
	
	public int getRandomInteger(int min, int max) {
		Random ran = new Random();
		if(min <= max) { //check if the min number introduced is lower than the max
			return ran.nextInt((max - min) + 1) + min;	
		} else {
			return -1;
		}
	}
}
