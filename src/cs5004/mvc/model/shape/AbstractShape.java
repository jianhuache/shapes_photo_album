package cs5004.mvc.model.shape;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
  /**
   * The Id.
   */
  protected String id;
  /**
   * The Type.
   */
  protected TypeOfShape type;
  /**
   * The Position.
   */
  protected Position position;
  /**
   * The Color.
   */
  protected Color color;

  /**
   * Instantiates a new Abstract shape.
   *
   * @param id       the id
   * @param type     the type
   * @param position the position
   * @param color    the color
   */
  public AbstractShape(String id, TypeOfShape type, Position position, Color color) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Invalid ID!");
    }
    this.id = id;
    this.type = type;
    this.position = position;
    this.color = color;
  }

  @Override
  public void setPosition(Position position) {
    this.position = position;
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public TypeOfShape getType() {
    return type;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "ID: " + id + "\n"
            + "Type: " + type + "\n" +
            "Position: " + position + "\n" +
            "Color: " + color + "\n";
  }

  @Override
  public abstract IShape clone();
}
