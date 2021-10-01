import javax.swing.*;
class gui{
    public static void main(String args[]){
       JFrame frame = new JFrame("CS Club Enrollment");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500,500);
       JButton button1 = new JButton("Start");
       frame.getContentPane().add(button1); // Adds Button to content pane of frame
       frame.setVisible(true);
    }
}