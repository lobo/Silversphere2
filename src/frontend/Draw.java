package frontend;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

import backend.Board;
import backend.Box;
import backend.Cell;
import backend.Floor;
import backend.Ice;
import backend.Interruptor;
import backend.Player;
import backend.Target;
import backend.Tree;
import backend.Water;
import backend.WaterBox;

public class Draw {

	private final HashMap<Class<?>, String> images = new HashMap<Class<?>, String>();

	public Draw() throws IOException {

		images.put(Box.class, "resources/box.png");
		images.put(Floor.class, "resources/cell.png");
		images.put(Ice.class, "resources/ice-box.png");
		images.put(Player.class, "resources/player.png");
		images.put(Water.class, "resources/water.png");
		images.put(Tree.class, "resources/tree.png");
		images.put(Target.class, "resources/target.png");
		images.put(Interruptor.class, "resources/ice-box-target.png");

	}

	public Image drawCell(Board board, int row, int col) throws IOException {
		Cell cell = board.getCell(new Point(row, col));
		if (cell instanceof Tree || cell instanceof Water) {
			return loadImage(images.get(cell.getClass()));
		} else if (cell instanceof WaterBox) {
			if (!cell.isAccesible()) {
				return loadImage(images.get(cell.getClass()));
			} else {
				return colorize(loadImage(images.get(Box.class)), new Color(
						100, 100, 100));
			}
		} else {
			if (cell.isAccesible()) {
				return loadImage(images.get(cell.getClass()));
			} else {
				// fijar back x getContent en Cell
				return loadImage(images.get(cell.getContent().getClass()));
			}
		}

	}

	/**
	 * Carga una imagen y retorna una instancia de la misma. Si hay algun
	 * problema al leer el archivo lanza una excepcion.
	 */
	public static Image loadImage(String fileName) throws IOException {
		InputStream stream = ClassLoader.getSystemResourceAsStream(fileName);
		if (stream == null) {
			return ImageIO.read(new File(fileName));
		} else {
			return ImageIO.read(stream);
		}
	}

	/**
	 * Dada una imagen en escala de grises, la tiÃ±e con el color indicado.
	 */
	public static Image colorize(Image image, Color color) {
		BufferedImage result = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		result.getGraphics().drawImage(image, 0, 0, null);

		for (int x = 0; x < image.getWidth(null); x++) {
			for (int y = 0; y < image.getHeight(null); y++) {
				Color c = new Color(result.getRGB(x, y), true);

				if (c.getAlpha() != 0) {
					double r = c.getGreen() / 255.0;
					Color c2 = new Color((int) (r * color.getRed()),
							(int) (r * color.getGreen()),
							(int) (r * color.getBlue()));
					result.setRGB(x, y, c2.getRGB());
				}
			}
		}
		return result;

	}

}
