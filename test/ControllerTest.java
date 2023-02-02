import static org.junit.Assert.assertEquals;

import cs5004.mvc.controller.Controller;
import cs5004.mvc.model.IModel;
import cs5004.mvc.model.ModelImpl;
import cs5004.mvc.util.FileParse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Controller test.
 */
public class ControllerTest {
  /**
   * The Model.
   */
  IModel model;
  /**
   * The Controller.
   */
  Controller controller;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    model = new ModelImpl();
    FileParse.read("buildings.txt", model);
    controller = new Controller(model, "buildingsOut.html", 1000, 1000);
    controller.goSVGView();
  }

  /**
   * Test go svg view.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testGoSVGView() throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("buildingsOut.html"));
    StringBuffer buffer;
    StringBuilder builder = new StringBuilder();
    while (in.ready()) {
      buffer = (new StringBuffer(in.readLine()));
      builder.append(buffer).append("\n");
    }
    assertEquals("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<h1>Jianhua Che's Photo Album in SVG View</h1>\n" +
            "<div>\n" +
            "<h2>"+ model.getSnapshotIds().get(0) + "</h2>\n" +
            "<h3>Description: </h3>\n" +
            "<svg width=\"1000\" height=\"1000\">\n" +
            "<rect id=\"background\" x=\"0\" y=\"0\" width=\"800\" height=\"800\" fill=\"rgb(33,94,248)\">\n" +
            "</rect>\n" +
            "<rect id=\"B0\" x=\"80\" y=\"424\" width=\"100\" height=\"326\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B1\" x=\"260\" y=\"365\" width=\"100\" height=\"385\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B2\" x=\"440\" y=\"375\" width=\"100\" height=\"375\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B3\" x=\"620\" y=\"445\" width=\"100\" height=\"305\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"window000\" x=\"100\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window001\" x=\"140\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window010\" x=\"100\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window011\" x=\"140\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "</svg>\n" +
            "</div>\n" +
            "<div>\n" +
            "<h2>"+ model.getSnapshotIds().get(1) + "</h2>\n" +
            "<h3>Description: </h3>\n" +
            "<svg width=\"1000\" height=\"1000\">\n" +
            "<rect id=\"background\" x=\"0\" y=\"0\" width=\"800\" height=\"800\" fill=\"rgb(33,94,248)\">\n" +
            "</rect>\n" +
            "<rect id=\"B0\" x=\"80\" y=\"424\" width=\"100\" height=\"326\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B1\" x=\"260\" y=\"365\" width=\"100\" height=\"385\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B2\" x=\"440\" y=\"375\" width=\"100\" height=\"375\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B3\" x=\"620\" y=\"445\" width=\"100\" height=\"305\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"window000\" x=\"100\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window001\" x=\"140\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window010\" x=\"100\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window011\" x=\"140\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window002\" x=\"280\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window021\" x=\"320\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window022\" x=\"280\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window200\" x=\"320\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "</svg>\n" +
            "</div>\n" +
            "<div>\n" +
            "<h2>"+ model.getSnapshotIds().get(2) + "</h2>\n" +
            "<h3>Description: Turn on the Lights!</h3>\n" +
            "<svg width=\"1000\" height=\"1000\">\n" +
            "<rect id=\"background\" x=\"0\" y=\"0\" width=\"800\" height=\"800\" fill=\"rgb(33,94,248)\">\n" +
            "</rect>\n" +
            "<rect id=\"B0\" x=\"80\" y=\"424\" width=\"100\" height=\"326\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B1\" x=\"260\" y=\"365\" width=\"100\" height=\"385\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B2\" x=\"440\" y=\"375\" width=\"100\" height=\"375\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"B3\" x=\"620\" y=\"445\" width=\"100\" height=\"305\" fill=\"rgb(0,0,0)\">\n" +
            "</rect>\n" +
            "<rect id=\"window000\" x=\"100\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window001\" x=\"140\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window010\" x=\"100\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window011\" x=\"140\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window002\" x=\"280\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window021\" x=\"320\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window022\" x=\"280\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window200\" x=\"320\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window003\" x=\"460\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window033\" x=\"500\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window333\" x=\"460\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window313\" x=\"500\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window004\" x=\"640\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window044\" x=\"680\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window444\" x=\"640\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<rect id=\"window414\" x=\"680\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">\n" +
            "</rect>\n" +
            "<ellipse id=\"moon\" cx=\"200\" cy=\"200\" rx=\"100\" ry=\"100\" fill=\"rgb(229,229,255)\">\n" +
            "</ellipse>\n" +
            "</svg>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>", builder.substring(0,builder.length()-1));
  }
}