package seek;

import game.TestStage;
import game.stage.Stage42;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class TheGameTest {

  
  @Test
  public void getChildrenTest(){
    TheGame game = new TheGame(new Stage42());

    List<TheGame> manList = game.getChildren();
    
    Assert.assertEquals(4, manList.size());//sizeŠm”F
    
    
    
    
    
    
  }
  
  
  
  
  @Test
  public void printMyHistoryTest(){
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    TheGame game = new TheGame(ts1);

   
    Assert.assertEquals("",  game.printMyHistory());
    
    game.getChildren();
    
    
    
  }
  
  
}
