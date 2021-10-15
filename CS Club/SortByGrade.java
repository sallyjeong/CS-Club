// *** imports *** //
import java.util.Comparator;

/**
 * SortByGrade.java
 * A class that implements Comparator to sort Student objects by ascending grade
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class SortByGrade implements Comparator<Student> {
  /**
   * compare
   * compares the grade of Students
   * @param studentA The first Student being compared
   * @param studentB The second Student being compared
   * @return The difference between the grades (a negative integer, zero, or a positive integer 
   *         as the first argument is less than, equal to, or greater than the second)
   */
  @Override
  public int compare(Student studentA, Student studentB){
    return studentA.getGrade() - studentB.getGrade();
  }
}
