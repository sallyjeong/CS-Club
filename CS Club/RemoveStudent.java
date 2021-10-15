// *** imports *** //
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 * RemoveStudent.java
 * A page that allows the user to remove a student
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class RemoveStudent extends JFrame {

    public static JTextField studentID;
    public static int studentIDInput;

    public static EnrollmentSystem enrolment;

  /**
   * RemoveStudent
   * This constructor adds all visible components to the JFrame upon instantiating the object
   * @param enrolment The EnrollmentSystem that contains a masterlist of students
   */
    RemoveStudent(EnrollmentSystem enrolment) {
        // *** setting up the frame *** //
        super("Remove Student");
        this.enrolment = enrolment;
        this.setVisible(true);
        this.setBounds(0, 0, 400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setResizable(false);

        // *** setting up the panels *** //
        JPanel panel = new JPanel();
        panel.setBounds(15, 15, 370, 100);
        TitledBorder title = BorderFactory.createTitledBorder("Remove Student");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        // *** Labels *** //
        //name 
        JLabel studentNumLabel = new JLabel("Student #:");
        panel.add(studentNumLabel);

        // *** Text Field *** //
        //name 
        studentID = new JTextField(15);
        panel.add(studentID);

        // *** Layout Constraints *** //
        layout.putConstraint(SpringLayout.WEST, studentNumLabel, 15, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, studentNumLabel, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, studentID, 5, SpringLayout.EAST, studentNumLabel);
        layout.putConstraint(SpringLayout.NORTH, studentID, 21, SpringLayout.NORTH, panel);

        // *** Buttons *** //
        //submit 
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(280, 130, 90, 20);
        btnSubmit.addActionListener(new RemoveSubmitButtonListener());
        
        //back 
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(20, 130, 90, 20);
        btnBack.addActionListener(new BackButtonListener(this));

        this.getContentPane().add(btnSubmit);
        this.getContentPane().add(btnBack);
        this.setVisible(true);

        this.add(panel);
        this.setSize(400,210);

    }

  /**
   * verifyStudentNum
   * This method checks if the user input for student numbers was valid
   * @param id The inputted ID from the user
   * @return true if the student number is default or 9 digits long, false otherwise
   */
    public static boolean verifyStudentNum(String id) {
        if (id.length() == 9) {
            try {
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Enter a Valid Student #");
                return false;
            }
            return true;
        }
        return false;
    }
}

/**
 * RemoveSubmitButtonListener.java
 * Confirms valid input, removes Student from masterlist, resets input fields
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class RemoveSubmitButtonListener implements ActionListener {
  /**
   * actionPerformed
   * This method remove a Student object based on user input
   * @param e is the button click
   */
    public void actionPerformed(ActionEvent e) {
        if (RemoveStudent.verifyStudentNum(RemoveStudent.studentID.getText())) {
            RemoveStudent.studentIDInput = Integer.parseInt(RemoveStudent.studentID.getText());
        }

        if (RemoveStudent.enrolment.removeStudent(RemoveStudent.studentIDInput)){
            JOptionPane.showMessageDialog(null, "Student Removed");
        }else{
            JOptionPane.showMessageDialog(null, "Student Not Found in the Database");
        }
        RemoveStudent.studentID.setText("");
    }
}



