/**
 * SystemManager.java
 * Calls the main components of the code to run 
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class SystemManager {
  public static EnrollmentSystem enrolment = new EnrollmentSystem();
  public SeatingPlanSystem seatingPlan = new SeatingPlanSystem();
  public FloorPlan floorPlan = new FloorPlan();

  // *** main method to open the start menu *** //
  public static void main(String[] args){
    displayChoices();
  }

  /**
   * displayChoices
   * This method displays the actions available to the user by opening a menu
   */
  public static void displayChoices(){
   new Menu(enrolment);
  }
}