package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testInitBoard() {
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
	
	//@Test
	public void testInitMines() {
		Board testboard1 = new Board(1);
		int m[][] = testboard1.getBoard();
		int mines=0;
		
		//Buscar si hay 10 minas
		for(int i=0; i < 8; i++)
		{
			for(int j=0; j < 8; j++) {
				if(m[i][j]==5) {
					mines = mines+1;
				}
			}
		}
		assertEquals(mines,10);
		
		Board testboard2 = new Board(2);
		int m1[][] = testboard2.getBoard();
		int mines1=0;
		
		//Buscar si hay 10 minas
		for(int x=0; x < 16; x++)
		{
			for(int y=0; y < 16; y++) {
				if(m1[x][y]==5) {
					mines1 = mines1+1;
				}
			}
		}
		assertEquals(mines1,40);
		
		Board testboard3 = new Board(3);
		int m2[][] = testboard3.getBoard();
		int mines2=0;
		
		//Buscar si hay 10 minas
		for(int x=0; x < 16; x++)
		{
			for(int y=0; y < 30; y++) {
				if(m2[x][y]==5) {
					mines2 = mines2+1;
				}
			}
		}
		assertEquals(mines2,99);
	}

	@Test
	public void testInitBoard() {
		Board testboard = new Board(1);
		int b[][] = testboard.getBoard();
		
		//int[][] board_init = testboard.initBoard(8,8);
		//assertEquals(board_init,b);
		
		
	}

}
