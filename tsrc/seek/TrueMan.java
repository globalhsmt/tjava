package seek;

import java.util.ArrayList;
import java.util.List;

import man.IMan;

public class TrueMan implements IMan {

  private int cnt = 1;

  public TrueMan() {

  }

  public TrueMan(int cnt) {
    this.cnt = cnt + 1;
  }

  @Override
  public List<IMan> getChildren() {
    List<IMan> list = new ArrayList<IMan>();
    list.add( new TrueMan(cnt));
    return list;
  }

  @Override
  public void writeHistry() {
    System.out.println(cnt);
  }

  @Override
  public boolean isTrueMan() {
    return cnt > 10;
  }

  @Override
  public boolean identify(IMan man) {
    return false;//“¯ˆêl•¨‚Í‚¢‚È‚¢‘z’è
  }

}
