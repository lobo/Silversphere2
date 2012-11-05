package frontend;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

<<<<<<< HEAD
public class ErrorWindow extends JDialog {

	public ErrorWindow(String str, final JFrame frame) {
=======
public class ErrorWindow extends JDialog{

	public ErrorWindow(String str, final JFrame frame){
		
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
		frame.setEnabled(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setResizable(false);
<<<<<<< HEAD
		setSize(250, 100);
		centerScreen();
		setTitle("ERROR");

		JLabel label = new JLabel(str, JLabel.CENTER);
		add(label);
		addWindowListener(new WindowAdapter() {
			@Override
=======
		setSize(250,100);
		centerScreen();
		setTitle("ERROR");
        
		JLabel label = new JLabel(str, JLabel.CENTER);
	
		add(label);
		
		addWindowListener(new WindowAdapter() {
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				frame.setEnabled(true);
			}
		});
<<<<<<< HEAD
	}

	public void centerScreen() {
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2
				- getHeight() / 2);
=======
		
	}

	public void centerScreen(){
		Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,
        size.height/2 - getHeight()/2);
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
	}

}
