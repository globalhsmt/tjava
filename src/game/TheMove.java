package game;

public class TheMove {

	private final String id;
	private final DIRECTION dir;

	TheMove(String id, DIRECTION dir) {
		super();
		this.id = id;
		this.dir = dir;
	}

	String getId() {
		return id;
	}

	DIRECTION getDir() {
		return dir;
	}

	enum DIRECTION {

		UP, LEFT, RIGHT, DOWN
	}

}
