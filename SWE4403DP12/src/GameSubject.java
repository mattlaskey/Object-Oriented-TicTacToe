import java.util.ArrayList;

public abstract class GameSubject {
	int observerCount = 0;
	   private ArrayList<GameObserver> observers;   
	   public GameSubject() 
	   {
	         observers = new ArrayList<GameObserver>();;
	   }

	   public void attach(GameObserver observer) 
	   {
	         observers.add(observer);
	   }
	   
	   protected void notifyObservers() 
	   {
	         for (int i = 0; i <observers.size(); i++) {
	             GameObserver observer =  observers.get(i);
	             observer.update();
	         }
	   }
}
