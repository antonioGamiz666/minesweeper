package minesweeper;

import java.lang.*;

import java.util.*;

import java.io.*;

public class GameView {
	
public static String[][] field = new String[9][9];

private static String closedcell = "[]";
private static String openedcell_empty = "[_]";
private static String openeddcell_mine = "[X]";
private static String number1 = "[1]";
private static String number2 = "[2]";
private static String number3 = "[3]";
private static String number4 = "[4]";
private static String number5 = "[5]";
private static String number6 = "[6]";
private static String number7 = "[7]";
private static String number8 = "[8]";
private static String flag = "[!]";



	
	public static void main(String[] args) {
		
		//while no se acabe el juego
		//preguntar si quiere abrir una casilla o poner flag
		//preguntar posicion -> meter posicion por teclado 
		
		for ( int i = 0; i <= 8; i++) {
			for ( int j = 0; j <= 8; j++) {
				field[i][j]=closedcell;
			}

		}
		
		for ( int i = 0; i <= 8; i++) {
			for ( int j = 0; j <= 8; j++) {
				if(i == 0) {
					if(j==0) {
						System.out.print(" ");
					}
					else {
						System.out.print("\t"+ j);
					}
					
				}
				else {
					if (j == 0) System.out.print(+i);
					else System.out.print("\t"+field[i][j]);
					
				}
				
			}
			System.out.println();
			
		}

	}
}
