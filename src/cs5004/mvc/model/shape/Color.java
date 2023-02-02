package cs5004.mvc.model.shape;

/**
 * The type Color.
 */
public class Color {
  private int r;
  private int g;
  private int b;

  /**
   * Instantiates a new Color.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   */
  public Color(int r, int g, int b) {
    if (r > 255.0
            || g > 255.0
            || b > 255.0
            || r < 0
            || g < 0
            || b < 0) {
      throw new IllegalArgumentException("Invalid Color!");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Gets r.
   *
   * @return the r
   */
  public int getR() {
    return r;
  }

  /**
   * Gets g.
   *
   * @return the g
   */
  public int getG() {
    return g;
  }

  /**
   * Gets b.
   *
   * @return the b
   */
  public int getB() {
    return b;
  }

  @Override
  public String toString() {
    return "(" + r + ", " + g + ", " + b + ')';
  }
}
