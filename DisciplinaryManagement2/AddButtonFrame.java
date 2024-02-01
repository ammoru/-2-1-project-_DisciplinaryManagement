import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddButtonFrame extends JFrame {

    AddButtonFrame(){



        JLabel addLabel = new JLabel("ADD STUDENT DATA");
        addLabel.setBounds(80,30,300,50);
        addLabel.setFont(new Font("Comic sans MS",Font.BOLD,25));


        JLabel nameLabel = new JLabel("Name     : ");
        nameLabel.setBounds(50,100,150,50);
        nameLabel.setFont(new Font("Comic sans MS",Font.ITALIC,25));

        JTextField nameField = new JTextField();
        nameField.setBounds(200,110,200,35);



        JLabel rollLabel = new JLabel("Roll No   : ");
        rollLabel.setBounds(50,170,150,50);
        rollLabel.setFont(new Font("Comic sans MS",Font.ITALIC,25));

        JTextField rollField = new JTextField();
        rollField.setBounds(200,180,200,35);

        JLabel collegeLabel = new JLabel("College   : ");
        collegeLabel.setBounds(50,240,150,50);
        collegeLabel.setFont(new Font("Comic sans MS",Font.ITALIC,25));

        JTextField collegeField = new JTextField();
        collegeField.setBounds(200,250,200,35);

        JLabel actLabel = new JLabel("Action    : ");
        actLabel.setBounds(50,310,150,50);
        actLabel.setFont(new Font("Comic sans MS",Font.ITALIC,25));

        JTextField actField = new JTextField();
        actField.setBounds(200,320,200,35);


        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(40,400,180,40);
        clearButton.setFont(new Font("Comic sans MS",Font.PLAIN,20));
        clearButton.setFocusable(false);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                rollField.setText("");
                collegeField.setText("");
                actField.setText("");

            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(240,400,180,40);
        submitButton.setFont(new Font("Comic sans MS",Font.PLAIN,20));
        submitButton.setFocusable(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String rollNo = rollField.getText().trim();
                String college = collegeField.getText().trim();
                String act = actField.getText().trim();
                String insertQuery = "INSERT INTO student_data VALUES(?,?,?,?,?)";
                String countQuery = "SELECT roll_number, COUNT(*) FROM student_data where roll_number = \""+ rollNo +"\" GROUP BY roll_number";
                String addIntoTerminatedQuery = "INSERT INTO terminated_students VALUES(?,?,?)";

                try{
                    PreparedStatement countPst = DisciplinaryManagement.con.prepareStatement(countQuery);
                    ResultSet countRs = countPst.executeQuery();
                    while(countRs.next())
                    {
                        int cnt = Integer.parseInt(countRs.getString(2)) ;
                        System.out.println(cnt);
                        if (cnt == 2){
                            try {
                                PreparedStatement terminatedStudentsQuery = DisciplinaryManagement.con.prepareStatement(addIntoTerminatedQuery);
                                terminatedStudentsQuery.setString(1, name);
                                terminatedStudentsQuery.setString(2, rollNo);
                                terminatedStudentsQuery.setString(3, college);

                                terminatedStudentsQuery.executeUpdate();

                            }
                            catch (Exception terminatedException){
                                System.out.println("Entered into terminated catch block");
                            }
                            JOptionPane.showMessageDialog(null,"you are terminated");
                        }
                        else if (cnt > 2){
                            JOptionPane.showMessageDialog(null,"already terminated");
                        }
                    }
                }
                catch (Exception showButtonException){

                }

                if (name.equals("") || rollNo.equals("") || college.equals("") || act.equals("")) {
                        JOptionPane.showMessageDialog(null,"Provided null values");
                }
                else {
//                    PreparedStatement countPst = DisciplinaryManagement.con.prepareStatement(countQuery);
//                    ResultSet countRs = countPst.executeQuery();
                    try {

                            PreparedStatement pst = DisciplinaryManagement.con.prepareStatement(insertQuery);
                            pst.setString(1, "0");
                            pst.setString(2, name);
                            pst.setString(3, rollNo);
                            pst.setString(4, college);
                            pst.setString(5, act);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Submitted successfully");
                            



                    } catch (Exception e2) {
                        System.out.println(e2);
//                        JOptionPane.showMessageDialog(null, "please check there is an error");
                    }
                }
                nameField.setText("");
                rollField.setText("");
                collegeField.setText("");
                actField.setText("");
            }
        });

        setTitle("Add student data");
        setSize(500,500);
//        setDefaultCloseOperation();
        setLayout(null);
        setVisible(true);
        setResizable(false);
        add(addLabel);
        add(nameLabel);
        add(rollLabel);
        add(collegeLabel);
        add(actLabel);
        add(nameField);
        add(rollField);
        add(collegeField);
        add(actField);
        add(clearButton);
        add(submitButton);
    }

    public static void main(String[] args) {
        new AddButtonFrame();
    }
}
