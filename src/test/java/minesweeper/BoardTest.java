package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testInitBoard() {
		Board testboard = new Board();
		int b[][] = new int[8][8];
		int[][] board_init = testboard.initBoard(8,8);
		assertEquals(board_init,b);
		
		
	}
	
	@Test
	public void testInitMines() {
		Board testboard1 = new Board();
		int b[][] = new int[8][8];
		int mines=0;
		b = testboard1.initMines(10, b);
		//Buscar si hay 10 minas
		for(int i=0; i < 8; i++)
		{
			for(int j=0; j < 8; j++) {
				if(b[i][j]==5) {
					mines = mines+1;
				}
			}
		}
		assertEquals(mines,10);
		//Mirar si hay un maximo de 3 minas por fila
	}

}
