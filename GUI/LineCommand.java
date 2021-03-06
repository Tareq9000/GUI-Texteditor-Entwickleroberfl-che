package GUI;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LineCommand extends Command {

	int x;
	int y;
	int x2;
	int y2;
	
	
	public void parseParameter(String[] parameter, Pane p) {
	
		x = Integer.parseInt(parameter[1]);
		y = Integer.parseInt(parameter[2]);
		x2 = Integer.parseInt(parameter[3]);
		y2 = Integer.parseInt(parameter[4]);
		
		drawPane(p);
		
	}
	
	public void drawPane(Pane p) {
		
		Line line = new Line(x, y, x2, y2);
		
		p.getChildren().add(line);
	}
}
