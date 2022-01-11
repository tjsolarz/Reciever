import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisImg extends JPanel{
	public DisImg(){
		BufferedImage img = null;
		try {
		img=ImageIO.read(new File("D:\\Dropbox\\Pics\\bb2f5q8laqt11.jpg"));
		}catch (IOException e) {
	          e.printStackTrace();
	      }
		ImageIcon icon=new ImageIcon(img);
   
		setLayout(new FlowLayout());
		setSize(200,300);
		JLabel lbl=new JLabel();
			
        lbl.setIcon(icon);
        add(lbl);
	}
}
