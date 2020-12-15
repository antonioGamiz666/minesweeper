package minesweeper;

import java.lang.*;

import java.util.*;

import java.io.*;

public class GameView {
	
		public static String[][] field = new String[9][9];
		
		private static String closedcell = "[?]";
		private static String openedcell_empty = "[_]";
		private static String openedcell_mine = "[X]";
		private static String number1 = "[1]";
		private static String number2 = "[2]";
		private static String number3 = "[3]";
		private static String number4 = "[4]";
		private static String number5 = "[5]";
		private static String number6 = "[6]";
		private static String number7 = "[7]";
		private static String number8 = "[8]";
		
		
		public void gameOver() {
			System.out.println("Game Over");
		}
		 
		public void askPosX() {			
			System.out.println("Introduce row: ");			
		}
		
		public void askPosY() {
			System.out.println("Introduce column: ");
		}
		
		public void printMatrix(int [][]userBoard) {
				
			for (int i = 0; i <= 8; i++) {
				for ( int j = 0; j <= 8; j++) {
					if(i == 0) {
						if(j==0) {
							System.out.print("       ");
						}
						else {
							System.out.print("\t");
							System.out.print(j-1);
						}
						
					}
					else {
						if (j == 0) System.out.print(i-1);
						else {
							switch(userBoard[i-1][j-1]) {
								case -1:
									this.field[i][j]=this.closedcell;
									break;
								case 0:
									this.field[i][j]=this.openedcell_empty;
									break;
								case 1:
									this.field[i][j]=this.number1;
									break;
								case 2:
									this.field[i][j]=this.number2;
									break;
								case 3:
									this.field[i][j]=this.number3;
									break;
								case 4:
									this.field[i][j]=this.number4;
									break;
								case 5:
									this.field[i][j]=this.number5;
									break;
								case 6:
									this.field[i][j]=this.number6;
									break;
								case 7:
									this.field[i][j]=this.number7;
									break;
								case 8:
									this.field[i][j]=this.number8;
									break;
								case 9:
									this.field[i][j]=this.openedcell_mine;
									break;
									
							}
							System.out.print("\t"+field[i][j]);
						}
						
					}
					
				}
				System.out.println();
				
			}
		}
}
