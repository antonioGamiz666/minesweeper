package minesweeper;

import static org.junit.Assert.*;
import java.util.Arrays;


import org.junit.Test;

public class BoardTest {

	@Test
	public void testInitBoard() {//We should test the LVL value we give to the Board constructor
		Board testboard = new Board(1); //8x8
		
		//----TDD TESTS
		int[][] b = new int[8][8];
		int[][] c = new int[8][8];
		b[0][0] = testboard.Mine_value;
		b[1][1] = testboard.Mine_value;
		
		testboard.setBoard(b);
		testboard.initBoard();
		c = testboard.getBoard();
		
		assertEquals(c[0][1], 2);
		assertEquals(c[2][2], 1);
		assertEquals(c[5][5], 0);
		//TDD TESTS----
		
		
		//----Equivalence partitioning
		int lvl1_valid_dim = 8;
		Board testboardlvl1 = new Board(1);
		int[][] testdimlvl1 = new int[8][8];
		//Do a getSize for the board matrix then make an assert equals
		int lvl1_invalid_lower = 7;
		int lvl1_invalid_higher = 9;
		//assertTrue("Dimension for lvl1 matrix should be 8x8 instead of " + getSize, (getsize <= lvl1_invalid_lower) || ( getsize >= lvl1_invalid_higher));
		
		int lvl2_valid_dim = 16;
		Board testboardlvl2 = new Board(2);
		int[][] testdimlvl2 = new int[16][16];
		//Do a getSize for the board matrix then make an assert equals
		int lvl2_invalid_lower = 15;
		int lvl2_invalid_higher = 17;
		//assertTrue("Dimension for lvl2 matrix should be 16x16 instead of " + getSize, (getsize <= lvl2_invalid_lower) || ( getsize >= lvl2_invalid_higher));

		
		
		int lvl3_valid_row = 16;
		int lvl3_valid_col = 30;
		Board testboardlvl3 = new Board(2);
		int[][] testdimlvl3 = new int[16][30];
		//Do a getSize for the board matrix then make an assert equals	
		int lvl1_invalid_lower_row = 15;
		int lvl1_invalid_higher_row = 17;
		//assertTrue("Dimension for lvl3 matrix should be 16x30 instead of " + getSize, (getsize <= lvl3_invalid_lower_row) || ( getsize >= lvl3_invalid_higher_row));
		int lvl1_invalid_lower_col = 39;
		int lvl1_invalid_higher_col = 41;
		//assertTrue("Dimension for lvl3 matrix should be 16x30 instead of " + getSize, (getsize <= lvl3_invalid_lower_col) || ( getsize >= lvl3_invalid_higher_col));
		
		
		
		
		//Equivalence partitioning----
		
		
		//----Limit values
		
		
		
		//Limit values----
	}
	
	@Test
	public void testAdjacentMineChecks() {
		//testing checkRightMines, checkLeftMines, checkTopMines, checkBottomMines, checkTopRightMines, checkTopLeftMines, checkBottomRightMines, checkBottomLeftMines
		//this functions only will return a 1 if there is a mine on the position it's checking. for example, checkRight will return a 1 if there is a mine right to the cell or a 0 if not
				
		int [][] inputTest = new int[][] {{9, 9, 9, 0, 0, 0, 0, 0}, // we will use the position 1,1 to check when THERE IS a mine
										  {9, 0, 9, 0, 0, 0, 0, 0},
										  {9, 9, 9, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0}, // we will use the position 6,6 to check when THERE ISN'T a mine
										  {0, 0, 0, 0, 0, 0, 0, 0}};
										  
		Board testBoard = new Board(1);
		testBoard.setBoard(inputTest);
										  			
		//test if there is a bomb
		assertTrue("EP", testBoard.checkTopMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkTopRightMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkRightMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkBottomRightMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkBottomMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkBottomLeftMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkLeftMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkTopLeftMines(1, 1) == 1);
	}
	
