
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
public class DisplayStudents extends JFrame{

    public static EnrollmentSystem enrolment;

    DisplayStudents(EnrollmentSystem enrolment){
        super("Display Students");
        this.enrolment = enrolment;
        ArrayList<Student> students = enrolment.getStudentList();

        String studentData[][] = new String [students.size()][4];

        for (int i = 0; i < students.size(); i++) {
            studentData[i] = students.get(i).studentInfo();
        }
        
        String[] column = {"Name", "ID", "Group", "Grade"};
        JTable table = new JTable (studentData,column);
        table.setBounds (10, 10, 370, 97);
        JScrollPane scroll = new JScrollPane(table);    
        this.add(scroll);          
        this.setSize(400,600);    
        this.setVisible(true);
    }  
}


   

