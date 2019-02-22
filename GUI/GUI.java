package GUI;

import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class GUI extends Application implements TextDocumentListener{

	TextDokument dokument = new TextDokument();

	CodeParser cpars = new CodeParser();
	
	TextArea haupttext = new TextArea();
	Pane ppane = new Pane();
	
	Slider s1 = new Slider(0, 50, 100);
	Slider s2 = new Slider();
	Slider s3 = new Slider();
	Slider s4 = new Slider();
	
	int word = 0;
	int line = 0;
	public static void main(String[] args) {
		
		Application.launch(args);

	}
	
	class MyViewController{
		
		public Label halloLabel;
		FXMLLoader loader = new FXMLLoader();
	
	}

	public void start(Stage primarystage) throws IOException {
		
		
		TextField author = new TextField("Ihr Name");
		Button laden = new Button("LADEN");
		Button speichern = new Button("SPEICHERN");
		Button loeschen = new Button("LÖSCHEN");
		Button rgb = new Button("FARBE");
		HBox hboxtop = new HBox(laden, speichern, loeschen, rgb, author);
		
		
		HBox hboxslides = new HBox(s1, s2, s3, s4);
		
		HBox hboxmiddle = new HBox(haupttext, ppane);
		ppane.setMinSize(300, 200);
		
		Label anzahlLines = new Label("Lines: " + line);
		Label anzahlWords = new Label("Words: " + word+"	");
		BorderPane bpane = new BorderPane();
		bpane.setCenter(hboxslides);
		bpane.setLeft(anzahlWords);
		bpane.setBottom(anzahlLines);
		
		BorderPane pane = new BorderPane();
		pane.setTop(hboxtop);
		pane.setCenter(hboxmiddle);
		pane.setBottom(bpane);
		
	
		dokument.load();
		author.setText(dokument.getAuthor());
		haupttext.setText(dokument.getText());
		
		haupttext.textProperty().addListener((obs, o, n) ->{
			
			
			ppane.getChildren().clear();
			cpars.parseCode(haupttext.getText(), ppane);
			
			
			
			Label anzahlLines2 = new Label("Lines: " + line);
			String[] lines = haupttext.getText().split("\n");
			line = lines.length;
			bpane.setBottom(anzahlLines2);

			
			Label anzahlWords2 = new Label("Words: " + word+"	");
			String[] woerter = haupttext.getText().split(" ");
			word = woerter.length;
			bpane.setLeft(anzahlWords2);

		});
		

		
		speichern.setOnAction((e) -> {
			dokument.setAuthor(author.getText());
			dokument.setText(haupttext.getText());
			try {dokument.save();
			} catch (IOException e1) {	e1.printStackTrace();
			}
		});
		
		laden.setOnAction((e) -> {
			try {dokument.load();
			} catch (IOException e1) {e1.printStackTrace();
			}
			author.setText(dokument.getAuthor());
			haupttext.setText(dokument.getText());
		});
		
		loeschen.setOnAction((e) -> {
			dokument.setAuthor("");
			dokument.setText("");
			author.setText("");
			haupttext.setText("");
		});
		
		Scene scene = new Scene(pane, 700, 400);
		primarystage.setMaxHeight(1000);
		primarystage.setMaxWidth(1000);
		
		scene.getStylesheets().add("cssfile.css");
		
		primarystage.setTitle("Programmieroberfläche");
		primarystage.setScene(scene);
		primarystage.show();

	}

	@Override
	public void textCanged() {

		
	}

	public void codeparser() {
		

	}
}




//rgb.setOnAction((e) -> {
//Slider rot = new Slider();
//Slider gruen = new Slider();
//Slider blau = new Slider();
//
//Button ok = new Button("OK");
//VBox vbox2 = new VBox(rot, gruen, blau, ok);
//Pane pane2 = new Pane(vbox2);
//
//Scene scene2 = new Scene(pane2, 500, 300);
//scene2.getStylesheets().add("cssfile.css");
//
//primarystage.setScene(scene2);
//primarystage.show();
//ok.setOnAction((f) -> {
//	primarystage.close();
//	primarystage.setScene(scene);
//});
//
//});

