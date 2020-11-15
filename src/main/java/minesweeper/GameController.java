package minesweeper;
import java.util.Scanner;

public class GameController {

    public static int requestPosX(GameView gameview, InputKeyboard input) {
    	int aux=-1;
        while(aux > 7 || aux < 0) { //if the value introduced is not between 0 and 7, request a new one
            gameview.askPosX(); //Requests the view to ask for new positionX
            aux = input.read();

        }
         return aux;
    }

    public static int requestPosY(GameView gameview, InputKeyboard input) {
        int aux=-1;
        while(aux > 7 || aux < 0) { //if the value introduced is not between 0 and 7, request a new one
            gameview.askPosY(); //Requests the view to ask for new positionY
            aux = input.read();
        }
        return aux;
    }

    public static void main(String[] args) {
        Board board = new Board();
        GameView gv = new GameView();
        InputKeyboard input = new InputKeyboard();
        
        int positionX = 0;
        int positionY = 0;

        while(board.lose == false) {
            gv.printMatrix(board.getBoardUser());
            positionX = requestPosX(gv, input);
            positionY = requestPosY(gv, input);
            board.openCell(positionX, positionY);            
        }
        gv.printMatrix(board.getBoardUser());
        gv.gameOver();
    }

}