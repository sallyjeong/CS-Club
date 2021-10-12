/**
 * 2021-10-12 12:38AM
 *
 * EDITS
 * added action listener to every button
 *
 * ERROR
 * when you run it, the add student, display student, etc will have errors because we don't have those methods yet
 * to test it, press the button quit
 * 
 * QUESTION
 * go to line 67  -  display floor plan
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

class menu1 {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Menu");
        frame.setVisible(true);
        frame.setBounds(0, 0, 400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

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
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent(Student s);
            }
        });

        JButton remove = new JButton("Remove Student");
        remove.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent(int id);
            }
        });

        JButton floorPlan = new JButton("Display Floor Plan");
        floorPlan.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(floorPlan);
        floorPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FloorPlanSystem.displayTables();
                /***** ??? not in the uml - ask kat/rachel *****/
            }
        });

        JButton students = new JButton("Display Students");
        students.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(students);
        students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents;
            }
        });

        JButton quit = new JButton("Quit");
        quit.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

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



        frame.add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}