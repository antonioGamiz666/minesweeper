package minesweeper;

import java.util.Arrays;
import java.util.Random;
public class Board {
	

	protected int[][] board;
	private int[][] boardUser;
	public boolean lose;
	public boolean win;
	public int opned;
	
	public int num_rows;
	public int num_columns;

	private int num_mines;
	
	private final int LVL1_ROWS = 8;
	private final int LVL1_COLS = 8;
	private final int LVL1_MINES = 10;
		
	private final int Empty_cell_value = 0;
	private final int Score_1_value = 1;
	private final int Score_2_value = 2;
	private final int Score_3_value = 3;
	
	private final int number_Score_1 = 16;
	private final int number_Score_2 = 12;
	private final int number_Score_3 = 8;
	
	public final int Mine_value = 9;

	public void setMines(int mines) {
		this.num_mines = mines;
	}
	
	public void setRows(int rows) {
		this.num_rows = rows;
	}
	
	public void setColumns(int columns) {
		this.num_columns = columns;
	}
	
	public void initMines() {
		
		//We have a matrix columns x row, generate 2 random
		//1 random for X and one for Y and generate until we place all the mines
		//check if num_mines is between 0 and 10 (max number of mines)
		if(this.num_mines >= 0 && this.num_mines <= 10) {
			//This variable is to be able to control how many bombs left to allocate
			int number_Mines_left = this.num_mines;		
			while(number_Mines_left > 0) {
					
				int posX = getRandomInteger(0, this.num_rows - 1); // Random integer to the position X of the bomb
				int posY = getRandomInteger(0, this.num_columns - 1); // Random integer to the position Y of the bomb
				if(board[posX][posY] != Mine_value) { // If there isn't a mine yet on this random position, we place it
					board[posX][posY] = Mine_value;
					number_Mines_left--;
				}
			}
		}
	}
	
