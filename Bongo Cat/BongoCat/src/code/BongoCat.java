package code;
import java.awt.*;

import javax.swing.*;

/**
 * Osu! Bongo Cat :3
 * @author LsXxP
 *
 */
public class BongoCat extends JPanel{
	public Image p;
	static Dimension size = new Dimension(466,313);
	private String active = "idle";
	
	private JLabel l;
	private JFrame j;
	
	public BongoCat() {
		setPreferredSize(size);
		setBackground(Color.cyan);
		start();
	}
	
	public void start() {
		
		j = new JFrame("Osu! Bongo Cat");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(size);
        j.setVisible(true);
        j.getContentPane().setLayout(null);;
        
        
        JLabel lblNewLabel = new JLabel();
        l = lblNewLabel;
        l.setBounds(0, 0, 452, 276);
        l.setIcon(new ImageIcon(BongoCat.class.getResource("/images/BongoCatNone.jpg")));
        j.getContentPane().add(l);
        j.repaint();
        
        
        update();
	}

	public void setActive(String s) {
		active = s;
		System.out.println(s);
		System.out.println(getActive());
	}
	
	public String getActive() {
		return active;
	}
	
	
	public void update() {
		String a = getActive();
		
		System.out.print("Testing " + a);
		
		if(a.equals("x")) {
			l.setIcon(new ImageIcon(BongoCat.class.getResource("/images/BongoCatLeft3.jpg")));
		}else if(a.equals("z")){
			l.setIcon(new ImageIcon(BongoCat.class.getResource("/images/BongoCatRight3.jpg")));
		}else if(a.equals("xHold")) {
			l.setIcon(new ImageIcon(BongoCat.class.getResource("/images/BongoCatLeft2.jpg")));
		}else if(a.equals("zHold")) {
			l.setIcon(new ImageIcon(BongoCat.class.getResource("/images/BongoCatRight2.jpg")));
		}else {
			l.setIcon(new ImageIcon(BongoCat.class.getResource("/images/BongoCatNone.jpg")));
		}
		
		j.getContentPane().add(l);
        j.repaint();
        System.out.print("Repainted");
	}
}


