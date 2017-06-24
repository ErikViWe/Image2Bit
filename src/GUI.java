import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	
	private JFrame mainFrame;
	private JLabel lbImagePath;
	private JTextField tfImagePath;

	public GUI() {
		initFrame();
		initComponents();
	}
	
	/**
	 * Generates a 400 x 400 Frame to display components like JLabels and JTextFields to handle the user input.
	 * In addition the mainFrame displays the image to confirm the user selection.
	 * It also shows error messages if any error occurs during runtime.
	 */
	private void initFrame() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Image2Bit");
		mainFrame.setSize(new Dimension(400, 400));
		mainFrame.setVisible(true);
		mainFrame.setLayout(new BorderLayout());
	}
	
	private void initComponents() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		lbImagePath = new JLabel("Please enter the image path here: ");
		topPanel.add(lbImagePath);
		tfImagePath = new JTextField();
		tfImagePath.setSize(new Dimension(200, 20));
		topPanel.add(tfImagePath);
		topPanel.setVisible(true);
		mainFrame.add(topPanel, BorderLayout.NORTH);
	}
}
