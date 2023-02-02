package cs5004.mvc.model.shape;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {
  private int x;
  private int y;

  /**
   * Instantiates a new Oval.
   *
   * @param id       the id
   * @param type     the type
   * @param position the position
   * @param x        the x
   * @param y        the y
   * @param color    the color
   */
  public Oval(String id, TypeOfShape type, Position position, int x, int y, Color color) {
    super(id, type, position, color);
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Invalid size!");
    }
    this.x = x;
    this.y = y;
  }

  @Override
  public void setSize(int size1, int size2) {
    if (size1 < 0 || size2 < 0) {
      throw new IllegalArgumentException("Invalid size!");
    }
    this.x = size1;
    this.y = size2;
  }

  @Override
  public int getSize1() {
    return this.x;
  }

  @Override
  public int getSize2() {
    return this.y;
  }

  @Override
  public String toString() {
    return super.toString() + "X radius: "
            + this.x + "\n" + "Y radius: "
            + this.y + "\n";
  }

  @Override
  public IShape clone() {
    return new Oval(this.id, this.type, this.position,this.x, this.y, this.color);
  }
}
