package cs5004.mvc.model.shape;

/**
 * The interface Shape.
 */
public interface IShape {

  /**
   * Sets position.
   *
   * @param position the position
   */
  void setPosition(Position position);

  /**
   * Sets color.
   *
   * @param color the color
   */
  void setColor(Color color);

  /**
   * Sets size.
   *
   * @param size1 the size 1
   * @param size2 the size 2
   */
  void setSize(int size1, int size2);

  /**
   * Gets id.
   *
   * @return the id
   */
  String getId();

  /**
   * Gets type.
   *
   * @return the type
   */
  TypeOfShape getType();

  /**
   * Gets position.
   *
   * @return the position
   */
  Position getPosition();

  /**
   * Gets color.
   *
   * @return the color
   */
  Color getColor();

  /**
   * Gets size 1.
   *
   * @return the size 1
   */
  int getSize1();

  /**
   * Gets size 2.
   *
   * @return the size 2
   */
  int getSize2();

  /**
   * Clone IShape.
   *
   * @return new IShape object
   */
  IShape clone();
}
