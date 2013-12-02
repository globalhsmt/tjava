package seek;

import man.IMan;

/**
 * 
 * @author works
 */
public class World {

  /**
   * @param args
   * @author works
   */
  public static void main(String[] args) {
    IMan ori = Origine.born();//î≠èÀ
    GenelationSeeker seeker = new GenelationSeeker();
    seeker.seek(ori);
  }

}
