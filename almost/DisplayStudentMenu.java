 /**
2	+  * 2021-10-12 12:38AM
3	+  *
4	+  * EDITS
5	+  * added action listener to every button
6	+  *
7	+  * ERROR
8	+  * when you run it, the add student, display student, etc will have errors because we don't have those methods yet
9	+  * to test it, press the button quit
10	+  * 
11	+  * QUESTION
12	+  * go to line 67  -  display floor plan
13	+  */
import java.util.Collections;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
class DisplayStudentMenu extends JFrame {
    public static EnrollmentSystem enrolment;
DisplayStudentMenu(EnrollmentSystem enrolment) {
    super("Display Student Menu");
    DisplayStudentMenu.enrolment = enrolment;
    
    this.setVisible(true);
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
     
    // add student, remove student, display floor plan, ??
    
   JButton sortName = new JButton("Sort by Name");
    sortName.setVerticalTextPosition(AbstractButton.CENTER);
   panel.add(sortName);
   sortName.addActionListener(new SortNameButtonListener(this));
     
   JButton sortGroup = new JButton("Sort by Group");
    sortGroup.setVerticalTextPosition(AbstractButton.CENTER);
   panel.add(sortGroup);
   sortGroup.addActionListener(new SortGroupButtonListener(this));
   
    JButton sortGrade = new JButton("Sort by Name");
   sortGrade.setVerticalTextPosition(AbstractButton.CENTER);
   panel.add(sortGrade);
   sortGrade.addActionListener(new SortGradeListener(this));
  
   
    JButton back = new JButton("Back");
    back.setVerticalTextPosition(AbstractButton.CENTER);
    panel.add(back);
    back.addActionListener(new DisplayBackButtonListener(this));
   
    //b1 layout
    layout.putConstraint(SpringLayout.WEST, sortName, 115, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, sortName, 10, SpringLayout.NORTH, panel);
    layout.putConstraint(SpringLayout.WEST, sortGroup, 105, SpringLayout.WEST, panel);       
    layout.putConstraint(SpringLayout.NORTH, sortGroup, 20, SpringLayout.SOUTH, sortName);
    layout.putConstraint(SpringLayout.WEST, sortGrade, 100, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, sortGrade, 20, SpringLayout.SOUTH, sortGroup);        layout.putConstraint(SpringLayout.WEST, back, 97, SpringLayout.WEST, panel);
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
     // sort by name doesn't exist yet Collections.sort(DisplayStudentMenu.enrolment.getStudentList(), new SortByName()); 
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
    // sort by name doesn't exist yet Collections.sort(DisplayStudentMenu.enrolment.getStudentList(), new SortByGroup());
    new DisplayStudents(DisplayStudentMenu.enrolment);
     frame.dispose();
     // call a page asking for student number ---- doens't xist yet
     // in that page/class, call enrollment system. remove student
   }
 }
class SortGradeListener implements ActionListener {
 JFrame frame;
   SortGradeListener(JFrame frame) {
    this.frame = frame;
  }
   
  public void actionPerformed(ActionEvent e) {
    // sort by grade doesn't exist yet Collections.sort(EnrollmentSystem.getStudentList(), new SortByGrade());
    new DisplayStudents(DisplayStudentMenu.enrolment);
    frame.dispose();
   // floorPlan.displayTables();
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
//  }
class DisplayBackButtonListener implements ActionListener {
   JFrame frame;
  DisplayBackButtonListener(JFrame frame) {
    this.frame = frame;
  }
  
  public void actionPerformed(ActionEvent arg0) {
    new Menu(AddStudent.enrolment);
    frame.dispose();
  }

  }
