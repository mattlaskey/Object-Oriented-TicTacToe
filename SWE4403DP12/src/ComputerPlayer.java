public class ComputerPlayer {

	
	private GameBoard gameBoard;
	private PlayStrategy compStrat;

	public ComputerPlayer(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	public void makeComputerMove() {
		System.out.println("Computer move");
		if(compStrat == null)
			compStrat = new PlayWinStrategy();
		
		int[] pos = compStrat.computePosition(gameBoard);
		gameBoard.setPlayer(pos[0], pos[1],2);
	}
}