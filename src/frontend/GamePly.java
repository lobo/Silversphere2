package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import backend.SaveandLoadGame;
import backend.State;
import exceptions.ParsingException;
import frontend.MainMenu;

public class GamePly extends JFrame {
	
	public static final int CELL_SIZE = 30;
	private Board board;
	private final GamePan gp;
	

	public GamePly(File archive) throws IOException {
		this(createFromArchive(archive));
		
			}
		
	public GamePly(Board board){
		this.board=board;
		setTitle("Silversphere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		createMenuBar();
		setSize (board.getWidth()*CELL_SIZE + 20,board.getHeight()*CELL_SIZE + 70 );
		gp = new GamePan(board, this);
		handleInput();
		add(gp);
		gp.drawBoard();
		centerScreen();
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
		
		gotoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainMenu();
			}
		});

		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveGame();
			}

			
		});
		

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
				if(board.getState().equals(State.PLAYING)){
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

					gp.drawBoard();
					playerWon();
					playerLost();

			}
			
			}


		});
	}
	
	private void playerLost() {
		if(board.getState().equals(State.LOSE)){
			new EndScreen(this, "PERDISTE").setVisible(true);
		}
		
	}

	private void playerWon() {
		if(board.getState().equals(State.WIN)){
			new EndScreen(this, "GANASTE").setVisible(true);
		}
		
	}
	
	private void saveGame() {
	        String name;
	        name = (String) JOptionPane.showInputDialog(null, "Ingrese un nombre",
	        "Guardar Partida",JOptionPane.OK_CANCEL_OPTION);
	        if(name != null) {
	        	File saveFolder = new File("saveGames");
	        	saveFolder.mkdir();
	        	try{
	        		new SaveandLoadGame().SaveGame(board,"saveGames/" + name);
	        } catch (IOException e) {
				new ErrorWindow("Error al guardar partida", this).setVisible(true);
				new MainMenu();
	        }
	     }
	}
	
	private static Board createFromArchive(File archive)throws IOException{
		try {
			return (new Parser()).parse(archive);
		} catch (ParsingException exc) {
			JOptionPane.showMessageDialog(null,
					"El mapa seleccionado es invalido", "Error",
					JOptionPane.ERROR_MESSAGE);
					throw new IOException();
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null,
					"El mapa seleccionado es invalido", "Error",
					JOptionPane.ERROR_MESSAGE);
				throw new IOException();
				
		}
	}
	
}