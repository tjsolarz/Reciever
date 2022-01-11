import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Debug  extends JPanel{
	JTextArea DebugDisplay = new JTextArea();
	
	public Debug() {
		setLayout(null);
		DebugDisplay.setBounds(10,10,300,300);
		add(DebugDisplay);
	}
	
	public void sendDM(String DM) {
		DebugDisplay.setText(DebugDisplay.getText() + "\n" + DM);
	}
}
