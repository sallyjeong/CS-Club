// *** imports *** //
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

/**
 * DisplayStudentMenu.java
 * A page that allows the user to pick display order (sorting based on name, group, grade)
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class DisplayStudentMenu extends JFrame {

    /**
     * variables
     */
  public static EnrollmentSystem enrolment;

  /**
   * DisplayStudentMenu
   * This constructor adds all visible components to the JFrame upon instantiating the object
   * @param enrollment The EnrollmentSystem that contains a masterlist of students
   */
  DisplayStudentMenu(EnrollmentSystem enrollment) {
    super("Display Student Menu");
    DisplayStudentMenu.enrolment = enrollment;
    
    // *** setting up the frame *** //
    this.setBounds(0, 0, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setLayout(null);
    this.setResizable(false);

    // *** setting up the panels *** //
    JPanel panel = new JPanel();
    panel.setBounds(15, 15, 370, 300);
    TitledBorder title = BorderFactory.createTitledBorder("Choose Display Type");
    title.setTitleJustification(TitledBorder.CENTER);
    panel.setBorder(title);
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);
    
    // *** buttons *** //
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
    
    // *** spring layout constraints *** //
    //sort by name button
    layout.putConstraint(SpringLayout.WEST, sortName, 115, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, sortName, 10, SpringLayout.NORTH, panel);

    //sort by group button
    layout.putConstraint(SpringLayout.WEST, sortGroup, -1, SpringLayout.WEST, sortName);
    layout.putConstraint(SpringLayout.NORTH, sortGroup, 20, SpringLayout.SOUTH, sortName);

    //sort by grade button
    layout.putConstraint(SpringLayout.WEST, sortGrade, 1, SpringLayout.WEST, sortGroup);
    layout.putConstraint(SpringLayout.NORTH, sortGrade, 20, SpringLayout.SOUTH, sortGroup);

    //back button 
    layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, sortGrade);
    layout.putConstraint(SpringLayout.NORTH, back, 20, SpringLayout.SOUTH, sortGrade);
    
    this.add(panel);
    this.setSize(400,400);
    this.setVisible(true);
  }
}

/**
 * SortNameButtonListener.java
 * Sorts students by name
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class SortNameButtonListener implements ActionListener {
  JFrame frame;
  /**
   * SortNameButtonListener
   * This constructor ensures the sort group button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  SortNameButtonListener(JFrame frame) {
    this.frame = frame;
  }

  /**
   * actionPerformed
   * This method allows the user to display students by name
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    DisplayStudentMenu.enrolment.getStudentList().sort(new SortByName());
    frame.dispose();
    new DisplayStudents(DisplayStudentMenu.enrolment);
  }
}
/**
 * SortGroupButtonListener.java
 * Disposes current frame, opens new frame to display students sorted by group 
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class SortGroupButtonListener implements ActionListener {
  JFrame frame;

  /**
   * SortGroupButtonListener
   * This constructor ensures the sort group button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  SortGroupButtonListener(JFrame frame) {
    this.frame = frame;
  }

  /**
   * actionPerformed
   * This method allows the user to display students by group
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    DisplayStudentMenu.enrolment.getStudentList().sort(new SortByGroup());
    new DisplayStudents(DisplayStudentMenu.enrolment);
    frame.dispose();
  }
}

/**
 * SortGradeListener.java
 * Disposes current frame, opens new frame to display students sorted by grade 
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class SortGradeListener implements ActionListener {
  JFrame frame;
  /**
   * SortGradeListener
   * This constructor ensures the sort group button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  SortGradeListener(JFrame frame) {
    this.frame = frame;
  }

  /**
   * actionPerformed
   * This method allows the user to display students by grade and dispose the current frame
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    DisplayStudentMenu.enrolment.getStudentList().sort(new SortByGrade());
    new DisplayStudents(DisplayStudentMenu.enrolment);
    frame.dispose();
  }
}
