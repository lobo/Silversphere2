package frontend;

import gui.BoardPanel;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import backend.Board;
import backend.Floor;
import backend.Player;

public class GamePan extends JPanel {

	private static final int CELL_SIZE = 30;

	private final Board board;
	private final BoardPanel bpanel;
	private final JFrame frame;
	private boolean first = true;

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
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				if (board.getCell(new Point(i, j)).equals(Floor.class)
						&& !board.getCell(new Point(i, j)).isAccesible()) {
					bpanel.clearImage(i, j);
				}
				if (board.getCell(new Point(i, j)).getContent()
						.equals(Player.class)
						&& first) {
					System.out.println("entro en gamepan");
					bpanel.appendImage(i, j, paint.drawCell(board, i, j));
					first = false;
				}
				bpanel.appendImage(i, j, paint.drawCell(board, i, j));
			}
		}
		bpanel.repaint();

	}
}
