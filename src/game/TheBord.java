package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * �ł��B �u���b�N�������A�u���b�N�ɑ΂��鑀����󂯎����܂��B 
 * �u���b�N�𓮂����邩�ǂ����ƁA����������ǂ��Ȃ邩�͔���ł��܂����A
 * ����ȏ�̂��Ɓi�ǂ��������΂悢���H�j�͏o���܂���B
 * 
 * @author works
 */
public class TheBord {

	private Map<String, TheCell> matrix;
	private String mainId;//
	private static final int WIDTH = 4;
	private static final int HEIGHT = 5;

	/**
	 * �����Ă���u���b�N��ID��Ԃ��܂��B
	 * 
	 * @return
	 */
	public Set<String> getBlockIdSet() {
		return this.matrix.keySet();
	}
	
	public TheBord(){
		
	}

	private TheBord(Map<String, TheCell> matrix) {
		this.matrix = matrix;
	}

	private boolean isCanMove(TheMove move) {
		if (!matrix.containsKey(move.getId())) {
			throw new RuntimeException("not exist id:" + move.getId());
		}
		return auditBlocks(makeNext(move).values());
	}

	/**
	 * id�u���b�N��move������̎p��Ԃ��܂��B ���삪���s�ł��Ȃ������ꍇ�i�ړ���ɕʂ̃u���b�N�����铙�j�́Anull��Ԃ��܂��B
	 * id�����݂��Ȃ��ꍇ�Amove��null�̏ꍇ�́AruntimeException�𓊂��܂��B
	 * 
	 * @param move
	 * @return
	 */
	public TheBord makeNextBord(TheMove move) {
		if (move == null){
			throw new RuntimeException("null");
		}
		if (isCanMove(move)) {
			return new TheBord(makeNext(move));
		} else {
			return null;
		}
	}

	private Map<String, TheCell> makeNext(TheMove move) {
		Map<String, TheCell> tomorrow = new HashMap<String, TheCell>();
		for (String key : matrix.keySet()) {
			if (key.equals(move.getId())) {
				tomorrow.put(key, matrix.get(key).move(move.getDir()));
			} else {
				tomorrow.put(key, matrix.get(key));
			}
		}
		return tomorrow;
	}

	/**
	 * �ړI��B���Ă���imainId�̃u���b�N������̈ʒu�ɂ��邩�j�ꍇ�́Atrue�ł��B
	 * 
	 * @return
	 */
	public boolean isGoal() {
		// �o�����mainId�̃u���b�N�������true
		if (mainId.equals(getCellId(1, 4)) && mainId.equals(getCellId(2, 4))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �w�肵���ʒu�ɂ���u���b�N��ID��Ԃ��܂��B �u���b�N���������null��Ԃ��܂��B
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private String getCellId(int x, int y) {
		for (TheCell cell : matrix.values()) {
			if (cell.getX() == x && cell.getY() == y) {
				return cell.getId();
			}
		}
		return null;
	}

	/**
	 * �u���b�N�z�u���K�؂��ǂ������`�F�b�N���܂��B �u���b�N�̏d����A�g����͂ݏo���Ă����ꍇ��false��Ԃ��܂��B
	 * 
	 * @param cells
	 * @return
	 */
	private static boolean auditBlocks(Collection<TheCell> cells) {
		Set<TheCell> checked = new HashSet<TheCell>();
		for (TheCell cell : cells) {
			if (cell.getX() < 0 || cell.getX() >= WIDTH || cell.getY() < 0
					|| cell.getY() >= HEIGHT)
				return false;
			for (TheCell ckd : checked) {
				if (cell.getX() == ckd.getX() && cell.getY() == ckd.getY()) {
					return false;
				} else {
					checked.add(ckd);
				}
			}
		}
		return true;
	}

	/**
	 * �����{�[�h���ǂ����𔻒�
	 * 
	 * @param bord
	 * @return
	 */
	public boolean isSameBord(TheBord bord) {
		if (!(bord.getBlockIdSet().size() == this.getBlockIdSet().size())) {
			return false;// �����Ⴄ
		}
		for (TheCell myCell : this.matrix.values()) {
			// cell�̈ʒu���Ⴄ
			TheCell there = bord.matrix.get(myCell.getId());
			if (there == null || myCell.getX() != there.getX()
					|| myCell.getY() != there.getY()) {
				return false;
			}
		}
		return true;

	}

}