	@Test
	public void testInitBoard2() {
		Board testboard = new Board(1);
		int [][] test1 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0}};
									  
		int [][] expectedOut1 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0}};
										     
        int [][] test2 = new int[][] {{9, 9, 9, 9, 9, 9, 9, 9},
						        	  {9, 9, 9, 9, 9, 9, 9, 9},
						        	  {9, 9, 9, 9, 9, 9, 9, 9},
						        	  {9, 9, 9, 9, 9, 9, 9, 9},
						        	  {9, 9, 9, 9, 9, 9, 9, 9},
						        	  {9, 9, 9, 9, 9, 9, 9, 9},
						        	  {9, 9, 9, 9, 9, 9, 9, 9},
						        	  {9, 9, 9, 9, 9, 9, 9, 9}};
						        	  
		int [][] expectedOut2 = new int[][] {{9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9}};;
      	  									 
		int [][] test3 = new int[][] {{9, 0, 0, 0, 0, 0, 0, 9},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0},
									  {9, 0, 0, 0, 0, 0, 0, 9}};
									  
		int [][] expectedOut3 = new int[][] {{9, 1, 0, 0, 0, 0, 1, 9},
											 {1, 1, 0, 0, 0, 0, 1, 1},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {1, 1, 0, 0, 0, 0, 1, 1},
											 {9, 1, 0, 0, 0, 0, 1, 9}};
											 
		int [][] test4 = new int[][] {{0, 9, 0, 0, 0, 0, 9, 0},
			 						  {9, 9, 0, 0, 0, 0, 9, 9},
			 						  {0, 0, 0, 0, 0, 0, 0, 0},
			 						  {0, 0, 0, 0, 0, 0, 0, 0},
			 						  {0, 0, 0, 0, 0, 0, 0, 0},
			 						  {0, 0, 0, 0, 0, 0, 0, 0},
			 						  {9, 9, 0, 0, 0, 0, 9, 9},
			 						  {0, 9, 0, 0, 0, 0, 9, 0}};
			 						   
		int [][] expectedOut4 = new int[][] {{3, 9, 2, 0, 0, 2, 9, 3},
			 								 {9, 9, 2, 0, 0, 2, 9, 9},
			 								 {2, 2, 1, 0, 0, 1, 2, 2},
			 								 {0, 0, 0, 0, 0, 0, 0, 0},
			 								 {0, 0, 0, 0, 0, 0, 0, 0},
			 								 {2, 2, 1, 0, 0, 1, 2, 2},
			 								 {9, 9, 2, 0, 0, 2, 9, 9},
			 								 {3, 9, 2, 0, 0, 2, 9, 3}};
			 								  
		int [][] test5 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 9, 9, 9, 9, 9, 9, 0},
									  {0, 9, 0, 0, 0, 0, 9, 0},
									  {0, 9, 0, 0, 0, 0, 9, 0},
									  {0, 9, 0, 0, 0, 0, 9, 0},
									  {0, 9, 0, 0, 0, 0, 9, 0},
									  {0, 9, 9, 9, 9, 9, 9, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0}};
									  
		int [][] expectedOut5 = new int[][] {{1, 2, 3, 3, 3, 3, 2, 1},
											 {2, 9, 9, 9, 9, 9, 9, 2},
											 {3, 9, 5, 3, 3, 5, 9, 3},
											 {3, 9, 3, 0, 0, 3, 9, 3},
											 {3, 9, 3, 0, 0, 3, 9, 3},
											 {3, 9, 5, 3, 3, 5, 9, 3},
											 {2, 9, 9, 9, 9, 9, 9, 2},
											 {1, 2, 3, 3, 3, 3, 2, 1}};
											 
		int [][] test6 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
									  {0, 9, 9, 9, 0, 0, 0, 0},
									  {0, 9, 0, 9, 0, 0, 0, 0},
									  {0, 9, 9, 9, 0, 0, 0, 0},
									  {0, 0, 0, 0, 9, 9, 9, 0},
									  {0, 0, 0, 0, 9, 0, 9, 0},
									  {0, 0, 0, 0, 9, 9, 9, 0},
									  {0, 0, 0, 0, 0, 0, 0, 0}};
									  
		int [][] expectedOut6 = new int[][] {{1, 2, 3, 2, 1, 0, 0, 0},
											 {2, 9, 9, 9, 2, 0, 0, 0},
											 {3, 9, 8, 9, 3, 0, 0, 0},
											 {2, 9, 9, 9, 4, 3, 2, 1},
											 {1, 2, 3, 4, 9, 9, 9, 2},
											 {0, 0, 0, 3, 9, 8, 9, 3},
											 {0, 0, 0, 2, 9, 9, 9, 2},
											 {0, 0, 0, 1, 2, 3, 2, 1}};
		//test
		Board testboard1 = new Board(1);
		testboard.setBoard(test1);
		testboard.initBoard();
		assertArrayEquals(testboard.getBoard(), expectedOut1);
		testboard.setBoard(test2);
		testboard.initBoard();
		assertArrayEquals(testboard.getBoard(), expectedOut2);
		testboard.setBoard(test3);
		testboard.initBoard();
		assertArrayEquals(testboard.getBoard(), expectedOut3);
		testboard.setBoard(test4);
		testboard.initBoard();
		assertArrayEquals(testboard.getBoard(), expectedOut4);
		testboard.setBoard(test5);
		testboard.initBoard();
		assertArrayEquals(testboard.getBoard(), expectedOut5);
		testboard.setBoard(test6);
		testboard.initBoard();
		assertArrayEquals(testboard.getBoard(), expectedOut6);
	}
		 
	
	@Test
	public void testInitMines() {
		//----TDD TESTS
		Board testboard1 = new Board(1);
		int m1[][] = testboard1.getBoard();
		int mines1=0;
		
		//Search for 10 mines
		for(int i=0; i < 8; i++)//make a function???
		{
			for(int j=0; j < 8; j++) {
				if(m1[i][j]==9) {
					mines1 = mines1+1;
				}
			}
		}
		assertEquals(mines1,10);
		
		Board testboard2 = new Board(2);
		int m2[][] = testboard2.getBoard();
		int mines2=0;
		
		//Search for 40 mines
		for(int x=0; x < 16; x++)
		{
			for(int y=0; y < 16; y++) {
				if(m2[x][y]==9) {
					mines2 = mines2+1;
				}
			}
		}
		assertEquals(mines2,40);
		
		Board testboard3 = new Board(3);
		int m3[][] = testboard3.getBoard();
		int mines3=0;
		
		//Search for 99 mines
		for(int x=0; x < 16; x++)
		{
			for(int y=0; y < 30; y++) {
				if(m3[x][y]==9) {
					mines3 = mines3+1;
				}
			}
		}
		assertEquals(mines3,99);
		//TDD TESTS----
		
		//----Equivalence partitioning
		//Already tested for the valid values on TDD tested
		
		//SHOULD WE DO A NEW TEST EXECUTION??
		
		//Now we want to test the invalid values, THROW EXCEPTION???
		//Lvl1 has 10 bombs, we should test if we have more or less than 10 and show an error if we have a case
		int lvl1_invalid_lower = 9;
		int lvl1_invalid_higher = 11;
		assertTrue("Mines for lvl 1 should be 10 instead of " + mines1, (mines1 >= lvl1_invalid_lower) || (mines1 <= lvl1_invalid_higher));
		//Lvl2 has 40 bombs, we should test if we have more or less than 40 and show an error if we have a case
		int lvl2_invalid_lower = 39;
		int lvl2_invalid_higher = 41;
		assertTrue("Mines for lvl 2 should be 40 instead of " + mines2, (mines2 >= lvl2_invalid_lower) || (mines2 <= lvl2_invalid_higher));
		//Lvl3 has 99 bombs, we should test if we have more or less than 99 and show an error if we have a case
		int lvl3_invalid_lower = 98;
		int lvl3_invalid_higher = 100;
		assertTrue("Mines for lvl 3 should be 99 instead of " + mines3, (mines3 >= lvl3_invalid_lower) || (mines3 <= lvl3_invalid_higher));
		//Equivalence partitioning----
		
		//----Limit values
		//In this case we don't have a valid range, so we can only test individual numbers
		//Min 0, 9(invalid), 10(valid)
		
		assertTrue("Test not passed due to the mine value beeing lower than the limit value", mines1 >= lvl1_invalid_lower);
		//intermidiate 20, 39(invalid), 40 valid
		assertTrue("Test not passed due to the mine value beeing lower than the mid term value", mines2 >= lvl2_invalid_lower);
		//Max 100, 200(invalid), 99(valid)
		assertTrue("Test not passed due to the mine value beeing higher than the limit value", mines2 <= lvl3_invalid_higher);
		
		
		//Limit values----
	}
	
	@Test
	public void testopenCell() {
		//TDD
		Board testboard10 = new Board(1);
		int [][] input = new int[][] {{3, 9, 2, 0, 0, 2, 9, 3},
									 {9, 9, 2, 0, 0, 2, 9, 9},
									 {2, 2, 1, 0, 0, 1, 2, 2},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {2, 2, 1, 0, 0, 1, 2, 2},
									 {9, 9, 2, 0, 0, 2, 9, 9},
									 {3, 9, 2, 0, 0, 2, 9, 3}};
			 
		 testboard10.setBoard(input);
		 //Selecting any middle cell with value 0 should output the following matrix
		 int [][] expectedOu = new int[][] {{-1, -1, 2, 0, 0, 2, -1, -1},
										   {-1, -1, 2, 0, 0, 2, -1, -1},
										   {2, 2, 1, 0, 0, 1, 2, 2},
										   {0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0},
										   {2, 2, 1, 0, 0, 1, 2, 2},
										   {-1, -1, 2, 0, 0, 2, -1, -1},
										   {-1, -1, 2, 0, 0, 2, -1, -1}};
										   
		int [][] expectedOu1 = new int[][] {{3, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1}};
										   
	   int [][] expectedOu2  = new int[][] {{3, 9, -1, -1, -1, -1, 9, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, 9, -1, -1, -1, -1, 9, -1}};
										   
		int [][] expectedOu3= new int[][] {{3, 9, -1, -1, -1, -1, 9, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, 9, -1, -1, -1, -1, 9, 3}};
	   								   
		testboard10.openCell(0, 3);									   
		int [][]p = new int[8][8];
		p = testboard10.getBoardUser();
		assertArrayEquals(expectedOu, p);
		
		Board testboard11 = new Board(1);
		testboard11.setBoard(input);
		int [][]v = new int[8][8];
		testboard11.openCell(0, 0);	
		
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu1, v);
		
		//----TDD for opening a mine and losing
		testboard11.openCell(0, 1);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		//----Equivalence partitioning and Limit values
		//We already tested for a valid inputs
		//Now we are going to test invalid inputs
		//we should get the same out as the last one due to not opnening invalid values
		testboard11.openCell(-1, -1);
		assertArrayEquals(expectedOu2,v);
		testboard11.openCell(-1, 3);
		assertArrayEquals(expectedOu2,v);
		testboard11.openCell(8, 8);
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(7,7);
		assertArrayEquals(expectedOu3,v);
	
	}


}
