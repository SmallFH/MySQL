package test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test extends JPanel{
	JFrame jf;
	int x= 100;
	int y=200;

	public test() {
		jf = new JFrame("��Ϸ");

		jf.add(this);
		jf.addKeyListener(new MyKey());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(800, 800);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new test();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image im = new ImageIcon("src/images/Side.png").getImage();
		g.drawImage(im, x, y, this);
		repaint();
	}

	class MyKey extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				System.out.println("��");
				x-=5;
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("��");
				x+=5;
				break;
			case KeyEvent.VK_UP:
				System.out.println("��");
				y-=5;
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("��");
				y+=5;
				break;

			}
		}
	}
}

