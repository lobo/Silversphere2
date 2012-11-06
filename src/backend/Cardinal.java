package backend;

import java.io.Serializable;

public enum Cardinal implements Serializable {

	NORTH(-1, 0), SOUTH(1, 0), WEST(0, -1), EAST(0, 1);

	private int dirX;
	private int dirY;

	/**
	 * Creates a new Cardinal
	 * 
	 * @param dirX
	 * @param dirY
	 */
	private Cardinal(int dirX, int dirY) {
		this.dirX = dirX;
		this.dirY = dirY;
	}
	
	/**
	 * Returns the Points "X" direction
	 * 
	 * @return int dirX
	 */
	public int getDirX() {
		return dirX;
	}

	/**
	 * Returns the Points "Y" direction
	 * 
	 * @return int dirY
	 */
	public int getDirY() {
		return dirY;
	}
}