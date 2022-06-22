public class GameBoard implements GameBoardView 
{
   private int[][] board;
   public GameBoard() 
   {
         board = new int[3][3];
         for (int i = 0; i < 3; i++) 
               for (int j = 0; j < 3; j++) {
                     board.clone()[i][j] = 0;
               }
   }

   public int getPlayer(int row, int col) 
   {
    return board[row][col];
   }
   
   public void setPlayer(int row, int col, int player) 
   {
         board[row][col] = player;
   }
}

 