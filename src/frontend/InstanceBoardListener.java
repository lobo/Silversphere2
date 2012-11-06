package frontend;

import javax.swing.JOptionPane;

import backend.BoardListener;

public class InstanceBoardListener implements BoardListener {

	@Override
	public void win() {
		frameCreator("Ganaste!");
	}

	@Override
	public void gameOver() {
		frameCreator("Perdiste!");
	}

	private void frameCreator(String text) {
		JOptionPane.showMessageDialog(null, text);
		System.exit(0);
	}

}