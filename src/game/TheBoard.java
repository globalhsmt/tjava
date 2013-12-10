package game;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 板です。 ブロックを持ち、ブロックに対する操作を受け持ちます。 
 * ブロックを動かせるかどうかと、動かしたらどうなるかは判定できますが、
 * それ以上のこと（どう動かせばよいか？）は出来ません。
 * 
 * @author works
 */
public class TheBoard {

  private final Set<TheCell> cellSet;
  private final String mainId;//
  private static final int WIDTH = 4;
  private static final int HEIGHT = 5;

  /**
   * boardの生成
   * @param cellSet
   * @param mainId
   */
  TheBoard(Set<TheCell> cellSet, String mainId) {
    this.cellSet = cellSet;
    ;
    this.mainId = mainId;
  }
  
  public TheBoard(AbsStage stage) {
    this.cellSet = stage.makeStage();
    this.mainId = stage.getMainId();
  }

  /**
   * 持っているブロックのIDを返します。
   * 
   * @return
   */
  public Set<String> getBlockIdSet() {
    Set<String> idSet = new HashSet<String>();
    for (TheCell cell : cellSet) {
      idSet.add(cell.getId());
    }
    return idSet;
  }
  
  /**
   * idブロックをmoveした後の姿を返します。 操作が実行できなかった場合（移動先に別のブロックがある等）は、nullを返します。
   * @param move
   * @return
   */
  public TheBoard makeNextBord(TheMove move) {
    if (move == null) {
      throw new RuntimeException("null");
    }
    Set<TheCell> nextCan = makeNext(move);
    if (auditBlocks(nextCan)) {
      return new TheBoard(nextCan, mainId);
    } else {
      return null;
    }
  }

  /**
   * moveに従ってcellを移動させた結果のcellSetを返します。
   * 但し、この結果は整合性を担保しません。
   * @param move
   * @return
   * @author works
   */
  private Set<TheCell> makeNext(TheMove move) {
    Set<TheCell> tomorrow = new HashSet<TheCell>();
    for (TheCell cell : cellSet) {
      if (cell.getId().equals(move.getId())) {
        //idが同じ場合はmove
        tomorrow.add(cell.move(move.getDir()));
      } else {
        tomorrow.add(cell);
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
    if (mainId.equals(getCellId(0, 4)) || mainId.equals(getCellId(3, 4))) {
      //ここにあると、出られない
      return false;
    } else if (mainId.equals(getCellId(1, 4)) || mainId.equals(getCellId(2, 4))) {
      //すぐ出られる。
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
    for (TheCell cell : cellSet) {
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
      if (cell.getX() < 0 || cell.getX() >= WIDTH || cell.getY() < 0 || cell.getY() >= HEIGHT)
        //はみ出している人
        return false;
      for (TheCell ckd : checked) {//check済のと重複確認
        if (cell.getX() == ckd.getX() && cell.getY() == ckd.getY()) {
          //重なっている人
          return false;
        }
      }
      checked.add(cell);//問題なければcheckedに入れて次
    }
    return true;
  }

  /**
   * 同じブロック配置のボードかどうかを判定します。
   * 配置が不整合な場合は、判定結果は保証しません。
   * @param bord
   * @return
   */
  public boolean isSameBord(TheBoard bord) {
    if (!(bord.cellSet.size() == this.cellSet.size())) {
      return false;// 数が違う
    }
    for (TheCell cell : cellSet) {
      TheCell sameCell = null;
      for (TheCell there : bord.cellSet) {
        if (there.getId().equals(cell.getId()) && there.getX() == cell.getX() && there.getY() == cell.getY()) {
          sameCell = there;
        }
      }
      if (sameCell == null) {
        return false;//仲間ない
      }
    }
    return true;
  }

}
