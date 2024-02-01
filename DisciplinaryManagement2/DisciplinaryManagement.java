import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class DisciplinaryManagement extends JFrame {

    // connecting database
    static Connection con;
    DisciplinaryManagement(){

        try {
            String url = "jdbc:mysql://localhost:3306/disciplinary_management";
            String user = "root";
            String pass = "Thinkmore@44";
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }


        JLabel DLabel = new JLabel();
        DLabel.setText("Disciplinary Management");
        DLabel.setFont(new Font("Comic sans MS",Font.BOLD,30));
        DLabel.setBounds(130,30,400,100);

        JButton showButton = new JButton("Show Data");
        showButton.setBounds(30,150,170,50);
        showButton.setFocusable(false);
        showButton.setFont(new Font("Comic sans MS",Font.ITALIC,18));

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new ShowButtonFrame();
            }
        });



        JButton addButton  = new JButton("Add Data");
        addButton.setBounds(230,150,170,50);
        addButton.setFocusable(false);
        addButton.setFont(new Font("Comic sans MS",Font.ITALIC,18));




        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddButtonFrame();
            }
        });


        JButton terminatedButton = new JButton("Terminated Data");
        terminatedButton.setBounds(430,150,180,50);
        terminatedButton.setFocusable(false);
        terminatedButton.setFont(new Font("Comic sans MS",Font.ITALIC,18));
//        terminatedButton.setForeground(Color.red);

        terminatedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TerminatedDataFrame();
            }
        });


        setTitle("Disciplinary Management");
        setSize(650,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        add(DLabel);
        add(showButton);
        add(addButton);
        add(terminatedButton);

    }

    public static void main(String[] args) {
        new DisciplinaryManagement();
    }
}
