package minesweeper;


// this mock simulates outputs from the function initMines() with hardcoded cases to simulate random mines placement
public class MockBoard extends Board {
	
	public int[][] initMines(int mockSelection) {
		
		switch(mockSelection) {
		
			case 1: //all cells filled with mines
				return new int[][] {{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9}};
				
			case 2: //mines in corner
				return new int[][] {{9, 0, 0, 0, 0, 0, 0, 9},
					  			    {0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{9, 0, 0, 0, 0, 0, 0, 9}};

			case 3: //testing corners
				return new int[][] {{0, 9, 0, 0, 0, 0, 9, 0},
					  			    {9, 9, 0, 0, 0, 0, 9, 9},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{9, 9, 0, 0, 0, 0, 9, 9},
					  				{0, 9, 0, 0, 0, 0, 9, 0}};
				
			case 4: //testing limits (first and last row, first and last column)
				return new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 9, 9, 9, 9, 9, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 9, 9, 9, 9, 9, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0}};
				
			case 5: //testing maximum values (bombs surrounding a cell)
				return new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 9, 9, 9, 0, 0, 0, 0},
					  				{0, 9, 0, 9, 0, 0, 0, 0},
					  				{0, 9, 9, 9, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 9, 9, 9, 0},
					  				{0, 0, 0, 0, 9, 0, 9, 0},
					  				{0, 0, 0, 0, 9, 9, 9, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0}};
					  				
			case 6: //testing invalid values 
				return new int[][] {{-1, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, -1000, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 9, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 30, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{66, 0, 0, 0, 80, 0, 0, 0}};
				
			default: //testing board without mines
				return new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0}};
											
		}
	}
}
