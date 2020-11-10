package minesweeper;

import static org.junit.Assert.*;



import org.junit.Test;

public class BoardTest {

	@Test
	public void testInitBoard() {//We should test the LVL value we give to the Board constructor
		Board testboard = new Board(1); //8x8
		
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
											 {0, 0, 0, 3, 9, 0, 9, 3},
											 {0, 0, 0, 2, 9, 9, 9, 2},
											 {0, 0, 0, 1, 2, 3, 2, 1}};
			
	}
		 
	
	//@Test
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
					mines2 = mines1+1;
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
		assertTrue("Mines for lvl 1 should be 9 instead of " + mines1, (mines1 <= lvl1_invalid_lower) || (mines1 >= lvl1_invalid_higher));
		//Lvl2 has 40 bombs, we should test if we have more or less than 40 and show an error if we have a case
		int lvl2_invalid_lower = 39;
		int lvl2_invalid_higher = 41;
		assertTrue("Mines for lvl 2 should be 40 instead of " + mines2, (mines2 <= lvl2_invalid_lower) || (mines2 >= lvl2_invalid_higher));
		//Lvl3 has 99 bombs, we should test if we have more or less than 99 and show an error if we have a case
		int lvl3_invalid_lower = 98;
		int lvl3_invalid_higher = 100;
		assertTrue("Mines for lvl 3 should be 99 instead of " + mines3, (mines3 <= lvl3_invalid_lower) || (mines3 >= lvl3_invalid_higher));
		//Equivalence partitioning----
		
		//----Limit values
		//In this case we don't have a valid range, so we can only test individual numbers
		//Min 0, 9(invalid), 10(valid)
		
		assertTrue("Test not passed due to the mine value beeing lower than the limit value", mines1 <= lvl1_invalid_lower);
		//intermidiate 20, 39(invalid), 40 valid
		assertTrue("Test not passed due to the mine value beeing lower than the mid term value", mines2 <= lvl2_invalid_lower);
		//Max 100, 200(invalid), 99(valid)
		assertTrue("Test not passed due to the mine value beeing higher than the limit value", mines2 >= lvl3_invalid_higher);
		
		
		//Limit values----
	}
	
	

}
