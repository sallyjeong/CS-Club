// *** imports *** //
import java.util.Comparator;

/**
 * SortByName.java
 * A class that implements Comparator to sort Student objects alphabetically by name
 * @author Katherine Liu, Rachel Liu, Sally Jeong
 * @version Oct 13, 2021
 */
public class SortByName implements Comparator<Student> {
  /**
   * compare
   * compares the name of Students alphabetically
   * @param studentA The first Student being compared
   * @param studentB The second Student being compared
   * @return a negative integer, zero, or a positive integer 
   *         as the first argument is less than, equal to, or greater than the second 
   */
  @Override
  public int compare(Student studentA, Student studentB){
    return studentA.getName().compareTo(studentB.getName());
  }
}