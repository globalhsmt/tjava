package game;

import java.util.HashSet;
import java.util.Set;

public class TestStage implements IStage {

  private String mainId;
  private Set<TheCell> cellset;

  public TestStage() {
    cellset = new HashSet<TheCell>();
  }

  public void putCell(String id, int x, int y) {
    cellset.add(new TheCell(id, x, y));
  }

  @Override
  public Set<TheCell> makeStage() {
    return cellset;
  }

  @Override
  public String getMainId() {
    return mainId;
  }

  public void setMainId(String mainId) {
    this.mainId = mainId;
  }

}
