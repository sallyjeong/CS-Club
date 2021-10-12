import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

class menu {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Menu"); 
        frame.setVisible(true);
        frame.setBounds(0, 0, 400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();  
        panel.setBounds(15, 15, 370, 300); 
        TitledBorder title = BorderFactory.createTitledBorder("Menu");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        // add student, remove student, display floor plan, ??

        JButton b1 = new JButton("Add Student");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(b1);

        JButton b2 = new JButton("Remove Student");
        b2.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(b2);

        JButton b3 = new JButton("Display Floor Plan");
        b3.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(b3);

        JButton b4 = new JButton("Display Students");
        b4.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(b4);

        JButton b5 = new JButton("Quit");
        b4.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(b5);

        //b1 layout
        layout.putConstraint(SpringLayout.WEST, b1, 115, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, b1, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, b2, 105, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, b2, 20, SpringLayout.SOUTH, b1);
        layout.putConstraint(SpringLayout.WEST, b4, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, b4, 20, SpringLayout.SOUTH, b2);
        layout.putConstraint(SpringLayout.WEST, b3, 97, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, b3, 20, SpringLayout.SOUTH, b4);
        layout.putConstraint(SpringLayout.WEST, b5, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, b5, 50, SpringLayout.SOUTH, b3);
        
        

        frame.add(panel);  
        frame.setSize(400,600);       
        frame.setVisible(true);

    }
  static void 
}