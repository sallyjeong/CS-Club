public class Student {
    private String name;
    private int id;
    private int grade;
    private int[] friendPreferences = new int[3];
    private String group;
    
    Student (String name, int id, int grade, int[]friendPreferences, String group) {
        this.name = name;
        this.id = id;
        this.group = group;
        this.grade = grade;
        this.friendPreferences = friendPreferences;
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

    

    public String toString() {
      // String groupName="";
      // if (group == 0) {
      //   groupName = "game dev";
      // } else if (group == 1) {
      //   groupName = "web dev";
      // } else if (group == 2) {
      //   groupName = "competitive";
      // }
      return "Name: " + name + " | ID: " + id + " | Group: " + group;
    }

    

}