package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Board implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cell[][] board = null;
	private int height = 0;
	private int width = 0;
	private boolean interruptor = false;
	private Player player = null;

	private transient BoardListener instanceBoardListener;

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		board = new Cell[height][width]; // queda todo en null
	}

	public Cell[][] getBoard() {
		return board;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player element) {
		this.player = element;
	}

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

	public boolean putCell(Cell cell, Point position) {
			board[position.x][position.y]=cell;
			return true;
	}

	/* Parser use only */
	public boolean putContent(Content cont, Point position) {
		if(board[position.x][position.y] instanceof ContentOperations && ((ContentOperations)board[position.x][position.y]).getContent()==null){
			board[position.x][position.y].setContent(cont);
			return true;
		}
		return false;
	}

	public Cell getCell(Point position) {
		return board[position.x][position.y];
	}

	public boolean validPosition(Point p) {
		return (p.x >= 0 && p.x < height && p.y >= 0 && p.y < width);
	}

	public boolean isInterruptorActive() {
		return interruptor;
	}

	/**
	 * New point with the position I want to go.
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

	public void activateInterruptor() {
		interruptor = true;
	}

	public BoardListener getInstanceBoardListener() {
		return instanceBoardListener;
	}

	public void setInstanceBoardListener(BoardListener instanceBoardListener) {
		this.instanceBoardListener = instanceBoardListener;
	}

}