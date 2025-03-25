package com.example;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Main {
    static JCheckBox box;
    static JList list;
    static JTextField text;
    static JComboBox list2;

    public static void main(String[] args) {
        JFrame jfrm = new JFrame("More Components");
	    jfrm.setSize(400 ,300);
	    jfrm.setLayout(new FlowLayout());

        //creating components
        box = new JCheckBox("Done?");
        box.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if(box.isSelected()){
                    System.out.println("The box was selected!");
                }
                else{
                    System.out.println("The box was unselected!");      
                }           
            }
        });
        

        DefaultListModel model = new DefaultListModel();
        list = new JList(model);
        model.addElement("1");
        model.addElement("2");
        model.addElement("3");
        model.addElement("4");

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
            if (!arg0.getValueIsAdjusting()) {
                System.out.println(list.getSelectedValue());
             }
            }
        });


        text = new JTextField();
	    text.setPreferredSize(new Dimension(100,100));
        text.setText("hello!!");

        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              System.out.println(text.getText());
            }
          });

        String[] answers = {"level","a","b","c","d"};
        list2 = new JComboBox(answers);

        JComboBox list2 = new JComboBox(answers);
        list2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              System.out.println(list2.getSelectedItem());
            }
         });

        //adding components to the frame
        jfrm.add(box);
        jfrm.add(list);
        jfrm.add(text);
        jfrm.add(list2);
	
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jfrm.setVisible(true);

    }

  
}