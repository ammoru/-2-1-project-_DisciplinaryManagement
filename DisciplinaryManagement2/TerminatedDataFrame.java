import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TerminatedDataFrame extends JFrame {

    TerminatedDataFrame(){


        JTextArea terminatedArea = new JTextArea();

        JScrollPane tScrollPane = new JScrollPane(terminatedArea);
        tScrollPane.setBounds(0,0,600,600);
        tScrollPane.setVisible(true);

        terminatedArea.setBounds(0,0,600,600);
        terminatedArea.setFont(new Font("Comic sans Ms",Font.PLAIN,15));

        String showTerminatedQuery = "select * from terminated_students";
        try{
            PreparedStatement terminatedPs = DisciplinaryManagement.con.prepareStatement(showTerminatedQuery);
            ResultSet terminatedRs = terminatedPs.executeQuery();
            terminatedArea.setText("");
            while(terminatedRs.next())
            {
                terminatedArea.replaceSelection(terminatedRs.getString(1) + "\t" + terminatedRs.getString(2) + "\t    " + terminatedRs.getString(3)+"\n");
            }
        }
        catch (Exception showButtonException){

        }

        JMenuBar terminatedMenuBar = new JMenuBar();



        JMenu aecMenu = new JMenu("AEC");
        aecMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        aecMenu.setBounds(120,0,100,60);
        aecMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

//                terminatedArea.setText("AEC");
                String aecQuery = "select * from terminated_students where college = \"aec\"";

                try {
                    PreparedStatement aecPst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet aecRs = aecPst.executeQuery();
                    terminatedArea.setText("");
                    while (aecRs.next()){
                        terminatedArea.replaceSelection(aecRs.getString(1)+"\t"+ aecRs.getString(2)+"\t    "+aecRs.getString(3)+"\n");
                    }
                }
                catch(Exception aecException){

                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        JMenu acetMenu = new JMenu("ACET");
        acetMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        acetMenu.setBounds(240,0,100,60);
        acetMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                terminatedArea.setText("acet");
                String aecQuery = "select * from terminated_students where college = \"acet\"";
                try {
                    PreparedStatement acetPst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet acetRs = acetPst.executeQuery();
                    terminatedArea.setText("");
                    while (acetRs.next()){
                        terminatedArea.replaceSelection(acetRs.getString(1)+"\t"+ acetRs.getString(2)+"\t    "+acetRs.getString(3)+"\n");
                    }
                }
                catch(Exception aecException){

                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        JMenu acoeMenu = new JMenu("ACOE");
        acoeMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        acoeMenu.setBounds(360,0,100,60);
        acoeMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                terminatedArea.setText("acoe");
                String aecQuery = "select * from terminated_students where college = \"acoe\"";
                try {
                    PreparedStatement acoePst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet acoeRs = acoePst.executeQuery();
                    terminatedArea.setText("");
                    while (acoeRs.next()){
                        terminatedArea.replaceSelection(acoeRs.getString(1)+"\t"+ acoeRs.getString(2)+"\t    "+acoeRs.getString(3)+"\n");
                    }
                }
                catch(Exception aecException){

                }
            }


            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        JMenu allMenu = new JMenu ("ALL");
        allMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        allMenu.setBounds(0,0,100,60);
        allMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                terminatedArea.setText("all");
                String aecQuery = "select * from terminated_students ";
                try {
                    PreparedStatement allPst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet allRs = allPst.executeQuery();
                    terminatedArea.setText("");
                    while (allRs.next()){
                        terminatedArea.replaceSelection(allRs.getString(1)+"\t"+ allRs.getString(2)+"\t    "+allRs.getString(3)+"\n");
                    }
                }
                catch(Exception aecException){

                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        terminatedMenuBar.add(allMenu);
        terminatedMenuBar.add(aecMenu);
        terminatedMenuBar.add(acetMenu);
        terminatedMenuBar.add(acoeMenu);


        terminatedMenuBar.setVisible(true);
        terminatedMenuBar.setBounds(0,0,620,60);


        setSize(620,620);
        setTitle("Terminated Students data");
        setVisible(true);
        setLayout(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(tScrollPane);
        setJMenuBar(terminatedMenuBar);
        setResizable(false);


    }

    public static void main(String[] args) {
        new TerminatedDataFrame();
    }
}

