package minesweeper;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class GameControllerTest {
	
	@Test
	public void testRequestPosX() {
		GameController testGC = new GameController();
		MockGameView mockGV = new MockGameView();
		
		//LIMIT VALUES
		//We check limit values (-2000, -1, 8, 2000). The method has to do nothing with this values
		//and return the last 1 we introduce (valid value)
		MockInputKeyboard mockInput0 = new MockInputKeyboard(new int[] {-2000,-1,8,2000,1});
		assertEquals(testGC.requestPosX(mockGV, mockInput0), 1);
		
		//EQUIVALENCE PARTITIONING -- valid values
		MockInputKeyboard mockInput1 = new MockInputKeyboard(new int[] {0,1,2,3,4,5,6,7});
		
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 0);
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 1);
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 2);
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 3);
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 4);
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 5);
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 6);
		assertEquals(testGC.requestPosX(mockGV, mockInput1), 7);
		
		
		//EQUIVALENCE PARTITIONING -- invalid values
		MockInputKeyboard mockInput2 = new MockInputKeyboard(new int[] {-3,1,10,7});
		//first we input a -3 (invalid), then the function have to do nothing and wait for a valid
		//value and later we input a 1 (valid value) and then the function has to return this 1
		//Same with the 10 (invalid) and then the 7(valid)
		assertEquals(testGC.requestPosX(mockGV, mockInput2), 1);
		assertEquals(testGC.requestPosX(mockGV, mockInput2), 7);
	}
	
	@Test
	public void testRequestPosY() {
		GameController testGC = new GameController();
		MockGameView mockGV = new MockGameView();
		
		//LIMIT VALUES
		//We check limit values (-2000, -1, 8, 2000). The method has to do nothing with this values
		//and return the last 1 we introduce (valid value)
		MockInputKeyboard mockInput0 = new MockInputKeyboard(new int[] {-2000,-1,8,2000,1});
		assertEquals(testGC.requestPosY(mockGV, mockInput0), 1);
		
		//EQUIVALENCE PARTITIONING -- valid values
		MockInputKeyboard mockInput1 = new MockInputKeyboard(new int[] {0,1,2,3,4,5,6,7});
		
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 0);
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 1);
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 2);
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 3);
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 4);
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 5);
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 6);
		assertEquals(testGC.requestPosY(mockGV, mockInput1), 7);
		
		
		//EQUIVALENCE PARTITIONING -- invalid values
		MockInputKeyboard mockInput2 = new MockInputKeyboard(new int[] {-3,1,10,7});
		//first we input a -3 (invalid), then the function have to do nothing and wait for a valid
		//value and later we input a 1 (valid value) and then the function has to return this 1
		//Same with the 10 (invalid) and then the 7(valid)
		assertEquals(testGC.requestPosY(mockGV, mockInput2), 1);
		assertEquals(testGC.requestPosY(mockGV, mockInput2), 7);
	}
	
}
