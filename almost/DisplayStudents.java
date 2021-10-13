
//imports
import javax.swing.*;
import java.util.ArrayList;
public class DisplayStudents extends JFrame{

    public static EnrollmentSystem enrolment;

    DisplayStudents(EnrollmentSystem enrolment){
        super("Display Students");
        this.setResizable(false);
        this.enrolment = enrolment;
        ArrayList<Student> students = enrolment.getStudentList();

        String studentData[][] = new String [students.size()][4];
        for (int i = 0; i < students.size(); i++) {
            studentData[i] = students.get(i).studentInfo();
        }

        JPanel panel = new JPanel();
        panel.setBounds(20, 0, 390, 500);
 
        String[] column = {"Name", "ID", "Group", "Grade"};
        JTable table = new JTable (studentData,column);
        table.setBounds (15, 10, 320, 100);
        JScrollPane scroll = new JScrollPane(table);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(0, 0, 400, 20);
        btnBack.addActionListener(new BackButtonListener(this));
        panel.add(btnBack);
        panel.add(new JScrollPane(table));
        panel.add(new JScrollPane(scroll));

        this.add(panel);
        this.setSize(480,500);
        this.setVisible(true);

    }
}




   

