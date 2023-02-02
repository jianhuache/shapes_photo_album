package cs5004.mvc.model;

import java.util.HashMap;
import java.util.List;

import cs5004.mvc.model.shape.Color;
import cs5004.mvc.model.shape.IShape;
import cs5004.mvc.model.shape.Position;
import cs5004.mvc.model.shape.TypeOfShape;

/**
 * The interface Model.
 */
public interface IModel {

  /**
   * Create shape shape.
   *
   * @param id       the id
   * @param position the position
   * @param color    the color
   * @param size1    the size 1
   * @param size2    the size 2
   * @param type     the type
   * @return the shape
   */
  IShape createShape(String id, Position position,
                     Color color, int size1, int size2, TypeOfShape type);

  /**
   * Delete shape.
   *
   * @param id the id
   */
  void deleteShape(String id);

  /**
   * Change color.
   *
   * @param id       the id
   * @param newColor the new color
   */
  void changeColor(String id, Color newColor);

  /**
   * Change size.
   *
   * @param id    the id
   * @param size1 the size 1
   * @param size2 the size 2
   */
  void changeSize(String id, int size1, int size2);

  /**
   * Change position.
   *
   * @param id          the id
   * @param newPosition the new position
   */
  void changePosition(String id, Position newPosition);

  /**
   * Add snap shot.
   */
  void addSnapShot(String description);

  /**
   * Print snapshots string.
   *
   * @return the string
   */
  String printSnapshots();

  /**
   * Add shape.
   *
   * @param shape the shape
   */
  void addShape(IShape shape);

  /**
   * Reset snapshots.
   */
  void resetSnapshots();

  /**
   * Print shapes string.
   *
   * @return the string
   */
  String printShapes();

  /**
   * Gets time stamp.
   *
   * @return the time stamp
   */
  List<String> getTimeStamp();

  /**
   * Gets snapshot ids.
   *
   * @return the snapshot ids
   */
  List<String> getSnapshotIds();

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  HashMap<String, List<IShape>> getSnapshotsForView();

  /**
   * Gets description.
   *
   * @return the description
   */
  List<String> getDescription();
}
