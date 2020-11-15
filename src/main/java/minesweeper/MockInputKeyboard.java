package minesweeper;

// With this mock we will be able to simulate a "user" interaction faking his inputs
public class MockInputKeyboard extends InputKeyboard{
	
	private int[] mockInput;
	private int pos; //to be able to know what position we have to send
	
	// With the constructor we initialize the inputs array, 
	// which contains the sorted inputs we want to simulate
	MockInputKeyboard(int[] inputs) {
		this.mockInput = inputs;
		this.pos = 0;
	}
	
	public int read() {
		if(this.pos < this.mockInput.length) {
			this.pos++;
			return this.mockInput[this.pos - 1];
			
		} else {
			return -3; //we send a -3 if we don't have more inputs to send
		}
	}
}
