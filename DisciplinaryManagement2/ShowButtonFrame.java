import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.*;

public class ShowButtonFrame extends JFrame{

    ShowButtonFrame(){




        JTextArea showArea = new JTextArea();

        showArea.setBounds(0,0,600,600);
        showArea.setFont(new Font("Comic sans MS",Font.PLAIN,15));


        JScrollPane scrollPane = new JScrollPane(showArea);
        scrollPane.setBounds(0,0,600,600);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setVisible(true);

        String showQuery = "select * from students";
        try{
            PreparedStatement ps = DisciplinaryManagement.con.prepareStatement(showQuery);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                showArea.append(rs.getString(1) + "    " + rs.getString(2) + "\t" + rs.getString(3) + "\t    " + rs.getString(4 ) + "\t" + rs.getString(5) + "\n");
            }
        }
        catch (Exception showButtonException){

        }



        JMenuBar showMenuBar = new JMenuBar();

        JMenu showAllMenu = new JMenu("ALL");
        showAllMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        showAllMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                String aecQuery = "select * from students ";
                try {
                    PreparedStatement allPst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet allRs = allPst.executeQuery();
                    showArea.setText("");
                    while (allRs.next()){
                        showArea.replaceSelection(allRs.getString(1)+"    "+ allRs.getString(2)+"\t"+allRs.getString(3)+"\t    " + allRs.getString(4 ) + "\t" + allRs.getString(5) +"\n");
                    }
                }
                catch(Exception aecException){

                }
            }@Override
            public void menuDeselected(MenuEvent e) {}@Override
            public void menuCanceled(MenuEvent e) {}
        });



        JMenu showAecMenu = new JMenu("AEC");
        showAecMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        showAecMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

                String aecQuery = "select * from students where college = \"aec\"";

                try {
                    PreparedStatement aecPst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet aecRs = aecPst.executeQuery();
                    showArea.setText("");
                    while (aecRs.next()){
                        showArea.replaceSelection(aecRs.getString(1)+"    "+ aecRs.getString(2)+"\t"+aecRs.getString(3)+"\t    "+aecRs.getString(4)+ "\t" +aecRs.getString(5)+"\n");
                    }
                }
                catch(Exception aecException){

                }
            }@Override
            public void menuDeselected(MenuEvent e) {}@Override
            public void menuCanceled(MenuEvent e) {}
        });


        JMenu showAcetMenu = new JMenu("ACET");
        showAcetMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        showAcetMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                String aecQuery = "select * from students where college = \"acet\"";
                try {
                    PreparedStatement acetPst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet acetRs = acetPst.executeQuery();
                    showArea.setText("");
                    while (acetRs.next()){
                        showArea.replaceSelection(acetRs.getString(1)+"    "+ acetRs.getString(2)+"\t"+acetRs.getString(3)+"\t    " + acetRs.getString(4 ) + "\t" + acetRs.getString(5) +"\n");
                    }
                }
                catch(Exception aecException){

                }
            }@Override
            public void menuDeselected(MenuEvent e) {}@Override
            public void menuCanceled(MenuEvent e) {}
        });


        JMenu showAcoeMenu = new JMenu("ACOE");
        showAcoeMenu.setFont(new Font("Comic sans MS",Font.PLAIN,15));
        showAcoeMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                String aecQuery = "select * from students where college = \"acoe\"";
                try {
                    PreparedStatement acoePst = DisciplinaryManagement.con.prepareStatement(aecQuery);
                    ResultSet acoeRs = acoePst.executeQuery();
                    showArea.setText("");
                    while (acoeRs.next()){
                        showArea.replaceSelection(acoeRs.getString(1)+"    "+ acoeRs.getString(2)+"\t"+acoeRs.getString(3)+"\t    " + acoeRs.getString(4 ) + "\t" + acoeRs.getString(5) +"\n");
                    }
                }
                catch(Exception aecException){

                }
            }@Override
            public void menuDeselected(MenuEvent e) {}@Override
            public void menuCanceled(MenuEvent e) {}
        });

        showMenuBar.add(showAllMenu);
        showMenuBar.add(showAecMenu);
        showMenuBar.add(showAcetMenu);
        showMenuBar.add(showAcoeMenu);


        showMenuBar.setVisible(true);
        showMenuBar.setBounds(0,0,580,60);


        setTitle("student data");
        setSize(620,620);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        add(scrollPane);
        setJMenuBar(showMenuBar);

    }

    public static void main(String[] args) {
        new ShowButtonFrame();
    }
}
