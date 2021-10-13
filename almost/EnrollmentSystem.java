import java.util.ArrayList;

public class EnrollmentSystem {
    private ArrayList<Student> studentList = new ArrayList<>();
    
    EnrollmentSystem () {
    }

    public void addStudent(Student student){     
        studentList.add(student);
    }

    public boolean removeStudent(int id){
      for (int i = 0; i<studentList.size(); i++){
        if (studentList.get(i).getId() == id) {
          studentList.remove(i);
          return true;
        }
      }
      return false;
    }

    public void displayStudents(){
      // idk if we need this? cause it'll be in the JTable pages
      for (int i = 0; i < studentList.size(); i++) {
        System.out.println(studentList.get(i));
      }
    }
  
    public ArrayList<Student> getStudentList() {
      return studentList;
    }
}