package minesweeper;
import java.util.Scanner;

public class GameController {

//    public int positionX=0;
//    public int positionY=0;

//    public int write() {
//        Scanner input = new Scanner(System.in);
//        int number = input.nextInt();
//        return number;
//
//    }


    public static int requestPosX(GameView gameview, InputKeyboard input) {
        //Requests the view to ask for new positionX
        int aux=-1;
        while(aux > 7 || aux < 0) {
        	//if(input instanceof MockInputKeyboard && input.read() == -67)
            gameview.askPosX();
            aux=input.read();

        }
         return aux;
    }

    public static int requestPosY(GameView gameview, InputKeyboard input) {
        //Requests the view to ask for new positionY
        int aux=-1;
        while(aux > 7 || aux < 0) {
            gameview.askPosY();
            aux=input.read();
        }
        return aux;
    }

    public static void UpdateModel(int posX, int posY, Board board) {
        //Updates the game by sending those positions to the Model
        //Calling openCell with the new positions?
        board.openCell(posX, posY);

    }

    public static void UpdateView(GameView gameview, Board board) {
        //Telling the view to print the new matrix
        //Calling the printMatrix from the view?
        gameview.printMatrix(board.getBoardUser());
    }

    public static void main(String[] args) {
        Board game = new Board();
        GameView gv = new GameView();
        InputKeyboard input = new InputKeyboard();
        
        int positionX=0;
        int positionY=0;
        

        while(game.lose==false || game.win==false) {
            UpdateView(gv,game);
            positionX=requestPosX(gv, input);
            positionY=requestPosY(gv, input);
            UpdateModel(positionX, positionY, game);
        }
        UpdateView(gv,game);
        gv.gameOver();
    }

}