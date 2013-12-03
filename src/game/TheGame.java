package game;

import game.TheMove.DIRECTION;

import java.util.ArrayList;
import java.util.List;

import man.IMan;

public class TheGame implements IMan {

	private final TheBord bord;
	private final List<TheMove> moveHistory;

	/**
	 * 外部から呼び出すコンストラクタ
	 */
	public TheGame() {
		this.bord = new TheBord();
		this.moveHistory = new ArrayList<TheMove>();
	}

	private TheGame(TheBord bord, List<TheMove> moveHistory) {
		super();
		this.bord = bord;
		this.moveHistory = moveHistory;
	}

	@Override
	public List<IMan> getChildren() {
		List<IMan> manList = new ArrayList<IMan>();
		for (String id : this.bord.getBlockIdSet()) {
			for (DIRECTION dir : DIRECTION.values()) {
				TheMove nextMovement = new TheMove(id, dir);
				TheBord nextBord = this.bord.makeNextBord(nextMovement);
				if (nextBord != null) {
					List<TheMove> childHistory = new ArrayList<TheMove>(
							this.moveHistory);
					childHistory.add(nextMovement);
					manList.add(new TheGame(nextBord, childHistory));
				}
			}
		}
		return manList;
	}

	@Override
	public void writeHistry() {

	}

	@Override
	public boolean isTrueMan() {
		return this.bord.isGoal();
	}

	@Override
	public boolean identify(IMan man) {
		if (!(man instanceof TheGame)) {
			return false;
		}
		return this.bord.isSameBord(((TheGame) man).bord);
	}

}
