// CHANGE THIS YK
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * ComboBoxDemo.java 
 */
public class ComboBox extends JPanel implements ActionListener {
  //  JLabel picture;
  public ComboBox() {
    super(new BorderLayout());
    
    String[] groupStrings = { "game development", "web development", "competitive programming" };
    
    //Create the combo box, select the item at index 3.
    //Indices start at 0, so 3 specifies competitive programming.
    JComboBox groupList = new JComboBox(groupStrings);
    groupList.setSelectedIndex(2);
    groupList.addActionListener(this);
    
    //Lay out the demo.
    add(groupList, BorderLayout.PAGE_START);
    // add(picture, BorderLayout.PAGE_END);
    setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
  }
  
  /** Listens to the combo box. */
  public void actionPerformed(ActionEvent e) {
    JComboBox options = (JComboBox)e.getSource();
    String groupName = (String)options.getSelectedItem();
  }
  
  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("CS Club Enrollment");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Create and set up the content pane.
    JComponent newContentPane = new ComboBoxDemo();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);
    
    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
  
  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}