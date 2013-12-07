package seek2;

import game.IStage;
import game.TheBord;
import game.TheMove;

import java.util.ArrayList;
import java.util.List;

public class Researcher {
  
  
  /**
   * moveList‚ğA‚æ‚èŒø—¦“I‚ÈmoveList‚É‚µ‚Ü‚·B
   * @param stage
   * @param moveList
   * @return
   * @author works
   */
  public List<TheMove> doResearch(IStage stage, List<TheMove> moveList) {

    List<TheMove> result = new ArrayList<TheMove>();
    TheBord compareBase = new TheBord(stage);

    List<TheMove> tmpMoveList = new ArrayList<TheMove>(moveList);
    TheBord tmpbord = compareBase;
    ;
    List<TheBord> bordList = new ArrayList<TheBord>();
    for (TheMove move : moveList) {
      tmpbord = tmpbord.makeNextBord(move);
      bordList.add(tmpbord);
    }

    while (tmpMoveList.size() > 0) {
      for (int idx = tmpMoveList.size() - 1; idx > 0; idx--) {
        if (compareBase.isSameBord(bordList.get(idx))) {
          for (int removeIndex = 0; removeIndex <= idx; removeIndex++) {
            bordList.remove(0);
            tmpMoveList.remove(0);
          }
          break;
        }
      }
      if (tmpMoveList.size() > 0) {
        result.add(tmpMoveList.remove(0));
        compareBase = bordList.remove(0);
      }

    }
    return result;
  }

}
