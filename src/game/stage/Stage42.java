package game.stage;

import java.util.HashSet;
import java.util.Set;

import game.IStage;
import game.TheCell;

public class Stage42 implements IStage {

  @Override
  public Set<TheCell> makeStage() {
    Set<TheCell> cellSet = new HashSet<TheCell>();
    cellSet.add(new TheCell("B3", 0, 0));
    cellSet.add(new TheCell("B3", 0, 1));
    cellSet.add(new TheCell("B1", 0, 2));
    cellSet.add(new TheCell("B1", 0, 3));
    cellSet.add(new TheCell("A1", 0, 4));
    cellSet.add(new TheCell("D", 1, 0));
    cellSet.add(new TheCell("D", 1, 1));
    cellSet.add(new TheCell("C1", 1, 2));
    cellSet.add(new TheCell("A3", 1, 3));
    cellSet.add(new TheCell("D", 2, 0));
    cellSet.add(new TheCell("D", 2, 1));
    cellSet.add(new TheCell("C1", 2, 2));
    cellSet.add(new TheCell("A4", 2, 3));
    cellSet.add(new TheCell("B4", 3, 0));
    cellSet.add(new TheCell("B4", 3, 1));
    cellSet.add(new TheCell("B2", 3, 2));
    cellSet.add(new TheCell("B2", 3, 3));
    cellSet.add(new TheCell("A2", 3, 4));
    return cellSet;
  }

  @Override
  public String getMainId() {
    return "D";
  }

}
