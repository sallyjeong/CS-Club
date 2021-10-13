
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class EnrollmentSystem {
    private ArrayList<Student> studentList = new ArrayList<>();
    public static File member= new File("member.txt");
//    PrintWriter output = new PrintWriter(member);

    EnrollmentSystem () {
        readFile();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    
    public void readFile() {
        try {
            // File member= new File("member.txt");
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

//                for(int i = 0; i< array.length; i++) {
//                  if ((i == 1) || (i == 3) || (i == 4) || (i == 5) || (i == 6)) {
//                    System.out.println(Integer.parseInt(array[i]));
//                  } else {
//                    System.out.println(array[i]);
//                  }
//                }
                
                addStudent(new Student(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[3]), array[2],
                        Integer.parseInt(array[4]), Integer.parseInt(array[5]), Integer.parseInt(array[6])));
            }
            readFile.close();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }

    }
    
    public void displayStudents() throws FileNotFoundException {
        PrintWriter output = new PrintWriter(member);
        for (int i = 0; i<studentList.size(); i++) {
            output.println(studentList.get(i));
        }
        output.close();
    }

    public boolean addStudent(Student student){
        studentList.add(student);
        try {
            displayStudents();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return true;
    }

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