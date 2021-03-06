import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI class works as the user interface. This is the only window of the program.
 * The user can operate the whole program over the components on this interface.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class GUI {
	
	private ImportImage importer;
	private ConvertImage converter;
	private PrintImage printer;
	private JFrame mainFrame;
	private JLabel lbImagePath;
	private JTextField tfImagePath;
	private JLabel lbStatus;
	private JLabel lbPreview;
	private JButton btnImport;
	private JButton btnConvert;
	private JButton btnExit;
	private BufferedImage image;
	

	/**
	 * Constructor generates the user interface as it generates the object and initializes the graphic components.
	 */
	public GUI() {
		initFrame();
		initTopComponents();
		initPreviewComponents();
		initBottomComponents();
		initButtonListener();
		importer = new ImportImage();
		converter = new ConvertImage();
		printer = new PrintImage();
	}
	
	/**
	 * Reloads the mainFrame object
	 */
	public void show() {
		mainFrame.setVisible(true);
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
		mainFrame.setLayout(new BorderLayout());
	}
	
	/**
	 * Initializes the components on the top of the GUI (BoxLayout.NORTH).
	 */
	private void initTopComponents() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		lbImagePath = new JLabel("Please enter the image path here: ");
		topPanel.add(lbImagePath);
		tfImagePath = new JTextField();
		tfImagePath.setSize(new Dimension(200, 20));
		topPanel.add(tfImagePath);
		lbStatus = new JLabel("Status: Please enter a path and import an image.");
		topPanel.add(lbStatus);
		topPanel.setVisible(true);
		mainFrame.add(topPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Initializes the mid component to display the imported image.
	 */
	private void initPreviewComponents() {
		lbPreview = new JLabel("");
		lbPreview.setHorizontalAlignment(JLabel.CENTER);
		lbPreview.setVerticalAlignment(JLabel.CENTER);
		mainFrame.add(lbPreview, BorderLayout.CENTER);
	}
	
	/**
	 * Initializes the buttons at the bottom of the mainFrame.
	 * Three buttons needed to handle the program (Import, Convert, Exit).
	 */
	private void initBottomComponents() {
		JPanel bottomPanel = new JPanel();
		btnImport = new JButton("Import");
		btnConvert = new JButton("Convert");
		btnExit = new JButton("Exit");
		bottomPanel.add(btnImport);
		bottomPanel.add(btnConvert);
		bottomPanel.add(btnExit);
		bottomPanel.setVisible(true);
		mainFrame.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	private void initButtonListener() {
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importImage();
			}
		});
		
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertImage();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Executes the importImage method of the importer and checks if the import
	 * is not <b> null <b>.
	 */
	private void importImage() {
		image = importer.importImageFromPath(tfImagePath.getText());
		if (image == null) {
			lbStatus.setText("Error, invalid path or file.");
		} else {
			lbStatus.setText("Status: Image successfully imported.");
			displayImage();
		}
	}
	
	/**
	 * Executes the convert method of the converter and prints the result by
	 * using the printFile method of the PrintImage class.
	 */
	private void convertImage() {
		String[][] bits = converter.convert(image);
		if (printer.printFile(bits, tfImagePath.getText())) {
			lbStatus.setText("Status: conversion has been successful.");
		} else {
			lbStatus.setText("Error, program was not able to store the converted image.");
		}
	}
	
	/**
	 * Displays the imported image inside the JLabel lbPreview.
	 * Method gets called only if image has been imported successfully.
	 * No checks needed.
	 */
	private void displayImage() {
		Image temp = image.getScaledInstance(300, 300, 0);
		ImageIcon icon = new ImageIcon(temp);
		lbPreview.setIcon(icon);
	}
}
