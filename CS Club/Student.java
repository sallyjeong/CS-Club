/**
 * Student.java
 * A class representing all Students and their attributes
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */

public class Student {
  // *** variables *** //
  private String name;
  private int id;
  private int grade;
  private String group;
  private int[] friendPreferences = new int[3];
  
  /**
   * AddStudent
   * This constructor ensures each student is created with the necessary components
   * @param name The name of the student
   * @param id The student number of the student
   * @param grade The grade of the student (9,10,11,12)
   * @param group The group in CS club the student is in (intro, web, contest)
   * @param friend1 The student number of a friend
   * @param friend2 The student number of a friend
   * @param friend3 The student number of a friend
   */
  Student (String name, int id, int grade, String group, int friend1, int friend2, int friend3) {
    this.name = name;
    this.id = id;
    this.group = group;
    this.grade = grade;
    this.friendPreferences[0] = friend1;
    this.friendPreferences[1] = friend2;
    this.friendPreferences[2] = friend3;
  }

  /**
   * getId
   * This method extracts and returns the private variable "id" 
   * @return The id of the Student
   */ 
  public int getId(){
    return id;
  }
  
  /**
   * getName
   * This method extracts and returns the private variable "name" 
   * @return The name of the Student
   */ 
  public String getName(){
    return name;
  }
  
  /**
   * getGroup
   * This method extracts and returns the private variable "group" 
   * @return The group of the Student
   */ 
  public String getGroup(){
    return group;
  }
  
  /**
   * getGrade
   * This method extracts and returns the private variable "grade" 
   * @return The grade of the Student
   */ 
  public int getGrade(){
    return grade;
  }
  
  /**
   * getFriendPreferences
   * This method extracts and returns the private variable "friendPreferences" 
   * @return The friends of the Student
   */ 
  public int[] getFriendPreferences(){
    return friendPreferences;
  }
  
  /**
   * setId
   * This method changes the private variable "id" 
   * @param id The new student number for the Student
   */ 
  public void setId(int id){
    this.id = id;
  }
  
  /**
   * setName
   * This method changes the private variable "name" 
   * @param name The new name for the Student
   */
  public void setName(String name){
    this.name = name;
  }
  
  /**
   * setGroup
   * This method changes the private variable "group" 
   * @param group The new group for the Student
   */
  public void setGroup(String group){
    this.group = group;
  }
  
  /**
   * setGrade
   * This method changes the private variable "grade" 
   * @param grade The new grade for the Student
   */
  public void setGrade(int grade){
    this.grade = grade;
  }
  
  /**
   * toString
   * This method changes output when printing a Student object to include information
   * @return The string including all student information
   */
  @Override
  public String toString() {
    return name+"|"+id+"|"+group+"|"+grade+"|"+friendPreferences[0]+"|"+friendPreferences[1]+"|"+friendPreferences[2]+"|";
  }
  
  /**
   * studentInfo
   * This method creates and returns an array including basic student information
   * @return The string array including student information for public display
   */
  public String[] studentInfo() {
    String[] info = new String[] {name, id+"", group, grade+""};
    return info;
  }
}
