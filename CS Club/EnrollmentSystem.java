// *** imports *** //
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


/**
 * EnrollmentSystem.java
 * The main program to run the Enrollment System
 * Reads and stores information in a file
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class EnrollmentSystem {
  /*
   * variables
   */
  private static ArrayList<Student> studentList = new ArrayList<>();
  public static File member= new File("member.txt");
  
  /**
   * EnrollmentSystem
   * This constructor ensures the system has all previous members of the club by reading through the file
   */
  EnrollmentSystem () {
    readFile();
  }
  
  /**
   * getStudentList
   * This method returns the variable "studentList" containing all members of the club
   * @return the master list of students in the club
   */
  public ArrayList<Student> getStudentList() {
    return studentList;
  }
  
  /**
   * readFile
   * This method reads the file containing member information and 
   * translates the data into the Student ArrayList
   */
  public void readFile() {
    try {
      Scanner readFile = new Scanner (member);
      String[]array = new String[7];
      String line;
      
      while (readFile.hasNextLine()) {
        line = readFile.nextLine();
        
        for(int i = 0; i< array.length; i++) {
          int index = line.indexOf('|');
          array[i]=line.substring(0,index);
          line = line.substring(index+1);
        }
        
        addStudent(new Student(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[3]), array[2],
                               Integer.parseInt(array[4]), Integer.parseInt(array[5]), Integer.parseInt(array[6])));
      }
      readFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }
    
  }
  
  /**
   * displayStudents
   * This method ouptuts the data from the Student ArrayList into a text file
   * in order to store the information for future use
   * @throws FileNotFoundException in order to also write a new .txt file if necessary/the first time running the code
   */
  public void displayStudents() throws FileNotFoundException {
    PrintWriter output = new PrintWriter(member);
    for (int i = 0; i<studentList.size(); i++) {
      output.println(studentList.get(i));
    }
    output.close();
  }
  
  /**
   * addStudent
   * This method adds a Student to the master list studentList
   * @param student The student that has joined the CS club
   * @return true if the process was successful
   */
  public boolean addStudent(Student student){
    studentList.add(student);
    try {
      displayStudents();
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }
    return true;
  }
  
  /**
   * removeStudent
   * This method removes a Student from the master list studentList after checking that they exist
   * @param id The student number of the student that is in CS club
   * @return true if the process was successful (student was found in the list), false otherwise
   */
  public boolean removeStudent(int id){
    for (int i = 0; i<studentList.size(); i++){
      if (studentList.get(i).getId() == id) {
        studentList.remove(i);
        try {
          displayStudents();
        } catch (FileNotFoundException e) {
          System.out.println("File Not Found");
        }
        return true;
      }
    }
    return false;
  }
  
}