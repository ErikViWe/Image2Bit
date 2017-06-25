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

	public PrintImage() {
		
	}
	
	public boolean printFile(String[][] bits, String path) {
		String filepath = path.substring(0, path.length() - 3) + "txt"; //saves the file with the same name but .txt format
		try{
	        File file = new File(filepath);
	        file.createNewFile();
	        Writer output = new BufferedWriter(new FileWriter(file));

	        int counter = 0;
	        StringBuilder str = new StringBuilder();
	        for (int i = 0; i < bits.length; i++) {
	        	for (int j = 0; j < bits[0].length; j++) {
	        		str.append(bits[i][j] + " ");
	        		counter++;
	        		if (counter == 10) {
	        			str.append("\n");
	        			counter = 0;
	        		}
	        	}
	        }
	        output.write(str.toString());
	        output.close();
	    }catch(Exception e){
	        e.printStackTrace();
	        return false;
	    }
		return true;
	}
}
