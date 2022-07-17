import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class View extends Canvas {

	private static final long serialVersionUID = 6402801354313886123L;
	private static Image imageIcon;
	public static final int WIDTH = 160;
	public static final int HEIGHT = 160;
	public static final int SCALE = 4;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame gameFrame = new JFrame("Skribbl.io Clone");
				JPanel drawPanel = new JPanel();
				try {
					imageIcon = ImageIO.read(new File("res/skribbliologo.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}

				JSplitPane chatSplitPane = new JSplitPane();
				JScrollPane scrollPane = new JScrollPane();
				JTextField messageBox = new JTextField();
				JTextArea chatBox = new JTextArea();
				scrollPane.add(messageBox);
				
				chatSplitPane.setBorder(null);
				chatSplitPane.setEnabled(false);
				chatSplitPane.setDividerLocation(WIDTH * 5 / 2);
				Canvas canvas = new Canvas();
				chatSplitPane.setLeftComponent(canvas);
				chatSplitPane.setRightComponent(scrollPane);

				JSplitPane leftSplitPane = new JSplitPane();
				leftSplitPane.setBorder(null);
				leftSplitPane.setLeftComponent(new JPanel());
				leftSplitPane.setRightComponent(chatSplitPane);
				leftSplitPane.setEnabled(false);
				leftSplitPane.setDividerLocation(WIDTH * 3 / 2);

				gameFrame.add(leftSplitPane);
				gameFrame.setSize(new Dimension(WIDTH * (SCALE + 2), HEIGHT * (SCALE)));
				gameFrame.setResizable(false);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLocationRelativeTo(null);
				gameFrame.setVisible(false);
				gameFrame.setIconImage(imageIcon);

				JFrame usernameFrame = new JFrame("Skribbl.io Clone");
				usernameFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
				usernameFrame.setSize(new Dimension(WIDTH * SCALE / 2, HEIGHT * 5 / 8));
				usernameFrame.setResizable(false);
				usernameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				usernameFrame.setLocationRelativeTo(null);
				usernameFrame.setVisible(true);
				usernameFrame.setIconImage(imageIcon);

				usernameFrame.add(new JLabel("Enter your username:"));

				JTextField usernameField = new JTextField();
				usernameField.setColumns(16);
				usernameFrame.add(usernameField);
				
				PlayerHandler playerHandler = new PlayerHandler();

				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (usernameField.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Your username cannot be an empty string", "Alert", JOptionPane.ERROR_MESSAGE);
						} else {
							playerHandler.addPlayer(usernameField.getText());
							usernameFrame.setVisible(false);
							gameFrame.setVisible(true);
						}
					}
				});
				okButton.setActionCommand("ok");
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						usernameFrame.setVisible(false);
					}
				});
				cancelButton.setActionCommand("cancel");

				usernameFrame.add(okButton);
				usernameFrame.add(cancelButton);
			}
		});
	}
}
