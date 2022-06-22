public class GameReferee 
{
   private GameBoardView gameBoard;
   public int checkLegalMove(int row, int col, int player) 
   {
         return gameBoard.getPlayer(row, col);
   }
   
   public int checkGameStatus() 
   {
         int playerId = checkWinning();
         if (playerId == 1) return GameStatus.player1Win;
         if (playerId == 2) return GameStatus.player2Win;
         boolean status = checkTie();
         if (status == true) return GameStatus.tie;
         return GameStatus.gameContinue;
   }

   private int checkWinning() 
   {
         for (int row = 0; row < 3; row++) {
               int playerId = gameBoard.getPlayer(row, 0);
               int count = 1;
               for (int col = 1; col < 3; col++ ) {
                     if (gameBoard.getPlayer(row, col) == 
                      playerId) count++;
               }
               if (count == 3 && playerId != 0) return playerId;
         }
         for (int col = 0; col < 3; col++) {
               int playerId = gameBoard.getPlayer(0, col);
               int count = 1;
               for (int row = 1; row < 3; row++ ) {
                     if (gameBoard.getPlayer(row, col) == 
                      playerId) count++;
               }
               if (count == 3 && playerId != 0) return playerId;
         }
         int playerId = gameBoard.getPlayer(0, 0);
         int count = 1;
         for (int row = 1; row < 3; row++) {
               if (gameBoard.getPlayer(row, row) == playerId) count++;
         }
         if (count == 3 && playerId != 0) return playerId;
         playerId = gameBoard.getPlayer(0, 2);
         count = 1;
         for (int row = 1; row < 3; row++) {
               if (gameBoard.getPlayer(row, 2-row) == playerId) count++;
         }
         if (count == 3 && playerId != 0) return playerId;
         return 0;
   }

   

   

   private boolean checkTie() 

   {

         for (int row = 0; row < 3; row++) {

               int[] counts = new int[3];

               for (int col = 1; col < 3; col++ ) {

                     int playerId = gameBoard.getPlayer(row, col);

                     counts[playerId]++;

               }

               for (int i = 0; i < 3; i++) {

                     if (counts[0] >= 2) return false;

                     if ((counts[1] == 2 || counts[2] == 2) 

                       && counts[0] == 1) return false;

               }

         }

         for (int col = 0; col < 3; col++) {

               int[] counts = new int[3];

               for (int row = 1; row < 3; row++ ) {

                     int playerId = gameBoard.getPlayer(row, col);

                     counts[playerId]++;

               }

               for (int i = 0; i < 3; i++) {

                     if (counts[0] >= 2) return false;

                     if ((counts[1] == 2 || counts[2] == 2) 

                         && counts[0] == 1) return false;

               }

         }

         for (int row = 0; row < 3; row++) {

               int[] counts = new int[3];

               int playerId = gameBoard.getPlayer(row, row);

               counts[playerId]++;

               for (int i = 0; i < 3; i++) {

                     if (counts[0] >= 2) return false;

                     if ((counts[1] == 2 || counts[2] == 2) 

                      && counts[0] == 1) return false;

               }

         }

         for (int row = 0; row < 3; row++) {

               int[] counts = new int[3];

               int playerId = gameBoard.getPlayer(row, 2-row);

               counts[playerId]++;

               for (int i = 0; i < 3; i++) {

                     if (counts[0] >= 2) return false;

                     if ((counts[1] == 2 || counts[2] == 2) 

                     && counts[0] == 1) return false;

               }

         }

         return true;

   }

   

   public GameReferee(GameBoardView gameBoard) 

   {

         this.gameBoard = gameBoard;

   }

}

 