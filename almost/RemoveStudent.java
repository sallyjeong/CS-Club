
//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;


public class RemoveStudent extends JFrame {

    public static JTextField studentID;
    public static int studentIDInput;

    public static EnrollmentSystem enrolment;
    RemoveStudent(EnrollmentSystem enrolment) {

        super("Remove Student");
        this.enrolment = enrolment;

        this.setVisible(true);
        this.setBounds(0, 0, 400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(15, 15, 370, 100);
        TitledBorder title = BorderFactory.createTitledBorder("Remove Student");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        //LABELS ------------------------

        //name label
        JLabel studentNumLabel = new JLabel("Student #:");
        panel.add(studentNumLabel);

        //FIELDS ------------------------
        studentID = new JTextField(15);
        panel.add(studentID);

        //LAYOUT CONSTRAINTS----------------
        //name
        layout.putConstraint(SpringLayout.WEST, studentNumLabel, 15, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, studentNumLabel, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, studentID, 5, SpringLayout.EAST, studentNumLabel);
        layout.putConstraint(SpringLayout.NORTH, studentID, 21, SpringLayout.NORTH, panel);

        //SUBMIT BUTTON-----------------

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(280, 130, 90, 20);
        btnSubmit.addActionListener(new RemoveSubmitButtonListener());

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(20, 130, 90, 20);
        btnBack.addActionListener(new BackButtonListener(this));

        this.getContentPane().add(btnSubmit);
        this.getContentPane().add(btnBack);
        this.setVisible(true);

        this.add(panel);
        this.setSize(400,210);

    }
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
class RemoveSubmitButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0) {
        if (RemoveStudent.verifyStudentNum(RemoveStudent.studentID.getText())) {
            RemoveStudent.studentIDInput = Integer.parseInt(RemoveStudent.studentID.getText());
        }

        if (RemoveStudent.enrolment.removeStudent(RemoveStudent.studentIDInput)){
            JOptionPane.showMessageDialog(null, "Student Removed");
        }else{
            JOptionPane.showMessageDialog(null, "Student Not Found in the Database");
        }

        RemoveStudent.studentID.setText("");

//        RemoveStudent.enrolment.removeStudent(RemoveStudent.studentIDInput);
//        int index = removeStudentIndex();
//        if (index>=0){
//            RemoveStudent.enrolment.getStudentList().remove(index);
//            JOptionPane.showMessageDialog(null, "Student Removed");
//        }else{
//            JOptionPane.showMessageDialog(null, "Student Not Found in the Database");
//        }

    }

//    public int removeStudentIndex() {
//        int count = 0;
//        while (RemoveStudent.enrolment.getStudentList().size() > count) {
//            System.out.println(RemoveStudent.enrolment.getStudentList());
//            if (RemoveStudent.enrolment.getStudentList().get(count).getId() == RemoveStudent.studentIDInput) {
//                System.out.println("true");
//                return count;
//            }
//            count++;
//            System.out.println("count: "+count);
//        }
//        System.out.println("false");
//        return -1;
//    }
}



