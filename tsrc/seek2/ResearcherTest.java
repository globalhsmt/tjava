package seek2;

import game.TestStage;
import game.TheMove;
import game.TheMove.DIRECTION;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ResearcherTest {

  @Test
  public void testDoResearch1() {

    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 0);

    List<TheMove > moveList = new ArrayList<TheMove>();
    
    moveList.add(new TheMove("A",DIRECTION.LEFT));
    moveList.add(new TheMove("A",DIRECTION.RIGHT));
    moveList.add(new TheMove("A",DIRECTION.RIGHT));
    List<TheMove> result = new Researcher().doResearch(ts1, moveList);
    
    Assert.assertEquals(1, result.size());
    Assert.assertEquals(new TheMove("A", DIRECTION.RIGHT), result.get(0));
  }
  
  @Test
  public void testDoResearch2() {

    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 0);

    List<TheMove > moveList = new ArrayList<TheMove>();
    
    moveList.add(new TheMove("A",DIRECTION.LEFT));
    moveList.add(new TheMove("A",DIRECTION.DOWN));
    moveList.add(new TheMove("A",DIRECTION.RIGHT));
    moveList.add(new TheMove("A",DIRECTION.RIGHT));
    moveList.add(new TheMove("A",DIRECTION.UP));
    moveList.add(new TheMove("A",DIRECTION.LEFT));
    moveList.add(new TheMove("A",DIRECTION.DOWN));
    List<TheMove> result = new Researcher().doResearch(ts1, moveList);
    
    Assert.assertEquals(1, result.size());
    Assert.assertEquals(new TheMove("A", DIRECTION.DOWN), result.get(0));
  }
}
