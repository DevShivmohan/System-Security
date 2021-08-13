package icon;

import java.io.File;

public class Icons extends ScreenSize {
	private File file = new File(System.getProperty("user.dir") + "//require//icon");

	public String getPreloderIcon() {
		File preLoaderFile = new File(file.getAbsolutePath() + "//login_preloader.gif");
		if (preLoaderFile.exists())
			return preLoaderFile.getAbsolutePath();
		else
			return null;
	}

	public String getHomeWalpaper() {
		File preLoaderFile = new File(file.getAbsolutePath() + "//home.jpeg");
		if (preLoaderFile.exists())
			return preLoaderFile.getAbsolutePath();
		else
			return null;
	}

	public String getFunctionIcon() {
		File preLoaderFile = new File(file.getAbsolutePath() + "//security.png");
		if (preLoaderFile.exists())
			return preLoaderFile.getAbsolutePath();
		else
			return null;
	}
}
