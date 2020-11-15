package minesweeper;

import static org.junit.Assert.*;
import java.util.Arrays;


import org.junit.Test;

public class GameControllerTest {
	
	@Test
	public void requestPosX() {
		Board game = new Board();
		GameController test_gc1 = new GameController();
		GameView gv = new GameView();
		
		test_gc1.main(null);
	
		
	}
	
	@Test
	public void requestPosY() {
		GameController test_gc = new GameController();
		
		//test_gc.updateView();
	}
}
