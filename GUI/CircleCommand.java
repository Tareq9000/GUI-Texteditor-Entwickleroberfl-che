package GUI;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class CircleCommand extends Command {

	int x;
	int y;
	int radius;
	
	
	public void parseParameter(String[] parameter, Pane p) {
		
		x = Integer.parseInt(parameter[1]);
		y = Integer.parseInt(parameter[2]);
		radius = Integer.parseInt(parameter[3]);
		
		drawPane(p);

	}
	
	public void drawPane(Pane p) {
		Circle c = new Circle(x, y, radius);

		p.getChildren().add(c);

	}
	
}

