package minesweeper;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyRandomTest {
	
	@Test
	public void testGetRandomInteger() {
		MyRandom rnd = new MyRandom();
		//between 0,5
		int value = rnd.getRandomInteger(0,5);
		assertTrue(value >= 0 && value <= 5);
		//between 0,1
		value = rnd.getRandomInteger(0,1);
		assertTrue(value >= 0 && value <= 1);
		//between 0,0
		value = rnd.getRandomInteger(0,0);
		assertTrue(value >= 0 && value <= 0);
		//between 5,0
		value = rnd.getRandomInteger(5,0);
		assertTrue(value == -1);
		//between -1,0
		value = rnd.getRandomInteger(-1,0);
		assertTrue(value >= -1 && value <= 0);
		//between -2,-1
		value = rnd.getRandomInteger(-2,-1);
		assertTrue(value >= -2 && value <= -1);
	}
}
