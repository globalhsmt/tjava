package game;

import game.TheMove.DIRECTION;
import game.stage.Stage42;

import org.junit.Assert;

public class TheBordSpeedCheck {

  
  
  public static void main(String[] arg) {

    long start = System.currentTimeMillis();

    IStage stage = new Stage42();
    TheBord bord = new TheBord(stage.makeStage(), stage.getMainId());

    TheBord next = bord.makeNextBord(new TheMove("A3", DIRECTION.DOWN));
    next = next.makeNextBord(new TheMove("A3", DIRECTION.UP));
    for (int i = 0; i < 10000000; i++) {
      next.equals(bord);
    }
    long end = System.currentTimeMillis();
    System.out.println("Œo‰ßŽžŠÔ:" + (end - start));

  }
  
}
