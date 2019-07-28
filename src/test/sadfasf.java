package test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class sadfasf extends JFrame{
        int x=88,y=88;
        JButton bt = new JButton("move me");
        JTextField tf = new JTextField(50);
        public sadfasf(String s) {
            super(s);
            setLayout(null);
            setBounds(100, 100, 300, 300);
            bt.setBounds(30, 30, 80, 20);
            bt.addKeyListener(new Mykey());
            tf.setBounds(60, 200, 170, 20);
            add(bt);
            add(tf);
            setVisible(true);
            setResizable(false);
            System.out.println(54);
        }
        public static void main(String[] args){
        	sadfasf frm = new sadfasf("keyboard event");
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    class Mykey extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            JButton but = (JButton)e.getSource();
            x = but.getLocation().x;
            y = but.getLocation().y;
            if(e.getKeyCode() == KeyEvent.VK_UP){
                y =y- 2;
                if(y<=0) y=0;
                System.out.println("ио");
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                y =y+ 2;
                if(y>=240) y=240;
                System.out.println("об");
            }
            else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                x =x -2;
                if(x<=0) x=0;
                System.out.println("вС");
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                x =x+ 2;
                if(x>=200) x=200;
                System.out.println("ср");
            }
            but.setLocation(x,y);
        }
        public void keyReleased(KeyEvent e){
            String str = "location:"+x+","+y;
            System.out.println(x);
            tf.setText(str);
        }
    }
	
}
