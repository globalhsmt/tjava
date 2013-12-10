package seek2;

import game.TestStage;
import game.TheMove;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 *  とりあえず動くかどうか（落ちないかどうか）だけテストします。
 * @author works
 */
public class SeekworkerTest {
  @Test
  public void testDoResearch1() {

    TestStage ts1 = new TestStage();
    ts1.setMainId("A");
    ts1.putCell("A", 1, 0);

    List<TheMove> result = new Seekworker().work(ts1, 1000, 1);
    Assert.assertNotNull(result);

  }
}
