package seek2;

import game.IStage;
import game.TheBord;
import game.TheMove;
import game.TheMove.DIRECTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 探し続ける人です。
 * @author works
 */
public class Seekworker {

  private List<TheMove> selections;
  private TheBord bord;

  public Seekworker() {
  }

  /**
   * 品質条件と納期付きで働きます。
   * むりなら　nullを返します。
   * @param stage
   * @param maxCount 何回以内か（品質条件）
   * @param minutes 何分以内か（納期）
   * @return
   * @author works
   */
  public List<TheMove> work(IStage stage,int maxCount,int minutes){
      long endTime = System.currentTimeMillis() + (60000 * minutes);
      while(System.currentTimeMillis() < endTime){
        List<TheMove> moveList = work(stage,maxCount);
        if(moveList != null){
          return moveList;
        }
    }
      return null;
  }
  
  
  
  
  /**
   * 答えを見つけるまでひたすら頑張ります。
   * @param stage
   * @return
   * @author works
   */
  public List<TheMove> work(IStage stage) {
    return work(stage, 0);
  }
  
  private List<TheMove> work(IStage stage,int maxCount) {

    bord = new TheBord(stage);
    selections = new ArrayList<TheMove>();
    for (String id : bord.getBlockIdSet()) {
      for (DIRECTION dir : DIRECTION.values()) {
        selections.add(new TheMove(id, dir));
      }
    }

    List<TheMove> moveList = new ArrayList<TheMove>();

    TheMove lastMove = null;
    int count = 0;
    while (!bord.isGoal()) {
      if (maxCount > 0 && count > maxCount) {
        return null;
      }

      lastMove = dicideNextMove(lastMove);
      moveList.add(lastMove);
      bord = bord.makeNextBord(lastMove);
      count++;
    }
    return moveList;
  }

  /**
   * 次のmoveをてきとうに決めます。
   * @param lastMove
   * @return
   * @author works
   */
  private TheMove dicideNextMove(TheMove lastMove) {
    TheBord next = null;
    List<TheMove> tmpList = new ArrayList<TheMove>(selections);

    TheMove back = null;
    if (lastMove != null) {
      back = new TheMove(lastMove.getId(), getAnotherSide(lastMove.getDir()));
    }

    while (tmpList.size() > 0) {
      Random rn = new Random();
      int val = rn.nextInt(tmpList.size());
      TheMove move = (TheMove) tmpList.get(val);
      //てきとうに試してみる。

      if (!move.equals(back)) {
        //戻るときは除外
        next = bord.makeNextBord(move);
        if (next != null) {
          return move;
        }
      }
      tmpList.remove(val);
    }
    //何も見つからない時は、諦めて戻る。
    return back;
  }

  public void putMove(int count, TheMove move) {
    System.out.println(count + " " + move.getId() + " " + move.getDir().name());
  }

  private DIRECTION getAnotherSide(DIRECTION dir) {
    switch (dir) {
      case DOWN:
        return DIRECTION.UP;
      case LEFT:
        return DIRECTION.RIGHT;
      case RIGHT:
        return DIRECTION.LEFT;
      case UP:
        return DIRECTION.DOWN;
      default:
        throw new RuntimeException();
    }
  }

}
