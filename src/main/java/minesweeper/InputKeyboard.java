package minesweeper;
import java.util.Scanner;

//This class uses the Scanner java util to read a variable introduced by the user
public class InputKeyboard {
	
	Scanner input = new Scanner(System.in);
	
	public int read() {
		return this.input.nextInt();
	}
}
