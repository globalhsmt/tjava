package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 板本体を意味します。
 * @author works
 */
public class TheBord {

  private static final int WIDTH = 4;
  private static final int HEIGHT = 5;
  
  private String[][] map;
  
  private Set<String> keys;
  
  
  public Set<String> getKeys(){
    return this.keys;
  }
  
  public boolean canMove(String key,TheMove move){
    if (key == null){
      throw new RuntimeException("keyがnullです。");
    } else if (!keys.contains(key)){
      throw new RuntimeException("keyがありません。key:" + key);
    } else {
      for (int x = 0 ; x < WIDTH ; x++){
        for (int y = 0 ; y < HEIGHT ; y++){
            
          
          
          
        }
      }
      
      
      
      
    }
  }
  
  
  
  
  
//
//  private Map<String, TheBlock> blocks;
//
//  public TheBord() {
//    //gameの定義
//    blocks = new HashMap<String, TheBlock>();
//
//  }
//
//  /**
//   * blockIDを全部返します。
//   * @return
//   * @author works
//   */
//  public Set<String> getBlockID() {
//    return blocks.keySet();
//  }
//
//  public boolean isCanMove(String key, TheMove move) {
//    if (this.blocks.keySet().contains(key)) {
//      throw new RuntimeException("keyがみつからないよ:" + key);
//    }
//    TheBlock base = new TheBlock(blocks.get(key), move);
//    if (!checkWall(base)) {
//      return false;
//    }
//
//  }
//
//  /**
//   * 壁にめり込んでいないかチェックします。
//   * @param block
//   * @return めりこんでいるとfalse
//   * @author works
//   */
//  public boolean checkWall(TheBlock block) {
//    return (block.getX1() >= 0 && block.getY1() >= 0 && block.getX2() <= WIDTH && block.getX2() <= HEIGHT);
//  }
//  
//  public boolean checkFriend(TheBlock block) {
//    for(TheBlock friend : blocks.values()){
//      if(!friend.getID().equals(block.getID())){
//        //IDが違う時にチェック（同じなら自分の前の位置なので気にしない
//        //重なりチェック
//        
//        
//        
//      }
//    }
//  }

}
