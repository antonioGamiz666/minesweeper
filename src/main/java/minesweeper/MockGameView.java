package minesweeper;

// In order to test GameController we need a GameView that doesn't print anything to cmd
public class MockGameView extends GameView {
	
	public void askPosX() {
		//don't print anything, just for test
	}
	
	public void askPosY() {
		//don't print anything, just for test
	}
}
