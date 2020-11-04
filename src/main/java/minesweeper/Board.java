package minesweeper;

import java.util.Arrays;
import java.util.Random;
public class Board {
	

	private int[][] board;
	
	
	
	private int num_rows;
	private int num_columns;

	private int num_mines;
	
	private final int LVL1_ROWS = 8;
	private final int LVL1_COLS = 8;
	private final int LVL1_MINES = 10;
	
	private final int LVL2_ROWS = 16;
	private final int LVL2_COLS = 16;
	private final int LVL2_MINES = 40;

	private final int LVL3_ROWS = 16;
	private final int LVL3_COLS = 30;
	private final int LVL3_MINES = 99;
	
	
	private final int Empty_cell_value = 0;
	private final int Score_1_value = 1;
	private final int Score_2_value = 2;
	private final int Score_3_value = 3;
	
	private final int number_Score_1 = 16;
	private final int number_Score_2 = 12;
	private final int number_Score_3 = 8;
	
	public final int Mine_value = 9;
	
	private final int Flag_value = 4;
	
	public void initMines() {
		//We have a matrix columns x row, generate 2 random
		//1 random for X and one for Y and generate until we place all the mines
		
		
		int number_Mines_left = this.num_mines;		
		
		//Sacar valor 0-3 para poner X minas en esa fila y ir restando al maximo de minas
		//Podriamos por ejemplo saltarnos la 3 fila y la 6 o asi
		while(number_Mines_left > 0 ) {//Crear funcion aparte

			//int y=0;
			int rand_mines = 0;
				
			int posX = getRandomInteger(0, this.num_rows - 1);
			int posY = getRandomInteger(0, this.num_columns - 1);
			if(board[posX][posY] != Mine_value) {
				board[posX][posY] = Mine_value;
				number_Mines_left--;
			}
		

		}
	}
	
