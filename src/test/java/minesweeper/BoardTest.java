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
		testboard1.initMines(10, b);
		//Buscar si hay 10 minas
		//Mirar si hay un maximo de 3 minas por fila
	}

}
