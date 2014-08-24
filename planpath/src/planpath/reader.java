
package planpath;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class reader {

	File file;
	String content, row;
	public reader(){
		
		this.file = new File("input.txt");
		
	}
	 public String converter(){
		 if (file.exists()){

			 try{
				 FileReader reader = new FileReader("input.txt");
				 BufferedReader reader2 = new BufferedReader(reader);
				 while(true){
					 row=reader2.readLine();
					 if(row == null){
						 return content;
					 }
					 content += row+"\n";
				 }
			 }
		     catch(Exception erro){}
		 }
		 return null;
	 }
}
