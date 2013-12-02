package seek;

import junit.framework.Assert;

import org.junit.Test;

public class GenelationSeekerTest {

  @Test
  public void doTest(){
    /**
     * ���̂��������l�����o�ꂵ�Ȃ��Ȃ�悤�ȃ��[�v�p�^�[���ŁA
     * ������������false��Ԃ����ǂ������e�X�g����B
     */
    GenelationSeeker seeker = new GenelationSeeker();
    Assert.assertEquals(false, seeker.seek(new NotTrueMan()));
  }

  @Test
  public void doTest2(){
    /**
     * ���̂����q�����o�ꂷ��悤�ȃ��[�v�p�^�[���ŁA
     * ������������true��Ԃ����ǂ������e�X�g����B
     */
    GenelationSeeker seeker = new GenelationSeeker();
    Assert.assertEquals(true, seeker.seek(new TrueMan()));
  }
  
}
