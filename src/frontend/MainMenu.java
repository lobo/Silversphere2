package frontend;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainMenu extends JFrame {

	public MainMenu() {
		setTitle("SilverSphere");
		setBounds(1, 1, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		BackGroundMenu back = new BackGroundMenu();

		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2
				- getHeight() / 2);

		JButton nuevo = new JButton("Nuevo Juego");
		nuevo.setBounds(20, 150, 140, 25);
		nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JButton cargar = new JButton("Cargar Partida");
		cargar.setBounds(20, 190, 140, 25);
		cargar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JButton salir = new JButton("Salir");
		salir.setBounds(20, 230, 140, 25);
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));

		back.add(nuevo);
		back.add(cargar);
		back.add(salir);
		add(back);

		repaint();

		nuevo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				switch (e.getID()) {
				case MouseEvent.MOUSE_CLICKED:
					setVisible(false);
					JFileChooser fileOpen = new JFileChooser();
					fileOpen.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileOpen.setAcceptAllFileFilterUsed(false);
					// fileOpen.setFileFilter(filter);
					int value = fileOpen.showDialog(
							MainMenu.this.getContentPane(), "New Game");
					if (value == JFileChooser.APPROVE_OPTION) {
						File archive = fileOpen.getSelectedFile();
						try {
							new GamePly(archive);
						} catch (Exception exc) {
							JOptionPane.showMessageDialog(
									MainMenu.this.getContentPane(),
									"An error has occurred while loading the file");
						}
						dispose();
					}
				}
			}
		});

		salir.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				switch (e.getID()) {
				case MouseEvent.MOUSE_CLICKED:
					System.exit(0);
				}

			}
		});

	}

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
	}
}