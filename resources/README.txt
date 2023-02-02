For HW9, I implemented View and Controller section of our final project.

Compared to last homework including model package only, I added three new packages: view, controller, util.

For View, I create two views for photo album, Graphic View and Web View. To implement Graphic View, I applied Java Swing to draw a graphic window with canvas. The canvas includes three sections, North, Center, and South. These sections are responsible for presenting 1. ID and description, 2. main canvas, and 3. buttons, respectively. To help the Graphic View, I also create a DrawPanel class to draw all the shapes to help the graphic view. As for Web/SVG View, I used a StringBuilder to create a file with pure String text. Method render generates the String content, and outputFile creates a new file and write in the content.

For Controller, I have a single controller to pass data from model to view. Since we have two different views, I create two groups of constructors and “go” methods. “Go” method will call the specific view. To better present the graphic view, then I also have a helper method called actionPerformed for graphic view to react with buttons. It will do different things according to what button we tap.