	public int checkRightMines(int posX, int posY) {
		if(this.board[posX][posY+1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	public int checkLeftMines(int posX, int posY) {
		if(this.board[posX][posY-1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	public int checkTopMines(int posX, int posY) {
		if(this.board[posX-1][posY] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	public int checkBottomMines(int posX, int posY) {
		if(this.board[posX+1][posY] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	public int checkTopRightMines(int posX, int posY) {
		if(this.board[posX-1][posY+1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	public int checkTopLeftMines(int posX, int posY) {
		if(this.board[posX-1][posY-1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	public int checkBottomRightMines(int posX, int posY) {
		if(this.board[posX+1][posY+1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	public int checkBottomLeftMines(int posX, int posY) {
		if(this.board[posX+1][posY-1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	////////////////////////////////////////////////////////////
	
	private void checkRight(int posX, int posY) {
		this.openCell(posX,posY+1);		
	}
	
	private void checkLeft(int posX, int posY) {
		this.openCell(posX,posY-1);
	}
	
	private void checkTop(int posX, int posY) {
		this.openCell(posX-1,posY); 
	}
	
	private void checkBottom(int posX, int posY) {
		this.openCell(posX+1,posY);
	}
	
	private void checkTopRight(int posX, int posY) {
		this.openCell(posX-1,posY+1);
	}
	
	private void checkTopLeft(int posX, int posY) {
		this.openCell(posX-1,posY-1);
	}
	
	private void checkBottomRight(int posX, int posY) {
		this.openCell(posX+1,posY+1); 
	}
	
	private void checkBottomLeft(int posX, int posY) {
		this.openCell(posX+1,posY-1); 
	}

	public void initBoard() {
		
		if(this.num_rows == 8 && this.num_columns == 8) { //check that the dimensions are 8x8
			for(int i = 0; i < (this.num_rows); i++) {
				for(int j = 0; j < (this.num_columns); j++) {
					if( this.board[i][j] != this.Mine_value ) {
						this.board[i][j] = getAdjacent(i,j);
					}
				}
			}
		}
	}
	
	public int getAdjacent(int posX, int posY) {
		int value = 0;		
		if( posX == 0 ) { //first row
			if( posY == 0 ) {
				//top left corner
				value += this.checkRightMines(posX, posY);
				value += this.checkBottomMines(posX, posY);
				value += this.checkBottomRightMines(posX, posY);
			} else if(posY == this.num_columns - 1) {
				//top right corner
				value += this.checkLeftMines(posX, posY);
				value += this.checkBottomMines(posX, posY);
				value += this.checkBottomLeftMines(posX, posY);
			} else { 
				//top row
				value += this.checkLeftMines(posX, posY);
				value += this.checkRightMines(posX, posY);
				value += this.checkBottomRightMines(posX, posY);
				value += this.checkBottomLeftMines(posX, posY);
				value += this.checkBottomMines(posX, posY);
			}
		} else if(posX == this.num_rows - 1) { //last row
			if( posY == 0 ) {
				//bottom left corner
				value += this.checkRightMines(posX, posY);
				value += this.checkTopMines(posX, posY);
				value += this.checkTopRightMines(posX, posY);
			} else if(posY == this.num_columns - 1) {
				//bottom right corner
				value += this.checkLeftMines(posX, posY);
				value += this.checkTopMines(posX, posY);
				value += this.checkTopLeftMines(posX, posY);
			} else { 
				//last row
				value += this.checkLeftMines(posX, posY);
				value += this.checkRightMines(posX, posY);
				value += this.checkTopRightMines(posX, posY);
				value += this.checkTopLeftMines(posX, posY);
				value += this.checkTopMines(posX, posY);
			}
		} else if(posY == 0) {
			// first column
			value += this.checkTopMines(posX, posY);
			value += this.checkBottomMines(posX, posY);
			value += this.checkTopRightMines(posX, posY);
			value += this.checkBottomRightMines(posX, posY);
			value += this.checkRightMines(posX, posY);
		} else if(posY == this.num_columns - 1) {
			//last column
			value += this.checkTopMines(posX, posY);
			value += this.checkBottomMines(posX, posY);
			value += this.checkTopLeftMines(posX, posY);
			value += this.checkBottomLeftMines(posX, posY);
			value += this.checkLeftMines(posX, posY);
		} else {
			//mid field (check all the surrounding positions)
			value += this.checkTopMines(posX, posY);
			value += this.checkBottomMines(posX, posY);
			value += this.checkLeftMines(posX, posY);
			value += this.checkRightMines(posX, posY);
			value += this.checkTopLeftMines(posX, posY);
			value += this.checkBottomLeftMines(posX, posY);
			value += this.checkTopRightMines(posX, posY);
			value += this.checkBottomRightMines(posX, posY);
		}
		
		
		return value;
	}
		
	Board() {	
		this.num_rows = LVL1_ROWS;
		this.num_columns = LVL1_COLS;
		this.num_mines = LVL1_MINES;
		
		
		this.board = new int[num_rows][num_columns];
		this.boardUser = new int[this.num_rows][this.num_columns];
		this.lose=false;
		this.win=false;
		this.opned=0;
		this.initMines();
		this.initBoard();
		for(int i=0; i< this.num_rows; i++) {
			for(int j=0; j<this.num_columns; j++) {
				this.boardUser[i][j]=-1;
			}
		}
	}
	
	public int[][] getBoard(){
		return this.board;
	}
	
	public int[][] getBoardUser(){
		return this.boardUser;
	}
	
	public int setBoard(int[][] b) {
		this.board  = b;
		return 0;
	}
	
	public static int getRandomInteger(int min, int max) {
		Random ran = new Random();
		if(min <= max) { //check if the min number introduced is lower than the max
			return ran.nextInt((max - min) + 1) + min;	
		} else {
			return -1;
		}
	}
	
	public void openCell(int posX, int posY) {
		//Create a new board in the class, and with
		//the recurse function we can fill it every time
		//we expose a cell, then send it to the view to print it
		if((posX >=0 && posX < this.num_columns) && (posY >= 0 && posY < this.num_columns)) {
		//if it's 0 and the cell its not opened yet
			if( this.board[posX][posY] == this.Mine_value) {
				this.lose=true;
				for(int i=0; i < this.num_rows;i++) {
					for(int j=0; j <this.num_columns;j++) {
						if(this.board[i][j]==this.Mine_value) {
							this.boardUser[i][j]=this.board[i][j];
						}
					}
				}
			}else {
			
				if(board[posX][posY] == this.Empty_cell_value && boardUser[posX][posY] == -1) {
					this.boardUser[posX][posY] = this.Empty_cell_value;
					
					if( posX == 0 ) { //first row
						if( posY == 0 ) {
							//top left corner
							this.checkRight(posX, posY);
							this.checkBottom(posX, posY);
							this.checkBottomRight(posX, posY);
						} else if(posY == this.num_columns - 1) {
							//top right corner
							this.checkLeft(posX, posY);
							this.checkBottom(posX, posY);
							this.checkBottomLeft(posX, posY);
							
						} else { 
							//top row
							this.checkLeft(posX, posY);
							this.checkRight(posX, posY);
							this.checkBottomRight(posX, posY);
							this.checkBottomLeft(posX, posY);
							this.checkBottom(posX, posY);
						
						}
					} else if(posX == this.num_rows - 1) { //last row
						if( posY == 0 ) {
							//bottom left corner
							this.checkRight(posX, posY);
							this.checkTop(posX, posY);
							this.checkTopRight(posX, posY);
						} else if(posY == this.num_columns - 1) {
							//bottom right corner
							this.checkLeft(posX, posY);
							this.checkTop(posX, posY);
							this.checkTopLeft(posX, posY);
						
						} else { 
							//last row
							this.checkLeft(posX, posY);
							this.checkRight(posX, posY);
							this.checkTopRight(posX, posY);
							this.checkTopLeft(posX, posY);
							this.checkTop(posX, posY);
						
						}
					} else if(posY == 0) {
						// first column
						this.checkTop(posX, posY);
						this.checkBottom(posX, posY);
						this.checkTopRight(posX, posY);
						this.checkBottomRight(posX, posY);
						this.checkRight(posX, posY);
						
					} else if(posY == this.num_columns - 1) {
						//last column
						this.checkTop(posX, posY);
						this.checkBottom(posX, posY);
						this.checkTopLeft(posX, posY);
						this.checkBottomLeft(posX, posY);
						this.checkLeft(posX, posY);
						
					} else {
						this.checkTop(posX, posY);
						this.checkBottom(posX, posY);
						this.checkLeft(posX, posY);
						this.checkRight(posX, posY);
						this.checkTopLeft(posX, posY);
						this.checkBottomLeft(posX, posY);
						this.checkTopRight(posX, posY);
						this.checkBottomRight(posX, posY);
					}
				}else {
					if(boardUser[posX][posY] == -1)
					this.boardUser[posX][posY] = this.board[posX][posY];
				}
			}
		}
	}

}