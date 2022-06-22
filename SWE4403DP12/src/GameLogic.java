public class GameLogic extends GameSubject 
{
   private int gameStatus = GameStatus.gameContinue;
   private GameReferee referee;
   private GameBoard gameBoard;
   private ComputerPlayer computer;
   
   public GameLogic() 
   {
         gameBoard = new GameBoard();
         referee = new GameReferee(gameBoard);
         computer = new ComputerPlayer(gameBoard);
   }

   

   public void makeMove(int row, int col, int player) 
   {
          int status = referee.checkLegalMove(row, col, player);
          if (status != 0) {
            gameStatus = GameStatus.illegalMove;
          } else {
            gameBoard.setPlayer(row, col, player);
            gameStatus = referee.checkGameStatus();
            notifyObservers();
            computer.makeComputerMove();
            gameStatus = referee.checkGameStatus();
            notifyObservers();
            
          }
   }

   public GameBoardView getGameBoard() 
   {
    return gameBoard;
   }

   public int getGameStatus() 
   {
    return gameStatus;
   }
}
