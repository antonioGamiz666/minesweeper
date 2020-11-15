package minesweeper;

public class MockGameController extends GameController{
	
	public void requestPosX(GameView gameview, int positionMock) {
		
		gameview.askPosX();
		this.positionX=positionMock;
	}

}
