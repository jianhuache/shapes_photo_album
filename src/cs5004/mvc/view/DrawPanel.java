package cs5004.mvc.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs5004.mvc.model.shape.IShape;

/**
 * The type Draw panel.
 */
public class DrawPanel extends JPanel {

  private List<IShape> shapes;

  /**
   * Instantiates a new Draw panel.
   *
   * @param shapes the shapes
   */
  public DrawPanel(List<IShape> shapes) {
    this.shapes = shapes;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    setBackground(Color.white);

    for (IShape shape: this.shapes) {
      switch (shape.getType().getString().toLowerCase()) {
        case "rectangle":
          g.setColor(new Color(shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB()));
          g.fillRect(shape.getPosition().getX(), shape.getPosition().getY(), shape.getSize1(), shape.getSize2());
          break;
        case "oval":
          g.setColor(new Color(shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB()));
          g.fillOval(shape.getPosition().getX(), shape.getPosition().getY(), shape.getSize1(), shape.getSize2());
          break;
        default:
      }
    }
  }
}
