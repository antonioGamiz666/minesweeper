package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;


public class automatization1 {
	
	
	@Test
	public void automatization1()
	{
		 /*** 
		  For the first view we wanted to finish the game, but as we saw in the test cases there was no end to the game.  
		  To do this first view we played the game and we can see the final result in the image
		  ***/
		
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------Test 1------------------------");
		System.out.println("----------------------------------------------------------");
		
		MockBoard board = new MockBoard();
		GameView gv = new GameView();
		GameController testGC = new GameController();
		
		int matrix[][] = board.initMines(7);
		int[] pos = {0,0,0,7,7,0,4,0,2,2,3,2,4,2,4,4,4,5,4,7,5,5,5,6,5,7,6,5,6,7,7,7,3,1};
		
		MockInputKeyboard mockInput2 = new MockInputKeyboard(pos);
		
		board.setBoard(matrix);
		board.initBoard();
		int iteracion = 0;
		
		
		
		 while(board.lose == false && iteracion < pos.length) {
	            gv.printMatrix(board.getBoardUser());
	            System.out.println("\n");
	            int positionX = testGC.requestPosX(gv, mockInput2);
	            int positionY = testGC.requestPosY(gv, mockInput2);
	            iteracion+=2;
	            board.openCell(positionX, positionY);            
	        }
	        gv.printMatrix(board.getBoardUser());
	       assertEquals(true, false);
		
	}
	
	@Test
	public void automatization2()
	{

		 /*** 
		  In this view we wanted to lose the game, it was as simple as getting a mine, this works fine as we saw in the test case.
		  ***/
		
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------Test 2------------------------");
		System.out.println("----------------------------------------------------------");
		
		MockBoard board = new MockBoard();
		GameView gv = new GameView();
		GameController testGC = new GameController();
		
		int matrix[][] = board.initMines(7);
		int[] pos = {3,0};
		
		MockInputKeyboard mockInput2 = new MockInputKeyboard(pos);
		
		board.setBoard(matrix);
		board.initBoard();
		int iteracion = 0;
		
		
		
		 while(board.lose == false) {
	            gv.printMatrix(board.getBoardUser());
	            System.out.println("\n");
	            int positionX = testGC.requestPosX(gv, mockInput2);
	            int positionY = testGC.requestPosY(gv, mockInput2);
	            board.openCell(positionX, positionY);            
	        }
	        gv.printMatrix(board.getBoardUser());
	        assertEquals(board.lose, true);
	}
	
	@Test
	public void automatization3()
	{

		 /*** 
		 In this view we wanted to play again and try to open the four edges of the board, they all worked fine this time.
		  ***/
		
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------Test 3------------------------");
		System.out.println("----------------------------------------------------------");
		
		MockBoard board = new MockBoard();
		GameView gv = new GameView();
		GameController testGC = new GameController();
		
		int matrix[][] = board.initMines(8);
		int[] pos = {0,0,0,7,7,7,7,0};
		
		MockInputKeyboard mockInput2 = new MockInputKeyboard(pos);
		
		board.setBoard(matrix);
		board.initBoard();
		int iteracion = 0;
		
		 while(board.lose == false && iteracion < pos.length) {
	            gv.printMatrix(board.getBoardUser());
	            System.out.println("\n");
	            int positionX = testGC.requestPosX(gv, mockInput2);
	            int positionY = testGC.requestPosY(gv, mockInput2);
	            iteracion+=2;
	            board.openCell(positionX, positionY);            
	        }
	        gv.printMatrix(board.getBoardUser());
	        
	        int[][] boardUser = board.getBoardUser();
	        
	        
	        assertNotEquals(-1, boardUser[1][2]);
	        assertEquals(-1, boardUser[2][2]);
	        
	        assertEquals(-1, boardUser[0][6]);
	        assertNotEquals(-1,boardUser[1][6]);
	        
	        
	        assertNotEquals(-1, boardUser[6][0]);
	        assertNotEquals(-1, boardUser[2][7]);
	        assertNotEquals(-1, boardUser[7][6]);
	        
	        assertEquals(-1, boardUser[4][4]);
	        assertNotEquals(-1, boardUser[5][1]);
	        assertNotEquals(-1, boardUser[6][3]);
	       
	        
	}
	
	@Test
	public void automatization4()
	{

		 /*** 
		 In this view we wanted to play again and try to open the four edges of the board, they all worked fine this time.
		 ***/
		
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------Test 4------------------------");
		System.out.println("----------------------------------------------------------");
		
		MockBoard board[] = new MockBoard[3];
		GameView gv = new GameView();
		
		int intent = 0;
		int MAX_INBTENT = 3;
		
		while(intent < MAX_INBTENT)
		{
			System.out.println("----------------------------Map "+ (intent+1) + "---------------------------");
			board[intent] = new MockBoard();
			board[intent].initMines();
			board[intent].initBoard();
			gv.printMatrix(board[intent].getBoard());
			intent++;
		}
		
		assertNotEquals(board[0].getBoard(), board[1].getBoard());
		assertNotEquals(board[0].getBoard(), board[2].getBoard());
		assertNotEquals(board[2].getBoard(), board[1].getBoard());   
	}
	
	@Test
	public void automatization5()
	{
		 /*** 
		  We made another game to check if the game ends when we got a mine.
		  ***/
		
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------Test 5------------------------");
		System.out.println("----------------------------------------------------------");
		
		MockBoard board = new MockBoard();
		GameView gv = new GameView();
		GameController testGC = new GameController();
		
		int matrix[][] = board.initMines(7);
		int[] pos = {0,0,0,7,7,0,4,6,7};
		
		MockInputKeyboard mockInput2 = new MockInputKeyboard(pos);
		
		board.setBoard(matrix);
		board.initBoard();
		int iteracion = 0;
		
		
		
		 while(board.lose == false) {
	            gv.printMatrix(board.getBoardUser());
	            System.out.println("\n");
	            int positionX = testGC.requestPosX(gv, mockInput2);
	            int positionY = testGC.requestPosY(gv, mockInput2);
	            iteracion+=2;
	            board.openCell(positionX, positionY);            
	        }
        gv.printMatrix(board.getBoardUser());
        assertEquals(true, board.lose);
		
	}
	
	
	@Test
	public void automatization6()
	{

		 /*** 
		 We set a new board where there is all possible value from squares and check it if puts all numbers well.
		  ***/
		
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------Test 6------------------------");
		System.out.println("----------------------------------------------------------");
		
		MockBoard board = new MockBoard();
		GameView gv = new GameView();
		
		int matrix[][] = board.initMines(9);		
		board.setBoard(matrix);
		board.initBoard(); 
		
		gv.printMatrix(matrix);
        
        assertEquals(8, matrix[1][1]);
        assertEquals(7, matrix[1][3]);        
        assertEquals(6, matrix[2][4]);
        assertEquals(5, matrix[3][1]);  
        assertEquals(4, matrix[3][2]);
        assertEquals(3, matrix[1][5]);
        assertEquals(2, matrix[0][5]);        
        assertEquals(1, matrix[5][0]);
	       
	        
	}
	
	

}
