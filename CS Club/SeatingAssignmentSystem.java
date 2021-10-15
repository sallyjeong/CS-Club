import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [SeatingAssignmentSystem.java]
 * Description: Class for managing seating assignments for students such as assinging seats.
 * @author Jonathan, Ray, Wajeeh
 * @version 1.0, October 1st, 2021
 */

public class SeatingAssignmentSystem {
    
    // Number of students a table cam hold
    private int tableCapacity = 6;
  
    /**
     * arrangeStudent 
     * 
     * Arranges students into tables based on their grade, the groupthey are in, and friend preferences. 
     * An arraylist containing the students are passed into the method, which is then sorted and placed into tables. 
     * Studentsare grouped together by a comparator sort, comparing their grade and group.
     * It then runs an algorithim to find and group friend preferences together while remaing in their grade and group. 
     * Once it is done sorting, it stores the students in table arraylist found in floorPlanSystem.
     * 
     * @param floorPlanSystem, The floorPlanSystem object that contains the table arraylist
     * @param studentList,     The arraylist that contains the students
     */
    public void arrangeStudents(FloorPlanSystem floorPlanSystem, ArrayList<Student> studentList) {
        
     ArrayList<Student> groups = new ArrayList<Student>();
     
        // Sorting:
        this.sortGrades(studentList);
        this.sortGroups(studentList);
        this.groupByFriends(groups, studentList);
        studentList = groups;
        
        this.putIntoSeats(floorPlanSystem, studentList);
    }
    
    /**
     * sortGrades 
     * 
     * Sorts the inputed arraylist of Students by their grade.
     * 
     * @param studentList, The arraylist that contains the students
     */
    private void sortGrades(ArrayList<Student> studentList) {
        
        class GradeComparator implements Comparator<Student> {
            
            @Override
            public int compare(Student a, Student b) {
                return a.getGrade() - b.getGrade();
            }
            
        }
        
        Collections.sort(studentList, new GradeComparator());
        
    }
    
    /**
     * sortGroups 
     * 
     * Sorts the inputed arraylist of Students by their group, while keeping their grades sorted.
     * Each grade is sorted by group individually, preserving the original ordering by grade. 
     * The method will not function properly if the list has not been sorted by grades first.
     * 
     * @param studentList, The arraylist that contains the students
     */
    private void sortGroups(ArrayList<Student> studentList) {
        
        class GroupComparator implements Comparator<Student> {
            
            @Override
            public int compare(Student a, Student b) {
                return a.getGroup().compareTo(b.getGroup());
            }
            
        }
        
        // Keeping track of each grade as a section, with a start position and the int
        // value of the grade
        int currentGrade = studentList.get(0).getGrade();
        int startPos = 0;
        
        for (int i = 1; i < studentList.size(); i++) {
            if (studentList.get(i).getGrade() != currentGrade) {
                
                // Sort the grade through the section defined by startpost and i (i is not
                // inclusive)
                Collections.sort(studentList.subList(startPos, i), new GroupComparator());
                
                // Assign new starting position and grade value for the new grade section
                startPos = i;
                currentGrade = studentList.get(i).getGrade();
            }
        }
        
        // Sorting the last remaing section from the start of the section to the end of
        // the list
        Collections.sort(studentList.subList(startPos, studentList.size()), new GroupComparator());
    }
    
    /**
     * updateForFriends
     * 
     * loops through the sublist for each group to check if a friend is in the same group
     * If so, swaps the person behind for the friend
     * Only works if student arraylist is already sorted by grade and group
     * 
     * @param studentList, The arraylist that contains the students
     * @param groupList, The sublist for each group of students
     */
    private void updateForFriends(List<Student> groupList, ArrayList<Student> studentList) {
        for (int i = 0; i < groupList.size() - 1; i++) {
            int[] studentFriends = (groupList.get(i)).getFriendPreferences();
            
            for(int j = 0; j < studentFriends.length; j++) {
                int id = studentFriends[j];
                
                int friendInListIndex = isIdInList(id, groupList);
                
                if (friendInListIndex > 0) {
                    Collections.swap(groupList, i+1, friendInListIndex);
                }
            }
        }
    }
    
    /**
     * isIdInList
     * 
     * Checks if the friend of the student is in the same group
     * 
     * @param id, the id of the friend
     * @param groupList, The sublist for each group of students
     * @return i, the index of the friend if friend is in group
     * @return -1, if friend is not in group
     */   
    private int isIdInList(int id, List<Student> groupList) {
        for (int i = 0; i < groupList.size(); i++) {
            if (id == (groupList.get(i)).getId()){
                return i;
            }
        }
        
        return -1;
    }
  
    /**
     * handleSameGradeAndGroup
     * 
     * Method that creates the sublists for each group and then calls the method that sorts it
     * 
     * @param groupName, the name of the group the student is in
     * @param gradeNum, the grade that the student is in
     * @param startingIndex, the starting index of the sublist
     * @param endingIndex, the ending index of the sublist
     * @param groups, the temporary arraylist that stores the sorted students
     * @param studentList, the list of students
     */
    private void handleSameGradeAndGroup(String groupName, int gradeNum, int startingIndex, int endingIndex, ArrayList<Student> groups, ArrayList<Student> studentList) {
        
        List<Student> groupList = studentList.subList(startingIndex, endingIndex);
        updateForFriends(groupList, studentList);
        groups.addAll(groupList);
        
    }
    
