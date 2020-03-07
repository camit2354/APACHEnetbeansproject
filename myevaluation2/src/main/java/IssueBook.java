import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



class IssueBook extends JFrame
{
    int noofrows=0;
    int i=0;
    ResultSet rs;

    public IssueBook()
    {



        try{
            Class.forName("com.mysql.jdbc.Driver");


            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb","root","camit2354");
            String query1 ="SELECT COUNT(*) FROM bookdata";


            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(query1);
            rs.next();
            noofrows = rs.getInt(1);

            String query2 ="select * from bookdata";
            rs=stmt.executeQuery(query2);







            // JLabel[] labels=new JLabel[noofrows];
            JCheckBox[] checkBoxes = new JCheckBox[noofrows];
            JButton deleteuser = new JButton("ISSUE-BOOK");

            JPanel panel = new JPanel() ;
            panel.setLayout(new GridBagLayout());
            panel.setBorder(new EmptyBorder(20, 20, 20, 20));
            Border border;



            GridBagConstraints c = new GridBagConstraints();
            c.insets= new Insets(5,5,0,5);
            c.fill=GridBagConstraints.HORIZONTAL;

            System.out.println("********************\n"+noofrows+"********************\n");

            for(i=0;i<noofrows;i++)
            {
                rs.next();

                String str = "";  //+"--"
                str = str + rs.getNString(2) +"   "+ rs.getNString(3) +"     "+ rs.getNString(4)+"    " ;
                System.out.println("********************\n"+str+"********************\n");

                checkBoxes[i] = new JCheckBox(str);


                c.gridx=0;
                c.gridy=i;
                c.anchor=GridBagConstraints.LINE_END;
                border = BorderFactory.createLineBorder(Color.BLACK, 2);
                checkBoxes[i].setBorder(border);
                panel.add(checkBoxes[i],c);


            }


            c.gridx=0;
            c.gridy=i;
            c.anchor=GridBagConstraints.LINE_END;
            border = BorderFactory.createLineBorder(Color.BLACK, 2);
            panel.add(deleteuser,c);

            deleteuser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {

                    try{
                        Class.forName("com.mysql.jdbc.Driver");


                        Connection con1=DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/demodb","root","camit2354");
                        String query2 ="select * from bookdata";

                        Statement stmt=con1.createStatement();
                        ResultSet rs1 ;
                        rs1=stmt.executeQuery(query2);



                        for(i=0;i<noofrows;i++)
                        {   rs1.next();

                            if(checkBoxes[i].isSelected())
                            {
                                new DeleteBookPage(rs1.getInt(1));
                               // dispose();
                            }

                        }

                        int choice =  JOptionPane.showConfirmDialog(null,"selected  books are issued\n do you want issue another", "issuebookpage ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                        switch(choice)
                        {
                            case JOptionPane.YES_OPTION :
                                new IssueBook();
                                dispose();
                                break;

                            case JOptionPane.NO_OPTION :
                                System.exit(0);

                                break;


                            case JOptionPane.CLOSED_OPTION :
                                new StartPage();
                                dispose();
                                break;
                        }

                        con1.close();

                    }catch(Exception e)
                    { System.out.println(e);}




                }
            });

            add(panel);

            con.close();

        }catch(Exception e)
        { System.out.println(e);}




        setTitle("ISSUE -BOOK -DATA");
        setVisible(true);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
//
//    public static void main(String[] args)
//    {
//        new IssueBook();
//    }


}

