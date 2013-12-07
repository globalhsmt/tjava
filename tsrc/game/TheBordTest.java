package game;

import game.TheMove.DIRECTION;

import org.junit.Assert;
import org.junit.Test;

public class TheBordTest {

  /**
   * ボード移動のテスト
   *NGパターン1:（壁）に移動
   * NGパターン2:他のブロックの場所に移動
   * OKパターン：空いている場所
   * をそれぞれテストします。
   * OKパターンの時は、ちゃんと想定通りの位置に移動出来ているかも確認します。
   * @author works
   */
  @Test
  public void makeNextBordTest1() {

    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());

    //NGパターン（壁がある）
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NGパターン（他のブロックがある）
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OKパターン
    result = bord.makeNextBord(new TheMove("A", DIRECTION.DOWN));
    Assert.assertNotNull(result);

    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 1, 1);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    
    result = result.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず
    
    
    result = bord.makeNextBord(new TheMove("A", DIRECTION.RIGHT));
    Assert.assertNotNull(result);

    expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 2, 0);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));

    result = result.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず
    
  }

  /**
   * 同
   * ブロックが横長のとき
   * 
   * @author works
   */
  @Test
  public void makeNextBordTest2() {
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    ts1.putCell("A", 2, 0);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());

    //NGパターン（壁がある）
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NGパターン（他のブロックがある）
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OKパターン
    result = bord.makeNextBord(new TheMove("A", DIRECTION.DOWN));
    Assert.assertNotNull(result);

    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 1, 1);
    expectedStage.putCell("A", 2, 1);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず

    result = bord.makeNextBord(new TheMove("A", DIRECTION.RIGHT));
    Assert.assertNotNull(result);

    expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 2, 0);
    expectedStage.putCell("A", 3, 0);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず
  }

  @Test
  public void makeNextBordTest3() {
    //縦に長い時
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    ts1.putCell("A", 1, 1);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());

    //NGパターン（壁がある）
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NGパターン（他のブロックがある）
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OKパターン
    result = bord.makeNextBord(new TheMove("A", DIRECTION.DOWN));
    Assert.assertNotNull(result);

    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 1, 1);
    expectedStage.putCell("A", 1, 2);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず

    result = bord.makeNextBord(new TheMove("A", DIRECTION.RIGHT));
    Assert.assertNotNull(result);

    expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 2, 0);
    expectedStage.putCell("A", 2, 1);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず
  }
  

  @Test
  public void makeNextBordTest4() {
    //四角
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    ts1.putCell("A", 1, 1);
    ts1.putCell("A", 2, 0);
    ts1.putCell("A", 2, 1);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());

    //NGパターン（壁がある）
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NGパターン（他のブロックがある）
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OKパターン
    result = bord.makeNextBord(new TheMove("A", DIRECTION.DOWN));
    Assert.assertNotNull(result);

    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 1, 1);
    expectedStage.putCell("A", 1, 2);
    expectedStage.putCell("A", 2, 1);
    expectedStage.putCell("A", 2, 2);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず

    result = bord.makeNextBord(new TheMove("A", DIRECTION.RIGHT));
    Assert.assertNotNull(result);

    expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 2, 0);
    expectedStage.putCell("A", 2, 1);
    expectedStage.putCell("A", 3, 0);
    expectedStage.putCell("A", 3, 1);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result =result.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertTrue(result.isSameBord(bord));//最初に戻っているはず
  }

  @Test(expected = RuntimeException.class)
  public void makeNextBordTest5() {
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    bord.makeNextBord(null);
  }
  
  /**
   * ゴールの位置にいるかどうかの判定に利用しています。
   * 全然ゴールにならないケース
   * 惜しいケース（一部がゴールにいる）
   * ゴールになっているケース（×ブロックの形パターン）
   * を、試します。
   * @author works
   */
  @Test
  public void isGoalTest(){
    //////////////////////
    //全然駄目
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 0);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertFalse(bord.isGoal());
    
    //////////////////////
    //惜しいケース1
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 0, 4);
    ts1.putCell("A", 1, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertFalse(bord.isGoal());
    

    //////////////////////
    //惜しいケース2
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 2, 4);
    ts1.putCell("A", 3, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertFalse(bord.isGoal());
    
    //////////////////////
    //ゴールケース1(小さい）
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertTrue(bord.isGoal());


    //////////////////////
    //ゴールケース2(縦長）
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 2, 3);
    ts1.putCell("A", 2, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertTrue(bord.isGoal());

    //////////////////////
    //ゴールケース3(横長）
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 4);
    ts1.putCell("A", 2, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertTrue(bord.isGoal());
    //////////////////////
    //ゴールケース4(大）
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 3);
    ts1.putCell("A", 2, 3);
    ts1.putCell("A", 1, 4);
    ts1.putCell("A", 2, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertTrue(bord.isGoal());
    
    
  }
  
  /**
   * makeNextBordTestでやっているので省略です。
   * 
   * @author works
   */
  public void isSameBordTest(){
    
  }
  
  

}
