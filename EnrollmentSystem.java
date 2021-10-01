import java.util.ArrayList;

public class EnrollmentSystem {
    private ArrayList<Student> studentList = new ArrayList<>();
    
    EnrollmentSystem () {
        //fillGroups();
    }

    public void addStudent(Student student){     
        studentList.add(student);
    }

    public void removeStudent(int id){
      for (int i = 0; i<studentList.size(); i++){
        if (studentList.get(i).getId() == id) {
          studentList.remove(i);
        }
      }
    }

    public void displayStudents(){
      for (int i = 0; i < studentList.size(); i++) {
        System.out.println(studentList.get(i));
      }
    }

    public ArrayList getStudentList() {
      return studentList;
    }
    // public void fillGroups() {
    //   // edit constructor parameter
    // Group gameDev = new Group("game development");
    // Group webDev = new Group("web development");
    // Group competitive = new Group("Competitive programming");

    // groupList.add(gameDev, webDev, competitive);
    // }

}