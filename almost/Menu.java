
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;


public class Menu extends JFrame {
    public static EnrollmentSystem enrolment;
    Menu(EnrollmentSystem enrolment) {
        super("Menu");
        this.enrolment = enrolment;
        this.setBounds(0, 0, 400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(15, 15, 370, 300);
        TitledBorder title = BorderFactory.createTitledBorder("Menu");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        // add student, remove student, display floor plan, ??

        JButton add = new JButton("Add Student");
        add.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(add);
        add.addActionListener(new AddButtonListener(this));

        JButton remove = new JButton("Remove Student");
        remove.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(remove);
        remove.addActionListener(new RemoveButtonListener(this));

        JButton floorPlan = new JButton("Display Floor Plan");
        floorPlan.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(floorPlan);
        floorPlan.addActionListener(new FloorPlanListener(this));

        JButton students = new JButton("Display Students");
        students.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(students);
        students.addActionListener(new DisplayButtonListener(this));

        JButton quit = new JButton("Quit");
        quit.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(quit);
        quit.addActionListener(new QuitButtonListener());

        //b1 layout
        layout.putConstraint(SpringLayout.WEST, add, 115, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, add, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, remove, 105, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, remove, 20, SpringLayout.SOUTH, add);
        layout.putConstraint(SpringLayout.WEST, students, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, students, 20, SpringLayout.SOUTH, remove);
        layout.putConstraint(SpringLayout.WEST, floorPlan, 97, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, floorPlan, 20, SpringLayout.SOUTH, students);
        layout.putConstraint(SpringLayout.WEST, quit, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, quit, 50, SpringLayout.SOUTH, floorPlan);

        this.add(panel);
        this.setSize(400,370);
        this.setVisible(true);
    }
}
class AddButtonListener implements ActionListener {
    JFrame frame;
    AddButtonListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        new AddStudent(Menu.enrolment);
        frame.dispose();
    }
}
class RemoveButtonListener implements ActionListener {
    JFrame frame;
    RemoveButtonListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        new RemoveStudent(Menu.enrolment);
        frame.dispose();
    }
}
class FloorPlanListener implements ActionListener {
    JFrame frame;
    FloorPlanListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
       // new FloorPlan();
        frame.dispose();
    }
}
class DisplayButtonListener implements ActionListener {
    JFrame frame;
    DisplayButtonListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        new DisplayStudentMenu(Menu.enrolment);
        frame.dispose();
    }
}
class QuitButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
