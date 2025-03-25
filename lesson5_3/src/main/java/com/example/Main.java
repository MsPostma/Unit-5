package com.example;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main{

	public static void main(String[] args) {
		JFrame jfrm = new JFrame("More Components");
		jfrm.setSize(400 ,300);
		jfrm.setLayout(new FlowLayout());

        JCheckBox box = new JCheckBox("Done?");

        DefaultListModel model = new DefaultListModel();
	    JList list = new JList(model);
	    model.addElement("1");
        model.addElement("2");
        model.addElement("3");
        model.addElement("4");

        JTextField text = new JTextField();
	    text.setPreferredSize(new Dimension(100,200));
        text.setText("hello!!");

        String[] answers = {"a","b","c","d"};
        JComboBox list2 = new JComboBox(answers);
        list2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              System.out.println(list2.getSelectedItem());
            }
         });


        jfrm.add(box);
        jfrm.add(list);
        jfrm.add(text);
        jfrm.add(list2);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
	}
}