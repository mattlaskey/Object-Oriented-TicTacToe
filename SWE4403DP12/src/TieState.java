
public class TieState extends GameViewState{

	
	public void handle(GameView gameView,GameBoardView board) {
		// TODO Auto-generated method stub
        gameView.displayGameBoard(board);
		gameView.displayMessage("It is a tie!");
	}

}
