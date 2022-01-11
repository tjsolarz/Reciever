import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SpecifyPacket extends JPanel{
	public SpecifyPacket() {
		setLayout(null);
		JButton B1 = new JButton("Guard Band");
		JButton B2 = new JButton("Sync Seq");
		JButton B3 = new JButton("Packet Number");
		JButton B4 = new JButton("Data");
		JButton B5 = new JButton("Pad Data");
		JButton B6 = new JButton("Blank Frame");
		
		B1.setBounds(10, 210, 110, 100);
		B2.setBounds(120, 210, 90, 100);
		B3.setBounds(210, 210, 130, 100);
		B4.setBounds(340, 210, 80, 100);
		B5.setBounds(420, 210, 100, 100);
		B6.setBounds(520, 210, 120, 100);
		
		JLabel L1 = new JLabel("Packet Parameters");
		JLabel L2 = new JLabel("Guard Bits");
		JLabel L3 = new JLabel("Sync Bits");
		JLabel L4 = new JLabel("Message Bits");
		JLabel L5 = new JLabel("Number of Packets to expect");
		JLabel L6 = new JLabel("Symbol Rate (symbols/sec)");
		JLabel L7 = new JLabel("PN sequence order for Sync Bits");
		
		L1.setBounds(10, 10, 120, 11);
		L2.setBounds(12, 25, 120, 11);
		L3.setBounds(102, 25, 100, 11);
		L4.setBounds(202, 25, 100, 11);
		L5.setBounds(502, 25, 170, 11);
		L6.setBounds(400,400, 1000, 11);
		L7.setBounds(50, 400, 1000, 11);
		
		JTextArea TA1 = new JTextArea("30");
		JTextArea TA2 = new JTextArea("20");
		JTextArea TA3 = new JTextArea("128");
		JTextArea TA4 = new JTextArea("46");
		JTextArea TA5 = new JTextArea("31");
		JTextArea TA6 = new JTextArea("62.5k");
		
		TA1.setBounds(12, 38, 50, 15);
		TA2.setBounds(102, 38, 50, 15);
		TA3.setBounds(202, 38, 50, 15);
		TA4.setBounds(502, 38, 50, 15);
		TA5.setBounds(50, 413, 50, 15);
		TA6.setBounds(400, 413, 50, 15);
		
		add(B1);
		add(B2);
		add(B3);
		add(B4);
		add(B5);
		add(B6);
		
		add(L1);
		add(L2);
		add(L3);
		add(L4);
		add(L5);
		add(L6);
		add(L7);
		
		add(TA1);
		add(TA2);
		add(TA3);
		add(TA4);
		add(TA5);
		add(TA6);
	}
}
