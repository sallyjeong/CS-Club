
//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GUI {
  public static void main(String args[]) {
    //Creating the Frame
    JFrame frame = new JFrame("Chat Frame");
    frame.setSize(400, 400);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JTextField textField1 = new JTextField();
    textField1.setBounds(204, 64, 167, 20);
    frame.getContentPane().add(textField1);
    textField1.setColumns(10);
    
    JTextField textField2 = new JTextField();
    textField2.setBounds(400, 100, 167, 20);
    frame.getContentPane().add(textField2);
    textField2.setColumns(10);
    
    JTextField textField3 = new JTextField();
    textField3.setBounds(400, 100, 167, 20);
    frame.getContentPane().add(textField3);
    textField3.setColumns(10);
    
    JTextField textField4 = new JTextField();
    textField4.setBounds(400, 100, 167, 20);
    frame.getContentPane().add(textField4);
    textField4.setColumns(10);
    
    JTextField textField5 = new JTextField();
    textField5.setBounds(400, 100, 167, 20);
    frame.getContentPane().add(textField5);
    textField5.setColumns(10);
    
    String group[]={"web development","game development","competitive"};
    JComboBox cb1=new JComboBox(group);
    cb1.setBounds(50, 50,90,20);
    frame.add(cb1);
    frame.setLayout(null);
    frame.setSize(500,500);
    frame.setVisible(true);
    cb1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox options = (JComboBox)e.getSource();
        String chosen = (String)options.getSelectedItem();
        System.out.println(chosen);
      }
    });
    
    String grade[]={"grade 9","grade 10","grade 11", "grade 12"};
    JComboBox cb2=new JComboBox(grade);
    cb2.setBounds(100, 200,90,20);
    frame.add(cb2);
    frame.setLayout(null);
    frame.setSize(500,500);
    frame.setVisible(true);
    cb2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox options = (JComboBox)e.getSource();
        String chosen = (String)options.getSelectedItem();
        System.out.println(chosen);
      }
    });
    
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        JOptionPane.showMessageDialog(null, "Data Submitted");
      }
    });
    btnSubmit.setBounds(93, 121, 89, 23);
    frame.getContentPane().add(btnSubmit);
  }
}


