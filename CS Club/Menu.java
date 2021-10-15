// *** imports *** //
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 * Menu.java
 * Allows the user to choose between, adding student, removing student, displaying students or displaying floor plan (menu page)
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class Menu extends JFrame {
  
  /**
   * Menu
   * This constructor adds all visible components to the JFrame upon instantiating the object
   */
  Menu() {
    // *** setting up the frame *** //
    super("Menu");
    this.setBounds(0, 0, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setLayout(null);
    this.setResizable(false);
    
    // *** setting up the panels *** //
    JPanel panel = new JPanel();
    panel.setBounds(15, 15, 370, 300);
    TitledBorder title = BorderFactory.createTitledBorder("Menu");
    title.setTitleJustification(TitledBorder.CENTER);
    panel.setBorder(title);
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);
    
    // *** setting up buttons *** //
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
    
    // *** spring layout constraints *** //
    // add student button
    layout.putConstraint(SpringLayout.WEST, add, 115, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, add, 10, SpringLayout.NORTH, panel);
    // remove student button 
    layout.putConstraint(SpringLayout.WEST, remove, 105, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, remove, 20, SpringLayout.SOUTH, add);
    // display students buttons
    layout.putConstraint(SpringLayout.WEST, students, 100, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, students, 20, SpringLayout.SOUTH, remove);
    // display floorplan button 
    layout.putConstraint(SpringLayout.WEST, floorPlan, 97, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, floorPlan, 20, SpringLayout.SOUTH, students);
    // quit button 
    layout.putConstraint(SpringLayout.WEST, quit, 140, SpringLayout.WEST, panel);
    layout.putConstraint(SpringLayout.NORTH, quit, 50, SpringLayout.SOUTH, floorPlan);
    
    this.add(panel);
    this.setSize(400,370);
    this.setVisible(true);
  }
}
/**
 * AddButtonListener.java
 * Adding student button listener 
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class AddButtonListener implements ActionListener {
  JFrame frame;
  
  /**
   * AddButtonListener
   * This constructor ensures the student add button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  AddButtonListener(JFrame frame) {
    this.frame = frame;
  }
  
  /**
   * actionPerformed
   * This method disposes the current frame and opens the add student page
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    new AddStudent(SystemManager.enrollment);
    frame.dispose();
  }
}
/**
 * RemoveButtonListener.java
 * Remove student button listener 
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class RemoveButtonListener implements ActionListener {
  JFrame frame;
  
  /**
   * RemoveButtonListener
   * This constructor ensures the student remove button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  RemoveButtonListener(JFrame frame) {
    this.frame = frame;
  }
  
  /**
   * actionPerformed
   * This method disposes the current frame and opens the remove student page
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    new RemoveStudent(SystemManager.enrollment);
    frame.dispose();
  }
}
/**
 * FloorPlanListener.java
 * Floor plan button listener, opens the floor plan
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class FloorPlanListener implements ActionListener {
  JFrame frame;
  
  /**
   * FloorPlanListener
   * This constructor ensures the display floor plan button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  FloorPlanListener(JFrame frame) {
    this.frame = frame;
  }
  
  /**
   * actionPerformed
   * This method disposes the current frame and opens the floor plan page
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    SystemManager.seatingPlan.arrangeStudents(SystemManager.floorPlan, SystemManager.enrollment.getStudentList());
    new Frame();
    frame.dispose();
  }
}
/**
 * DisplayButtonListener.java
 * Display students button listener
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class DisplayButtonListener implements ActionListener {
  JFrame frame;
  
  /**
   * DisplayButtonListener
   * This constructor ensures the display student button is linked to the current page
   * @param frame The current JFrame the button is on
   */
  DisplayButtonListener(JFrame frame) {
    this.frame = frame;
  }
  
  /**
   * actionPerformed
   * This method disposes the current frame and opens the display student menu page
   * @param e is the button click
   */
  public void actionPerformed(ActionEvent e) {
    new DisplayStudentMenu(SystemManager.enrollment);
    frame.dispose();
  }
}
/**
 * QuitButtonListener.java
 * Quit button listener to end the program
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
class QuitButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}
