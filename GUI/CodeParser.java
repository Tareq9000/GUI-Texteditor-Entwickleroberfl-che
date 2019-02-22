package GUI;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;

public class CodeParser {
	
	List <Command> commands = new ArrayList<>();
	
	public void parseCode(String code, Pane p) {
		Command c = null;
//		commands.clear();
		
		
		String[] text = code.split("\n");
		String[] parameter = new String[text.length];
		for (int i = 0; i < text.length; i++) {
			parameter = text[i].split(" ");
		}
		
		if(parameter[0].startsWith("circle")) {
			c = new CircleCommand();

			c.parseParameter(parameter, p);

			
		}
		if(parameter[0].startsWith("line")) {
			c = new LineCommand();
			c.parseParameter(parameter, p);
		}
		if(parameter[0].startsWith("ellipse")) {
			c = new EllipseCommand();
			c.parseParameter(parameter, p);
		}
		if(parameter[0].startsWith("arc")) {
			c = new ArcCommand();
			c.parseParameter(parameter, p);
		}
		
		commands.add(c);
	}
}

