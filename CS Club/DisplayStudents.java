// *** imports *** //
import javax.swing.*;
import java.util.ArrayList;

/**
 * DisplayStudents.java
 * Displays students into a table based on the master student list 
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class DisplayStudents extends JFrame{

    /**
     * variables
     */
    public static EnrollmentSystem enrolment;

    /**
     * DisplayStudents
     * This constructor adds all visible components to the JFrame upon instantiating the object
     * @param enrolment The EnrollmentSystem that contains a masterlist of students
     */
    DisplayStudents(EnrollmentSystem enrolment){
        super("Display Students");

        // *** setting up the frame *** //
        this.setResizable(false);
        this.enrolment = enrolment;

        // *** creating the table and scroll pane *** //
        ArrayList<Student> students = enrolment.getStudentList();
        String studentData[][] = new String [students.size()][4];
        for (int i = 0; i < students.size(); i++) {
            studentData[i] = students.get(i).studentInfo();
        }
        String[] column = {"Name", "ID", "Group", "Grade"};
        JTable table = new JTable (studentData,column);
        table.setBounds (15, 10, 320, 100);
        JScrollPane scroll = new JScrollPane(table);

        // *** setting up panel *** //
        JPanel panel = new JPanel();
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new BackButtonListener(this));

        // *** adding to panel *** //
        panel.add(btnBack);
        panel.add(new JScrollPane(table));
        panel.add(new JScrollPane(scroll));

        // *** setting up frame *** //
        this.add(panel);
        this.setSize(480,500);
        this.setVisible(true);

    }
}




   

