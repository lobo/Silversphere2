package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import manager.Parser;
import backend.Board;
import backend.Cardinal;
import exceptions.ParsingException;

public class GamePly extends JFrame {

	private Board board;
	private final GamePan gp;

	public GamePly(File archive) throws IOException {
		try {
			board = (new Parser()).parse(archive);
		} catch (ParsingException exc) {
			JOptionPane.showMessageDialog(null,
					"El mapa seleccionado es invalido", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Silversphere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		createMenuBar();
		setSize(300, 300);
		gp = new GamePan(board, this);
		handleInput();
		add(gp);
		gp.drawBoard();
		// centerScreen();
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Juego");
		menuBar.add(menu);

		this.add(menuBar);
		JMenuItem gotoMenu = new JMenuItem("Ir a menu");
		JMenuItem save = new JMenuItem("Guardar");
		JMenuItem quit = new JMenuItem("Salir");
		gotoMenu.addActionListener(null);
		menu.add(save);
		menu.add(gotoMenu);
		menu.add(quit);
		setJMenuBar(menuBar);

	}

	private void centerScreen() {
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(300, 300);
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2
				- getHeight() / 2);
	}

	/**
	 * Controla el movimiento del Player dependiendo que tecla se presiono
	 */
	private void handleInput() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					board.move(Cardinal.WEST);
					break;
				case KeyEvent.VK_RIGHT:
					board.move(Cardinal.EAST);
					break;
				case KeyEvent.VK_UP:
					board.move(Cardinal.NORTH);
					break;
				case KeyEvent.VK_DOWN:
					board.move(Cardinal.SOUTH);
					break;
				}

				try {
					gp.drawBoard();
					// playerWon();
					// playerLost();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
	}
}