    /**
     * groupByFriends
     * 
     * Method that determines the indexes for the group sublists and then calls handleSameGradeAndGroup to create the sublist
     * 
     * @param groups, the temporary arraylist that stores the sorted students
     * @param studentList, the list of students
     */
    private void groupByFriends(ArrayList<Student> groups, ArrayList<Student> studentList) {
        int startingIndex = 0;
        int endingIndex = 0;
        
        String groupName = (studentList.get(0)).getGroup();
        int gradeNum = (studentList.get(0)).getGrade();
        int i = 0;
        
        while (i < studentList.size()) {
            String curGroupName = (studentList.get(i)).getGroup();
            int curGradeNum = (studentList.get(i)).getGrade();
            
            if (curGroupName.equals(groupName) && curGradeNum == gradeNum) {
                endingIndex = i+1;
            } else {
                handleSameGradeAndGroup(groupName, gradeNum, startingIndex, endingIndex, groups, studentList);
                
                startingIndex = endingIndex;
                endingIndex = i+1;
                gradeNum = curGradeNum;
                groupName = curGroupName;
                
            }
            
            if (endingIndex >= studentList.size()) {
                handleSameGradeAndGroup(groupName, gradeNum, startingIndex, endingIndex, groups, studentList);
            }
            
            i++;
        }
    }
    
    /**
     * putIntoSeats 
     * 
     * Puts the students from the inputed arraylist into tables stored in floorPlanSystem
     * Students are placed into tables one by one, with new tables being created once it meets one of the conditions:
     *  1. The table is filled to capacity which is dependent on the variable tableCapacity.
     *  2. There are no more students in the same grade.
     *  3. There are no more students in the same group.
     * This loop continues until it has placed all students.
     * The method will not function properly if the student arraylist has not been fully sorted by group and grade.
     *
     * @param floorPlanSystem, The floorPlanSystem object that contains the table arraylist
     * @param studentList,     The arraylist that contains the students
     */
    private void putIntoSeats(FloorPlanSystem floorPlanSystem, ArrayList<Student> studentList) {
        
        floorPlanSystem.getTableList().clear();
        
        //assigning the first table to be the values of the first student
        int currentGrade = studentList.get(0).getGrade();
        String currentGroup = studentList.get(0).getGroup();
        int currentTable = 0;
        
        //Creating first table with first student in it
        floorPlanSystem.addTable(new Table(currentTable, currentGroup, tableCapacity));
        floorPlanSystem.getTableList().get(currentTable).addStudent(studentList.get(0));
        
        int nextEmptySeat = 1;
        
        for (int i = 1; i < studentList.size(); i++) {
            
            //If there is no more students in the same grade or group
            if ( (currentGrade != studentList.get(i).getGrade()) || (!currentGroup.equals(studentList.get(i).getGroup())) ) {
                
                //A new table should be created as long as the current table is not empty
                if (nextEmptySeat != 0) {
                 currentTable++;
                    floorPlanSystem.addTable(new Table(currentTable, studentList.get(i).getGroup(), tableCapacity));
                }
                
                //Placing the new student and changing the current grade and group
                floorPlanSystem.getTableList().get(currentTable).addStudent(studentList.get(i));
                currentGrade = studentList.get(i).getGrade();
                currentGroup = studentList.get(i).getGroup();
                nextEmptySeat = 1;
                
            } else if (nextEmptySeat == tableCapacity - 1) { //If there is only one spot from reaching maximum capacity
               
         //New Table
         currentTable++;
             floorPlanSystem.addTable(new Table(currentTable, studentList.get(i).getGroup(), tableCapacity));
             
             
             
             floorPlanSystem.getTableList().get(currentTable).addStudent(studentList.get(i));
             
                
             nextEmptySeat = 0;
                
            } else { //The condition has not been met and will continue to fill up the table with students
                
             //Put student into tale 
             floorPlanSystem.getTableList().get(currentTable).addStudent(studentList.get(i));         
                nextEmptySeat++;
            }
            
        }
        
        //Loop through the table arraylist to double check and remove any empty tables
        for (Table a: floorPlanSystem.getTableList()) {
         if (a.isEmpty()) {
          floorPlanSystem.getTableList().remove(a.getID());
         } 
        }
        
}
 
    
    /**
     * displayMembers 
     * 
     * Display memebers of the group.
     * 
     * @param groupName, The name of the group that its members are to be displayed
     * @param studentList, The arraylist that contains the students
     */
    public void displayMembers(String groupName, ArrayList<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getGroup().equals(groupName)) {
                System.out.println(studentList.get(i));
            }
        }
    }
    
    public int getTableCapacity() {
        return tableCapacity;
    }
    
    public void setTableCapacity(int tableCapacity) {
        this.tableCapacity = tableCapacity;
    }
    
}