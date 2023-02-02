package cs5004.mvc.model.shape;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {
  private int width;
  private int height;

  /**
   * Instantiates a new Rectangle.
   *
   * @param id       the id
   * @param type     the type
   * @param position the position
   * @param width    the width
   * @param height   the height
   * @param color    the color
   */
  public Rectangle(String id, TypeOfShape type,
                   Position position, int width, int height, Color color) {
    super(id, type, position, color);
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Invalid size!");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public void setSize(int size1, int size2) {
    if (size1 < 0 || size2 < 0) {
      throw new IllegalArgumentException("Invalid size!");
    }
    this.width = size1;
    this.height = size2;
  }

  @Override
  public int getSize1() {
    return width;
  }

  @Override
  public int getSize2() {
    return height;
  }

  @Override
  public String toString() {
    return super.toString() + "Width: "
            + this.width + "\n" + "Height: "
            + this.height + "\n";
  }

  @Override
  public IShape clone() {
    return new Rectangle(this.id, this.type, this.position,
            this.width, this.height, this.color);
  }
}
