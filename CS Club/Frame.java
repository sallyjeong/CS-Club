/* * * * * Imports * * * * */
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * [Frame.java]
 * This class creates the starting Frame
 * @author Peter Gao, Anthony Tecsa
 * @version Oct 2021
 */
public class Frame extends JFrame { 

 static FloorPlanSystem fp = SystemManager.floorPlan;

 static int cnt;
 
 /**
  * Constructs a starting frame
  */
 public Frame() {
  setTitle("Floor Plan System");
  setSize(1250, 850);  
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  GraphicsPanel panel = new GraphicsPanel();
  panel.setLayout(null);

  this.setResizable(false);
  this.setVisible(true);
  this.requestFocusInWindow();
  
  JButton b = new JButton("Show names");
  b.addActionListener(new ToggleButtonListener());
  b.setBounds(215,680,150,100); 
  JButton b2 = new JButton("Back");
  b2.addActionListener(new BackButtonListener(this));
  b2.setBounds(365,680,100,100); 
  panel.add(b);
  panel.add(b2);
  getContentPane().add(panel);
 }

 public class ToggleButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   for(int i = 0; i<fp.getTableList().size(); i++) {
    fp.getTableList().get(i).setToggleNames(!fp.getTableList().get(i).getToggleNames());
   }
  }
 }
 
 public class BackButtonListener implements ActionListener {
  JFrame frame;
  BackButtonListener(JFrame frame) {
   this.frame = frame;
  }
  public void actionPerformed(ActionEvent e) {
   frame.dispose();
   SystemManager.displayChoices();
  }
 }
 
 /**
  * [GraphicsPanel.java]
  * This inner class creates the JPanel to draw the menu on
  * @author Peter Gao, Anthony Tecsa
  * @version Oct 2021
  */
 static class GraphicsPanel extends JPanel {

  private BufferedImage trashcan;

  /**
   * Constructs the graphical panel for the user to use
   */
  public GraphicsPanel() {
   setPreferredSize(new Dimension(1250, 850));
   setFocusable(true);
   requestFocusInWindow();
   this.addMouseListener(new MyMouseListener());
   this.addMouseMotionListener(new MyMouseListener());
  }

  /**
   * paintComponent
   * This method draws and updates the screen repeatedly
   * @param g, Graphics for drawing
   */
  public void paintComponent(Graphics g) { 
   super.paintComponent(g); 
   draw(g);
   repaint();
  }

  /**
   * draw
   * This method draws the buttons, the table counter at the topright, and the trashcan at the bottom left. 
   * @param g, Graphics for drawing
   */
  public void draw(Graphics g) {
   g.setFont(new Font("TimesRoman", Font.BOLD, 80)); 
   g.setColor(Color.RED);
   if(fp.getTableList().size() <= 10) {
    g.drawString(fp.getTableList().size() + " /10", 1000, 70);
   } else {
    g.drawString("10 /10", 1000, 70);
   }
   g.fillRect(15, 680, 200, 100);
   loadSprite();
   g.drawImage(trashcan, 70, 680, null);

   fp.displayTables(g);
  }

  /**
   * loadSprite
   * This method loads the trashcan image
   */
  public void loadSprite() {
   try {
    trashcan = ImageIO.read(new File("files\\trashcan.png"));
   }catch (Exception e) {
    System.out.println("error loading file");
   }
  }

 }

 private static class MyMouseListener implements MouseListener, MouseMotionListener {
  public void mouseClicked(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  /**
   * mousePressed
   * This method is invoked when the mouse button has been pressed on a component
   * @param e, MouseEvent indicates that an action occurred
   */
  public void mousePressed(MouseEvent e) {
   for(int i=0; i<fp.getTableList().size(); i++) {
    if(fp.getTableList().get(i).getRect().contains(e.getX(), e.getY())) {
     fp.getTableList().get(i).setIsPressed(true);
     //change the x and y coordinates so that the cursor moves to the center of the table
     fp.getTableList().get(i).setX(e.getX()-75);
     fp.getTableList().get(i).setY(e.getY()-50);
     fp.getTableList().get(i).getRect().setLocation(e.getX()-75, e.getY()-50);
     //so that only 1 table can be clicked at one time
     break;
    }
   }
  }

  /**
   * mouseReleased
   * This method is invoked when the mouse button has been released 
   * @param e, MouseEvent indicates that an action occurred
   */
  public void mouseReleased(MouseEvent e) {
   for(int i=0; i<fp.getTableList().size(); i++) {
    if(fp.getTableList().get(i).getIsPressed()) {
     //if the table is released over the trash can
     if(e.getX()>=15 && e.getX()<=215 && e.getY()>=680 && e.getY()<=780) {
      if(fp.removeTable(fp.getTableList().get(i).getID())) {
       System.out.println("Table removed");
      }
     }else if(e.getX()>=215 && e.getX()<=365 && e.getY()>=680 && e.getY()<=780) {
      fp.getTableList().get(i).setX(215);
      fp.getTableList().get(i).setY(580);
      fp.getTableList().get(i).getRect().setLocation(215, 580);
      break;
     }
    }
   }
   //if nothing is being clicked, set all boolean values to false
   for(int i=0; i<fp.getTableList().size(); i++) {
    fp.getTableList().get(i).setIsPressed(false);
   }
  }

  /**
   * mouseDragged
   * This method is invoked when a mouse button is pressed on a component and then dragged
   * @param e, MouseEvent indicates that an action occurred
   */
  public void mouseDragged(MouseEvent e) {
   for(int i=0; i<fp.getTableList().size(); i++) {
    //move the table if it is being dragged by the mouse
    if(fp.getTableList().get(i).getIsPressed() && e.getX()>=0 && e.getX()<=1250 && e.getY()>=0 && e.getY()<=850) {
     //change the x and y so that the cursor is on the middle of the table
     fp.getTableList().get(i).setX(e.getX()-75);
     fp.getTableList().get(i).setY(e.getY()-50);
     fp.getTableList().get(i).getRect().setLocation(e.getX()-75, e.getY()-50);
     //so that only 1 table can be moved at one time
     break;
    }
   }
  }

  public void mouseMoved(MouseEvent e) {
  }
 }

 
}