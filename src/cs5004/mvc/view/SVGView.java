package cs5004.mvc.view;

import cs5004.mvc.model.shape.IShape;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

/**
 * The type Svg view.
 */
public class SVGView {
  private HashMap<String, List<IShape>> snapshots;
  private List<String> snapshotIds;
  private List<String> description;
  private String out;
  private int width;
  private int height;

  /**
   * Instantiates a new Svg view
   *
   * @param snapshots   the snapshots
   * @param snapshotIds the snapshot ids
   * @param description the description
   * @param out         the out
   * @param xMax        the x max
   * @param yMax        the y max
   */
  public SVGView(HashMap<String, List<IShape>> snapshots, List<String> snapshotIds,
                 List<String> description, String out, int xMax, int yMax) {
    this.snapshots = snapshots;
    this.snapshotIds = snapshotIds;
    this.description = description;
    this.out = out;
    this.width = xMax;
    this.height = yMax;
  }

  /**
   * Render string.
   *
   * @return the string
   * @throws IllegalArgumentException the illegal argument exception
   */
  public String render() throws IllegalArgumentException {
    StringBuilder sb = new StringBuilder();
    sb.append("<!DOCTYPE html>\n<html>\n<body>\n<h1>Jianhua Che's Photo Album in SVG View</h1>\n");

    for (int i = 0; i < this.snapshotIds.size(); i++) {
      sb.append("<div>\n")
              .append("<h2>").append(this.snapshotIds.get(i)).append("</h2>\n")
              .append("<h3>").append("Description: ").append(this.description.get(i)).append("</h3>\n")
              .append("<svg width=\"").append(this.width)
              .append("\" height=\"").append(this.height).append("\">\n");
      for (IShape shape: this.snapshots.get(this.snapshotIds.get(i))) {
        switch (shape.getType().getString()) {
          case "rectangle":
            sb.append("<rect id=\"").append(shape.getId()).append("\" x=\"")
                    .append(shape.getPosition().getX()).append("\" y=\"")
                    .append(shape.getPosition().getY()).append("\" width=\"")
                    .append(shape.getSize1()).append("\" height=\"")
                    .append(shape.getSize2()).append("\" fill=\"rgb(")
                    .append(shape.getColor().getR()).append(",")
                    .append(shape.getColor().getG()).append(",")
                    .append(shape.getColor().getB()).append(")\">\n").append("</rect>\n");
            break;
          case "oval":
            sb.append("<ellipse id=\"").append(shape.getId()).append("\" cx=\"")
                    .append(shape.getPosition().getX()).append("\" cy=\"")
                    .append(shape.getPosition().getY()).append("\" rx=\"")
                    .append(shape.getSize1()).append("\" ry=\"")
                    .append(shape.getSize2()).append("\" fill=\"rgb(")
                    .append(shape.getColor().getR()).append(",")
                    .append(shape.getColor().getG()).append(",")
                    .append(shape.getColor().getB()).append(")\">\n").append("</ellipse>\n");
            break;
          default:
            throw new IllegalArgumentException("invalid shape.");
        }
      }
      sb.append("</svg>\n</div>\n");
    }
    sb.append("</body>\n</html>");
    return String.valueOf(sb);
  }

  /**
   * Output file.
   *
   * @throws IOException the io exception
   */
  public void outputFile() throws IOException {
    String content = this.render();
    if (!out.equals("SysOut")) {
      PrintWriter writer = new PrintWriter(this.out, StandardCharsets.UTF_8);
      writer.append(content);
      writer.close();
    } else {
      System.out.print(content);
    }
  }
}
