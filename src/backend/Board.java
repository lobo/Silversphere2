package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Board implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cell[][] board = null;
	private int height = 0;
	private int width = 0;
	private State state = State.PLAYING;
	private Player player = null;
	private Interruptor inter = null;

	/**
	 * Creates a new Board
	 * 
	 * @param height
	 * @param width
	 */
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		board = new Cell[height][width];
	}

	/**
	 * Returns the board in its current state
	 * 
	 * @return Board board
	 */
	public Cell[][] getBoard() {
		return board;
	}

	/**
	 * Returns the height of the current board
	 * 
	 * @return Board's height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the width of the current board
	 * 
	 * @return Board's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the Board's Player
	 * 
	 * @return Player player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Sets the Board's Player with element
	 * 
	 * @param element
	 */
	public void setPlayer(Player element) {
		this.player = element;
	}

	/**
	 * Moves Player from one Cell to another in the direction of the given
	 * Cardinal
	 * 
	 * @param cardinal
	 * @return True if Player was able to move or False if Player wasn't able to
	 *         move
	 * @throws PositionOutOfBoundsException
	 */
	public boolean move(Cardinal cardinal) throws PositionOutOfBoundsException {

		Boolean AbletoMove;
		Point toPoint = SetPositionCardinal(player.getPosition(), cardinal);

		if (validPosition(toPoint) && board[toPoint.x][toPoint.y].setContent(player, toPoint,cardinal)) {
			((ContentOperations) board[player.getPosition().x][player.getPosition().y]).removeContent();
			player.setPosition(cardinal);

			AbletoMove = true;
		} else
			AbletoMove = false;

		return AbletoMove;
	}

	/**
	 * Places Cell on given position of the board
	 * 
	 * @param cell
	 * @param position
	 * @return True if the cell was successfully placed on the board
	 */
	public boolean putCell(Cell cell, Point position) {
		board[position.x][position.y] = cell;
		return true;
	}

	/**
	 * Places Content on given position of the board
	 * 
	 * @param cont
	 * @param position
	 * @return True if the Content given was able to placed on the board or
	 *         False if it wasn't able to
	 */
	public boolean putContent(Content cont, Point position) {
		if (board[position.x][position.y] instanceof ContentOperations
				&& ((ContentOperations) board[position.x][position.y])
						.getContent() == null) {
			board[position.x][position.y].setContent(cont);
			return true;
		}
		return false;
	}

	/**
	 * Returns Cell at the given position on the board
	 * 
	 * @param position
	 * @return Cell cell
	 */
	public Cell getCell(Point position) {
		return board[position.x][position.y];
	}

	/**
	 * Validates whether the point given is within the board's boundaries
	 * 
	 * @param p
	 * @return True if p is within the boards boundaries, False if not
	 */
	public boolean validPosition(Point p) {
		return (p.x >= 0 && p.x < height && p.y >= 0 && p.y < width);
	}

	/**
	 * Returns the actual state of the interrupter
	 * 
	 * @return Interrupter interrupter
	 */
	public boolean isInterruptorActive() {
		Content aux = inter.getContent();
		if (aux != null) {
			return (inter.getContent().interuptorReact());
		} else {
			return false;
		}
	}

	/**
	 * Sets inter as the board's interrupter
	 * 
	 * @param inter
	 */
	public void setInterruptor(Interruptor inter) {
		this.inter = inter;
	}

	/**
	 * Creates a new Point from the given Cardinal
	 * 
	 * @param p
	 *            Actual point
	 * @param c
	 *            Cardinal with the direction
	 * @return New instance of point with the new position.
	 */
	public Point SetPositionCardinal(Point p, Cardinal c) {
		return (new Point((int) p.getX() + c.getDirX(),
				((int) p.getY() + c.getDirY())));
	}

	/**
	 * Returns the current "Win or Lose" state of the board
	 * 
	 * @return State state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Sets the current "Win or Lose" state to the one given as a parameter
	 * 
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}

}