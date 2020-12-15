package minesweeper;

public class MockMyRandom extends MyRandom {
	int[] fake_inputs;
	int i;
	
	public int getRandomInteger(int min, int max) {
		this.i++;
		return this.fake_inputs[i - 1];		
	}
	
	MockMyRandom(int[] fakeInputs) {
		this.fake_inputs = fakeInputs;
		this.i = 0;
	}
}
