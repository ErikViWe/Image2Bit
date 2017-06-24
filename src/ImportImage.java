import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



/**
 * Contains the methods for the image import.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class ImportImage {

	/**
	 * Generates the ImportImage object.
	 */
	public ImportImage() {
		
	}
	
	/**
	 * Returns the image stored a the given path.
	 * @param path
	 * 		path where the image is stored
	 * @return
	 * 		BufferedImage containing the image
	 */
	public BufferedImage importImageFromPath(String path) {
		File source = new File(path);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(source);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
