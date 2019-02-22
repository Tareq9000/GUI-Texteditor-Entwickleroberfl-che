
package GUI;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;


public class ArcCommand extends Command {

	int x;
	int y;
	int x2;
	int y2;
	int x3;
	int y3;
	
	
	public void parseParameter(String[] parameter, Pane p) {
	
		x = Integer.parseInt(parameter[1]);
		y = Integer.parseInt(parameter[2]);
		x2 = Integer.parseInt(parameter[3]);
		y2 = Integer.parseInt(parameter[4]);
		x3 = Integer.parseInt(parameter[1]);
		y3 = Integer.parseInt(parameter[2]);
		
		drawPane(p);
		
	}
	
	public void drawPane(Pane p) {
		
		Arc arc = new Arc(x, y, x2, y2, x3, x3);
		
		p.getChildren().add(arc);
	}
}
