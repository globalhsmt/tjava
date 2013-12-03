package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 板です。 ブロックを持ち、ブロックに対する操作を受け持ちます。 
 * ブロックを動かせるかどうかと、動かしたらどうなるかは判定できますが、
 * それ以上のこと（どう動かせばよいか？）は出来ません。
 * 
 * @author works
 */
public class TheBord {

	private Map<String, TheCell> matrix;
	private String mainId;//
	private static final int WIDTH = 4;
	private static final int HEIGHT = 5;

	/**
	 * 持っているブロックのIDを返します。
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
	 * idブロックをmoveした後の姿を返します。 操作が実行できなかった場合（移動先に別のブロックがある等）は、nullを返します。
	 * idが存在しない場合、moveがnullの場合は、runtimeExceptionを投げます。
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
	 * 目的を達している（mainIdのブロックが所定の位置にあるか）場合は、trueです。
	 * 
	 * @return
	 */
	public boolean isGoal() {
		// 出口二つにmainIdのブロックがあればtrue
		if (mainId.equals(getCellId(1, 4)) && mainId.equals(getCellId(2, 4))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 指定した位置にあるブロックのIDを返します。 ブロックが無ければnullを返します。
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
	 * ブロック配置が適切かどうかをチェックします。 ブロックの重複や、枠からはみ出していた場合はfalseを返します。
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
	 * 同じボードかどうかを判定
	 * 
	 * @param bord
	 * @return
	 */
	public boolean isSameBord(TheBord bord) {
		if (!(bord.getBlockIdSet().size() == this.getBlockIdSet().size())) {
			return false;// 数が違う
		}
		for (TheCell myCell : this.matrix.values()) {
			// cellの位置が違う
			TheCell there = bord.matrix.get(myCell.getId());
			if (there == null || myCell.getX() != there.getX()
					|| myCell.getY() != there.getY()) {
				return false;
			}
		}
		return true;

	}

}
