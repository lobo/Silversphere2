package frontend;

import gui.BoardPanel;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import backend.Board;
import backend.Floor;

public class GamePan extends JPanel {

	private static final int CELL_SIZE = 30;

	private Board board;
	private BoardPanel bpanel;
	private JFrame frame;
	
	private Draw paint;

	public GamePan(Board b, JFrame frame) {

		this.frame = frame;
		
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
	
	public void drawBoard() throws IOException {
		for(int i = 0;i<board.getWidth();i++){
			for(int j = 0;j<board.getHeight();j++){
				if(board.getCell(new Point(i, j)).equals(Floor.class) && !board.getCell(new Point(i, j)).isAccesible()){
					bpanel.clearImage(i, j);
				}
				bpanel.setImage(i, j, paint.drawCell(board, i, j));
			}
		}
		bpanel.repaint();
		
}
}
	