package game;

import java.util.HashSet;
import java.util.Set;

public class stage1 implements IStage {

  @Override
  public Set<TheCell> makeStage() {
    Set<TheCell> cellSet = new HashSet<TheCell>();
    cellSet.add(new TheCell("A1", 0, 0));
    cellSet.add(new TheCell("A2", 0, 1));
    cellSet.add(new TheCell("A3", 0, 2));
    cellSet.add(new TheCell("A4", 0, 3));
    cellSet.add(new TheCell("A5", 0, 4));
    cellSet.add(new TheCell("D", 1, 0));
    cellSet.add(new TheCell("D", 1, 1));
    cellSet.add(new TheCell("B1", 1, 2));
    cellSet.add(new TheCell("B2", 1, 3));
    cellSet.add(new TheCell("D", 2, 0));
    cellSet.add(new TheCell("D", 2, 1));
    cellSet.add(new TheCell("C1", 2, 2));
    cellSet.add(new TheCell("C2", 2, 3));
    cellSet.add(new TheCell("D1", 3, 0));
    cellSet.add(new TheCell("D2", 3, 1));
    cellSet.add(new TheCell("D3", 3, 2));
    cellSet.add(new TheCell("D4", 3, 3));
    cellSet.add(new TheCell("D5", 3, 4));
    return cellSet;
  }

  @Override
  public String getMainId() {
    return "D";
  }

}
