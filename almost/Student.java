public class Student {
    private String name;
    private int id;
    private int grade;
    private String group;
    private int[] friendPreferences = new int[3];
    
    Student (String name, int id, int grade, String group, int friend1, int friend2, int friend3) {
      this.name = name;
      this.id = id;
      this.group = group;
      this.grade = grade;
      this.friendPreferences[0] = friend1;
      this.friendPreferences[1] = friend2;
      this.friendPreferences[2] = friend3;
    }
    
    public int getId(){
      return id;
    }
    
    public String getName(){
      return name;
    }
    
    public String getGroup(){
      return group;
    }
    
    public int getGrade(){
      return grade;
    }
    
    public void setId(int id){
      this.id = id;
    }
    
    public void setName(String name){
      this.name = name;
    }
    
    public void setGroup(String group){
      this.group = group;
    }
    
    public void setGrade(int grade){
      this.grade = grade;
    }
    
    // public String toString() {
    //   return "Name: " + name + " | ID: " + id + " | Group: " + group;
    // }
    
    public String[] studentInfo() {
      String[] info = new String[] {name, id+"", group, grade+""};
      return info;
    }

    // @Override
    // public int compareTo(Student s) {
    //     return this.name.compareTo(s.getName());
    // }
  }
