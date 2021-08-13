package color;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.plaf.ColorUIResource;

import icon.Icons;

public class Colors extends Icons {
	private String mainPath = System.getProperty("user.home");

	public String getSecurityRootPath() {
		File file = new File(mainPath + "//" + "security");
		file.mkdirs();
		return file.getAbsolutePath();
	}

	public Color getMySQLConfigPanelBackground() {
		return ColorUIResource.MAGENTA;
	}

	public Color getHomeMainPanelColor() {
		Color color = ColorUIResource.PINK;
		return color;
	}

	public Color getNorthPanelColor() {
		Color color = ColorUIResource.GREEN;
		return color;
	}

	public Color getSouthPanelColor() {
		Color color = ColorUIResource.RED;
		return color;
	}

	public Color getEastPanelColor() {
		Color color = ColorUIResource.MAGENTA;
		return color;
	}

	public Color getWestPanelColor() {
		Color color = ColorUIResource.PINK;
		Color color1 = readColor(0);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getCenterPanelColor() {
		Color color = ColorUIResource.DARK_GRAY;
		Color color1 = readColor(1);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getButtonBackgroundColor() {
		Color color = ColorUIResource.DARK_GRAY;
		Color color1 = readColor(2);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getButtonForegroundColor() {
		Color color = ColorUIResource.BLUE;
		Color color1 = readColor(3);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getTextAreaBackgroundColor() {
		Color color = ColorUIResource.DARK_GRAY;
		Color color1 = readColor(4);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getTextAreaForegroundColor() {
		Color color = ColorUIResource.WHITE;
		Color color1 = readColor(5);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getListBackgroundColor() {
		Color color = ColorUIResource.WHITE;
		Color color1 = readColor(6);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getListForegroundColor() {
		Color color = ColorUIResource.BLACK;
		Color color1 = readColor(7);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getHeadingForegroundColor() {
		Color color = ColorUIResource.BLUE;
		Color color1 = readColor(8);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getKeyLabelForegroundColor() {
		Color color = ColorUIResource.CYAN;
		Color color1 = readColor(9);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getTextFieldBackgroundColor() {
		Color color = ColorUIResource.MAGENTA;
		Color color1 = readColor(10);
		if (color1 != null)
			return color1;
		return color;
	}

	public Color getTextFieldForegroundColor() {
		Color color = ColorUIResource.BLACK;
		Color color1 = readColor(11);
		if (color1 != null)
			return color1;
		return color;
	}

	public void deleteFiles() {
		String[] hints = { "LeftPanelBackground", "CenterPanelBackground", "ButtonBackground", "ButtonForeground",
				"TextAreaBackground", "TextAreaForeground", "ListBackground", "ListForeground", "HeadingForeground",
				"KeyLabelForeground", "TextFieldBackground", "TextFieldForeground" };
		for (String str : hints) {
			File file = new File(getSecurityRootPath() + "//" + str + ".shiv");
			file.delete();
		}
	}

	public boolean writeColor(Color color, int index) {
		try {
			String[] hints = { "LeftPanelBackground", "CenterPanelBackground", "ButtonBackground", "ButtonForeground",
					"TextAreaBackground", "TextAreaForeground", "ListBackground", "ListForeground", "HeadingForeground",
					"KeyLabelForeground", "TextFieldBackground", "TextFieldForeground" };
			FileOutputStream fileOutputStream = new FileOutputStream(
					getSecurityRootPath() + "//" + hints[index] + ".shiv");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(color);
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Color readColor(int index) {
		try {
			String[] hints = { "LeftPanelBackground", "CenterPanelBackground", "ButtonBackground", "ButtonForeground",
					"TextAreaBackground", "TextAreaForeground", "ListBackground", "ListForeground", "HeadingForeground",
					"KeyLabelForeground", "TextFieldBackground", "TextFieldForeground" };
			FileInputStream fileInputStream = new FileInputStream(
					getSecurityRootPath() + "//" + hints[index] + ".shiv");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Color color = (Color) objectInputStream.readObject();
			objectInputStream.close();
			return color;
		} catch (Exception e) {
			return null;
		}
	}
}
