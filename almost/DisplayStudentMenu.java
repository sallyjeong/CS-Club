
//imports
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.util.Collections;

/**
 * DisplayStudentMenu.java
 * A page that allows the user to pick display order (sorting based on name, group, grade)
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class DisplayStudentMenu extends JFrame {
    public static EnrollmentSystem enrolment;
    DisplayStudentMenu(EnrollmentSystem enrolment) {
        super("Display Student Menu");
        DisplayStudentMenu.enrolment = enrolment;

        this.setBounds(0, 0, 400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(15, 15, 370, 300);
        TitledBorder title = BorderFactory.createTitledBorder("Choose Display Type");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        // different sort methods

        JButton sortName = new JButton("Sort by Name");
        sortName.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(sortName);
        sortName.addActionListener(new SortNameButtonListener(this));

        JButton sortGroup = new JButton("Sort by Group");
        sortGroup.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(sortGroup);
        sortGroup.addActionListener(new SortGroupButtonListener(this));

        JButton sortGrade = new JButton("Sort by Grade");
        sortGrade.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(sortGrade);
        sortGrade.addActionListener(new SortGradeListener(this));

        JButton back = new JButton("Back");
        back.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(back);
        back.addActionListener(new BackButtonListener(this));

        //b1 layout
        layout.putConstraint(SpringLayout.WEST, sortName, 115, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortName, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortGroup, -1, SpringLayout.WEST, sortName);
        layout.putConstraint(SpringLayout.NORTH, sortGroup, 20, SpringLayout.SOUTH, sortName);
        layout.putConstraint(SpringLayout.WEST, sortGrade, 1, SpringLayout.WEST, sortGroup);
        layout.putConstraint(SpringLayout.NORTH, sortGrade, 20, SpringLayout.SOUTH, sortGroup);
        layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, sortGrade);
        layout.putConstraint(SpringLayout.NORTH, back, 20, SpringLayout.SOUTH, sortGrade);

        this.add(panel);
        this.setSize(400,400);
        this.setVisible(true);
    }
}
class SortNameButtonListener implements ActionListener {
    JFrame frame;
    SortNameButtonListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        DisplayStudentMenu.enrolment.getStudentList().sort(new SortByName());
        frame.dispose();
        new DisplayStudents(DisplayStudentMenu.enrolment);

        // we should rename this though lmao
        // call the gui3 (page with student info)
        // in that page, create a student with the info provided (enrollment system.add student)
    }
}
class SortGroupButtonListener implements ActionListener {
    JFrame frame;
    SortGroupButtonListener(JFrame frame) {
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e) {
        DisplayStudentMenu.enrolment.getStudentList().sort(new SortByGroup());
        new DisplayStudents(DisplayStudentMenu.enrolment);
        frame.dispose();
    }
}
class SortGradeListener implements ActionListener {
    JFrame frame;
    SortGradeListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        DisplayStudentMenu.enrolment.getStudentList().sort(new SortByGrade());
        new DisplayStudents(DisplayStudentMenu.enrolment);
        frame.dispose();
    }
}
// class DisplayButtonListener implements ActionListener {
//   JFrame frame;
//   DisplayButtonListener(JFrame frame) {
//    this.frame = frame;
//   }

//    public void actionPerformed(ActionEvent e) {

//      new DisplayStudents();
//      frame.dispose();
//      // go into the page that gives options (import java.util.Collections?)
//      // either
//      // Collections.sort(EnrollmentSystem.getStudents, new SortByGrade());
//     // Collections.sort(EnrollmentSystem.getStudents, new SortByGroup());
//   }
//}
