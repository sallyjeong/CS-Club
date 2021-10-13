// addding an actual Student object

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
  public static String nameInput;
  public static int idInput;
  public static int gradeInput;
  public static String groupInput;
  public static int friend1Input = -1;
  public static int friend2Input = -1;
  public static int friend3Input = -1;
  public static EnrollmentSystem enrolment;
  public static JTextField name;
  public static JTextField id;
  public static JTextField friend1;
  public static JTextField friend2;
  public static JTextField friend3;
  
  AddStudent(EnrollmentSystem enrolment) {
    //Creating the Frame
    super("Students Enrollment");
    this.enrolment = enrolment;
    
    this.setVisible(true);
    this.setBounds(0, 0, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setLayout(null);
    this.setResizable(false);
    
    JPanel panel = new JPanel();
    panel.setBounds(15, 15, 370, 97);
    TitledBorder title = BorderFactory.createTitledBorder("Personal Information");
    title.setTitleJustification(TitledBorder.CENTER);
    panel.setBorder(title);
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);
    
    JPanel panel2 = new JPanel();
    panel2.setBounds(15, 130, 370, 125);
    TitledBorder title2 = BorderFactory.createTitledBorder("Friend Preferences (Student #)");
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
    panel.add(nameLabel);

    //student id label
    JLabel idLabel = new JLabel("Student #:");
    panel.add(idLabel);
    
    //friend 1 label
    JLabel friend1Label = new JLabel("Friend 1:");
    panel2.add(friend1Label);
    
    //friend 2 label
    JLabel friend2Label = new JLabel("Friend 2:");
    panel2.add(friend2Label);
    
    //friend 3 label
    JLabel friend3Label = new JLabel("Friend 3:");
    panel2.add(friend3Label);
    
    //group label
    JLabel groupLabel = new JLabel("Group:");
    panel3.add(groupLabel);
    
    //grade label
    JLabel gradeLabel = new JLabel("Grade:");
    panel3.add(gradeLabel);
    
    //FIELDS ------------------------
    name = new JTextField(15);
    panel.add(name);

    id = new JTextField(15);
    panel.add(id);
    
    friend1 = new JTextField(15);
    this.getContentPane().add(friend1);
    panel2.add(friend1);
    
    friend2 = new JTextField(15);
    this.getContentPane().add(friend2);
    panel2.add(friend2);
    
    friend3 = new JTextField(15);
    this.getContentPane().add(friend3);
    panel2.add(friend3);
    
    String[] group={"--","intro","web","contest"};
    JComboBox groupChoices=new JComboBox(group);
    panel3.add(groupChoices);
    this.setVisible(true);
    groupChoices.addActionListener(new GroupChoiceListener());
    
    String[] grade={"--","grade 9","grade 10","grade 11", "grade 12"};
    JComboBox gradeChoices=new JComboBox(grade);
    panel3.add(gradeChoices);
    this.setVisible(true);
    gradeChoices.addActionListener(new GradeChoiceListener());
  
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
  public static boolean verifyStudentNum(String id) {
    if (id.length() == 9) {
      try {
        int num = Integer.parseInt(id);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please Enter a Valid Student #");
        return false;
    }
    return true;
    }
    return false;
  }
}

class SubmitButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent arg0) {
    EnrollmentSystem enrollment = AddStudent.enrolment;
    // gather student info
    AddStudent.nameInput = AddStudent.name.getText();
    if (AddStudent.verifyStudentNum(AddStudent.id.getText())) {
      AddStudent.idInput = Integer.parseInt(AddStudent.id.getText());
    }
    if (AddStudent.verifyStudentNum(AddStudent.friend1.getText())) {
      AddStudent.friend1Input = Integer.parseInt(AddStudent.friend1.getText());
    }
    if (AddStudent.verifyStudentNum(AddStudent.friend2.getText())) {
      AddStudent.friend2Input = Integer.parseInt(AddStudent.friend2.getText());
    }
    if (AddStudent.verifyStudentNum(AddStudent.friend3.getText())) {
      AddStudent.friend3Input = Integer.parseInt(AddStudent.friend3.getText());
    }

    // System.out.println("Name: " + AddStudent.nameInput);
    // System.out.println("ID: " + AddStudent.idInput);
    // System.out.println("Friend 1: " + AddStudent.friend1Input);
    // System.out.println("Friend 2: " + AddStudent.friend2Input);
    // System.out.println("Friend 3: " + AddStudent.friend3Input);

    enrollment.addStudent(new Student(AddStudent.nameInput, AddStudent.idInput, AddStudent.gradeInput, AddStudent.groupInput,
    AddStudent.friend1Input, AddStudent.friend2Input, AddStudent.friend3Input));
     
    JOptionPane.showMessageDialog(null, "Student Added");
      // show the student info

     // JOptionPane.showMessageDialog(null, "Please Try Again");
    
    // resetting variables
  AddStudent.nameInput = "";
  AddStudent.idInput = 0;
  AddStudent.friend1Input = -1;
  AddStudent.friend2Input = -1;
  AddStudent.friend3Input = -1;
  }
  }

class BackButtonListener implements ActionListener {
  JFrame frame;
  BackButtonListener(JFrame frame) {
    this.frame = frame;
  }
  
  public void actionPerformed(ActionEvent arg0) {
    new Menu(AddStudent.enrolment);
    frame.dispose();
  }
}

class GradeChoiceListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JComboBox options = (JComboBox)e.getSource();
    String chosen = (String)options.getSelectedItem();
    int gradeNum = 0;
    if (chosen.equals("grade 9")) {
      gradeNum = 9;
    } else if (chosen.equals("grade 10")) {
      gradeNum = 10;
    } else if (chosen.equals("grade 11")) {
      gradeNum = 11;
    } else if (chosen.equals("grade 12")) {
      gradeNum = 12;
    }
    AddStudent.gradeInput = gradeNum;
    System.out.println("Grade: " + gradeNum);
  }
}

class GroupChoiceListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JComboBox options = (JComboBox)e.getSource();
    String chosen = (String)options.getSelectedItem();
    AddStudent.groupInput = chosen;
    System.out.println("Group: " + chosen);
  }
}



