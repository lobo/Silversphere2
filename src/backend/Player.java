package backend;

import java.awt.Point;
import java.io.Serializable;

public class Player extends Content implements Serializable {

	public Player(Point point, Board board) {
		super(point, board);
	}

	private static final long serialVersionUID = 1L;

	// Hecho para cuando se cae al agua, falta implementar,
	// se crea aca la situacion de perder la partida
	@Override
	public boolean remove() {
		this.getBoard().getInstanceBoardListener().gameOver();
		return false;
	}

	/**
	 * Nadie le va a pedir al player que se mueva
	 */
	@Override
	public boolean move(Point going, Cardinal cardinal) {
		return false;
	}
}