//////////////////////
// Edits: lined up input, added labels, 
// commented out code that didn't seem to do anything
//////////////////////
// Errors: sometimes it doesn't all show up
// (need to click the area first then it'll be displayed)
//////////////////////
// Tried: added a panel succesfully but only the JLabels would
// be displayed after panel.add(label) was called (can't add the 
// combo box and submit button to the panel unless you have a layout)
//////////////////////


//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

class GUI {
  public static void main(String args[]) {
    //Creating the Frame
    JFrame frame = new JFrame("Students Enrollment");  

  //  frame.setSize(500, 600);
    frame.setVisible(true);
    frame.setBounds(0, 0, 400, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JPanel panel = new JPanel();  
    panel.setBounds(15, 15, 370, 65);    
    //panel.setBackground(Color.gray);  
    panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    panel.setLayout(new GridBagLayout());
    GridBagConstraints alignment = new GridBagConstraints();
    panel.setBorder(BorderFactory.createTitledBorder("title"));


    // JPanel panel2 = new JPanel();  
    // panel2.setBounds(15, 15, 370, 65);    
    // //panel.setBackground(Color.gray);  
    // panel2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    // panel2.setLayout(new GridBagLayout());

    //name label  
    JLabel nameLabel = new JLabel("name:");
    nameLabel.setBounds(30, 50, 90, 20);
    panel.add(nameLabel,alignment);
    //frame.add(nameLabel);
    
    //student id label 
    JLabel idLabel = new JLabel("student #:");
    idLabel.setBounds(30, 100, 90, 20);
    //panel.add(idLabel,alignment);
    frame.add(idLabel);
    
    //friend 1 label  
    JLabel friend1Label = new JLabel("friend 1:");
    friend1Label.setBounds(30, 150, 90, 20);
    frame.add(friend1Label);
    
    //friend 2 label 
    JLabel friend2Label = new JLabel("friend 2:");
    friend2Label.setBounds(30, 200, 90, 20);
    frame.add(friend2Label);
    
    //friend 3 label  
    JLabel friend3Label = new JLabel("friend 3:");
    friend3Label.setBounds(30, 250, 90, 20);
    frame.add(friend3Label);
    
    //group label 
    JLabel groupLabel = new JLabel("group:");
    groupLabel.setBounds(30, 300, 90, 20);
    frame.add(groupLabel);
    
    //grade label
    JLabel gradeLabel = new JLabel("grade:");
    gradeLabel.setBounds(30, 350, 90, 20);
    frame.add(gradeLabel);
    
    JTextField name = new JTextField();
    name.setBounds(100, 50, 200, 20);
    //frame.getContentPane().add(name);
    panel.add(name, alignment);
    name.setColumns(10);
    // store name.getText();
    
    JTextField id = new JTextField();
    id.setBounds(100, 100, 200, 20);
    frame.getContentPane().add(id);
    //panel.add(id,alignment);
    id.setColumns(10);
    // store id.getText();
    
    JTextField friend1 = new JTextField();
    friend1.setBounds(100, 150, 200, 20);
    frame.getContentPane().add(friend1);
    friend1.setColumns(10);
    // store friend1.getText();
    
    JTextField friend2 = new JTextField();
    friend2.setBounds(100, 200, 200, 20);
    frame.getContentPane().add(friend2);
    friend2.setColumns(10);
    // store friend2.getText();
    
    JTextField friend3 = new JTextField();
    friend3.setBounds(100, 250, 200, 20);
    frame.getContentPane().add(friend3);
    friend3.setColumns(10);
    // store friend3.getText();
    
    String group[]={"web development","game development","competitive"};
    JComboBox cb1=new JComboBox(group);
    cb1.setBounds(100,300,200,20);
    frame.add(cb1);
   // frame.setLayout(null);
  //  frame.setSize(500,500);

  frame.add(panel);  
  frame.setSize(400,600);    
  frame.setLayout(null);    
  frame.setVisible(true);

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
    cb2.setBounds(100, 350,200,20);
    frame.add(cb2);
  //  frame.setLayout(null);
 //   frame.setSize(500,500);
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
    btnSubmit.setBounds(100, 400, 90, 20);
    frame.getContentPane().add(btnSubmit);
    frame.setVisible(true);
  }
}


