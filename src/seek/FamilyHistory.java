package seek;

import java.util.HashSet;
import java.util.Set;

import man.IMan;

/**
 * �Ƒ��̗��j�ł��B
 * @author works
 */
public class FamilyHistory {

  private Set<IMan> mans;

  public FamilyHistory() {
    this.mans = new HashSet<IMan>();
  }

  /**
   * �l���Z�b�g���܂��B
   * �ߋ��ɓ�����`�q�̐l��������false��Ԃ��܂��B
   * @param m
   * @return
   * @author works
   */
  public boolean putMan(IMan m) {
    for (IMan man : mans) {
      if (m.identify(man)) {
        //����ID�Ȃ�false
        return false;
      }
    }
    mans.add(m);
    return true;
  }

}
