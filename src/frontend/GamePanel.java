package frontend;

import gui.BoardPanel;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
<<<<<<< HEAD

=======
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
import backend.Board;
import backend.Floor;

public class GamePanel extends JPanel {

	private static final int CELL_SIZE = 30;

<<<<<<< HEAD
	private final Board board;
	private final BoardPanel bpanel;
	private final JFrame frame;

=======
	private Board board;
	private BoardPanel bpanel;
	private JFrame frame;
	
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
	private Draw paint;

	public GamePanel(Board b, JFrame frame) {

		this.frame = frame;
<<<<<<< HEAD

=======
		
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
		try {
			paint = new Draw();
		} catch (IOException e) {
			new ErrorWindow("Error al cargar imagenes", frame);
		}

		setLayout(null);
		setSize((b.getWidth()) * CELL_SIZE, (b.getHeight()) * CELL_SIZE);

		board = b;
		bpanel = new BoardPanel(board.getHeight(), board.getWidth(), CELL_SIZE);
		bpanel.setBackground(Color.WHITE);
		add(bpanel);
	}
<<<<<<< HEAD

	public void drawBoard() throws IOException {
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				if (board.getCell(new Point(i, j)).equals(Floor.class)
						&& !board.getCell(new Point(i, j)).isAccesible()) {
=======
	
	public void drawBoard() throws IOException {
		for(int i = 0;i<board.getWidth();i++){
			for(int j = 0;j<board.getHeight();j++){
				if(board.getCell(new Point(i, j)).equals(Floor.class) && !board.getCell(new Point(i, j)).isAccesible()){
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
					bpanel.clearImage(i, j);
				}
				bpanel.setImage(i, j, paint.drawCell(board, i, j));
			}
		}
		bpanel.repaint();
<<<<<<< HEAD

	}
}
=======
		
}
}
	
>>>>>>> 0fbf34c02731d7c621354735dfc9178d6c78ddbf
