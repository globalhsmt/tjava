package seek;

import junit.framework.Assert;

import org.junit.Test;

public class GenelationSeekerTest {

  @Test
  public void doTest(){
    /**
     * そのうち同じ人しか登場しなくなるようなループパターンで、
     * 正しく抜けてfalseを返すかどうかをテストする。
     */
    GenelationSeeker seeker = new GenelationSeeker();
    Assert.assertEquals(false, seeker.seek(new NotTrueMan()));
  }

  @Test
  public void doTest2(){
    /**
     * そのうち子孫が登場するようなループパターンで、
     * 正しく抜けてtrueを返すかどうかをテストする。
     */
    GenelationSeeker seeker = new GenelationSeeker();
    Assert.assertEquals(true, seeker.seek(new TrueMan()));
  }
  
}
