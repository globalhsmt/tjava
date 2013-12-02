package game;

public class TheBlock {

  
  private String ID;
  private int x1;
  private int x2;
  private int y1;
  private int y2;
  
  public TheBlock(String iD, int x1, int x2, int y1, int y2) {
    super();
    ID = iD;
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }
  
  /**
   * base‚ğmove‚µ‚½block‚ğì‚è‚Ü‚·B
   * @param base
   * @param move
   */
  public TheBlock(TheBlock base, TheMove move) {
    x1 = base.getX1();
    x2 = base.getX2();
    y1 = base.getY1();
    y2 = base.getY2();
    switch (move) {
      case UP:
        y1--;
        y2--;
        break;
      case DOWN:
        y1++;
        y2++;
        break;
      case RIGHT:
        x1++;
        x2++;
        break;
      case LEFT:
        x1--;
        x2--;
        break;
    }
  }

  String getID() {
    return ID;
  }

  int getX1() {
    return x1;
  }

  int getX2() {
    return x2;
  }

  int getY1() {
    return y1;
  }

  int getY2() {
    return y2;
  }

  
  
  
 
  
}
