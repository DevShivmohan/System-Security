import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Caret;

import mysql.home.MysqlConfigHome;
import system.SystemInfo;
import task.SeprateFile;
import validation.Validation;

public class WestPanel extends SystemInfo {

	private Thread thread1, thread2, thread3, thread4, thread5, thread6, thread7;
	private JPanel centerPanel, mainPanel;
	private JTextArea textArea;
	JScrollPane scrollPane;
	private JList list;
	private JFrame frame;

	public WestPanel(JFrame frame, JPanel mainPanel, JPanel centerPanel) {
		this.frame = frame;
		this.centerPanel = centerPanel;
		this.mainPanel = mainPanel;
		JPanel westPanel = new JPanel(new GridBagLayout());
		westPanel.setSize(200, getScreenHeight());
		westPanel.setBackground(getWestPanelColor());

		JScrollPane scrollPane = new JScrollPane(westPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollPane, BorderLayout.WEST);

		GridBagConstraints gbc = new GridBagConstraints();
		// new InsetsUIResource(top, left, bottom, right)

		gbc.insets = new Insets(50, 50, 50, 50);

		Color color1 = getButtonBackgroundColor();
		Color color2 = getButtonForegroundColor();

		// encrypt whole drives
		gbc.gridx = 0;
		gbc.gridy = 0;
		JButton encryptDriveButton = new JButton("Encrypt Drives");
		encryptDriveButton.setBackground(color1);
		encryptDriveButton.setForeground(color2);
		encryptDriveButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		encryptDriveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		westPanel.add(encryptDriveButton, gbc);
		encryptDriveButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				thread1 = new Thread(new Runnable() {
					public void run() {
						stopOtherTask(thread1);
						encryptDrivePanel();
					}
				});
				thread1.start();
			}
		});

		// encrypt directory
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton encryptDirButton = new JButton("Encrypt Folders");
		encryptDirButton.setBackground(color1);
		encryptDirButton.setForeground(color2);
		encryptDirButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		encryptDirButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		westPanel.add(encryptDirButton, gbc);
		encryptDirButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				thread2 = new Thread(new Runnable() {
					public void run() {
						stopOtherTask(thread2);
						encryptionDirPanel();
					}
				});
				thread2.start();
			}
		});

		// encrypt file
		gbc.gridx = 0;
		gbc.gridy = 2;
		JButton encryptFileButton = new JButton("Encrypt Files");
		encryptFileButton.setBackground(color1);
		encryptFileButton.setForeground(color2);
		encryptFileButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		encryptFileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		westPanel.add(encryptFileButton, gbc);
		encryptFileButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				thread3 = new Thread(new Runnable() {
					public void run() {
						stopOtherTask(thread3);
						encryptionFilePanel();
					}
				});
				thread3.start();
			}
		});

		// decrypt whole drive
		gbc.gridx = 0;
		gbc.gridy = 3;
		JButton decryptDriveButton = new JButton("Decrypt Drives");
		decryptDriveButton.setBackground(color1);
		decryptDriveButton.setForeground(color2);
		decryptDriveButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		decryptDriveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		westPanel.add(decryptDriveButton, gbc);
		decryptDriveButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				thread4 = new Thread(new Runnable() {
					public void run() {
						stopOtherTask(thread4);
						decryptDrivePanel();
					}
				});
				thread4.start();
			}
		});

		// decrypt directory
		gbc.gridx = 0;
		gbc.gridy = 4;
		JButton decryptDirButton = new JButton("Decrypt Folders");
		decryptDirButton.setBackground(color1);
		decryptDirButton.setForeground(color2);
		decryptDirButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		decryptDirButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		westPanel.add(decryptDirButton, gbc);
		decryptDirButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				thread5 = new Thread(new Runnable() {
					public void run() {
						stopOtherTask(thread5);
						decryptionDirPanel();
					}
				});
				thread5.start();
			}
		});

		// decrypt file
		gbc.gridx = 0;
		gbc.gridy = 5;
		JButton decryptFileButton = new JButton("Decrypt Files");
		decryptFileButton.setBackground(color1);
		decryptFileButton.setForeground(color2);
		decryptFileButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		decryptFileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		westPanel.add(decryptFileButton, gbc);
		decryptFileButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				thread6 = new Thread(new Runnable() {
					public void run() {
						stopOtherTask(thread6);
						decryptionFilePanel();
					}
				});
				thread6.start();
			}
		});

		// configuration
		gbc.gridx = 0;
		gbc.gridy = 6;
		JButton configButton = new JButton("Setting");
		configButton.setBackground(color1);
		configButton.setForeground(color2);
		configButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		configButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		westPanel.add(configButton, gbc);
		configButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				thread7 = new Thread(new Runnable() {
					public void run() {
						stopOtherTask(thread7);
						configurationPanel();
					}
				});
				thread7.start();
			}
		});
	}

	public void stopOtherTask(Thread thread) {
		if (thread1 != null && thread.getId() != thread1.getId() && thread1.isAlive())
			thread1.interrupt();
		if (thread2 != null && thread.getId() != thread2.getId() && thread2.isAlive())
			thread2.interrupt();
		if (thread3 != null && thread.getId() != thread3.getId() && thread3.isAlive())
			thread3.interrupt();
		if (thread4 != null && thread.getId() != thread4.getId() && thread4.isAlive())
			thread4.interrupt();
		if (thread5 != null && thread.getId() != thread5.getId() && thread5.isAlive())
			thread5.interrupt();
		if (thread6 != null && thread.getId() != thread6.getId() && thread6.isAlive())
			thread6.interrupt();
		if (thread7 != null && thread.getId() != thread7.getId() && thread7.isAlive())
			thread7.interrupt();
	}

	private void addSomeField(String frontText) {
		JLabel label = new JLabel(frontText);
		label.setFont(new Font("Arial", Font.CENTER_BASELINE, 22));
		label.setForeground(getHeadingForegroundColor());
		label.setBounds(300, 20, 400, 25);
		centerPanel.add(label);

		File[] files = scanDrives();
		String[] dirs = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			dirs[i] = files[i].getAbsolutePath();
		}
		JList list = new JList<>(dirs);
		list.setBounds(20, 50, 200, 300);
		list.setBackground(getListBackgroundColor());
		list.setForeground(getListForegroundColor());
		this.list = list;
		list.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		centerPanel.add(list);
	}

	// encryption drive panel
	private void encryptDrivePanel() {
		mainPanel.remove(centerPanel);
		if (scrollPane != null)
			mainPanel.remove(scrollPane);
		centerPanel = new JPanel(null);
		centerPanel.setBackground(getCenterPanelColor());
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		addSomeField("Encryption Drives");

		JLabel label = new JLabel("Create Key");
		label.setBounds(300, 100, 150, 30);
		label.setForeground(getKeyLabelForegroundColor());
		label.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		centerPanel.add(label);

		JTextField textField = new JTextField();
		textField.setBounds(450, 100, 300, 30);
		textField.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		textField.setToolTipText("Key length must be greater then 10 and less then 50 character");
		textField.setBackground(getTextFieldBackgroundColor());
		textField.setForeground(getTextFieldForegroundColor());
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent key) {
				if (textField.getText().length() == 50)
					key.consume();
			}
		});
		centerPanel.add(textField);

		// encrypt button
		JButton button = new JButton("Encrypt");
		button.setBounds(400, 150, 100, 30);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial", Font.ITALIC, 20));
		button.setBackground(getButtonBackgroundColor());
		button.setForeground(getButtonForegroundColor());
		centerPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Validation validation = new Validation();
				if (validation.isValidEncryptField(list, textField)) {
					if (isAuthenticatedUser()) {
						JOptionPane.showMessageDialog(button,
								"Note! This application will be accepted all files and ignore whoose file length more then "
										+ getRuntimeMemory() + " Byte",
								"Warning", JOptionPane.WARNING_MESSAGE);
						Object[] objects = list.getSelectedValues();
						SeprateFile seprateFile = new SeprateFile(textArea, textField.getText());
						seprateFile.initEncryptionTask(objects);
					}
				}
			}
		});

		// encrypted status in JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(getTextAreaBackgroundColor());
		textArea.setForeground(getTextAreaForegroundColor());
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(250, 200, 500, 200);
		Caret caret = textArea.getCaret();
		caret.setBlinkRate(20);
		caret.setDot(10);
		centerPanel.add(scrollPane);

		this.textArea = textArea;
		mainPanel.revalidate();
		mainPanel.repaint();

	}

	// encryption folder panel
	private void encryptionDirPanel() {

		mainPanel.remove(centerPanel);
		if (scrollPane != null)
			mainPanel.remove(scrollPane);
		centerPanel = new JPanel(null);
		centerPanel.setBackground(getCenterPanelColor());
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		addSomeField("Encryption Folders");
		centerPanel.remove(list);

		JLabel label = new JLabel("Create Key");
		label.setBounds(300, 100, 150, 30);
		label.setForeground(getKeyLabelForegroundColor());
		label.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		centerPanel.add(label);

		JTextField textField = new JTextField();
		textField.setBounds(450, 100, 300, 30);
		textField.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		textField.setToolTipText("Key length must be greater then 10 and less then 50 character");
		textField.setBackground(getTextFieldBackgroundColor());
		textField.setForeground(getTextFieldForegroundColor());
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent key) {
				if (textField.getText().length() == 50)
					key.consume();
			}
		});
		centerPanel.add(textField);

		// encrypt button
		JButton button = new JButton("Choose Folders");
		button.setBounds(400, 150, 200, 30);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial", Font.ITALIC, 20));
		button.setBackground(getButtonBackgroundColor());
		button.setForeground(getButtonForegroundColor());
		centerPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Validation validation = new Validation();
				if (validation.isValidKey(textField)) {
					JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fileChooser.setDialogTitle("Select directory");
					fileChooser.setMultiSelectionEnabled(true);
					fileChooser.setSize(700, 500);
					int a = fileChooser.showOpenDialog(centerPanel);
					if (a == fileChooser.APPROVE_OPTION) {
						a = JOptionPane.showConfirmDialog(centerPanel,
								"Note! This application will be accepted all files and ignore whoose file length more then "
										+ getRuntimeMemory() + " Byte\nAre you sure to start enrcyption ?",
								"Warning", JOptionPane.WARNING_MESSAGE);
						if (a == 0) {
							if (isAuthenticatedUser()) {
								File[] files = fileChooser.getSelectedFiles();
								SeprateFile seprateFile = new SeprateFile(textArea, textField.getText());
								seprateFile.initEncryptionTask(files);
							}
						}
					}
				}
			}
		});

		// encrypted status in JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(getTextAreaBackgroundColor());
		textArea.setForeground(getTextAreaForegroundColor());
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(250, 200, 500, 200);
		Caret caret = textArea.getCaret();
		caret.setBlinkRate(20);
		caret.setDot(10);
		centerPanel.add(scrollPane);

		this.textArea = textArea;
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	// encryption file panel
	private void encryptionFilePanel() {

		mainPanel.remove(centerPanel);
		if (scrollPane != null)
			mainPanel.remove(scrollPane);
		centerPanel = new JPanel(null);
		centerPanel.setBackground(getCenterPanelColor());
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		addSomeField("Encryption Files");
		centerPanel.remove(list);

		JLabel label = new JLabel("Create Key");
		label.setBounds(300, 100, 150, 30);
		label.setForeground(getKeyLabelForegroundColor());
		label.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		centerPanel.add(label);

		JTextField textField = new JTextField();
		textField.setBounds(450, 100, 300, 30);
		textField.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		textField.setToolTipText("Key length must be greater then 10 and less then 50 character");
		textField.setBackground(getTextFieldBackgroundColor());
		textField.setForeground(getTextFieldForegroundColor());
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent key) {
				if (textField.getText().length() == 50)
					key.consume();
			}
		});
		centerPanel.add(textField);

		// encrypt button
		JButton button = new JButton("Choose Files");
		button.setBounds(400, 150, 200, 30);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial", Font.ITALIC, 20));
		button.setBackground(getButtonBackgroundColor());
		button.setForeground(getButtonForegroundColor());
		centerPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Validation validation = new Validation();
				if (validation.isValidKey(textField)) {
					JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setDialogTitle("Select Files");
					fileChooser.setMultiSelectionEnabled(true);
					fileChooser.setSize(700, 500);
					int a = fileChooser.showOpenDialog(centerPanel);
					if (a == fileChooser.APPROVE_OPTION) {
						a = JOptionPane.showConfirmDialog(centerPanel,
								"Note! This application will be accepted all files and ignore whoose file length more then "
										+ getRuntimeMemory() + " Byte\nAre you sure to start enrcyption ?",
								"Warning", JOptionPane.WARNING_MESSAGE);
						if (a == 0) {
							if (isAuthenticatedUser()) {
								File[] files = fileChooser.getSelectedFiles();
								SeprateFile seprateFile = new SeprateFile(textArea, textField.getText());
								seprateFile.traverseEncryptionTask(files);
							}
						}
					}
				}
			}
		});

		// encrypted status in JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(getTextAreaBackgroundColor());
		textArea.setForeground(getTextAreaForegroundColor());
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(250, 200, 500, 200);
		Caret caret = textArea.getCaret();
		caret.setBlinkRate(20);
		caret.setDot(10);
		centerPanel.add(scrollPane);

		this.textArea = textArea;
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	// decryption drive panel
	private void decryptDrivePanel() {
		mainPanel.remove(centerPanel);
		if (scrollPane != null)
			mainPanel.remove(scrollPane);
		centerPanel = new JPanel(null);
		centerPanel.setBackground(getCenterPanelColor());
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		addSomeField("Decryption Drives");

		JLabel label = new JLabel("Enter your Key");
		label.setBounds(300, 100, 150, 30);
		label.setForeground(getKeyLabelForegroundColor());
		label.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		centerPanel.add(label);

		JPasswordField textField = new JPasswordField();
		textField.setBounds(450, 100, 300, 30);
		textField.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		textField.setToolTipText("Key length must be greater then 10 and less then 50 character");
		textField.setBackground(getTextFieldBackgroundColor());
		textField.setForeground(getTextFieldForegroundColor());
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent key) {
				if (textField.getText().length() == 50)
					key.consume();
			}
		});
		centerPanel.add(textField);

		// encrypt button
		JButton button = new JButton("Decrypt");
		button.setBounds(400, 150, 100, 30);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial", Font.ITALIC, 20));
		button.setBackground(getButtonBackgroundColor());
		button.setForeground(getButtonForegroundColor());
		centerPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Validation validation = new Validation();
				if (validation.isValidEncryptField(list, textField)) {
					if (isAuthenticatedUser()) {
						JOptionPane.showMessageDialog(button,
								"Note! This application will be accepted all files and ignore whoose file length more then "
										+ getRuntimeMemory() + " Byte",
								"Warning", JOptionPane.WARNING_MESSAGE);
						Object[] objects = list.getSelectedValues();
						SeprateFile seprateFile = new SeprateFile(textArea, textField.getText());
						seprateFile.initDecryptionTask(objects);
					}
				}
			}
		});

		// encrypted status in JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(getTextAreaBackgroundColor());
		textArea.setForeground(getTextAreaForegroundColor());
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(250, 200, 500, 200);
		Caret caret = textArea.getCaret();
		caret.setBlinkRate(20);
		caret.setDot(10);
		centerPanel.add(scrollPane);

		this.textArea = textArea;
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	// decryption folder panel
	private void decryptionDirPanel() {

		mainPanel.remove(centerPanel);
		if (scrollPane != null)
			mainPanel.remove(scrollPane);
		centerPanel = new JPanel(null);
		centerPanel.setBackground(getCenterPanelColor());
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		addSomeField("Decryption Folders");
		centerPanel.remove(list);

		JLabel label = new JLabel("Enter your Key");
		label.setBounds(300, 100, 150, 30);
		label.setForeground(getKeyLabelForegroundColor());
		label.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		centerPanel.add(label);

		JPasswordField textField = new JPasswordField();
		textField.setBounds(450, 100, 300, 30);
		textField.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		textField.setToolTipText("Key length must be greater then 10 and less then 50 character");
		textField.setBackground(getTextFieldBackgroundColor());
		textField.setForeground(getTextFieldForegroundColor());
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent key) {
				if (textField.getText().length() == 50)
					key.consume();
			}
		});
		centerPanel.add(textField);

		// folder choosen button
		JButton button = new JButton("Choose Folders");
		button.setBounds(400, 150, 200, 30);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial", Font.ITALIC, 20));
		button.setBackground(getButtonBackgroundColor());
		button.setForeground(getButtonForegroundColor());
		centerPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Validation validation = new Validation();
				if (validation.isValidKey(textField)) {
					JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fileChooser.setDialogTitle("Select directory");
					fileChooser.setMultiSelectionEnabled(true);
					fileChooser.setSize(700, 500);
					int a = fileChooser.showOpenDialog(centerPanel);
					if (a == fileChooser.APPROVE_OPTION) {
						a = JOptionPane.showConfirmDialog(centerPanel,
								"Note! This application will be accepted all files and ignore whoose file length more then "
										+ getRuntimeMemory() + " Byte\nAre you sure to start dercyption ?",
								"Warning", JOptionPane.WARNING_MESSAGE);
						if (a == 0) {
							if (isAuthenticatedUser()) {
								File[] files = fileChooser.getSelectedFiles();
								SeprateFile seprateFile = new SeprateFile(textArea, textField.getText());
								seprateFile.initDecryptionTask(files);
							}
						}
					}
				}
			}
		});

		// encrypted status in JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(getTextAreaBackgroundColor());
		textArea.setForeground(getTextAreaForegroundColor());
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(250, 200, 500, 200);
		Caret caret = textArea.getCaret();
		caret.setBlinkRate(20);
		caret.setDot(10);
		centerPanel.add(scrollPane);

		this.textArea = textArea;
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	// decryption file panel
	private void decryptionFilePanel() {

		mainPanel.remove(centerPanel);
		if (scrollPane != null)
			mainPanel.remove(scrollPane);
		centerPanel = new JPanel(null);
		centerPanel.setBackground(getCenterPanelColor());
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		addSomeField("Decryption Files");
		centerPanel.remove(list);

		JLabel label = new JLabel("Enter your Key");
		label.setBounds(300, 100, 150, 30);
		label.setForeground(getKeyLabelForegroundColor());
		label.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		centerPanel.add(label);

		JPasswordField textField = new JPasswordField();
		textField.setBounds(450, 100, 300, 30);
		textField.setFont(new Font("arial", Font.HANGING_BASELINE, 20));
		textField.setToolTipText("Key length must be greater then 10 and less then 50 character");
		textField.setBackground(getTextFieldBackgroundColor());
		textField.setForeground(getTextFieldForegroundColor());
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent key) {
				if (textField.getText().length() == 50)
					key.consume();
			}
		});
		centerPanel.add(textField);

		// decrypt button
		JButton button = new JButton("Choose Files");
		button.setBounds(400, 150, 200, 30);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial", Font.ITALIC, 20));
		button.setBackground(getButtonBackgroundColor());
		button.setForeground(getButtonForegroundColor());
		centerPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Validation validation = new Validation();
				if (validation.isValidKey(textField)) {
					JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setDialogTitle("Select Files");
					fileChooser.setMultiSelectionEnabled(true);
					fileChooser.setSize(700, 500);
					int a = fileChooser.showOpenDialog(centerPanel);
					if (a == fileChooser.APPROVE_OPTION) {
						a = JOptionPane.showConfirmDialog(centerPanel,
								"Note! This application will be accepted all files and ignore whoose file length more then "
										+ getRuntimeMemory() + " Byte\nAre you sure to start dercyption ?",
								"Warning", JOptionPane.WARNING_MESSAGE);
						if (a == 0) {
							if (isAuthenticatedUser()) {
								File[] files = fileChooser.getSelectedFiles();
								SeprateFile seprateFile = new SeprateFile(textArea, textField.getText());
								seprateFile.traverseDecryptionTask(files);
							}
						}
					}
				}
			}
		});

		// decrypted status in JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(getTextAreaBackgroundColor());
		textArea.setForeground(getTextAreaForegroundColor());
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(250, 200, 500, 200);
		Caret caret = textArea.getCaret();
		caret.setBlinkRate(20);
		caret.setDot(10);
		centerPanel.add(scrollPane);

		this.textArea = textArea;
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	// configuration panel
	private void configurationPanel() {

		mainPanel.remove(centerPanel);
		if (scrollPane != null)
			mainPanel.remove(scrollPane);
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(getCenterPanelColor());
		scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollPane, BorderLayout.CENTER);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(50, 50, 30, 50);
		gbc.gridx = 0;
		gbc.gridy = 0;
		// new InsetsUIResource(top, left, bottom, right)

		JLabel label = new JLabel("Configuration of all functions");
		label.setForeground(getHeadingForegroundColor());
		label.setFont(new Font("arial", Font.HANGING_BASELINE, 28));
		centerPanel.add(label, gbc);

		// decrypt button
		gbc.gridy = 1;
		JButton button = new JButton("Change System Password");
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial", Font.ITALIC, 20));
		button.setBackground(getButtonBackgroundColor());
		button.setForeground(getButtonForegroundColor());
		centerPanel.add(button, gbc);
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (isAuthenticatedUser()) {
					String pass = JOptionPane.showInputDialog(null,
							"Enter New System Password not for provided by developer");
					if (pass != null) {
						if (pass.length() >= 10 && pass.length() <= 50) {
							if (updateSystemPassword(pass))
								JOptionPane.showMessageDialog(null, "System Password has been updated successfully");
							else
								JOptionPane.showMessageDialog(null,
										"Some technical issues for updating System Password", "error", 0);
						} else
							JOptionPane.showMessageDialog(null, "Password length between 10 and 50 Character",
									"validate password", 0);
					}
				}
			}
		});

		// left panel button
		gbc.gridy = 2;
		JButton button1 = new JButton("Left Panel Background Color");
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button1.setFont(new Font("Arial", Font.ITALIC, 20));
		button1.setBackground(getButtonBackgroundColor());
		button1.setForeground(getButtonForegroundColor());
		centerPanel.add(button1, gbc);
		button1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(0);
			}
		});

		// center panel button
		gbc.gridy = 3;
		JButton button2 = new JButton("Center Panel Background Color");
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.setFont(new Font("Arial", Font.ITALIC, 20));
		button2.setBackground(getButtonBackgroundColor());
		button2.setForeground(getButtonForegroundColor());
		centerPanel.add(button2, gbc);
		button2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(1);
			}
		});

		gbc.gridy = 4;
		JButton button3 = new JButton("Button Background Color");
		button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button3.setFont(new Font("Arial", Font.ITALIC, 20));
		button3.setBackground(getButtonBackgroundColor());
		button3.setForeground(getButtonForegroundColor());
		centerPanel.add(button3, gbc);
		button3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(2);
			}
		});

		gbc.gridy = 5;
		JButton button4 = new JButton("Button Foreground Color");
		button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button4.setFont(new Font("Arial", Font.ITALIC, 20));
		button4.setBackground(getButtonBackgroundColor());
		button4.setForeground(getButtonForegroundColor());
		centerPanel.add(button4, gbc);
		button4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(3);
			}
		});

		gbc.gridy = 6;
		JButton button5 = new JButton("TextArea Background Color");
		button5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button5.setFont(new Font("Arial", Font.ITALIC, 20));
		button5.setBackground(getButtonBackgroundColor());
		button5.setForeground(getButtonForegroundColor());
		centerPanel.add(button5, gbc);
		button5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(4);
			}
		});

		gbc.gridy = 7;
		JButton button6 = new JButton("TextArea Foreground Color");
		button6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button6.setFont(new Font("Arial", Font.ITALIC, 20));
		button6.setBackground(getButtonBackgroundColor());
		button6.setForeground(getButtonForegroundColor());
		centerPanel.add(button6, gbc);
		button6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(5);
			}
		});

		gbc.gridy = 8;
		JButton button7 = new JButton("List Background Color");
		button7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button7.setFont(new Font("Arial", Font.ITALIC, 20));
		button7.setBackground(getButtonBackgroundColor());
		button7.setForeground(getButtonForegroundColor());
		centerPanel.add(button7, gbc);
		button7.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(6);
			}
		});

		gbc.gridy = 9;
		JButton button8 = new JButton("List Foreground Color");
		button8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button8.setFont(new Font("Arial", Font.ITALIC, 20));
		button8.setBackground(getButtonBackgroundColor());
		button8.setForeground(getButtonForegroundColor());
		centerPanel.add(button8, gbc);
		button8.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(7);
			}
		});

		gbc.gridy = 10;
		JButton button9 = new JButton("Heading Foreground Color");
		button9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button9.setFont(new Font("Arial", Font.ITALIC, 20));
		button9.setBackground(getButtonBackgroundColor());
		button9.setForeground(getButtonForegroundColor());
		centerPanel.add(button9, gbc);
		button9.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(8);
			}
		});

		gbc.gridy = 11;
		JButton button10 = new JButton("Key Label Foreground Color");
		button10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button10.setFont(new Font("Arial", Font.ITALIC, 20));
		button10.setBackground(getButtonBackgroundColor());
		button10.setForeground(getButtonForegroundColor());
		centerPanel.add(button10, gbc);
		button10.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(9);
			}
		});

		gbc.gridy = 12;
		JButton button11 = new JButton("TextField Background Color");
		button11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button11.setFont(new Font("Arial", Font.ITALIC, 20));
		button11.setBackground(getButtonBackgroundColor());
		button11.setForeground(getButtonForegroundColor());
		centerPanel.add(button11, gbc);
		button11.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(10);
			}
		});

		gbc.gridy = 13;
		JButton button12 = new JButton("TextField Foreground Color");
		button12.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button12.setFont(new Font("Arial", Font.ITALIC, 20));
		button12.setBackground(getButtonBackgroundColor());
		button12.setForeground(getButtonForegroundColor());
		centerPanel.add(button12, gbc);
		button12.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				inputColor(11);
			}
		});

		// mysql configuration
		gbc.gridy = 14;
		JButton mysqlConfigButton = new JButton("Mysql Configuration");
		mysqlConfigButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mysqlConfigButton.setFont(new Font("arial", Font.ITALIC, 20));
		mysqlConfigButton.setBackground(getButtonBackgroundColor());
		mysqlConfigButton.setForeground(getButtonForegroundColor());
		centerPanel.add(mysqlConfigButton, gbc);
		mysqlConfigButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new MysqlConfigHome(frame); // goto mysql page
			}
		});

		gbc.gridy = 15;
		JButton button13 = new JButton("Reset");
		button13.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button13.setFont(new Font("Arial", Font.ITALIC, 20));
		button13.setBackground(getButtonBackgroundColor());
		button13.setForeground(getButtonForegroundColor());
		centerPanel.add(button13, gbc);
		button13.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				deleteFiles();
				JOptionPane.showMessageDialog(null,
						"Setting are reset Please Restart the Application and Changes are applied");
			}
		});

		gbc.gridy = 16;
		JButton button14 = new JButton("Apply");
		button14.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button14.setFont(new Font("Arial", Font.ITALIC, 20));
		button14.setBackground(getButtonBackgroundColor());
		button14.setForeground(getButtonForegroundColor());
		centerPanel.add(button14, gbc);
		button14.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JOptionPane.showMessageDialog(null, "Please Restart the Application and Changes are applied");
				System.exit(0);
			}
		});

		mainPanel.revalidate();
		mainPanel.repaint();
	}

	private boolean isAuthenticatedUser() {
		JPasswordField passwordField = new JPasswordField();
		Object[] object = { new JLabel("Enter current System Password"), passwordField };
		int result = JOptionPane.showConfirmDialog(null, object, "System User Authentication",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			if (passwordField.getText().equals(getSystemPassword()))
				return true;
			else {
				JOptionPane.showMessageDialog(null, "Access Denide", "Unauthorized User", 0);
				return false;
			}
		}
		return false;
	}

	private void inputColor(int index) {
		JColorChooser colorChooser = new JColorChooser(Color.DARK_GRAY);
		Color color = colorChooser.showDialog(null, "Select Color", Color.DARK_GRAY);
		if (color != null) {
			if (writeColor(color, index))
				JOptionPane.showMessageDialog(null, "Color set successfully");
			else
				JOptionPane.showMessageDialog(null, "Color not set some technical issue", "error", 0);
		}

	}

}
