package cs5004.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import cs5004.mvc.model.IModel;
import cs5004.mvc.view.GraphicalView;
import cs5004.mvc.view.SVGView;

/**
 * The type Controller.
 */
public class Controller implements ActionListener {
  private IModel model;
  private GraphicalView graphicalView;
  private SVGView svgView;
  private int xMax;
  private int yMax;

  /**
   * Instantiates a new Controller.
   *
   * @param model the model
   * @param xMax  the x max
   * @param yMax  the y max
   */
  public Controller(IModel model, int xMax, int yMax) {
    this.model = model;
    this.graphicalView = new GraphicalView(this.model.getSnapshotsForView(),
            this.model.getSnapshotIds(), this.model.getDescription(), xMax, yMax);
    this.graphicalView.setActionListener(this);
  }

  /**
   * Instantiates a new Controller.
   *
   * @param model    the model
   * @param fileName the file name
   * @param xMax     the x max
   * @param yMax     the y max
   */
  public Controller(IModel model, String fileName, int xMax, int yMax) {
    this.model = model;
    this.svgView = new SVGView(this.model.getSnapshotsForView(),
            this.model.getSnapshotIds(), this.model.getDescription(), fileName, xMax, yMax);;
  }

  /**
   * Go.
   *
   * @throws IOException the io exception
   */
  public void go() throws IOException {
    this.graphicalView.setVisible(true);
  }

  /**
   * Go svg view.
   *
   * @throws IOException the io exception
   */
  public void goSVGView() throws IOException {
    this.svgView.outputFile();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
      case "Prev":
        if (this.graphicalView.getCurrentShot() == 0) {
          JOptionPane.showMessageDialog(this.graphicalView, "This is the first snapshot!");
          break;
        }
        this.graphicalView.setCurrentShot(this.graphicalView.getCurrentShot() - 1);
        this.graphicalView.removeNorth();
        this.graphicalView.updateNorth();
        this.graphicalView.removeCenter();
        this.graphicalView.updateCenter();
        break;
      case "Select":
        String selection = (String) JOptionPane.showInputDialog(
                this.graphicalView,
                "Choose",
                "Menu", JOptionPane.QUESTION_MESSAGE,
                null,
                this.graphicalView.getSnapshotIds(),
                this.graphicalView.getSnapshotIds()[0]);
        if (selection!=null) {
          int indexOfSnapshots = this.graphicalView.getIndexOfSnapshots(selection);
          this.graphicalView.setCurrentShot(indexOfSnapshots);
          this.graphicalView.removeNorth();
          this.graphicalView.updateNorth();
          this.graphicalView.removeCenter();
          this.graphicalView.updateCenter();
        }
        break;
      case "Next":
        if (this.graphicalView.getCurrentShot() == this.model.getSnapshotIds().size() - 1) {
          JOptionPane.showMessageDialog(this.graphicalView, "This is the last snapshot!");
          break;
        }
        this.graphicalView.setCurrentShot(this.graphicalView.getCurrentShot() + 1);
        this.graphicalView.removeNorth();
        this.graphicalView.updateNorth();
        this.graphicalView.removeCenter();
        this.graphicalView.updateCenter();
        break;
      case "Quit":
        System.exit(0);
      default:
    }
  }
}
