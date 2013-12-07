package seek2;

import game.IStage;
import game.TheMove;
import game.stage.Stage42;

import java.util.List;

public class Capitalist {
  
  
  public static void main(String[] arg){
    IStage stage = new Stage42();
//    List<TheMove> moveList = new Seekworker().work(stage);
    List<TheMove> moveList = new Seekworker().work(stage,5000,5);
    if(moveList == null){
      System.out.println("Œ©‚Â‚©‚è‚Ü‚¹‚ñ");
    } else {
      System.out.println("Œ©‚Â‚©‚è‚Ü‚µ‚½ :" + moveList.size());
    }
    
    
    moveList = new Researcher().doResearch(stage, moveList);
    
    int cnt = 1;
    for (TheMove move : moveList) {
      System.out.println(cnt + ":" + move.getId() + " " + move.getDir());
      cnt++;
    }
    
    
  }
  

}
