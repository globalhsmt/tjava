package game;

import java.util.HashSet;
import java.util.Set;

/**
 * ステージ（ブロックの初期配置）を意味する抽象クラスです。
 * 各ステージはこのクラスを継承して下さい。
 * セルの初期配置をputCellメソッドにて／ゴール位置に移動させる必要があるブロックのIDを、setMainIdにてセットして下さい。
 * @author works
 */
public abstract class AbsStage {

  private Set<TheCell> cellSet;
  private String mainId;

  public AbsStage() {
    this.cellSet = new HashSet<TheCell>();
  }

  /**
   * ブロックの位置をセットします。
   * 複数マスにまたがるブロックは、同IDにて、x,yの値を変更して複数回呼び出して下さい。
   * x,yは、板の左上から右および下に何マス先のマスかを意味します。
   * 例えば左上は0,0となり、右下は3,4となります。
   * @param id ブロックのID
   * @param x 横
   * @param y 縦
   * @author works
   */
  protected void putCell(String id, int x, int y) {
    cellSet.add(new TheCell(id, x, y));
  }

  /**
   * ゴール位置に移動させる必要があるブロックのIDです。
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
