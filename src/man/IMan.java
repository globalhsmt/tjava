package man;

import java.util.List;

/**
 * �l���Ӗ����܂��B
 */
public interface IMan {

  /**
   * �q�ǂ������i���̐���j��Ԃ��܂��B
   * ���̐���́A�K�����݂��܂��B�isize > 0�j
   * @return
   * @author works
   */
  public List<IMan> getChildren();

  /**
   * ���g�̐�c�B��print���܂��B
   * 
   * @author works
   */
  public void writeHistry();

  /**
   * �ړI�̐l�Ȃ��True
   * @return
   * @author works
   */
  public boolean isTrueMan();

  /**
   * ����Ɠ�����`�q�Ȃ��true��Ԃ��܂��B
   * @param man
   * @return
   * @author works
   */
  public boolean identify(IMan man);

}
