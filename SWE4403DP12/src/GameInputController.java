import java.util.Scanner;

public class GameInputController implements GameObserver 
{
   private int currentPlayer = 1;
   private int inputRow;
   private int inputCol;
   private boolean gameEnd = false;
   private GameLogic model;
   private GameView view;

   public GameInputController(GameView view, GameLogic model) 
   {
         this.view = view;
         this.model = model;
         model.attach(this);
   }

   public void control() 
   {
         view.displayMessage("Game Starts.");
         view.update();
         while (!gameEnd) {
               view.displayMessage("Player's turn.");
               getUserMove();
               model.makeMove(inputRow, inputCol, currentPlayer);
         }
   }

   public void update() 
   {
         int status = model.getGameStatus();
         switch (status) {
                  case GameStatus.illegalMove: 
                        view.displayMessage("Illegal move. Input again.");
                        getUserMove();
                        model.makeMove(inputRow, inputCol, currentPlayer);
                        break;
                  case GameStatus.gameContinue:
                  currentPlayer = currentPlayer==1?2:1;
                  break;
              default: 
                  gameEnd = true;
         }
   }

   private void getUserMove() 
   {
         Scanner scanner = new Scanner(System.in);
         while (true) {
                view.displayMessage("Enter row number (0-2): ");
                inputRow = scanner.nextInt();
                view.displayMessage("Enter column number (0-2): ");
                inputCol = scanner.nextInt();
                if (inputRow >= 0 && inputRow < 3 && inputCol >= 0 
                   && inputCol <3) break;
                view.displayMessage("Input error. Input again.");
         }
   }
}

 

