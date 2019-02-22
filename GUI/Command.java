package GUI;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;

public abstract class Command {

	String name;
	List <String> arguments = new ArrayList<>();
	
	public abstract void parseParameter(String[] parameter, Pane p);
	public abstract void drawPane(Pane p);
	
}
