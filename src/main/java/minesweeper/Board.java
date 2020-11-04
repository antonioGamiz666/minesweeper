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
	
	private final int Mine_value = 5;
	
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
	
	public void initBoard() {
				
		for(int i = 0; i < this.num_rows; i++) {
			for(int j = 0; i < this.num_columns; j++) {
				if( i == 0 ) { //primera fila
					if( j == 0 ) {
						//esquina superior izquierda
						this.board[i][j] = 1;
					} else if(j == this.num_columns - 1) {
						//esquina superior derecha
						this.board[i][j] = 2;
					} else { 
						//fila de arriba
						this.board[i][j] = 7;
					}
				} else if(i == this.num_rows - 1) { //ultima fila
					if( j == 0 ) {
						//esquina inferior izquierda
						this.board[i][j] = 3;
					} else if(j == this.num_columns - 1) {
						//esquina inferior derecha
						this.board[i][j] = 4;
					} else { 
						//fila de abajo
						this.board[i][j] = 6;
					}
				} else if(j == 0) {
					// primera columna
					this.board[i][j] = 5;
				} else if(j == this.num_columns - 1) {
					//ultima columna
					this.board[i][j] = 8;
				} else {
					//en medio del tablero, comprobar todas las posiciones
					this.board[i][j] = 9;
				}
			}
		}
	}
	public int getAdjacents(int posX, int posY) {
		
		
		
		
		return 0;
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
		//this.initBoard();
	}
	
	public int[][] getBoard(){
		return this.board;
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
