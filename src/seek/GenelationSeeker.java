package seek;

import java.util.ArrayList;
import java.util.List;

import man.IMan;

/**
 * 子孫達の中から条件に適合する人を探します。
 * @author works
 */
public class GenelationSeeker {

  public GenelationSeeker() {
  }

  private FamilyHistory his;

  /**
   * originの子孫から、条件に適合する人を探します。
   * 本人についても、判定します。
   * 見つかったら、その人を返します。
   * 子孫代々探しても見つからなかった場合は、nullを返します。
   * @param origin
   * @author works
   */
  public boolean seek(IMan origin) {
    IMan trueMan = seekFirst(origin);
    if (trueMan != null) {
      System.out.println("みつかった");
      trueMan.writeHistry();
      return true;
    } else {
      System.out.println("みつからない");
      return false;
    }
  }

  private IMan seekFirst(IMan origin) {
    if (origin.isTrueMan()) {
      return origin;
    }
    his = new FamilyHistory();
    his.putMan(origin);//最初のスナップをとっておく
    return seekNext(origin.getChildren());
  }

  /**
   * 子どもたちから探します。
   * いなければ、孫、ひ孫.... と見つかるまで探していきます。
   * 最後まで見つからない場合は、falseを返します。
   * @param tasks
   * @return
   * @author works
   */
  private IMan seekNext(List<IMan> tasks) {
    List<IMan> nextGenelations = new ArrayList<IMan>();
    for (IMan fortune : tasks) {
      if (fortune.isTrueMan()) {
        //完了
        return fortune;
      } else if (his.putMan(fortune)) {
        //未登録の遺伝子は、更に子供を探す
        nextGenelations.addAll(fortune.getChildren());
      } else {
        //同じ遺伝子の人は、もう子供を探す必要はない。
      }
    }
    if (nextGenelations.size() > 0) {
      //孫がいたら、続きを実施
      return seekNext(nextGenelations);
    } else {
      return null;//もういなかったらnullを返す。
    }
  }

}
