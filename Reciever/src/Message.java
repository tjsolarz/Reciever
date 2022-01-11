import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Message extends JPanel {
	private JTextArea MArea = new JTextArea();
	public Message() {
		setLayout(null);
		JLabel MText = new JLabel("Message Text");
		MText.setBounds(10, 10, 100, 100);
		add(MText);
		
		MArea.setBounds(100, 50, 200, 200);
		add(MArea);
	}
	public void sendM(String Message) {
		MArea.setText(MArea.getText() + Message);
	}
}
