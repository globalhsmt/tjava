package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * �{�̂��Ӗ����܂��B
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
      throw new RuntimeException("key��null�ł��B");
    } else if (!keys.contains(key)){
      throw new RuntimeException("key������܂���Bkey:" + key);
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
//    //game�̒�`
//    blocks = new HashMap<String, TheBlock>();
//
//  }
//
//  /**
//   * blockID��S���Ԃ��܂��B
//   * @return
//   * @author works
//   */
//  public Set<String> getBlockID() {
//    return blocks.keySet();
//  }
//
//  public boolean isCanMove(String key, TheMove move) {
//    if (this.blocks.keySet().contains(key)) {
//      throw new RuntimeException("key���݂���Ȃ���:" + key);
//    }
//    TheBlock base = new TheBlock(blocks.get(key), move);
//    if (!checkWall(base)) {
//      return false;
//    }
//
//  }
//
//  /**
//   * �ǂɂ߂荞��ł��Ȃ����`�F�b�N���܂��B
//   * @param block
//   * @return �߂肱��ł����false
//   * @author works
//   */
//  public boolean checkWall(TheBlock block) {
//    return (block.getX1() >= 0 && block.getY1() >= 0 && block.getX2() <= WIDTH && block.getX2() <= HEIGHT);
//  }
//  
//  public boolean checkFriend(TheBlock block) {
//    for(TheBlock friend : blocks.values()){
//      if(!friend.getID().equals(block.getID())){
//        //ID���Ⴄ���Ƀ`�F�b�N�i�����Ȃ玩���̑O�̈ʒu�Ȃ̂ŋC�ɂ��Ȃ�
//        //�d�Ȃ�`�F�b�N
//        
//        
//        
//      }
//    }
//  }

}
