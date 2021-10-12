package GUI;


//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


class RemoveStudent {
    public static void main(String args[]) {
        //Creating the Frame
        JFrame frame = new JFrame("Remove Student");

        //  frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setBounds(0, 0, 400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(15, 15, 370, 100);
        //panel.setBackground(Color.gray);
        //panel.setBorder(BorderFactory.createLineBorder(Color.blue));
        TitledBorder title = BorderFactory.createTitledBorder("Remove Student");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        //LABELS ------------------------

        //name label
        JLabel studentNumLabel = new JLabel("Student #:");
//        studentNumLabel.setBounds(30, 50, 90, 20);
        panel.add(studentNumLabel);
        //frame.add(nameLabel);

        //FIELDS ------------------------
        JTextField studentID = new JTextField(15);
//        studentID.setBounds(100, 50, 200, 20);
        //frame.getContentPane().add(name);
        panel.add(studentID);
        //name.setColumns(10);
        // store name.getText();



        //LAYOUT CONSTRAINTS----------------
        //name
        layout.putConstraint(SpringLayout.WEST, studentNumLabel, 15, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, studentNumLabel, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, studentID, 5, SpringLayout.EAST, studentNumLabel);
        layout.putConstraint(SpringLayout.NORTH, studentID, 21, SpringLayout.NORTH, panel);

        //SUBMIT BUTTON-----------------

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Data Submitted");
            }
        });
        btnSubmit.setBounds(150, 400, 90, 20);
        frame.getContentPane().add(btnSubmit);
        frame.setVisible(true);

        frame.add(panel);
        frame.setSize(400,600);

    }
}


