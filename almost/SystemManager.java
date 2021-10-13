public class SystemManager {
    public static EnrollmentSystem enrolment = new EnrollmentSystem();
   // SeatingPlanSystem seatingPlan = new SeatingPlanSystem();
   // FloorPlan floorPlan = new FloorPlan();
  
    public static void main(String[] args){
      displayChoices();
    }
  
    public static void displayChoices(){
     new Menu(enrolment);
    }
  }