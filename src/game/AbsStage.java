package game;

import java.util.HashSet;
import java.util.Set;

/**
 * �X�e�[�W�i�u���b�N�̏����z�u�j���Ӗ����钊�ۃN���X�ł��B
 * �e�X�e�[�W�͂��̃N���X���p�����ĉ������B
 * �Z���̏����z�u��putCell���\�b�h�ɂā^�S�[���ʒu�Ɉړ�������K�v������u���b�N��ID���AsetMainId�ɂăZ�b�g���ĉ������B
 * @author works
 */
public abstract class AbsStage {

  private Set<TheCell> cellSet;
  private String mainId;

  public AbsStage() {
    this.cellSet = new HashSet<TheCell>();
  }

  /**
   * �u���b�N�̈ʒu���Z�b�g���܂��B
   * �����}�X�ɂ܂�����u���b�N�́A��ID�ɂāAx,y�̒l��ύX���ĕ�����Ăяo���ĉ������B
   * x,y�́A�̍��ォ��E����щ��ɉ��}�X��̃}�X�����Ӗ����܂��B
   * �Ⴆ�΍����0,0�ƂȂ�A�E����3,4�ƂȂ�܂��B
   * @param id �u���b�N��ID
   * @param x ��
   * @param y �c
   * @author works
   */
  protected void putCell(String id, int x, int y) {
    cellSet.add(new TheCell(id, x, y));
  }

  /**
   * �S�[���ʒu�Ɉړ�������K�v������u���b�N��ID�ł��B
   * @param mainId
   * @author works
   */
  protected void setMainId(String mainId) {
    this.mainId = mainId;
  }

  final Set<TheCell> makeStage() {
    return this.cellSet;
  }

  String getMainId() {
    return this.mainId;
  }
}
