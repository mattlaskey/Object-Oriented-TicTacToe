public class PlaySmartStrategy extends PlayStrategy {

	private PlayRandomStrategy successor;

	@Override
	public int[] computePosition(GameBoard board) {
		int x = -1;
		int y = -1;
		int[] position = new int[2];
		
		if (board.getPlayer(1, 1) == 0) {
			position[0] = 1;
			position[1] = 1;
			return position;
		}
		
		if (board.getPlayer(0, 1) == GameStatus.player1Win) {
			x = 2;
			y = 0;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position[1] = y;
				return position;
			}
			x = 2;
			y = 2;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position[1] = y;
				return position;
			}
		}
		if (board.getPlayer(1, 0) == GameStatus.player1Win) {
			x = 0;
			y = 2;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position[1] = y;
				return position;
			}
			x = 2;
			y = 2;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position[1] = y;
				return position;
			}
		}
		if (board.getPlayer(1, 2) == GameStatus.player1Win) {
			x = 0;
			y = 0;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position[1] = y;
				return position;
			}
			x = 2;
			y = 0;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position[1] = y;
				return position;
			}
		}
		if (board.getPlayer(2, 1) == GameStatus.player1Win) {
			x = 0;
			y = 0;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position [1] = y;
				return position;
			}
			x = 0;
			y = 2;
			if (board.getPlayer(x, y) == 0) {
				position[0] = x;
				position[1] = y;
				return position;
			}
		}
		
		for (int i = 0; i < GameStatus.guess; i++) {
			x = (int) (Math.random() * 3);
			y = (int) (Math.random() * 3);
			if ((x + y) % 2 == 0) {
				if (board.getPlayer(x, y) == 0) {
					position[0] = x;
					position[1] = y;
					return position;
				}
			}

		}
		
		if (successor == null) {
			successor = new PlayRandomStrategy();
		}
		return successor.computePosition(board);
	}
}