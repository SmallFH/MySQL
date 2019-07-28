package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HaveChangePanel extends JPanel implements ActionListener{
	JFrame jf;
	public HaveChangePanel() {
		jf = new JFrame("一个带有修改的信息面板");
		
		JButton jb = new JButton("修改");
		JPanel jp_up = new JPanel();
		jp_up.setBackground(Color.BLUE);
		
		JPanel jp_down = new JPanel();
		jp_down.setBackground(Color.RED);
		jp_down.setPreferredSize(new Dimension(0,50));
		jp_down.add(jb);
		
		this.setLayout(new BorderLayout());
		this.add(jp_up,BorderLayout.CENTER);
		this.add(jp_down,BorderLayout.SOUTH);
		jf.add(this);
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new HaveChangePanel();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("修改信息啊");
	}
	
}
