import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Modulation  extends JPanel{
	public Modulation() {
		setLayout(null);
		JLabel L1 = new JLabel("QPSK System Parameters");
		JLabel L2 = new JLabel("Samples per Symbol");
		JLabel L3 = new JLabel("Differential PSK");
		JLabel L4 = new JLabel("PSK Type");
		JLabel L5 = new JLabel("Matching Filter Parameters");
		JLabel L6 = new JLabel("TX Filter");
		JLabel L7 = new JLabel("Alpha");
		JLabel L8 = new JLabel("Filter Length");
		
		L1.setBounds(10, 10, 200, 11);
		L2.setBounds(25, 25, 150, 11);
		L3.setBounds(175, 25, 200, 11);
		L4.setBounds(25, 75, 200, 11);
		
		L5.setBounds(340, 10, 200, 11);
		L6.setBounds(355, 25, 200, 11);
		L7.setBounds(355, 75, 200, 11);
		L8.setBounds(355, 125, 200, 11);
		
		
		JTextArea TA1 = new JTextArea("8");
		JTextArea TA2 = new JTextArea("disable");
		JTextArea TA3 = new JTextArea("normal");
		JTextArea TA4 = new JTextArea("Root Raised Cos");
		JTextArea TA5 = new JTextArea("0.50");
		JTextArea TA6 = new JTextArea("6");
		
		TA1.setBounds(25, 40, 100, 15);
		TA2.setBounds(175, 40, 100, 15);
		TA3.setBounds(25, 90, 100, 15);
		TA4.setBounds(355, 40, 100, 15);
		TA5.setBounds(355, 90, 100, 15);
		TA6.setBounds(355, 140, 100, 15);
		
		add(L1);
		add(L2);
		add(L3);
		add(L4);
		add(L5);
		add(L6);
		add(L7);
		add(L8);
		
		add(TA1);
		add(TA2);
		add(TA3);
		add(TA4);
		add(TA5);
		add(TA6);
	}
}
