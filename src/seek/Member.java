package seek;


import game.IStage;
import game.TheBord;
import game.TheMove;

import java.util.ArrayList;
import java.util.List;


/**
 * �t�@�~���[�̃����o�[�ł��A
 * @author works
 */
public class Member {

	private final TheBord bord;
	private final List<TheMove> moveHistory;

	/**
	 * �O������Ăяo���R���X�g���N�^
	 */
  public Member(IStage stage) {
    this.bord = new TheBord(stage);
		this.moveHistory = new ArrayList<TheMove>();
	}

	private Member(TheBord bord, List<TheMove> moveHistory) {
		super();
		this.bord = bord;
		this.moveHistory = moveHistory;
	}

	/**
	 * �q�ǂ������ł��B
	 * @return
	 * @author works
	 */
	public List<Member> getChildren() {
		List<Member> manList = new ArrayList<Member>();
		for (String id : this.bord.getBlockIdSet()) {
			for (TheMove.DIRECTION dir : TheMove.DIRECTION.values()) {
				TheMove nextMovement = new TheMove(id, dir);
				TheBord nextBord = this.bord.makeNextBord(nextMovement);
				if (nextBord != null) {
					List<TheMove> childHistory = new ArrayList<TheMove>(
							this.moveHistory);
					childHistory.add(nextMovement);
					manList.add(new Member(nextBord, childHistory));
				}
			}
		}
		return manList;
	}

	/**
	 * �Ƒ��̗��j��String�^�ŕԂ��܂��B
	 * @return
	 * @author works
	 */
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

	/**
	 * �{�����ǂ���
	 * @return
	 * @author works
	 */
	public boolean isTrueMan() {
		return this.bord.isGoal();
	}

	/**
	 * ������`�q�Ȃ��true
	 * @param man
	 * @return
	 * @author works
	 */
	public boolean identify(Member man) {
		if (!(man instanceof Member)) {
			return false;
		}
		return this.bord.isSameBord(((Member) man).bord);
	}

}