	private int checkRight(int posX, int posY) {
		if(this.board[posX][posY+1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int checkLeft(int posX, int posY) {
		if(this.board[posX][posY-1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int checkTop(int posX, int posY) {
		if(this.board[posX-1][posY] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int checkBottom(int posX, int posY) {
		if(this.board[posX+1][posY] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int checkTopRight(int posX, int posY) {
		if(this.board[posX-1][posY+1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int checkTopLeft(int posX, int posY) {
		if(this.board[posX-1][posY-1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int checkBottomRight(int posX, int posY) {
		if(this.board[posX+1][posY+1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int checkBottomLeft(int posX, int posY) {
		if(this.board[posX+1][posY-1] == this.Mine_value)
			return 1;
		else
			return 0;
	}
	
	private int getMinesAdjacent(int sample, int posX, int posY) {
		int value = 0;
		switch(sample) {
			case 0: // top left corner
				value += this.checkRight(posX, posY);
				value += this.checkBottom(posX, posY);
				value += this.checkBottomRight(posX, posY);
				break;
			case 1: // top right corner
				value += this.checkLeft(posX, posY);
				value += this.checkBottom(posX, posY);
				value += this.checkBottomLeft(posX, posY);
				break;
			case 2: // bottom left corner
				value += this.checkRight(posX, posY);
				value += this.checkTop(posX, posY);
				value += this.checkTopRight(posX, posY);
				break;
			case 3: // bottom right corner
				value += this.checkLeft(posX, posY);
				value += this.checkTop(posX, posY);
				value += this.checkTopLeft(posX, posY);
				break;
			case 4: // first row (without corners)
				value += this.checkLeft(posX, posY);
				value += this.checkRight(posX, posY);
				value += this.checkBottomRight(posX, posY);
				value += this.checkBottomLeft(posX, posY);
				value += this.checkBottom(posX, posY);
				break;
			case 5: // last row (without corners)
				value += this.checkLeft(posX, posY);
				value += this.checkRight(posX, posY);
				value += this.checkTopRight(posX, posY);
				value += this.checkTopLeft(posX, posY);
				value += this.checkTop(posX, posY);
				break;
			case 6: // first column (without corners)
				value += this.checkTop(posX, posY);
				value += this.checkBottom(posX, posY);
				value += this.checkTopRight(posX, posY);
				value += this.checkBottomRight(posX, posY);
				value += this.checkRight(posX, posY);
				break;
			case 7: // last column (without corners)
				value += this.checkTop(posX, posY);
				value += this.checkBottom(posX, posY);
				value += this.checkTopLeft(posX, posY);
				value += this.checkBottomLeft(posX, posY);
				value += this.checkLeft(posX, posY);
				break;
			case 8: // mid board (check all positions)
				value += this.checkTop(posX, posY);
				value += this.checkBottom(posX, posY);
				value += this.checkLeft(posX, posY);
				value += this.checkRight(posX, posY);
				value += this.checkTopLeft(posX, posY);
				value += this.checkBottomLeft(posX, posY);
				value += this.checkTopRight(posX, posY);
				value += this.checkBottomRight(posX, posY);
				break;
		}
		return value;
	}
	
	public void initBoard() {
		
		for(int i = 0; i < (this.num_rows); i++) {
			for(int j = 0; j < (this.num_columns); j++) {
				if( this.board[i][j] != this.Mine_value ) {
					if( i == 0 ) { //primera fila
						if( j == 0 ) {
							//esquina superior izquierda
							this.board[i][j] = this.getMinesAdjacent(0, i , j);
						} else if(j == this.num_columns - 1) {
							//esquina superior derecha
							this.board[i][j] = this.getMinesAdjacent(1, i , j);
						} else { 
							//fila de arriba
							this.board[i][j] = this.getMinesAdjacent(4, i , j);
						}
					} else if(i == this.num_rows - 1) { //ultima fila
						if( j == 0 ) {
							//esquina inferior izquierda
							this.board[i][j] = this.getMinesAdjacent(2, i , j);
						} else if(j == this.num_columns - 1) {
							//esquina inferior derecha
							this.board[i][j] = this.getMinesAdjacent(3, i , j);
						} else { 
							//fila de abajo
							this.board[i][j] = this.getMinesAdjacent(5, i , j);
						}
					} else if(j == 0) {
						// primera columna
						this.board[i][j] = this.getMinesAdjacent(6, i , j);
					} else if(j == this.num_columns - 1) {
						//ultima columna
						this.board[i][j] = this.getMinesAdjacent(7, i , j);
					} else {
						//en medio del tablero, comprobar todas las posiciones
						this.board[i][j] = this.getMinesAdjacent(8, i , j);
					}
				}
			}
		}
	}
	
	
	Board(int level){
		
		switch(level) {
		
			case 1:
				this.num_rows = LVL1_ROWS;
				this.num_columns = LVL1_COLS;
				this.num_mines = LVL1_MINES;
				break;
				
			case 2:
				this.num_rows = LVL2_ROWS;
				this.num_columns = LVL2_COLS;
				this.num_mines = LVL2_MINES;
				break;
				
			case 3:
				this.num_rows = LVL3_ROWS;
				this.num_columns = LVL3_COLS;
				this.num_mines = LVL3_MINES;
				break;
		
		};

		
		this.board = new int[num_rows][num_columns];
		this.initMines();
		this.initBoard();
	}
	
	public int[][] getBoard(){
		return this.board;
	}
	
	public int setBoard(int[][] b) {
		this.board  = b;
		return 0;
	}
	
	
	public static int getRandomInteger(int min, int max) {
		
		Random ran = new Random();
		return ran.nextInt((max - min) + 1) + min;
		
	}
	
	public int[][] initBoard(int row, int col) {
		int Matrix_board[][] = new int[row][col];
		
		
	
		return Matrix_board;
	}
	
	public int[][] initScores(int numScores_1, int numScores_2, int numScores_3) {
		//int Matrix_scores[][] = new int[NUM_ROWS][NUM_COLUMNS];
		
		
		return null;
		
	}
	
	
	/*
	
	public int[][] initMines(int numMines, int m[][]) {
		
		int Matrix_mines[][] = new int[NUM_ROWS][NUM_COLUMNS];
		Boolean doneMines = false;
		Matrix_mines= m;
		int number_Mines_left = numMines;
		int min_mine = 0;
		int max_mine = 3;
		
		int min_pos = 0;
		int max_pos = 7;
		int x=0;
		
		//Sacar valor 0-3 para poner X minas en esa fila y ir restando al maximo de minas
		//Podriamos por ejemplo saltarnos la 3 fila y la 6 o asi
		while(number_Mines_left > 0 || !doneMines) {//Crear funcion aparte

			//int y=0;
			int rand_mines = 0;
			
			
			rand_mines = getRandomInteger(min_mine, max_mine);
			if(rand_mines <= number_Mines_left) {
				for(int i=0; i < rand_mines; i++) {
					int rand_pos = 0;
					rand_pos = getRandomInteger(min_pos, max_pos);
					if(Matrix_mines[x][rand_pos] == 0) {
						Matrix_mines[x][rand_pos] = Mine_value;
					}else { i--; }
				}
				
				number_Mines_left = number_Mines_left - rand_mines;
				x++;
			}
			else {
				
					while(number_Mines_left > 0){
						int z=0;
						if(Matrix_mines[x][z]!=5) {
							Matrix_mines[x][z] = Mine_value;
							number_Mines_left = number_Mines_left - 1;
						}
					}
					
			}
			
			
			
			

		}
		
		//Posicion random 0-8 para colocar las minas en la fila X veces por el numero
		//de minas que vaya a a tener la fila
		
		
		return Matrix_mines;
		
	}

*/
}
