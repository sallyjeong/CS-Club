
// imports
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 * AddStudent.java
 * A page that takes user input and creates a Student based on input
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class AddStudent extends JFrame {

  /**
   * variables
   */
  public static EnrollmentSystem enrolment;

  // final input for Student object
  public static String nameInput;
  public static int idInput;
  public static int gradeInput;
  public static String groupInput;
  public static int friend1Input = -1;
  public static int friend2Input = -1;
  public static int friend3Input = -1;

  // user input on the screen
  public static JTextField name;
  public static JTextField id;
  public static JTextField friend1;
  public static JTextField friend2;
  public static JTextField friend3;
  public static JComboBox<String> groupChoices;
  public static JComboBox<String> gradeChoices;
  public static String gradeChosen;
  public static String groupChosen;

  /**
   * AddStudent
   * This constructor adds all visible components to the JFrame upon instantiating the object
   * @param enrolment The EnrollmentSystem that contains a masterlist of students
   */
  AddStudent(EnrollmentSystem enrolment) {
    // *** setting up the frame *** //
    super("Students Enrollment");
    this.enrolment = enrolment;
    this.setBounds(0, 0, 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setLayout(null);
    this.setResizable(false);

    // *** setting up the panels *** //
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

    // *** labels *** //
    JLabel nameLabel = new JLabel("Name:");
    panel.add(nameLabel);

    JLabel idLabel = new JLabel("Student #:");
    panel.add(idLabel);

    JLabel friend1Label = new JLabel("Friend 1:");
    panel2.add(friend1Label);

    JLabel friend2Label = new JLabel("Friend 2:");
    panel2.add(friend2Label);

    JLabel friend3Label = new JLabel("Friend 3:");
    panel2.add(friend3Label);

    JLabel groupLabel = new JLabel("Group:");
    panel3.add(groupLabel);

    JLabel gradeLabel = new JLabel("Grade:");
    panel3.add(gradeLabel);

    // *** text fields *** //
    name = new JTextField(15);
    panel.add(name);

    id = new JTextField(15);
    panel.add(id);

    friend1 = new JTextField(15);
    panel2.add(friend1);

    friend2 = new JTextField(15);
    panel2.add(friend2);

    friend3 = new JTextField(15);
    panel2.add(friend3);

    // *** combo boxes *** //
    String[] group={"--","intro","web","contest"};
    groupChoices=new JComboBox<>(group);
    panel3.add(groupChoices);
    groupChoices.addActionListener(new GroupChoiceListener());

    String[] grade={"--","grade 9","grade 10","grade 11", "grade 12"};
    gradeChoices=new JComboBox<>(grade);
    panel3.add(gradeChoices);
    gradeChoices.addActionListener(new GradeChoiceListener());

    // *** buttons *** //
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(280, 400, 90, 20);
    this.getContentPane().add(btnSubmit);
    btnSubmit.addActionListener(new SubmitButtonListener());

    JButton btnBack = new JButton("Back");
    btnBack.setBounds(20, 400, 90, 20);
    this.getContentPane().add(btnBack);
    btnBack.addActionListener(new BackButtonListener(this));


    // *** layout constraints *** //
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

    this.add(panel);
    this.add(panel2);
    this.add(panel3);
    this.setSize(400,500);
    this.setVisible(true);
  }

  /**
   * verifyStudentNum
   * This method checks if the user input for student numbers was valid
   * @param id The inputted ID from the user
   * @return true if the student number is default or 9 digits long, false otherwise
   */
  public static boolean verifyStudentNum(String id) {
    // default case (provided by changeEmpty method)
    if (id.equals("-1")) {
      return true;
    }
    // checking if the input is a number
    try {
      int num = Integer.parseInt(id);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Student # Invalid");
      return false;
    }
    // confirming the number is 9 digits long
    if (id.length() == 9) {
      return true;
    }
    JOptionPane.showMessageDialog(null, "Student # Invalid");
    return false;
  }

  /**
   * changeEmpty
   * This method changes empty string inputs (for student number) into "-1" for easier back-end management
   * @param id The inputted ID from the user
   * @return "-1" if the string is empty, the string to be checked if not empty
   */
  public static String changeEmpty(String id) {
    if (id.isEmpty()) {
      return "-1";
    }
    return id;
  }
  
  /**
   * studentExists
   * This method checks if a student already exists in the system
   * @param id The inputted ID from the user
   * @return true if the Student with the same student number already exists, false otherwise
   */
  public static boolean studentExists(String id) {
    for (int i = 0; i<enrolment.getStudentList().size(); i++){
      if (id.equals(enrolment.getStudentList().get(i).getId() + "")) {
        JOptionPane.showMessageDialog(null, "Student Already Exists (duplicate student #)");
        return true;
      }
    }
    return false;
  }

  /**
   * verifyComboChoice
   * This method checks if the user selected an invalid input 
   * @param choice the dropdown option selected
   * @return false if the option is empty, true otherwise
   */
  public static boolean verifyComboChoice(String choice) {
    if (choice == null || choice.equals("--")) {
      JOptionPane.showMessageDialog(null, "Please select a grade and group");
      return false;
    }
    return true;
  }
}

/**
 * SubmitButtonListener.java
 * Confirms valid input, creates and adds Student to masterlist, resets input fields
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class SubmitButtonListener implements ActionListener {

  /**
   * actionPerformed
   * This method adds a Student object based on user input
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    EnrollmentSystem enrollment = AddStudent.enrolment;

    String friend1Text = AddStudent.changeEmpty(AddStudent.friend1.getText());
    String friend2Text = AddStudent.changeEmpty(AddStudent.friend2.getText());
    String friend3Text = AddStudent.changeEmpty(AddStudent.friend3.getText());

    // *** gathering student info *** //
    AddStudent.nameInput = AddStudent.name.getText();
    if ((AddStudent.verifyStudentNum(AddStudent.id.getText())) && (!AddStudent.studentExists(AddStudent.id.getText())) && AddStudent.verifyStudentNum(friend1Text)
            && AddStudent.verifyStudentNum(friend2Text) && AddStudent.verifyStudentNum(friend3Text)
            && AddStudent.verifyComboChoice(AddStudent.gradeChosen) && AddStudent.verifyComboChoice(AddStudent.groupChosen)) {

      AddStudent.idInput = Integer.parseInt(AddStudent.id.getText());
      AddStudent.friend1Input = Integer.parseInt(friend1Text);
      AddStudent.friend2Input = Integer.parseInt(friend2Text);
      AddStudent.friend3Input = Integer.parseInt(friend3Text);
      AddStudent.gradeInput = Integer.parseInt(AddStudent.gradeChosen);
      AddStudent.groupInput = AddStudent.groupChosen;

      // adding student
      if (enrollment.addStudent(new Student(AddStudent.nameInput, AddStudent.idInput, AddStudent.gradeInput,
              AddStudent.groupInput, AddStudent.friend1Input,
              AddStudent.friend2Input, AddStudent.friend3Input))) {

        // if friend inputs are -1, make the number empty
        if (AddStudent.friend1Input == -1) {
          AddStudent.friend1Input = 0;
        }
        if (AddStudent.friend2Input == -1) {
          AddStudent.friend2Input = 0;
        }
        if (AddStudent.friend3Input == -1) {
          AddStudent.friend3Input = 0;
        }

        // confirmation message
        JOptionPane.showMessageDialog(null, "Student Added\n\tName: " + AddStudent.nameInput + "\n\tID: " + AddStudent.idInput
                + "\n\tFriend 1: " + AddStudent.friend1Input + "\n\tFriend 2: " + AddStudent.friend2Input
                + "\n\tFriend 3: " + AddStudent.friend3Input + "\n\tGroup: " + AddStudent.groupInput
                + "\n\tGroup: " + AddStudent.gradeInput);

        // resetting input fields
        AddStudent.name.setText("");
        AddStudent.id.setText("");
        AddStudent.friend1.setText("");
        AddStudent.friend2.setText("");
        AddStudent.friend3.setText("");
        AddStudent.groupChoices.setSelectedItem("--");
        AddStudent.gradeChoices.setSelectedItem("--");
      }
    }

    // resetting variables
    AddStudent.nameInput = "";
    AddStudent.idInput = 0;
    AddStudent.friend1Input = -1;
    AddStudent.friend2Input = -1;
    AddStudent.friend3Input = -1;
  }
}

/**
 * BackButtonListener.java
 * Closes the current frame and returns to the Menu page
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class BackButtonListener implements ActionListener {
  JFrame frame;

  /**
   * BackButtonListener
   * This constructor ensures the back button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  BackButtonListener(JFrame frame) {
    this.frame = frame;
  }
  /**
   * actionPerformed
   * This method closes the current frame and opens the menu page
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    new Menu();
    frame.dispose();
  }
}

/**
 * GradeChoiceListener.java
 * Gathers the user choice for grade
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class GradeChoiceListener implements ActionListener {
  /**
   * actionPerformed
   * This method saves the grade chosen by the user
   * @param e is action of selecting a dropdown item
   */
  public void actionPerformed(ActionEvent e) {
    JComboBox options = (JComboBox)e.getSource();
    AddStudent.gradeChosen = (String)options.getSelectedItem();

    // converting dropdown item into an integer variable
    if (AddStudent.gradeChosen.equals("grade 9")) {
      AddStudent.gradeChosen = "9";
    } else if (AddStudent.gradeChosen.equals("grade 10")) {
      AddStudent.gradeChosen = "10";
    } else if (AddStudent.gradeChosen.equals("grade 11")) {
      AddStudent.gradeChosen = "11";
    } else if (AddStudent.gradeChosen.equals("grade 12")) {
      AddStudent.gradeChosen = "12";
    }
  }
}

/**
 * GradeChoiceListener.java
 * Gathers the user choice for group
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class GroupChoiceListener implements ActionListener {
  /**
   * actionPerformed
   * This method saves the group chosen by the user
   * @param e is action of selecting a dropdown item
   */
  public void actionPerformed(ActionEvent e) {
    JComboBox options = (JComboBox)e.getSource();
    AddStudent.groupChosen = (String)options.getSelectedItem();
  }
}




