package game;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import game.TheBord;
import game.TheMove.DIRECTION;
import game.stage.Stage42;

import org.junit.Test;

public class Seek2Test {
  
  @Test
  public void testSeek2() {
    
    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("A", 1, 3);
    
      new Seek2(new Stage42()).doexecute();
  }
}
