package icon;

import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class ScreenSize {
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	public int getFrameWidth() {
		return dimension.width; // main frame width size
	}

	public int getFrameHeight() {
		return dimension.height; // main frame height size
	}

	public int getMenubarX() {
		int X = dimension.width / 6;
		return X + 100;
	}

	public int getMenubarY() {
		int Y = 10;
		return Y;
	}

	public int getMenubarWidth() {
		int width = dimension.width / 2;
		width = width - 20;
		return width;
	}

	public int getMenubarHeight() {
		int height = 30;
		return height;
	}
}
