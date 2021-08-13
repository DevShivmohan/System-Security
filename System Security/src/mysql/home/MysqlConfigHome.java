package mysql.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import color.Colors;

public class MysqlConfigHome extends Colors {
	private JFrame previousFrame, currentFrame;

	public MysqlConfigHome(JFrame frame) {
		this.previousFrame = frame; // initializing previous frame
		this.previousFrame.setVisible(false); // invisible previous frame
		currentFrame = new JFrame("MySQL Operations such as Upload files");
		currentFrame.setSize(getFrameWidth(), getFrameHeight());
		currentFrame.setLayout(new GridBagLayout());
		currentFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		currentFrame.getContentPane().setBackground(getMySQLConfigPanelBackground());
		currentFrame.setVisible(true);

		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints1.insets = new Insets(1, 1, 1, 1);
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 0;

		JLabel mainLabel = new JLabel(new ImageIcon(new ImageIcon(getHomeWalpaper()).getImage()
				.getScaledInstance(getFrameWidth(), getMenubarHeight(), Image.SCALE_AREA_AVERAGING)));
		mainLabel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY, 3, true), "MySQL Operations",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		mainLabel.setLayout(new GridBagLayout());
		mainLabel.setPreferredSize(new Dimension(getFrameWidth(), getFrameHeight()));
		mainLabel.setLayout(new GridBagLayout());
		mainLabel.setBackground(getMySQLConfigPanelBackground());
		currentFrame.add(mainLabel, gridBagConstraints1);

		// panel in mainLabel
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.insets = gridBagConstraints1.insets;
		JPanel homePanel = new JPanel(new GridBagLayout());
		homePanel.setBackground(getMySQLConfigPanelBackground());
		homePanel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY, 3, true), "Functions Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		mainLabel.add(homePanel, gridBagConstraints2);

		// backup
		gridBagConstraints3.insets = new Insets(80, 80, 30, 30);
		gridBagConstraints3.gridx = 1;
		gridBagConstraints3.gridy = 0;
		JButton backupButton = new JButton("Backup", new ImageIcon(
				new ImageIcon(getFunctionIcon()).getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		backupButton.setPreferredSize(new Dimension(130, 130));
		backupButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		backupButton.setHorizontalTextPosition(AbstractButton.CENTER);
		backupButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		homePanel.add(backupButton, gridBagConstraints3);

		// backup
		gridBagConstraints3.insets = new Insets(80, 80, 30, 30);
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.gridy = 0;
		backupButton = new JButton("Backupeee", new ImageIcon(
				new ImageIcon(getFunctionIcon()).getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		backupButton.setPreferredSize(new Dimension(130, 130));
		backupButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		backupButton.setHorizontalTextPosition(AbstractButton.CENTER);
		backupButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		homePanel.add(backupButton, gridBagConstraints3);

		// backup
		gridBagConstraints3.insets = new Insets(80, 80, 30, 30);
		gridBagConstraints3.gridx = 2;
		gridBagConstraints3.gridy = 0;
		backupButton = new JButton("Backupdd", new ImageIcon(
				new ImageIcon(getFunctionIcon()).getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		backupButton.setPreferredSize(new Dimension(130, 130));
		backupButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		backupButton.setHorizontalTextPosition(AbstractButton.CENTER);
		backupButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		homePanel.add(backupButton, gridBagConstraints3);
		currentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// window closing operation
		currentFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
