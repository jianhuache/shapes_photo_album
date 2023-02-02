package cs5004.mvc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cs5004.mvc.model.shape.Color;
import cs5004.mvc.model.shape.IShape;
import cs5004.mvc.model.shape.Oval;
import cs5004.mvc.model.shape.Position;
import cs5004.mvc.model.shape.Rectangle;
import cs5004.mvc.model.shape.TypeOfShape;

/**
 * The type Model.
 */
public class ModelImpl implements IModel {
  private List<IShape> shapes;//arraylist store shapes
  private HashMap<String, Integer> shapeIds; // hashmap stores key and index
  private HashMap<String, String> snapshots; // hashmap stores data
  private List<String> snapshotIds; //arraylist stores id to maintain order
  private List<String> timeStamp;
  private List<String> description;
  private HashMap<String, List<IShape>> snapshotsForView;
  private static final int START = 0;
  private static final int OFFSET = 1;

  /**
   * Instantiates a new Model.
   */
  public ModelImpl() {
    this.shapes = new ArrayList<>();
    this.shapeIds = new HashMap<>();
    this.snapshots = new HashMap<>();
    this.snapshotIds = new ArrayList<>();
    this.timeStamp = new ArrayList<>();
    this.snapshotsForView = new HashMap<>();
    this.description = new ArrayList<>();
  }

  @Override
  public IShape createShape(String id, Position position,
                            Color color, int size1, int size2, TypeOfShape type) {
    IShape shape;
    switch (type.getString().toLowerCase()) {
      case "rectangle":
        shape = new Rectangle(id, type, position, size1, size2, color);
        break;
      case "oval":
        shape = new Oval(id, type, position, size1, size2, color);
        break;
      default:
        shape = null;
    }
    return shape;
  }

  @Override
  public void addShape(IShape shape) throws IllegalArgumentException {
    if (shapeIds.containsKey(shape.getId())) {
      throw new IllegalArgumentException("This ID exists already!");
    }
    this.shapes.add(shape);
    this.shapeIds.put(shape.getId(), shapes.indexOf(shape));
  }

  @Override
  public void deleteShape(String id) throws IllegalArgumentException {
    if (!shapeIds.containsKey(id)) {
      throw new IllegalArgumentException("This shape does not exist!");
    }
    this.shapes.remove((int) this.shapeIds.get(id));
    this.shapeIds.remove(id);
    for (IShape shape: this.shapes) {
      this.shapeIds.replace(shape.getId(), this.shapes.indexOf(shape));
    }
  }

  @Override
  public void resetSnapshots() {
    System.out.println("List of snapshots taken before reset: " + this.snapshotIds.toString());
    this.snapshotIds.clear();
    this.snapshots.clear();
  }

  @Override
  public void changeColor(String id, Color newColor) throws IllegalArgumentException {
    if (!shapeIds.containsKey(id)) {
      throw new IllegalArgumentException("This shape does not exist!");
    }
    this.shapes.get(this.shapeIds.get(id)).setColor(newColor);
  }

  @Override
  public void changeSize(String id, int size1, int size2) throws IllegalArgumentException {
    if (!shapeIds.containsKey(id)) {
      throw new IllegalArgumentException("This shape does not exist!");
    }
    this.shapes.get(this.shapeIds.get(id)).setSize(size1, size2);
  }

  @Override
  public void changePosition(String id, Position newPosition) throws IllegalArgumentException {
    if (!shapeIds.containsKey(id)) {
      throw new IllegalArgumentException("This shape does not exist!");
    }
    this.shapes.get(this.shapeIds.get(id)).setPosition(newPosition);
  }

  @Override
  public void addSnapShot(String description) {
    String snapshot = "Snapshot ID: ";
    String snapshotId = LocalDateTime.now().toString();
    snapshot += snapshotId + "\n" + "Timestamp: ";
    String timeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            .format(LocalDateTime.now());
    snapshot += timeStamp + "\n" + "Description: " + description + "\n" + "Shape Information:";
    for (IShape shape : this.shapes) {
      snapshot += "\n" + "Name: " + shape.getId() + "\n" + "Type: "
              + shape.getType().getString() + "\n";
      switch (shape.getType().getString().toLowerCase()) {
        case "rectangle":
          snapshot += "Min corner: (" + shape.getPosition().getX() + "," + shape.getPosition().getY()
                  + "), Width: " + shape.getSize1() + ", Height: " +  shape.getSize2()
                  + ", Color: (" + shape.getColor().getR() + "," + shape.getColor().getG() + ","
                  + shape.getColor().getB() + ")" + "\n";
          break;
        case "oval":
          snapshot += "Center: (" + shape.getPosition().getX() + "," + shape.getPosition().getY()
                  + "), X radius: " + shape.getSize1() + ", Y radius: " +  shape.getSize2()
                  + ", Color: (" + shape.getColor().getR() + "," + shape.getColor().getG() + ","
                  + shape.getColor().getB() + ")" + "\n";
          break;
        default:
      }
    }
    this.snapshotIds.add(snapshotId);
    this.timeStamp.add(timeStamp);
    this.description.add(description);
    ArrayList<IShape> clonedList = new ArrayList<>();
    for (IShape shape : this.shapes) {
      clonedList.add(shape.clone());
    }
    this.snapshotsForView.put(snapshotId, clonedList);

    this.snapshots.put(snapshotId, snapshot.substring(START, snapshot.length() - OFFSET));
  }

  @Override
  public String printShapes() {
    String shapesString = "Current Shapes\n";
    for (IShape shape: this.shapes) {
      shapesString += shape.toString();
    }
    return shapesString;
  }

  @Override
  public String printSnapshots() {
    String snapshots = "Printing Snapshots\n";
    for (String snapshotId: this.snapshotIds) {
      snapshots += this.snapshots.get(snapshotId) + "\n\n";
    }
    return snapshots;
  }

  @Override
  public List<String> getTimeStamp() {
    return this.timeStamp;
  }

  @Override
  public List<String> getSnapshotIds() {
    return this.snapshotIds;
  }

  @Override
  public HashMap<String, List<IShape>> getSnapshotsForView() {
    return this.snapshotsForView;
  }

  @Override
  public List<String> getDescription() {
    return this.description;
  }
}
