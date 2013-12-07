package seek;

import game.IStage;
import game.TheBord;
import game.TheMove;

import java.util.ArrayList;
import java.util.List;

public class TheGame {

	private final TheBord bord;
	private final List<TheMove> moveHistory;

	/**
	 * 外部から呼び出すコンストラクタ
	 */
  public TheGame(IStage stage) {
    this.bord = new TheBord(stage);
		this.moveHistory = new ArrayList<TheMove>();
	}

	private TheGame(TheBord bord, List<TheMove> moveHistory) {
		super();
		this.bord = bord;
		this.moveHistory = moveHistory;
	}

	public List<TheGame> getChildren() {
		List<TheGame> manList = new ArrayList<TheGame>();
		
		for (String id : this.bord.getBlockIdSet()) {
			for (TheMove.DIRECTION dir : TheMove.DIRECTION.values()) {
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

	
	public String printMyHistory() {
	  StringBuilder sb = new StringBuilder();
	  String sp = System.getProperty("line.separator");
	  for(int idx = 0 ; idx < moveHistory.size() ; idx++){
	    TheMove move = moveHistory.get(idx);
	    sb.append(idx);
      sb.append(" ");
	    sb.append(move.getId());
	    sb.append(" ");
	    sb.append(move.getDir().name());
	    sb.append(sp);
	  }
	  return sb.toString();
	}

	
	public boolean isTrueMan() {
		return this.bord.isGoal();
	}

	
	public boolean identify(TheGame man) {
		if (!(man instanceof TheGame)) {
			return false;
		}
		return this.bord.isSameBord(((TheGame) man).bord);
	}

}
