import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import cs5004.mvc.model.shape.Color;
import cs5004.mvc.model.shape.IShape;
import cs5004.mvc.model.shape.Oval;
import cs5004.mvc.model.shape.Position;
import cs5004.mvc.model.shape.Rectangle;
import cs5004.mvc.model.shape.TypeOfShape;


/**
 * The type Shape test.
 */
public class IShapeTest {

  /**
   * The Rec.
   */
  IShape rec;
  /**
   * The Oval.
   */
  IShape oval;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    Position positionRec = new Position(20, 50);
    Position positionOval = new Position(150, 100);
    Color colorRec = new Color(120, 120, 120);
    Color colorOval = new Color(20, 30, 40);
    rec = new Rectangle("Rec1", TypeOfShape.RECTANGLE, positionRec, 30, 30, colorRec);
    oval = new Oval("Oval1", TypeOfShape.OVAL, positionOval, 100, 100, colorOval);
  }

  /**
   * Test get id.
   */
  @Test
  public void testGetId() {
    assertEquals("Rec1", rec.getId());
    assertEquals("Oval1", oval.getId());
  }

  /**
   * Test null id.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullId() {
    IShape rec1 = new Rectangle(null, TypeOfShape.RECTANGLE,
            new Position(20, 50), 30, 30, new Color(2, 2, 2));
  }

  /**
   * Test empty id.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyId() {
    IShape rec1 = new Rectangle("", TypeOfShape.RECTANGLE,
            new Position(20, 50), 30, 30, new Color(120, 120, 120));
  }

  /**
   * Test get type.
   */
  @Test
  public void testGetType() {
    assertEquals("rectangle", rec.getType().getString());
    assertEquals("oval", oval.getType().getString());
  }

  /**
   * Test get position.
   */
  @Test
  public void testGetPosition() {
    assertEquals(20.0, rec.getPosition().getX(), 0.001);
    assertEquals(50.0, rec.getPosition().getY(), 0.001);
    assertEquals(150.0, oval.getPosition().getX(), 0.001);
    assertEquals(100.0, oval.getPosition().getY(), 0.001);
  }

  /**
   * Test negative position.
   */
  @Test
  public void testNegativePosition() {
    Position positionRec1 = new Position(-20, -50);
    Color colorRec = new Color(120, 120, 120);
    rec = new Rectangle("Rec2", TypeOfShape.RECTANGLE, positionRec1, 30, 30, colorRec);
    assertEquals(-20.0, rec.getPosition().getX(), 0.001);
    assertEquals(-50.0, rec.getPosition().getY(), 0.001);
  }

  /**
   * Test big position.
   */
  @Test
  public void testBigPosition() {
    Position positionRec1 = new Position(999999999, 888888888);
    rec = new Rectangle("Rec2", TypeOfShape.RECTANGLE, positionRec1,
            30, 30, new Color(2, 2, 1));
    assertEquals(999999999, rec.getPosition().getX());
    assertEquals(888888888, rec.getPosition().getY());
  }



  /**
   * Test zero position.
   */
  @Test
  public void testZeroPosition() {
    Position positionRec1 = new Position(0, 0);
    rec = new Rectangle("Rec2", TypeOfShape.RECTANGLE, positionRec1,
            30, 30, new Color(2, 2, 1));
    assertEquals(0, rec.getPosition().getX(), 0.001);
    assertEquals(0, rec.getPosition().getY(), 0.001);
  }

  /**
   * Test get color.
   */
  @Test
  public void testGetColor() {
    assertEquals(120.0, rec.getColor().getR(), 0.001);
    assertEquals(120.0, rec.getColor().getG(), 0.001);
    assertEquals(120.0, rec.getColor().getB(), 0.001);

    assertEquals(20.0, oval.getColor().getR(), 0.001);
    assertEquals(30.0, oval.getColor().getG(), 0.001);
    assertEquals(40.0, oval.getColor().getB(), 0.001);
  }

  /**
   * Test invalid color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidColor() {
    IShape rec1 = new Rectangle("rec", TypeOfShape.RECTANGLE,
            new Position(20, 50), 30, 30,
            new Color(256, 256, 256));
  }

  /**
   * Test negative rbg color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeRBGColor() {
    IShape rec1 = new Rectangle("rec", TypeOfShape.RECTANGLE,
            new Position(20, 50), 30, 30,
            new Color(-1, -2, -3));
  }

  /**
   * Test get size 1.
   */
  @Test
  public void testGetSize1() {
    assertEquals(30.0, rec.getSize1(), 0.001);
    assertEquals(100.0, oval.getSize1(), 0.001);
  }

  /**
   * Test get size 2.
   */
  @Test
  public void testGetSize2() {
    assertEquals(30.0, rec.getSize2(), 0.001);
    assertEquals(100.0, oval.getSize2(), 0.001);
  }

  /**
   * Test negative sizes.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizes() {
    IShape rec1 = new Rectangle("rec", TypeOfShape.RECTANGLE,
            new Position(20, 50), -30, 30,
            new Color(1, 2, 3));
  }

  /**
   * Test set position.
   */
  @Test
  public void testSetPosition() {
    assertEquals(20, rec.getPosition().getX(), 0.001);
    assertEquals(50, rec.getPosition().getY(), 0.001);

    rec.setPosition(new Position(88, 99));
    assertEquals(88, rec.getPosition().getX(), 0.001);
    assertEquals(99, rec.getPosition().getY(), 0.001);
  }

  /**
   * Test set color.
   */
  @Test
  public void testSetColor() {
    assertEquals(120.0, rec.getColor().getR(), 0.001);
    assertEquals(120.0, rec.getColor().getG(), 0.001);
    assertEquals(120.0, rec.getColor().getB(), 0.001);

    rec.setColor(new Color(10, 10, 10));
    assertEquals(10.0, rec.getColor().getR(), 0.001);
    assertEquals(10.0, rec.getColor().getG(), 0.001);
    assertEquals(10.0, rec.getColor().getB(), 0.001);
  }

  /**
   * Test set size.
   */
  @Test
  public void testSetSize() {
    assertEquals(30, rec.getSize1());
    assertEquals(30, rec.getSize2());

    rec.setSize(66, 77);
    assertEquals(66, rec.getSize1());
    assertEquals(77, rec.getSize2());
  }
}