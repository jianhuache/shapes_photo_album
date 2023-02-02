package cs5004.mvc.model.shape;

/**
 * The enum Type of shape.
 */
public enum TypeOfShape {
  /**
   * Rectangle type of shape.
   */
  RECTANGLE("rectangle"),
  /**
   * Oval type of shape.
   */
  OVAL("oval");

  private String string;

  TypeOfShape(String string) {
    if (string == null || string.isEmpty()) {
      throw new IllegalArgumentException("Invalid string!");
    }
    this.string = string;
  }

  /**
   * Gets string.
   *
   * @return the string
   */
  public String getString() {
    return this.string;
  }
}
