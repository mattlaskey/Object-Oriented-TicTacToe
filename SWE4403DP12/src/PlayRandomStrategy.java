public class PlayRandomStrategy extends PlayStrategy {
	
	public int[] computePosition(GameBoard board) {
		
		int[] position = new int[2];
		while(true)
		{
			int x = (int)(Math.random()*3);
			
			int y = (int)(Math.random()*3);
			
			if(board.getPlayer(x,y)==0)
			{
				position[0] = x;
				position[1] = y;
				break;
			}
		}
		return position;
	}
}