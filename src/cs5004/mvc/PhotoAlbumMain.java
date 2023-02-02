package cs5004.mvc;

import java.io.FileNotFoundException;
import java.io.IOException;

import cs5004.mvc.controller.Controller;
import cs5004.mvc.model.IModel;
import cs5004.mvc.model.ModelImpl;
import cs5004.mvc.util.FileParse;

public class PhotoAlbumMain {
  public static void main(String[] args) throws IOException {
    String inputFile = null;
    String choiceOfView = null;
    String outputFile = null;
    int xMax = 1000;
    int yMax = 1000;

    for (int i = 0; i < args.length; i++) {
      if (isInteger(args[i]) && xMax == 1000 && yMax == 1000) {
        xMax = Integer.parseInt(args[i]);
        yMax = Integer.parseInt(args[i + 1]);
      } else {
        switch (args[i].toLowerCase()) {
          case "-in":
            inputFile = args[i+1];
            break;
          case "-v":
          case "-view":
            choiceOfView = args[i+1];
            break;
          case "-out":
            outputFile = args[i+1];
            break;
          default:
        }
      }
    }

    if (inputFile == null || choiceOfView == null) {
      throw new FileNotFoundException("Without input file name or view choice!");
    }

    if (choiceOfView.equalsIgnoreCase("web") && (outputFile == null)) {
      System.exit(1);
    }

    IModel model = new ModelImpl();

    FileParse.read(inputFile, model);

    if (choiceOfView.equalsIgnoreCase("graphical")) {
      Controller controller = new Controller(model, xMax, yMax);
      controller.go();
    } else {
      Controller controller = new Controller(model, outputFile, xMax, yMax);
      controller.goSVGView();
    }
  }

  public static boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }
}


//buildings
//demo_input
//face_sun
//playground
//teris_wallpaper
//the_shot