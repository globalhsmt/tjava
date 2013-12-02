package seek;

import java.util.HashSet;
import java.util.Set;

import man.IMan;

/**
 * 家族の歴史です。
 * @author works
 */
public class FamilyHistory {

  private Set<IMan> mans;

  public FamilyHistory() {
    this.mans = new HashSet<IMan>();
  }

  /**
   * 人をセットします。
   * 過去に同じ遺伝子の人がいたらfalseを返します。
   * @param m
   * @return
   * @author works
   */
  public boolean putMan(IMan m) {
    for (IMan man : mans) {
      if (m.identify(man)) {
        //同じIDならfalse
        return false;
      }
    }
    mans.add(m);
    return true;
  }

}
