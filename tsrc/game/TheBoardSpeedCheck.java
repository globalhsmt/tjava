package game;

import game.TheMove.DIRECTION;
import game.stage.Stage42;


public class TheBoardSpeedCheck {

  
  
  public static void main(String[] arg) {

    long start = System.currentTimeMillis();

    AbsStage stage = new Stage42();
    TheBoard bord = new TheBoard(stage.makeStage(), stage.getMainId());

    TheBoard next = bord.makeNextBord(new TheMove("A3", DIRECTION.DOWN));
    next = next.makeNextBord(new TheMove("A3", DIRECTION.UP));
    for (int i = 0; i < 10000000; i++) {
      next.equals(bord);
    }
    long end = System.currentTimeMillis();
    System.out.println("Œo‰ßŽžŠÔ:" + (end - start));

  }
  
}
