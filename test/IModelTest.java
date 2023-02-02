import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import cs5004.mvc.model.IModel;
import cs5004.mvc.model.ModelImpl;
import cs5004.mvc.model.shape.Color;
import cs5004.mvc.model.shape.IShape;
import cs5004.mvc.model.shape.Position;
import cs5004.mvc.model.shape.TypeOfShape;

/**
 * The type Model test.
 */
public class IModelTest {

  /**
   * The Model.
   */
  IModel model;
  /**
   * The Rec.
   */
  IShape rec;
  /**
   * The Rec 1.
   */
  IShape rec1;
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
    model = new ModelImpl();
    rec = model.createShape("rec", new Position(50, 50),
            new Color(10,10,15), 200, 50, TypeOfShape.RECTANGLE);
    oval = model.createShape("oval", new Position(30, 30),
            new Color(2,2,2), 40, 60, TypeOfShape.OVAL);
  }

  /**
   * Test create shape.
   */
  @Test
  public void testCreateShape() {
    IShape shape = model.createShape("rec",
            new Position(30, 30),
            new Color(2,2,2), 3,3, TypeOfShape.RECTANGLE);
    assertEquals("rectangle", shape.getType().getString());
  }

  /**
   * Test add shape.
   */
  @Test
  public void testAddShape() {
    model.addShape(rec);
    model.addShape(oval);
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (50, 50)\n" +
            "Color: (10, 10, 15)\n" +
            "Width: 200\n" +
            "Height: 50\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
  }

  /**
   * Test add two shapes with same id.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddTwoShapesWithSameId() {
    rec1 = model.createShape("rec", new Position(150, 150),
            new Color(120,120,125), 30, 50, TypeOfShape.RECTANGLE);
    model.addShape(rec);
    model.addShape(rec1);
  }

  /**
   * Test delete shape.
   */
  @Test
  public void testDeleteShape() {
    model.addShape(rec);
    model.addShape(oval);
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (50, 50)\n" +
            "Color: (10, 10, 15)\n" +
            "Width: 200\n" +
            "Height: 50\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
    model.deleteShape("rec");
    assertEquals("Current Shapes\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
  }

  /**
   * Test delete shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteShapeNotExisted() {
    model.addShape(rec);
    model.addShape(oval);
    model.deleteShape("circle");
  }

  /**
   * Test change color.
   */
  @Test
  public void testChangeColor() {
    model.addShape(rec);
    model.addShape(oval);
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (50, 50)\n" +
            "Color: (10, 10, 15)\n" +
            "Width: 200\n" +
            "Height: 50\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
    model.changeColor("rec", new Color(1, 2, 3));
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (50, 50)\n" +
            "Color: (1, 2, 3)\n" +
            "Width: 200\n" +
            "Height: 50\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
  }

  /**
   * Test change color of shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOfShapeNotExisted() {
    model.addShape(rec);
    model.addShape(oval);
    model.changeColor("circle", new Color(3,4,5));
  }

  /**
   * Test change size.
   */
  @Test
  public void testChangeSize() {
    model.addShape(rec);
    model.addShape(oval);
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (50, 50)\n" +
            "Color: (10, 10, 15)\n" +
            "Width: 200\n" +
            "Height: 50\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
    model.changeSize("rec", 0, 0);
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (50, 50)\n" +
            "Color: (10, 10, 15)\n" +
            "Width: 0\n" +
            "Height: 0\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
  }

  /**
   * Test change size of shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeOfShapeNotExisted() {
    model.addShape(rec);
    model.addShape(oval);
    model.changeSize("circle", 40, 60);
  }

  /**
   * Test change position.
   */
  @Test
  public void testChangePosition() {
    model.addShape(rec);
    model.addShape(oval);
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (50, 50)\n" +
            "Color: (10, 10, 15)\n" +
            "Width: 200\n" +
            "Height: 50\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
    model.changePosition("rec", new Position(0,0));
    assertEquals("Current Shapes\n" +
            "ID: rec\n" +
            "Type: RECTANGLE\n" +
            "Position: (0, 0)\n" +
            "Color: (10, 10, 15)\n" +
            "Width: 200\n" +
            "Height: 50\n" +
            "ID: oval\n" +
            "Type: OVAL\n" +
            "Position: (30, 30)\n" +
            "Color: (2, 2, 2)\n" +
            "X radius: 40\n" +
            "Y radius: 60\n", model.printShapes());
  }

  /**
   * Test change position of shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangePositionOfShapeNotExisted() {
    model.addShape(rec);
    model.addShape(oval);
    model.changePosition("circle", new Position(20, 34));
  }

  /**
   * Test add snap shot.
   */
  @Test
  public void testAddSnapShot() {
    model.addShape(rec);
    model.addShape(oval);
    model.addSnapShot("a");
    List<String> snapshotIds = model.getSnapshotIds();
    List<String> timeStamps = model.getTimeStamp();
    assertEquals("Printing Snapshots\n" +
            "Snapshot ID: " + snapshotIds.get(0) + "\n" +
            "Timestamp: " + timeStamps.get(0) + "\n" +
            "Description: a\n" +
            "Shape Information:\n" +
            "Name: rec\n" +
            "Type: rectangle\n" +
            "Min corner: (50,50), Width: 200, Height: 50, Color: (10,10,15)\n" +
            "\n" +
            "Name: oval\n" +
            "Type: oval\n" +
            "Center: (30,30), X radius: 40, Y radius: 60, Color: (2,2,2)\n" +
            "\n", model.printSnapshots());
  }

  /**
   * Test print snapshots.
   */
  @Test
  public void testPrintSnapshots() {
    model.addShape(rec);
    model.addShape(oval);
    model.addSnapShot("a");
    List<String> snapshotIds = model.getSnapshotIds();
    List<String> timeStamps = model.getTimeStamp();
    assertEquals("Printing Snapshots\n" +
            "Snapshot ID: " + snapshotIds.get(0) + "\n" +
            "Timestamp: " + timeStamps.get(0) + "\n" +
            "Description: a\n" +
            "Shape Information:\n" +
            "Name: rec\n" +
            "Type: rectangle\n" +
            "Min corner: (50,50), Width: 200, Height: 50, Color: (10,10,15)\n" +
            "\n" +
            "Name: oval\n" +
            "Type: oval\n" +
            "Center: (30,30), X radius: 40, Y radius: 60, Color: (2,2,2)\n" +
            "\n", model.printSnapshots());
  }

  /**
   * Test reset snapshots.
   */
  @Test
  public void testResetSnapshots() {
    model.addShape(rec);
    model.addShape(oval);
    model.addSnapShot("a");
    List<String> snapshotIds = model.getSnapshotIds();
    List<String> timeStamps = model.getTimeStamp();
    assertEquals("Printing Snapshots\n" +
            "Snapshot ID: " + snapshotIds.get(0) + "\n" +
            "Timestamp: " + timeStamps.get(0) + "\n" +
            "Description: a\n" +
            "Shape Information:\n" +
            "Name: rec\n" +
            "Type: rectangle\n" +
            "Min corner: (50,50), Width: 200, Height: 50, Color: (10,10,15)\n" +
            "\n" +
            "Name: oval\n" +
            "Type: oval\n" +
            "Center: (30,30), X radius: 40, Y radius: 60, Color: (2,2,2)\n" +
            "\n", model.printSnapshots());
    model.resetSnapshots();
    assertEquals("Printing Snapshots\n", model.printSnapshots());
  }
}