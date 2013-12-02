package seek;

import java.util.ArrayList;
import java.util.List;

import man.IMan;

public class NotTrueMan implements IMan {

  private int cnt;

  private static final int BASE_NUM = 31;

  public NotTrueMan() {

  }

  public NotTrueMan(int newCnt) {
    this.cnt = newCnt;
  }

  @Override
  public List<IMan> getChildren() {
    List<IMan> list = new ArrayList<IMan>();
    list.add(new NotTrueMan(cnt + 1));
    list.add(new NotTrueMan(cnt + 2));
    list.add(new NotTrueMan(cnt + 3));
    return list;
  }

  @Override
  public void writeHistry() {

  }

  @Override
  public boolean isTrueMan() {
    return false;
  }

  @Override
  public boolean identify(IMan man) {
    if (man instanceof NotTrueMan) {
      if ((this.cnt % BASE_NUM) == (((NotTrueMan) man).getCnt() % BASE_NUM)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public int getCnt() {
    return cnt;
  }

}
