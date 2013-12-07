package game;

import game.TheMove.DIRECTION;

import org.junit.Assert;
import org.junit.Test;

public class TheBordTest {

  /**
   * �{�[�h�ړ��̃e�X�g
   *NG�p�^�[��1:�i�ǁj�Ɉړ�
   * NG�p�^�[��2:���̃u���b�N�̏ꏊ�Ɉړ�
   * OK�p�^�[���F�󂢂Ă���ꏊ
   * �����ꂼ��e�X�g���܂��B
   * OK�p�^�[���̎��́A�����Ƒz��ʂ�̈ʒu�Ɉړ��o���Ă��邩���m�F���܂��B
   * @author works
   */
  @Test
  public void makeNextBordTest1() {

    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());

    //NG�p�^�[���i�ǂ�����j
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NG�p�^�[���i���̃u���b�N������j
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OK�p�^�[��
    result = bord.makeNextBord(new TheMove("A", DIRECTION.DOWN));
    Assert.assertNotNull(result);

    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 1, 1);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    
    result = result.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�
    
    
    result = bord.makeNextBord(new TheMove("A", DIRECTION.RIGHT));
    Assert.assertNotNull(result);

    expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 2, 0);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));

    result = result.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�
    
  }

  /**
   * ��
   * �u���b�N�������̂Ƃ�
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

    //NG�p�^�[���i�ǂ�����j
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NG�p�^�[���i���̃u���b�N������j
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OK�p�^�[��
    result = bord.makeNextBord(new TheMove("A", DIRECTION.DOWN));
    Assert.assertNotNull(result);

    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 1, 1);
    expectedStage.putCell("A", 2, 1);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�

    result = bord.makeNextBord(new TheMove("A", DIRECTION.RIGHT));
    Assert.assertNotNull(result);

    expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 2, 0);
    expectedStage.putCell("A", 3, 0);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�
  }

  @Test
  public void makeNextBordTest3() {
    //�c�ɒ�����
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    ts1.putCell("A", 1, 1);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());

    //NG�p�^�[���i�ǂ�����j
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NG�p�^�[���i���̃u���b�N������j
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OK�p�^�[��
    result = bord.makeNextBord(new TheMove("A", DIRECTION.DOWN));
    Assert.assertNotNull(result);

    TestStage expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 1, 1);
    expectedStage.putCell("A", 1, 2);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�

    result = bord.makeNextBord(new TheMove("A", DIRECTION.RIGHT));
    Assert.assertNotNull(result);

    expectedStage = new TestStage();
    expectedStage.setMainId("A");
    expectedStage.putCell("B", 0, 0);
    expectedStage.putCell("A", 2, 0);
    expectedStage.putCell("A", 2, 1);
    Assert.assertTrue(result.isSameBord(new TheBord(expectedStage.makeStage(), expectedStage.getMainId())));
    result = result.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�
  }
  

  @Test
  public void makeNextBordTest4() {
    //�l�p
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("B", 0, 0);
    ts1.putCell("A", 1, 0);
    ts1.putCell("A", 1, 1);
    ts1.putCell("A", 2, 0);
    ts1.putCell("A", 2, 1);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());

    //NG�p�^�[���i�ǂ�����j
    TheBord result = null;
    result = bord.makeNextBord(new TheMove("A", DIRECTION.UP));
    Assert.assertNull(result);

    //NG�p�^�[���i���̃u���b�N������j
    result = bord.makeNextBord(new TheMove("A", DIRECTION.LEFT));
    Assert.assertNull(result);

    //OK�p�^�[��
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
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�

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
    Assert.assertTrue(result.isSameBord(bord));//�ŏ��ɖ߂��Ă���͂�
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
   * �S�[���̈ʒu�ɂ��邩�ǂ����̔���ɗ��p���Ă��܂��B
   * �S�R�S�[���ɂȂ�Ȃ��P�[�X
   * �ɂ����P�[�X�i�ꕔ���S�[���ɂ���j
   * �S�[���ɂȂ��Ă���P�[�X�i�~�u���b�N�̌`�p�^�[���j
   * ���A�����܂��B
   * @author works
   */
  @Test
  public void isGoalTest(){
    //////////////////////
    //�S�R�ʖ�
    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 0);
    TheBord bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertFalse(bord.isGoal());
    
    //////////////////////
    //�ɂ����P�[�X1
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 0, 4);
    ts1.putCell("A", 1, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertFalse(bord.isGoal());
    

    //////////////////////
    //�ɂ����P�[�X2
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 2, 4);
    ts1.putCell("A", 3, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertFalse(bord.isGoal());
    
    //////////////////////
    //�S�[���P�[�X1(�������j
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertTrue(bord.isGoal());


    //////////////////////
    //�S�[���P�[�X2(�c���j
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 2, 3);
    ts1.putCell("A", 2, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertTrue(bord.isGoal());

    //////////////////////
    //�S�[���P�[�X3(�����j
    ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 4);
    ts1.putCell("A", 2, 4);
    bord = new TheBord(ts1.makeStage(), ts1.getMainId());
    Assert.assertTrue(bord.isGoal());
    //////////////////////
    //�S�[���P�[�X4(��j
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
   * makeNextBordTest�ł���Ă���̂ŏȗ��ł��B
   * 
   * @author works
   */
  public void isSameBordTest(){
    
  }
  
  

}
