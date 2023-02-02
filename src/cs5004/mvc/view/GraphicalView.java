package cs5004.mvc.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import cs5004.mvc.model.shape.IShape;

/**
 * The type Graphical view.
 */
public class GraphicalView extends JFrame {
  private HashMap<String, List<IShape>> snapshots;
  private List<String> snapshotIds;
  private List<String> description;
  private JButton prev;
  private JButton select;
  private JButton next;
  private JButton quit;
  private JPanel north;
  private JPanel center;
  private JPanel south;
  private int currentShot;
  private int width;
  private int height;

  /**
   * Instantiates a new Graphical view.
   *
   * @param snapshots   the snapshots
   * @param snapshotIds the snapshot ids
   * @param description the description
   * @param xMax        the x max
   * @param yMax        the y max
   */
  public GraphicalView(HashMap<String, List<IShape>> snapshots, List<String> snapshotIds,
                       List<String> description, int xMax, int yMax) {
    this.snapshotIds = snapshotIds;
    this.snapshots = snapshots;
    this.description = description;
    this.currentShot = 0;
    this.width = xMax;
    this.height = yMax;

    this.setSize(width, height);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("cs5004 Shapes Photo Album Viewer");
    this.setLayout(new BorderLayout());

    this.north = new JPanel();
    this.add(north, BorderLayout.NORTH);
    this.drawNorth(north);

    this.center = new DrawPanel(this.snapshots.get(this.snapshotIds.get(this.currentShot)));
    this.add(center, BorderLayout.CENTER);

    this.south = new JPanel();
    this.add(south, BorderLayout.SOUTH);
    this.drawSouth(south);

  }

  /**
   * Draw south.
   *
   * @param south the south
   */
  public void drawSouth(JPanel south) {
    south.setPreferredSize(new Dimension(0,40));
    south.setBackground(Color.orange);

    prev = new JButton("<< Prev <<");
    prev.setActionCommand("Prev");
    south.add(prev);

    select = new JButton("^^ Select ^^");
    select.setActionCommand("Select");
    south.add(select);

    next = new JButton(">> Next >>");
    next.setActionCommand("Next");
    south.add(next);

    quit = new JButton("xx Quit xx");
    quit.setActionCommand("Quit");
    south.add(quit);
  }

  /**
   * Draw north.
   *
   * @param north the north
   */
  public void drawNorth(JPanel north) {
    north.setPreferredSize(new Dimension(0,20));
    north.setBackground(Color.pink);
    north.add(new JLabel(this.snapshotIds.get(currentShot)));
    north.add(new JLabel(" |  Description: " + this.description.get(currentShot)));
  }


  /**
   * Remove center.
   */
  public void removeCenter() {
    this.center.revalidate();
  }

  /**
   * Update center.
   */
  public void updateCenter() {
    this.center = new DrawPanel(this.snapshots.get(this.snapshotIds.get(this.currentShot)));
    this.add(center, BorderLayout.CENTER);
  }

  /**
   * Remove north.
   */
  public void removeNorth() {
    this.north.revalidate();
  }

  /**
   * Update north.
   */
  public void updateNorth() {
    this.north = new JPanel();
    this.north.setPreferredSize(new Dimension(0,20));
    this.north.setBackground(Color.pink);
    this.north.add(new JLabel(this.snapshotIds.get(currentShot)));
    this.north.add(new JLabel(" |  Description: " + this.description.get(currentShot)));
    this.add(north, BorderLayout.NORTH);
  }


  /**
   * Gets current shot.
   *
   * @return the current shot
   */
  public int getCurrentShot() {
    return this.currentShot;
  }

  /**
   * Sets current shot.
   *
   * @param currentShot the current shot
   */
  public void setCurrentShot(int currentShot) {
    this.currentShot = currentShot;
  }

  /**
   * Get snapshot ids object [ ].
   *
   * @return the object [ ]
   */
  public Object[] getSnapshotIds() {
    return this.snapshotIds.toArray();
  }

  /**
   * Gets index of snapshots.
   *
   * @param id the id
   * @return the index of snapshots
   */
  public int getIndexOfSnapshots(String id) {
    return this.snapshotIds.indexOf(id);
  }

  /**
   * Sets action listener.
   *
   * @param listener the listener
   */
  public void setActionListener(ActionListener listener) {
    this.prev.addActionListener(listener);
    this.select.addActionListener(listener);
    this.next.addActionListener(listener);
    this.quit.addActionListener(listener);
  }
}
