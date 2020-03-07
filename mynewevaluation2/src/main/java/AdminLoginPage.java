import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class AdminLoginPage extends JFrame


{


    public AdminLoginPage(String s1,String s2)
    {
        JPanel panel = new JPanel() ;

        JLabel unTF,fnTF,lnTF,emailTF,mnTF,passTF;

        JLabel unlabel,fnlabel,lnlabel,emaillabel,mnlabel,passlabel,mainlabel;
        JButton showuserdata ;





        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));


        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(5,5,0,5);
        c.fill=GridBagConstraints.HORIZONTAL;





        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb","root","camit2354");

            String query ="select * from admindata   WHERE `username` = ? AND `password` = ? ";

            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setString(1,s1);
            stmt.setString(2,s2);

            //  ResultSet rs=stmt.executeQuery("select * from userdata");   //select * FROM userdata WHERE `username` = "ami2354" AND `password` ="camit2354";
            ResultSet rs=stmt.executeQuery();












            mainlabel =new JLabel("ADMIN -DATABASE-INFORMATION-AVAILABLE");

            unlabel=new JLabel("ADMIN-NAME");
            passlabel=new JLabel("PASS-WORD");
            fnlabel=new JLabel("FIRST-NAME");
            lnlabel=new JLabel("LAST-NAME");
            emaillabel=new JLabel("EMAIL-ADDRESS");
            mnlabel=new JLabel("MOBILE-NO");

            showuserdata =new JButton("let's-see-users-data");


            if(rs.next())
            {
                unTF = new JLabel(rs.getString(4));
                passTF =new JLabel(rs.getString(5));
                fnTF= new JLabel(rs.getString(2));
                lnTF=new JLabel(rs.getString(3));
                emailTF= new JLabel(rs.getString(6));
                mnTF= new JLabel(rs.getString(7));




                c.gridx=0;
                c.gridy=0;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(mainlabel,c);


                c.gridx=0;
                c.gridy=1;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(unlabel,c);

                c.gridx=1;
                c.gridy=1;
                c.anchor=GridBagConstraints.LINE_START;

                panel.add(unTF,c);



                c.gridx=0;
                c.gridy=2;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(passlabel,c);

                c.gridx=1;
                c.gridy=2;
                c.anchor=GridBagConstraints.LINE_START;

                panel.add(passTF,c);



                c.gridx=0;
                c.gridy=3;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(fnlabel,c);

                c.gridx=1;
                c.gridy=3;
                c.anchor=GridBagConstraints.LINE_START;

                panel.add(fnTF,c);




                c.gridx=0;
                c.gridy=4;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(lnlabel,c);

                c.gridx=1;
                c.gridy=4;
                c.anchor=GridBagConstraints.LINE_START;

                panel.add(lnTF,c);




                c.gridx=0;
                c.gridy=5;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(emaillabel,c);

                c.gridx=1;
                c.gridy=5;
                c.anchor=GridBagConstraints.LINE_START;

                panel.add(emailTF,c);



                c.gridx=0;
                c.gridy=6;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(mnlabel,c);

                c.gridx=1;
                c.gridy=6;
                c.anchor=GridBagConstraints.LINE_START;

                panel.add(mnTF,c);

                c.gridx=0;
                c.gridy=7;
                c.anchor=GridBagConstraints.LINE_END;
                panel.add(showuserdata,c);

                add(panel);

                showuserdata.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        new ShowUserData2();
                    }
                });







            }
            else
            {
                int choice =  JOptionPane.showConfirmDialog(this,"You are not registered user --\n do uou want to register \n", "invalid user ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                switch(choice)
                {
                    case JOptionPane.YES_OPTION :
                        new UserRegisterPage();
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

            }







            con.close();
        }catch(Exception e)
        { System.out.println(e);}



        setTitle("ADMIN-LOGIN-PAGE");
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);











    }

}
