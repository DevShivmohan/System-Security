import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import system.SystemInfo;

public class Home extends SystemInfo {
	private JFrame frame;

	public Home() {
		frame = new JFrame("System Security");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(getScreenWidth(), getScreenHeight());
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// calling authorized person
//        inputPassword();

		// main panel
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(getHomeMainPanelColor());
		mainPanel.setBounds(0, 0, getScreenWidth(), getScreenHeight());
		frame.add(mainPanel);

		// north panel
		new NorthPanel(mainPanel);

		// south panel
		new SouthPanel(mainPanel);

		// east panel
		new EastPanel(mainPanel);

		// center panel
		CenterPanel centerPanel = new CenterPanel(mainPanel);

		// west panel
		new WestPanel(frame, mainPanel, centerPanel.getPanel());

		// refreshing mainPanel
		mainPanel.revalidate();
		mainPanel.repaint();

		// exit frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	private void inputPassword() {
		JPasswordField passwordField = new JPasswordField();
		Object[] object = { new JLabel("Enter System build Password which provided by developer"), passwordField };
		int result = JOptionPane.showConfirmDialog(null, object, "System Authentication", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			if (!passwordField.getText().equals(getSystemPassword())) {
				JOptionPane.showMessageDialog(frame, "Incorrect System build Password please try again",
						"Unauthorized person", JOptionPane.ERROR_MESSAGE);
				inputPassword();
			}
		} else
			System.exit(0);
	}
}
