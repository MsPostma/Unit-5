package com.example;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main{

	public static void main(String[] args) {
		JFrame jfrm = new JFrame("Image test");
		jfrm.setSize(200 ,200);
        jfrm.setLayout(new GridLayout(2,1,5,5));
        
            
        ImageIcon originalImage = new ImageIcon(Main.class.getResource("/Dog.png"));
        Image resizedImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel picLabel = new JLabel(resizedIcon);
        jfrm.add(picLabel);

        //ImageIcon image2 = new ImageIcon("Start.png");
        ImageIcon originalImage2 = new ImageIcon(Main.class.getResource("/Start.png"));
        ImageIcon resizedIcon2 = scaleImageIcon(originalImage2, 0.25); // 25% scaling

        JButton button1 = new JButton(resizedIcon2); 
        
        button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("The button 1 was clicked!");
                }		
            });
		jfrm.add(button1);

		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
	}

     /**
     * Scales an ImageIcon by a given percentage.
     *
     * @param icon The original ImageIcon to scale.
     * @param scale The scaling factor (e.g., 0.5 for 50%, 1.0 for 100%).
     * @return A new ImageIcon with the scaled image.
     */
    private static ImageIcon scaleImageIcon(ImageIcon icon, double scale) {
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();

        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);

        Image scaledImage = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}