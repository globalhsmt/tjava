package man;

import java.util.List;

/**
 * 人を意味します。
 */
public interface IMan {

  /**
   * 子どもたち（次の世代）を返します。
   * 次の世代は、必ず存在します。（size > 0）
   * @return
   * @author works
   */
  public List<IMan> getChildren();

  /**
   * 自身の先祖達をprintします。
   * 
   * @author works
   */
  public void writeHistry();

  /**
   * 目的の人ならばTrue
   * @return
   * @author works
   */
  public boolean isTrueMan();

  /**
   * 相手と同じ遺伝子ならばtrueを返します。
   * @param man
   * @return
   * @author works
   */
  public boolean identify(IMan man);

}
