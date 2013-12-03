package game;

import game.TheMove.DIRECTION;

public class TheCell {

	private String id;
	private int x;
	private int y;

	public TheCell(String id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public TheCell move(DIRECTION dir) {
		switch (dir) {
		case UP:
			return new TheCell(id, x, y - 1);
		case DOWN:
			return new TheCell(id, x, y + 1);
		case LEFT:
			return new TheCell(id, x - 1, y);
		case RIGHT:
			return new TheCell(id, x + 1, y);
		default:
			throw new RuntimeException("nullmove");
		}
	}

	String getId() {
		return id;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

}
