package game;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * �ł��B �u���b�N�������A�u���b�N�ɑ΂��鑀����󂯎����܂��B 
 * �u���b�N�𓮂����邩�ǂ����ƁA����������ǂ��Ȃ邩�͔���ł��܂����A
 * ����ȏ�̂��Ɓi�ǂ��������΂悢���H�j�͏o���܂���B
 * 
 * @author works
 */
public class TheBoard {

  private final Set<TheCell> cellSet;
  private final String mainId;//
  private static final int WIDTH = 4;
  private static final int HEIGHT = 5;

  /**
   * board�̐���
   * @param cellSet
   * @param mainId
   */
  TheBoard(Set<TheCell> cellSet, String mainId) {
    this.cellSet = cellSet;
    ;
    this.mainId = mainId;
  }
  
  public TheBoard(AbsStage stage) {
    this.cellSet = stage.makeStage();
    this.mainId = stage.getMainId();
  }

  /**
   * �����Ă���u���b�N��ID��Ԃ��܂��B
   * 
   * @return
   */
  public Set<String> getBlockIdSet() {
    Set<String> idSet = new HashSet<String>();
    for (TheCell cell : cellSet) {
      idSet.add(cell.getId());
    }
    return idSet;
  }
  
  /**
   * id�u���b�N��move������̎p��Ԃ��܂��B ���삪���s�ł��Ȃ������ꍇ�i�ړ���ɕʂ̃u���b�N�����铙�j�́Anull��Ԃ��܂��B
   * @param move
   * @return
   */
  public TheBoard makeNextBord(TheMove move) {
    if (move == null) {
      throw new RuntimeException("null");
    }
    Set<TheCell> nextCan = makeNext(move);
    if (auditBlocks(nextCan)) {
      return new TheBoard(nextCan, mainId);
    } else {
      return null;
    }
  }

  /**
   * move�ɏ]����cell���ړ����������ʂ�cellSet��Ԃ��܂��B
   * �A���A���̌��ʂ͐�������S�ۂ��܂���B
   * @param move
   * @return
   * @author works
   */
  private Set<TheCell> makeNext(TheMove move) {
    Set<TheCell> tomorrow = new HashSet<TheCell>();
    for (TheCell cell : cellSet) {
      if (cell.getId().equals(move.getId())) {
        //id�������ꍇ��move
        tomorrow.add(cell.move(move.getDir()));
      } else {
        tomorrow.add(cell);
      }
    }
    return tomorrow;
  }

  /**
   * �ړI��B���Ă���imainId�̃u���b�N������̈ʒu�ɂ��邩�j�ꍇ�́Atrue�ł��B
   * 
   * @return
   */
  public boolean isGoal() {
    if (mainId.equals(getCellId(0, 4)) || mainId.equals(getCellId(3, 4))) {
      //�����ɂ���ƁA�o���Ȃ�
      return false;
    } else if (mainId.equals(getCellId(1, 4)) || mainId.equals(getCellId(2, 4))) {
      //�����o����B
      return true;
    } else {
      return false;
    }
  }

  /**
   * �w�肵���ʒu�ɂ���u���b�N��ID��Ԃ��܂��B �u���b�N���������null��Ԃ��܂��B
   * 
   * @param x
   * @param y
   * @return
   */
  private String getCellId(int x, int y) {
    for (TheCell cell : cellSet) {
      if (cell.getX() == x && cell.getY() == y) {
        return cell.getId();
      }
    }
    return null;
  }

  /**
   * �u���b�N�z�u���K�؂��ǂ������`�F�b�N���܂��B �u���b�N�̏d����A�g����͂ݏo���Ă����ꍇ��false��Ԃ��܂��B
   * 
   * @param cells
   * @return
   */
  private static boolean auditBlocks(Collection<TheCell> cells) {
    Set<TheCell> checked = new HashSet<TheCell>();
    for (TheCell cell : cells) {
      if (cell.getX() < 0 || cell.getX() >= WIDTH || cell.getY() < 0 || cell.getY() >= HEIGHT)
        //�͂ݏo���Ă���l
        return false;
      for (TheCell ckd : checked) {//check�ς̂Əd���m�F
        if (cell.getX() == ckd.getX() && cell.getY() == ckd.getY()) {
          //�d�Ȃ��Ă���l
          return false;
        }
      }
      checked.add(cell);//���Ȃ����checked�ɓ���Ď�
    }
    return true;
  }

  /**
   * �����u���b�N�z�u�̃{�[�h���ǂ����𔻒肵�܂��B
   * �z�u���s�����ȏꍇ�́A���茋�ʂ͕ۏ؂��܂���B
   * @param bord
   * @return
   */
  public boolean isSameBord(TheBoard bord) {
    if (!(bord.cellSet.size() == this.cellSet.size())) {
      return false;// �����Ⴄ
    }
    for (TheCell cell : cellSet) {
      TheCell sameCell = null;
      for (TheCell there : bord.cellSet) {
        if (there.getId().equals(cell.getId()) && there.getX() == cell.getX() && there.getY() == cell.getY()) {
          sameCell = there;
        }
      }
      if (sameCell == null) {
        return false;//���ԂȂ�
      }
    }
    return true;
  }

}
