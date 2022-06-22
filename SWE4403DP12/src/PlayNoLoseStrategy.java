public class PlayNoLoseStrategy extends PlayStrategy {

	private PlaySmartStrategy successor;

	@Override
	public int[] computePosition(GameBoard board) {
		
		int[] position = new int[2];
		int x, y;

		
		int countX = 0;
		for (x = 0; x < 3; x++) {
			countX = 0;
			for (y = 0; y < 3; y++) {
				if ((board.getPlayer(x, y)) == 1) {
					countX++;
				} else if ((board.getPlayer(x, y)) == 2) {
					countX = 0;
					break;
				} else {
					position[0] = x;
					position[1] = y;
				}

				if (countX == 2 && y == 2) {
					return position;
				}
			}
		}

		
		int countY = 0;
		for (y = 0; y < 3; y++) {
			countY = 0;
			for (x = 0; x < 3; x++) {
				if ((board.getPlayer(x, y)) == 1) {
					countY++;
				} else if ((board.getPlayer(x, y)) == 2) {
					countY = 0;
					break;
				} else {
					position[0] = x;
					position[1] = y;
				}

				if (countY == 2 && x == 2) {
					return position;
				}
			}
		}

		
		int[] p2 = new int[2];
		int diag1 = 0;
		int diag2 = 0;

		
		x = 0;
		y = 0;
		if ((board.getPlayer(x, y)) == 1) {
			diag1++;
		} else if ((board.getPlayer(x, y)) == 2) {
			diag1 = 0;
		} else {
			position[0] = x;
			position[1] = y;
		}

		
		y = 2;
		if ((board.getPlayer(x, y)) == 1) {
			diag2++;
		} else if ((board.getPlayer(x, y)) == 2) {
			diag2 = 0;
		} else {
			p2[0] = x;
			p2[1] = y;
		}

		
		x = 1;
		y = 1;
		if ((board.getPlayer(x, y)) == 1) {
			diag1++;
			diag2++;
		} else if ((board.getPlayer(x, y)) == 2) {
			diag1 = 0;
			diag2 = 0;
		} else {
			position[0] = x;
			position[1] = y;
			p2[0] = x;
			p2[1] = y;
		}

		
		x = 2;
		y = 0;
		if ((board.getPlayer(x, y)) == 1) {
			diag2++;
		} else if ((board.getPlayer(x, y)) == 2) {
			diag2 = 0;
		} else {
			p2[0] = x;
			p2[1] = y;
		}

		
		x = 2;
		y = 2;
		if ((board.getPlayer(x, y)) == 1) {
			diag1++;
		} else if ((board.getPlayer(x, y)) == 2) {
			diag1 = 0;
		} else {
			position[0] = x;
			position[1] = y;
		}

		
		if (diag1 == 2) {
			return position;
		}
		if (diag2 == 2) {
			return p2;
		}

		if (successor == null) {
			successor = new PlaySmartStrategy();
		}

		return successor.computePosition(board);
	}
}