import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class contains all methods dealing with the imported image.
 * It supports converting and exporting the image to the source location.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class ConvertImage {
	
	public ConvertImage() {
		
	}
	
	public String[][] convert(BufferedImage image) {
		String[][] bits = new String[image.getHeight()][image.getWidth()];
		//fill the array
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				Color c = new Color(image.getRGB(j, i));
				//divide by 16 to reduce
				int[] colors = new int[3]; // r, g, b
				colors[0] = c.getRed() / 16;
				colors[1] = c.getGreen() / 16;
				colors[2] = c.getBlue() / 16;
				bits[i][j] = calcString(colors);
			}
		}
		return bits;		
	}
	
	/**
	 * Converts the given r g b integer colors to a 12 bit binary string.
	 * @param colors
	 * 		integer array containing the r g b color information
	 * @return
	 * 		12 bit binary string
	 */
	private String calcString(int[] colors) {
		String one = "0";
		String two = "00";
		String three = "000";
		String result = "";
		for (int color : colors) {
			String temp = Integer.toBinaryString(color);
			switch (temp.length()) {
			case 1:
				temp = three + temp;
				break;
			case 2:
				temp = two + temp;
				break;
			case 3:
				temp = one + temp;
				break;
			default:
				//temp has length of four which is correct
				break;
			}
			result += temp;
		}
		return result;
	}
}
