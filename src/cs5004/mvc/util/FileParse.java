package cs5004.mvc.util;

import java.io.FileNotFoundException;
import java.util.Scanner;

import cs5004.mvc.model.IModel;
import cs5004.mvc.model.shape.Color;
import cs5004.mvc.model.shape.Position;
import cs5004.mvc.model.shape.TypeOfShape;

/**
 * The type File parse.
 */
public class FileParse {

  /**
   * Read.
   *
   * @param fileName the file name
   * @param model    the model
   * @throws FileNotFoundException the file not found exception
   */
  public static void read(String fileName, IModel model) throws FileNotFoundException {
    java.io.File file = new java.io.File(fileName);

    Scanner input = new Scanner(file);

    while (input.hasNext()) {
      switch (input.next().toLowerCase()) {
        case "#":
          input.nextLine();
          break;
        case "shape":
          String id = input.next();
          String type = input.next();
          int x = Integer.parseInt(input.next());
          int y = Integer.parseInt(input.next());
          int width = Integer.parseInt(input.next());
          int height = Integer.parseInt(input.next());
          int r = Integer.parseInt(input.next());
          int g = Integer.parseInt(input.next());
          int b = Integer.parseInt(input.next());
          if (type.equalsIgnoreCase(TypeOfShape.RECTANGLE.getString())) {
            model.addShape(model.createShape(id, new Position(x,y), new Color(r, g, b), width, height, TypeOfShape.RECTANGLE));
          } else {
            model.addShape(model.createShape(id, new Position(x,y), new Color(r, g, b), width, height, TypeOfShape.OVAL));
          }
          break;
        case "move":
          String idMove = input.next();
          int xMove = Integer.parseInt(input.next());
          int yMove = Integer.parseInt(input.next());
          model.changePosition(idMove, new Position(xMove,yMove));
          break;
        case "color":
          String idColor = input.next();
          int rColor = Integer.parseInt(input.next());
          int gColor = Integer.parseInt(input.next());
          int bColor = Integer.parseInt(input.next());
          model.changeColor(idColor, new Color(rColor,gColor,bColor));
          break;
        case "resize":
          String idSize = input.next();
          int widthSize = Integer.parseInt(input.next());
          int heightSize = Integer.parseInt(input.next());
          model.changeSize(idSize, widthSize, heightSize);
          break;
        case "remove":
          String idRemove = input.next();
          model.deleteShape(idRemove);
          break;
        case "snapshot":
          String description = input.nextLine();
          model.addSnapShot(description.trim());
          break;
        default:
      }
    }

    input.close();
  }

}
