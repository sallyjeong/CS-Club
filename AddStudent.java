


//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


class AddStudent extends JFrame {

  AddStudent() {
    //Creating the Frame
    super("Students Enrollment");
    
    //  this.setSize(500, 600);
    this.setVisible(true);
    this.setBounds(0, 0, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setLayout(null);
    this.setResizable(false);
    
    JPanel panel = new JPanel();
    panel.setBounds(15, 15, 370, 97);
    //panel.setBackground(Color.gray);
    //panel.setBorder(BorderFactory.createLineBorder(Color.blue));
    TitledBorder title = BorderFactory.createTitledBorder("Personal Information");
    title.setTitleJustification(TitledBorder.CENTER);
    panel.setBorder(title);
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);
    
    JPanel panel2 = new JPanel();
    panel2.setBounds(15, 130, 370, 125);
    TitledBorder title2 = BorderFactory.createTitledBorder("Friend Preferences");
    title2.setTitleJustification(TitledBorder.CENTER);
    panel2.setBorder(title2);
    SpringLayout layout2 = new SpringLayout();
    panel2.setLayout(layout2);
    
    JPanel panel3 = new JPanel();
    panel3.setBounds(15, 273, 370, 97);
    TitledBorder title3 = BorderFactory.createTitledBorder("Grouping Information");
    title3.setTitleJustification(TitledBorder.CENTER);
    panel3.setBorder(title3);
    SpringLayout layout3 = new SpringLayout();
    panel3.setLayout(layout3);
    
    
    //LABELS ------------------------
    
    //name label
    JLabel nameLabel = new JLabel("Name:");
    // nameLabel.setBounds(30, 50, 90, 20);
    panel.add(nameLabel);
    //this.add(nameLabel);
    
    //student id label
    JLabel idLabel = new JLabel("Student #:");
    // idLabel.setBounds(30, 100, 90, 20);
    panel.add(idLabel);
    //this.add(idLabel);
    
    //friend 1 label
    JLabel friend1Label = new JLabel("Friend 1:");
    // friend1Label.setBounds(30, 150, 90, 20);
    //this.add(friend1Label);
    panel2.add(friend1Label);
    
    //friend 2 label
    JLabel friend2Label = new JLabel("Friend 2:");
    // friend2Label.setBounds(30, 200, 90, 20);
    //this.add(friend2Label);
    panel2.add(friend2Label);
    
    //friend 3 label
    JLabel friend3Label = new JLabel("Friend 3:");
    // friend3Label.setBounds(30, 250, 90, 20);
    //this.add(friend3Label);
    panel2.add(friend3Label);
    
    //group label
    JLabel groupLabel = new JLabel("Group:");
    // groupLabel.setBounds(30, 300, 90, 20);
    //this.add(groupLabel);
    panel3.add(groupLabel);
    
    //grade label
    JLabel gradeLabel = new JLabel("Grade:");
    // gradeLabel.setBounds(30, 350, 90, 20);
    panel3.add(gradeLabel);
    
    //FIELDS ------------------------
    JTextField name = new JTextField(15);
    // name.setBounds(100, 50, 200, 20);
    //this.getContentPane().add(name);
    panel.add(name);
    //name.setColumns(10);
    // store name.getText();
    
    JTextField id = new JTextField(15);
    // id.setBounds(100, 100, 200, 20);
    //this.getContentPane().add(id);
    panel.add(id);
    //id.setColumns(10);
    // store id.getText();
    
    JTextField friend1 = new JTextField(15);
    // friend1.setBounds(100, 150, 200, 20);
    this.getContentPane().add(friend1);
    panel2.add(friend1);
    //friend1.setColumns(10);
    // store friend1.getText();
    
    JTextField friend2 = new JTextField(15);
    // friend2.setBounds(100, 200, 200, 20);
    this.getContentPane().add(friend2);
    panel2.add(friend2);
    //friend2.setColumns(10);
    // store friend2.getText();
    
    JTextField friend3 = new JTextField(15);
    // friend3.setBounds(100, 250, 200, 20);
    this.getContentPane().add(friend3);
    panel2.add(friend3);
    //friend3.setColumns(10);
    // store friend3.getText();
    
    String[] group={"intro","web","contest"};
    JComboBox groupChoices=new JComboBox(group);
    // groupChoices.setBounds(100,300,200,20);
    panel3.add(groupChoices);
    // this.add(groupChoices);
    // this.setLayout(null);
    //  this.setSize(500,500);
    
    this.setVisible(true);
    //  groupChoices.addActionListener(new );
    
    String[] grade={"grade 9","grade 10","grade 11", "grade 12"};
    JComboBox gradeChoices=new JComboBox(grade);
    // gradeChoices.setBounds(100, 350,200,20);
    panel3.add(gradeChoices);
    //this.add(cb2);
    //  this.setLayout(null);
    //   this.setSize(500,500);
    this.setVisible(true);
    gradeChoices.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox options = (JComboBox)e.getSource();
        String chosen = (String)options.getSelectedItem();
        System.out.println(chosen);
      }
    });
    //LAYOUT CONSTRAINTS----------------
    //name
    layout.putConstraint(SpringLayout.WEST, nameLabel, 15, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.NORTH, panel);
    layout.putConstraint(SpringLayout.WEST, name, 5, SpringLayout.EAST, nameLabel);
    layout.putConstraint(SpringLayout.SOUTH, name, 6, SpringLayout.SOUTH, nameLabel);
    
    //id
    layout.putConstraint(SpringLayout.WEST, idLabel, 15, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, idLabel, 12, SpringLayout.SOUTH, nameLabel);
    layout.putConstraint(SpringLayout.WEST, id, 5, SpringLayout.EAST, idLabel);
    layout.putConstraint(SpringLayout.SOUTH, id, 6, SpringLayout.SOUTH, idLabel);
    
    //friend1
    layout2.putConstraint(SpringLayout.WEST, friend1Label, 15, SpringLayout.WEST, panel);
    layout2.putConstraint(SpringLayout.NORTH, friend1Label, 10, SpringLayout.NORTH, panel);
    layout2.putConstraint(SpringLayout.WEST, friend1, 5, SpringLayout.EAST, friend1Label);
    layout2.putConstraint(SpringLayout.SOUTH, friend1, 6, SpringLayout.SOUTH, friend1Label);
    
    //friend2
    layout2.putConstraint(SpringLayout.WEST, friend2Label, 15, SpringLayout.WEST, panel);
    layout2.putConstraint(SpringLayout.NORTH, friend2Label, 12, SpringLayout.SOUTH, friend1Label);
    layout2.putConstraint(SpringLayout.WEST, friend2, 5, SpringLayout.EAST, friend2Label);
    layout2.putConstraint(SpringLayout.SOUTH, friend2, 6, SpringLayout.SOUTH, friend2Label);
    //friend3
    layout2.putConstraint(SpringLayout.WEST, friend3Label, 15, SpringLayout.WEST, panel);
    layout2.putConstraint(SpringLayout.NORTH, friend3Label, 12, SpringLayout.SOUTH, friend2Label);
    layout2.putConstraint(SpringLayout.WEST, friend3, 5, SpringLayout.EAST, friend3Label);
    layout2.putConstraint(SpringLayout.SOUTH, friend3, 6, SpringLayout.SOUTH, friend3Label);
    //group
    layout3.putConstraint(SpringLayout.WEST, groupLabel, 15, SpringLayout.WEST, panel);
    layout3.putConstraint(SpringLayout.NORTH, groupLabel, 10, SpringLayout.NORTH, panel);
    layout3.putConstraint(SpringLayout.WEST, groupChoices, 5, SpringLayout.EAST, groupLabel);
    layout3.putConstraint(SpringLayout.SOUTH, groupChoices, 6, SpringLayout.SOUTH, groupLabel);
    //grade
    layout3.putConstraint(SpringLayout.WEST, gradeLabel, 15, SpringLayout.WEST, panel);
    layout3.putConstraint(SpringLayout.NORTH, gradeLabel, 12, SpringLayout.SOUTH, groupLabel);
    layout3.putConstraint(SpringLayout.WEST, gradeChoices, 5, SpringLayout.EAST, gradeLabel);
    layout3.putConstraint(SpringLayout.SOUTH, gradeChoices, 6, SpringLayout.SOUTH, gradeLabel);
    //SUBMIT BUTTON-----------------
    
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(280, 400, 90, 20);
    btnSubmit.addActionListener(new SubmitButtonListener());
    
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(20, 400, 90, 20);
    btnBack.addActionListener(new BackButtonListener(this));
    
    this.getContentPane().add(btnSubmit);
    this.getContentPane().add(btnBack);
    this.setVisible(true);
    
    this.add(panel);
    this.setSize(400,600);
    this.setVisible(true);
    
    this.add(panel2);
    this.setSize(400,600);
    this.setVisible(true);
    
    this.add(panel3);
    this.setSize(400,600);
    this.setVisible(true);
    
  }
}
class SubmitButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent arg0) {
    JOptionPane.showMessageDialog(null, "Student Added");
  }
}
class BackButtonListener implements ActionListener {
  JFrame frame;
  BackButtonListener(JFrame frame) {
    this.frame = frame;
  }
  
  public void actionPerformed(ActionEvent arg0) {
    new menu2();
    frame.dispose();
  }
}



