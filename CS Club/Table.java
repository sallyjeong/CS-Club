/* * * * * Imports * * * * */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * [Table.java]
 * This class represents a table used in the club
 * @author Peter Gao, Anthony Tecsa
 * @version 1.0
 * @since Oct 2021
 */
public class Table {
  private int id;
  private int capacity, remainingCapacity;
  private int x, y;
  private String tableName;
  private Student[] studentList;
  private boolean isPressed;
  private boolean toggleNames;
  private Rectangle rect;
  
  /**
   * Constructs a new table
   * @param id An integer holding the id of the table
   * @param t A String holding the tablename
   */
  public Table(int id, String t) {
    this.id = id;
    this.tableName = t;
    if(tableName.equals("intro")) {
      this.x = 200; this.y = 150+id*50;
    }else if(tableName.equals("contest")) {
      this.x = 500; this.y = 150+id*50;
    }else if(tableName.equals("web")) {
      this.x = 800; this.y = 150+id*50;
    }
    this.capacity = 6; 
    this.remainingCapacity = 6;
    studentList = new Student[capacity];
    this.isPressed = false;
    this.toggleNames = false;
    rect = new Rectangle(this.getX(), this.getY(), 150, 100);
  }
  
  /**
   * Constructs a new table with students
   * @param id An integer holding the id of the table
   * @param t A String holding the tablename
   * @param capacity The number of students a table can fit
   */
  public Table(int id, String t, int capacity) {
    this.id = id;
    this.tableName = t;
    if(tableName.equals("intro")) {
      this.x = 200; this.y = 150+id*50;
    }else if(tableName.equals("contest")) {
      this.x = 500; this.y = 150+id*50;
    }else if(tableName.equals("web")) {
      this.x = 800; this.y = 150+id*50;
    }
    this.capacity = capacity; 
    this.remainingCapacity = capacity;
    studentList = new Student [capacity];
    this.isPressed = false;
    this.toggleNames = false;
    rect = new Rectangle(this.getX(), this.getY(), 150, 100);
  }
  
  /**
   * getID
   * @return int the id of the table
   */
  public int getID() {
    return this.id; 
  }
  
  public int getRemainingCapacity() {
  return this.remainingCapacity;
  }

  public boolean isEmpty() {
  if(remainingCapacity==capacity) {
   return true;
  }
  return false;
 }
  
  public Student[] getStudentList() {
  return this.studentList;
 }
  
  /**
   * getCapacity
   * @return int the max capacity of a table
   */
  public int getCapacity() {
    return this.capacity;
  }
  
  /**
   * getX
   * @return int the x coordinate of the table
   */
  public int getX() {
    return this.x;
  }
  
  /**
   * getY
   * @return int the y coordinate of the table
   */
  public int getY() {
    return this.y;
  }
  
  /**
   * setX
   * changes the x coordinate of the table
   */
  public void setX(int x) {
    this.x = x;
  }
  
  /**
   * setY
   * changes the y coordinate of the table
   */
  public void setY(int y) {
    this.y = y;
  }
  
  /**
   * getRect
   * @return Rectangle the rectangle object representing the table
   */
  public Rectangle getRect() {
    return this.rect;
  }
  
  /**
   * getIsPressed
   * @return boolean if the rectangle is being clicked by the mouse
   */
  public boolean getIsPressed() {
    return isPressed;
  }
  
  /**
   * setIsPressed
   * changes the boolean value isPressed
   */
  public void setIsPressed(boolean b) {
    this.isPressed = b;
  }
  /**
   * getToggleNames
   * @return boolean if the rectangle is being clicked by the mouse
   */
  public boolean getToggleNames() {
    return toggleNames;
  }
  /**
   * setToggleNames
   * changes the boolean value isPressed
   */
  public void setToggleNames(boolean b) {
    this.toggleNames = b;
  }
  
  /**
   * addStudent
   * @param s The Student being added 
   * @return boolean, whether the addition was successful or not
   */
  public boolean addStudent(Student s) {
    if(remainingCapacity>0) {
      studentList[capacity-remainingCapacity] = s;
      remainingCapacity--;
      return true;
    }
    return false;
  }
  
  /**
   * removeStudent
   * @param id The id of the student being removed
   * @return boolean, whether the removal was successful or not
   */
  public boolean removeStudent(int id) {
    for(int i=0; i<studentList.length; i++) {
      if(studentList[i].getId()==id) {
        studentList[i] = null; 
        //shifting each element in the array down
        for(int j=i+1; j<studentList.length; i++) {
          studentList[j-1] = studentList[j];
        }
        studentList[studentList.length-1] = null;
        remainingCapacity++;
        return true;
      }
    }
    return false;
  }
  
  /**
   * draw
   * @param g Graphics for drawing
   */
  public void draw(Graphics g) {
      
    // I Intro, C Contest, W Web
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(this.getX(), this.getY(), 150, 100);
    g.setColor(Color.WHITE);
    if(toggleNames == false) {
      g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
      if(tableName.equals("intro")) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.getX(), this.getY(), 150, 100);
        g.setColor(Color.WHITE);
        g.drawString("I : " + (id), this.getX()+50, this.getY()+55);
      }else if(tableName.equals("contest")) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.getX(), this.getY(), 150, 100);
        g.setColor(Color.WHITE);
        g.drawString("C : " + (id), this.getX()+48, this.getY()+55);
      }else if(tableName.equals("web")) {
        g.setColor(Color.ORANGE);
        g.fillRect(this.getX(), this.getY(), 150, 100);
        g.setColor(Color.WHITE);
        g.drawString("W : " + (id), this.getX()+40, this.getY()+55);
      }
      
      
    } else if(toggleNames == true) {
      g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
      if(tableName.equals("intro")) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.getX(), this.getY(), 150, 100);
        g.setColor(Color.WHITE);
        
        for(int i = 0;i<studentList.length;i++) {
            if (studentList[i] != null) {         
                g.drawString(studentList[i].getName(), this.getX()+5, this.getY()+(i+1)*15);
            }
        }
      }else if(tableName.equals("contest")) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.getX(), this.getY(), 150, 100);
        g.setColor(Color.WHITE);
        for(int i = 0;i<studentList.length;i++) {
            if (studentList[i] != null) {  
                g.drawString(studentList[i].getName(), this.getX()+5, this.getY()+(i+1)*15);
            }
        }
      }else if(tableName.equals("web")) {
        g.setColor(Color.ORANGE);
        g.fillRect(this.getX(), this.getY(), 150, 100);
        g.setColor(Color.WHITE);
        for(int i = 0;i<studentList.length;i++) {
          if (studentList[i] != null) {  
            g.drawString(studentList[i].getName(), this.getX()+5, this.getY()+(i+1)*15);
          }
        }
      }
      
    }
  }
} 


