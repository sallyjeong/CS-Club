package CSClub;


//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


class RemoveStudent extends JFrame {
    public static int studentNumber;
    public static EnrollmentSystem enrolment;
    RemoveStudent(EnrollmentSystem enrolment) {

        super("Remove Student");
        this.enrolment = enrolment;

        //  frame.setSize(500, 600);
        this.setVisible(true);
        this.setBounds(0, 0, 400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(15, 15, 370, 100);
        //panel.setBackground(Color.gray);
        //panel.setBorder(BorderFactory.createLineBorder(Color.blue));
        TitledBorder title = BorderFactory.createTitledBorder("Remove Student");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        //LABELS ------------------------

        //name label
        JLabel studentNumLabel = new JLabel("Student #:");
//        studentNumLabel.setBounds(30, 50, 90, 20);
        panel.add(studentNumLabel);
        //frame.add(nameLabel);

        //FIELDS ------------------------
        JTextField studentID = new JTextField(15);
//        studentID.setBounds(100, 50, 200, 20);
        //frame.getContentPane().add(name);
        panel.add(studentID);
        //name.setColumns(10);
        // store name.getText();
        if (verifyStudentNum(studentID.getText())) {
            studentNumber = Integer.parseInt(studentID.getText());
        }



        //LAYOUT CONSTRAINTS----------------
        //name
        layout.putConstraint(SpringLayout.WEST, studentNumLabel, 15, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, studentNumLabel, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, studentID, 5, SpringLayout.EAST, studentNumLabel);
        layout.putConstraint(SpringLayout.NORTH, studentID, 21, SpringLayout.NORTH, panel);

        //SUBMIT BUTTON-----------------

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new RemoveSubmitButtonListener());
        btnSubmit.setBounds(150, 400, 90, 20);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(20, 400, 90, 20);
        btnBack.addActionListener(new RemoveBackButtonListener(this));

        this.getContentPane().add(btnBack);
        this.getContentPane().add(btnSubmit);
        this.setVisible(true);

        this.add(panel);
        this.setSize(400,600);

    }
    public boolean verifyStudentNum(String id) {
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
class RemoveSubmitButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0) {
        int count = 0;
        while (RemoveStudent.enrolment.getStudentList().size()>count || RemoveStudent.enrolment.getStudentList().get(count).getId()!=RemoveStudent.studentNumber){
            count++;
        }
        if (RemoveStudent.enrolment.getStudentList().get(count).getId()==RemoveStudent.studentNumber) {
            RemoveStudent.enrolment.getStudentList().remove(count);
            JOptionPane.showMessageDialog(null, "Student Removed");
        }else{
            JOptionPane.showMessageDialog(null, "Student Not Found in the Database");
        }


        // show the student info

        // JOptionPane.showMessageDialog(null, "Please Try Again");
    }
}

class RemoveBackButtonListener implements ActionListener {
    JFrame frame;
    RemoveBackButtonListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent arg0) {
        new Menu(AddStudent.enrolment);
        frame.dispose();
    }
}


