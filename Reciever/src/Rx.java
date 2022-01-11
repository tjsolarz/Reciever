import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Rx  extends JPanel{
	public String IPAdr = "";
	JTextArea TA1 = new JTextArea("192.168.10.3");
	public Rx() {
		setLayout(null);
		JLabel L1 = new JLabel("USRP IP Address");
		JLabel L2 = new JLabel("Acquisition Duration (sec)");
		JLabel L3 = new JLabel("Rx Parameters");
		JLabel L4 = new JLabel("Actual Rx Parameters");
		JLabel L5 = new JLabel("Rx IQ Sampling Rate");
		JLabel L52 = new JLabel("Rx IQ Sampling Rate");
		JLabel L6 = new JLabel("Rx Frequency");
		JLabel L62 = new JLabel("Rx Frequency");
		JLabel L7 = new JLabel("Rx Gain");
		JLabel L72 = new JLabel("Rx Gain");
		JLabel L8 = new JLabel("Rx Antenna");
		JLabel L82 = new JLabel("Rx Antenna");
		
		L1.setBounds(10, 10, 100, 11);
		L2.setBounds(200, 10, 200, 11);
		L3.setBounds(10, 100, 100, 11);
		L4.setBounds(200, 100, 200, 11);
		L5.setBounds(25,115, 200, 11);
		L6.setBounds(25,150, 200, 11);
		L7.setBounds(25,185, 200, 11);
		L8.setBounds(25,220, 200, 11);
		L52.setBounds(215,115, 200, 11);
		L62.setBounds(215,150, 200, 11);
		L72.setBounds(215,185, 200, 11);
		L82.setBounds(215,220, 200, 11);
		
		
		JTextArea TA2 = new JTextArea("40m");
		JTextArea TA3 = new JTextArea("500k");
		JTextArea TA4 = new JTextArea("500k");
		JTextArea TA5 = new JTextArea("915M");
		JTextArea TA6 = new JTextArea("915M");
		JTextArea TA7 = new JTextArea("20");
		JTextArea TA8 = new JTextArea("20");
		JTextArea TA9 = new JTextArea("RX1");
		JTextArea TA10 = new JTextArea("RX1");
		
		TA1.setBounds(10,25,100,15);
		TA2.setBounds(200,25,100,15);
		TA3.setBounds(25,130,100,15);
		TA4.setBounds(215,130,100,15);
		TA5.setBounds(25,165,100,15);
		TA6.setBounds(215,165,100,15);
		TA7.setBounds(25,200,100,15);
		TA8.setBounds(215,200,100,15);
		TA9.setBounds(25,235,100,15);
		TA10.setBounds(215,235,100,15);
		
		add(L1);
		add(L2);
		add(L3);
		add(L4);
		add(L5);
		add(L6);
		add(L7);
		add(L8);
		add(L52);
		add(L62);
		add(L72);
		add(L82);
		add(TA1);
		add(TA2);
		add(TA3);
		add(TA4);
		add(TA5);
		add(TA6);
		add(TA7);
		add(TA8);
		add(TA9);
		add(TA10);
		
	}
	public String getIP() {
		IPAdr = TA1.getText();
		return IPAdr;
	}
}
