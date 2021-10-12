public class SystemManager {
  EnrollmentSystem enrollment = new EnrollmentSystem();
  SeatingPlanSystem seatingPlan = new SeatingPlanSystem();
  FloorPlan floorPlan = new FloorPlan();

public static void main(String[] args){
  displayChoices();
}

public static void displayChoices(){
  new menu2();
}