import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Class which contains methods to write the final output file.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class PrintImage {

	/**
	 * Constructor generates the object only.
	 */
	public PrintImage() {
		
	}
	
	/**
	 * Generates a new .txt file at the given path and prints the bits into this file.
	 * the current printing format is 10 pixel per line.
	 * @param bits
	 * 		contains all pits to print as single Strings
	 * @param path
	 * 		path where the output file should be stored
	 * @return
	 * 		<b>true</b> if the process was successful
	 */
	public boolean printFile(String[][] bits, String path) {
		String filepath = path.substring(0, path.length() - 3) + "txt"; //saves the file with the same name but .txt format
		try{
	        File file = new File(filepath);
	        file.createNewFile();
	        Writer output = new BufferedWriter(new FileWriter(file));

	        //remove comments to add line breaks
	        //int counter = 0;
	        StringBuilder str = new StringBuilder();
	        str.append("(");
	        for (int i = 0; i < bits.length; i++) {
	        	for (int j = 0; j < bits[0].length; j++) {
	        		str.append("\"" + bits[i][j] + "\", ");
	        		/*
	        		counter++;
	        		if (counter == 10) {
	        			str.append("\n");
	        			counter = 0;
	        		} */
	        	}
	        }
	        str.replace(str.length() - 2, str.length(), "");
	        str.append(")");
	        output.write(str.toString());
	        output.close();
	    }catch(Exception e){
	        e.printStackTrace();
	        return false;
	    }
		return true;
	}
}
