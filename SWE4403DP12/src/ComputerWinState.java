
public class ComputerWinState extends GameViewState {
	
	
	public void handle(GameView gameView,GameBoardView board) {
		// TODO Auto-generated method stub
		
        gameView.displayGameBoard(board);
		gameView.displayMessage("Player 2 Won!");
	}
}
