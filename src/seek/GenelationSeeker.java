package seek;

import java.util.ArrayList;
import java.util.List;

import man.IMan;

/**
 * �q���B�̒���������ɓK������l��T���܂��B
 * @author works
 */
public class GenelationSeeker {

  public GenelationSeeker() {
  }

  private FamilyHistory his;

  /**
   * origin�̎q������A�����ɓK������l��T���܂��B
   * �{�l�ɂ��Ă��A���肵�܂��B
   * ����������A���̐l��Ԃ��܂��B
   * �q����X�T���Ă�������Ȃ������ꍇ�́Anull��Ԃ��܂��B
   * @param origin
   * @author works
   */
  public boolean seek(IMan origin) {
    IMan trueMan = seekFirst(origin);
    if (trueMan != null) {
      System.out.println("�݂�����");
      trueMan.writeHistry();
      return true;
    } else {
      System.out.println("�݂���Ȃ�");
      return false;
    }
  }

  private IMan seekFirst(IMan origin) {
    if (origin.isTrueMan()) {
      return origin;
    }
    his = new FamilyHistory();
    his.putMan(origin);//�ŏ��̃X�i�b�v���Ƃ��Ă���
    return seekNext(origin.getChildren());
  }

  /**
   * �q�ǂ���������T���܂��B
   * ���Ȃ���΁A���A�Б�.... �ƌ�����܂ŒT���Ă����܂��B
   * �Ō�܂Ō�����Ȃ��ꍇ�́Afalse��Ԃ��܂��B
   * @param tasks
   * @return
   * @author works
   */
  private IMan seekNext(List<IMan> tasks) {
    List<IMan> nextGenelations = new ArrayList<IMan>();
    for (IMan fortune : tasks) {
      if (fortune.isTrueMan()) {
        //����
        return fortune;
      } else if (his.putMan(fortune)) {
        //���o�^�̈�`�q�́A�X�Ɏq����T��
        nextGenelations.addAll(fortune.getChildren());
      } else {
        //������`�q�̐l�́A�����q����T���K�v�͂Ȃ��B
      }
    }
    if (nextGenelations.size() > 0) {
      //����������A���������{
      return seekNext(nextGenelations);
    } else {
      return null;//�������Ȃ�������null��Ԃ��B
    }
  }

}
