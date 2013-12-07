package game;

import game.TheMove.DIRECTION;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Seek2 {

  private final Set<TheMove> mainSet;
  private final List<TheMove> noMainList;
  private TheBord bord;

  public Seek2(IStage stage) {
    bord = new TheBord(stage.makeStage(), stage.getMainId());

    mainSet = new HashSet<TheMove>();
    noMainList = new ArrayList<TheMove>();
    for (DIRECTION dir : DIRECTION.values()) {
      noMainList.add(new TheMove(stage.getMainId(), dir));
    }
    for (String id : bord.getBlockIdSet()) {
      if (id.equals(stage.getMainId())) {
        continue;
      }
      for (DIRECTION dir : DIRECTION.values()) {
        noMainList.add(new TheMove(id, dir));
      }
    }
  }

  public void doexecute() {
    List<TheMove> moveList = new ArrayList<TheMove>();
    int count = 0;

    TheMove lastMove = null;
    while (true) {
      //Ç∏Ç¡Ç∆Ç‚ÇËë±ÇØÇÈ
      count++;
      if (bord.isGoal()) {
        System.out.println("gorl!");
//        System.out.println(printMyHistory(moveList));
        return;
      }

      if (count % 100 == 0) {
        System.out.println("cnt :" + count);
      }
      lastMove = dicideNextMove(lastMove);
      moveList.add(lastMove);
      putMove(count,lastMove);
      bord = bord.makeNextBord(lastMove);
    }
  }

  private TheMove dicideNextMove(TheMove lastMove) {
    TheBord next = null;
    //Ç∆ÇËÇ†Ç¶Ç∏mainIdÇ™ìÆÇ©ÇπÇÈÇ©ééÇ∑
    for (TheMove move : mainSet) {
      if (isSame(move, lastMove)) {
        continue;
      } else {
        next = bord.makeNextBord(move);
        if (next != null) {
          return move;
        }
      }
    }
    List<TheMove> tmpList = new ArrayList<TheMove>(noMainList);
    while (tmpList.size() > 0) {
      Random rn = new Random();
      int val = rn.nextInt(tmpList.size());
      TheMove move = (TheMove) tmpList.get(val);
      if (!isSame(move, lastMove)) {
        next = bord.makeNextBord(move);
        if (next != null) {
          return move;
        }
      }
      tmpList.remove(val);
    }
    //âΩÇ‡å©Ç¬Ç©ÇÁÇ»Ç¢éûÇÕÅAí˙ÇﬂÇƒñﬂÇÈÅB
    return new TheMove(lastMove.getId(),getAnotherSide(lastMove.getDir()));
  }

  public String printMyHistory(List<TheMove> moveHistory) {
    StringBuilder sb = new StringBuilder();
    String sp = System.getProperty("line.separator");
    for (TheMove move : moveHistory) {
      sb.append(move.getId());
      sb.append(" ");
      sb.append(move.getDir().name());
      sb.append(sp);
    }
    return sb.toString();
  }

  public void putMove(int count,TheMove move) {
    System.out.println(count + " " +  move.getId() + " " + move.getDir().name());
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

  private boolean isSame(TheMove move1, TheMove move2) {
    if (move1 != null && move2 != null && move1.getId().equals(move2.getId())) {
     return move1.getDir() == getAnotherSide(move2.getDir());
    }
    return false;
  }

}
