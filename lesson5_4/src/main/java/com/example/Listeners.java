package com.example;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Listeners {
	public static void main(String[] args) {
		JFrame jfrm = new JFrame("Mouse Test");
		jfrm.setSize(300 ,300);
		jfrm.setLayout(new FlowLayout());
		
        jfrm.addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent me) { 
                System.out.println("Clicked: "+ me.getX()); 
            } 
            public void mouseEntered(MouseEvent e) {
                System.out.println("Entered");
            }
            public void mouseExited(MouseEvent e){
                System.out.println("Left");
            }
        });
        

        jfrm.addMouseMotionListener(new MouseAdapter() { 
            public void mouseDragged(MouseEvent me) { 
              System.out.println("Dragged: " + me.getX()); 
            } 
            public void mouseMoved(MouseEvent me) {
              System.out.println("Moved: " + me.getX());
            }
        
        }); 


        jfrm.addKeyListener(new KeyListener() { 
            public void keyPressed(KeyEvent e) {
              int key = e.getKeyCode();
              System.out.println("Char: " +e.getKeyChar());
              System.out.println("Key: " +key);
              System.out.println();
            }
            public void keyReleased(KeyEvent e) {
           
            }
            public void keyTyped(KeyEvent e) {
           
            }
        });
    
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
	}
}