public class GameView implements GameObserver 
{
   private GameLogic model;
   public GameViewState state;
   public GameView(GameLogic model) 
   {
         this.model = model;
         model.attach(this);
   }
   
   void displayGameBoard(GameBoardView gameBoard) 
   {
         for (int row = 0; row < 3; row++) {
               for (int col = 0; col < 3; col++) {
                     int playerId = gameBoard.getPlayer(row, col);
                     switch (playerId) {
                              case 0: System.out.print("*"); break; 
                              case 1: System.out.print("X"); break; 
                              case 2: System.out.print("O"); break; 
                     }
                     System.out.print(" ");
               }
               System.out.println();
         }
   }

   public void displayMessage(String message) 
   {
         System.out.println(message);
   }

   public void update() 
   {
         int status = model.getGameStatus();
         if (status != GameStatus.illegalMove) {
               GameBoardView board = model.getGameBoard();
               //displayGameBoard(board);
               String message = "";
               switch(status) {
                        case GameStatus.gameContinue: 
                         //message = "Game Continue";
                        	state = new ContinueState();
                         break;
                        case GameStatus.player1Win: 
                         //message = "Player 1 Won!";
                        	state = new PlayerWinState();
                         break;
                        case GameStatus.player2Win: 
                         //message = "Player 2 Won!";
                        	state = new ComputerWinState();
                         break;
                        case GameStatus.tie: 
                         //message = "It is a tie!";
                        	state = new TieState();
                         break;
               }
               //displayMessage(message);
               state.handle(this,board);
         }
   }
}

 