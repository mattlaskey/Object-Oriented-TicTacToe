
public class TicTacToeGame 
{
   public static void main(String[] args) 
   {
         GameLogic model = new GameLogic();
         GameView view = new GameView(model);
         GameInputController controller = 
            new GameInputController(view, model);
         controller.control();
   }
}

 
 


 




 




 



