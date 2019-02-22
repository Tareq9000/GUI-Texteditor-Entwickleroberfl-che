package GUI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class TextDokument {
	
	private String text;
	private String author;
	private String pfad = "GUItext.txt";
	
	private File file = new File(pfad);
	
	ArrayList<TextDocumentListener> listener = new ArrayList();
	
	public void load() throws IOException {
		
		FileReader fr = new FileReader(file);
		char[] a =  new char[(int) file.length()];
		
		fr.read(a);
		fr.close();
		String strfile = new String(a);
		
		String[] text1 = strfile.split(System.lineSeparator());
		
		author = text1[0];
		
		this.text = "";
		for(int i = 1; i < text1.length; i++) {
			this.text += text1[i] + System.lineSeparator();
		}
		
	}
	
	public void save() throws IOException {
		
		if (!file.exists()) {
			file.createNewFile();
		} 
		
		Writer writer = new FileWriter(new File(pfad));
		
		writer.write(author + System.lineSeparator());
		writer.write(text);
		writer.close();
		
	}
	
	public String getAuthor() {
		 return author;
	}
	public String getText() {
		 return text;
	}
	
	public void setAuthor(String author) {
		 this.author = author;
	}
	public void setText(String text) {
		 this.text = text;
		 
		 for(TextDocumentListener i : listener) {
			i.textCanged(); 
		 }
	}
}
