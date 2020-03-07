import java.awt.Dimension;
import java.sql.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class AdminRegisterPage extends JFrame
{


    JPanel panel =new JPanel();

    JTextField unTF,fnTF,lnTF,emailTF,mnTF,passTF;


    JLabel unlabel,fnlabel,lnlabel,emaillabel,mnlabel,passlabel,mainlabel;
    JButton submit;

    public AdminRegisterPage()
    {


        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));


        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(5,5,5,5);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.fill=GridBagConstraints.VERTICAL;


        submit =new JButton("REGISTER-SUBMIT");

        unTF= new JTextField(50);
        passTF = new JTextField(50);
        fnTF= new JTextField(50);
        lnTF= new JTextField(50);
        emailTF= new JTextField(50);
        mnTF= new JTextField(50);

        mainlabel =new JLabel("ADMIN--REGISTRATION-FORM");
        unlabel=new JLabel("USER-NAME");
        passlabel=new JLabel("PASS-WORD");
        fnlabel=new JLabel("FIRST-NAME");
        lnlabel=new JLabel("LAST-NAME");
        emaillabel=new JLabel("EMAIL-ADDRESS");
        mnlabel=new JLabel("MOBILE-NO");



        Dimension dim1 =new Dimension(100,30);



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
        unTF.setColumns(20);
        c.weightx = 0.5;
        unTF.setMinimumSize(dim1);
        unTF.setPreferredSize(dim1);
        panel.add(unTF,c);



        c.gridx=0;
        c.gridy=2;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(passlabel,c);

        c.gridx=1;
        c.gridy=2;
        c.anchor=GridBagConstraints.LINE_START;
        passTF.setColumns(20);
        c.weightx = 0.5;
        passTF.setMinimumSize(dim1);
        passTF.setPreferredSize(dim1);
        panel.add(passTF,c);



        c.gridx=0;
        c.gridy=3;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(fnlabel,c);

        c.gridx=1;
        c.gridy=3;
        c.anchor=GridBagConstraints.LINE_START;
        fnTF.setColumns(20);
        c.weightx = 0.5;
        fnTF.setMinimumSize(dim1);
        fnTF.setPreferredSize(dim1);
        panel.add(fnTF,c);




        c.gridx=0;
        c.gridy=4;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(lnlabel,c);

        c.gridx=1;
        c.gridy=4;
        c.anchor=GridBagConstraints.LINE_START;
        lnTF.setColumns(20);
        c.weightx = 0.5;
        lnTF.setMinimumSize(dim1);
        lnTF.setPreferredSize(dim1);
        panel.add(lnTF,c);




        c.gridx=0;
        c.gridy=5;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(emaillabel,c);

        c.gridx=1;
        c.gridy=5;
        c.anchor=GridBagConstraints.LINE_START;
        emailTF.setColumns(20);
        c.weightx = 0.5;
        emailTF.setMinimumSize(dim1);
        emailTF.setPreferredSize(dim1);
        panel.add(emailTF,c);



        c.gridx=0;
        c.gridy=6;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(mnlabel,c);

        c.gridx=1;
        c.gridy=6;
        c.anchor=GridBagConstraints.LINE_START;
        mnTF.setColumns(20);
        c.weightx = 0.5;
        mnTF.setMinimumSize(dim1);
        mnTF.setPreferredSize(dim1);
        panel.add(mnTF,c);

        c.gridx=0;
        c.gridy=7;
        c.anchor=GridBagConstraints.LINE_END;
        c.weightx = 0.5;
        panel.add(submit,c);


        add(panel);


        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/demodb","root","camit2354");
                    String query ="INSERT INTO `admindata` (`firstname`,`lastname`,`username`,`password`,`email`,`mobileno`) VALUES (?,?,?,?,?,?)";
                    PreparedStatement stmt=con.prepareStatement(query);

                    //INSERT INTO `userdata` (`firstname`,`lastname`,`username`,`password`,`email`,`mobileno`) VALUES ('amit','chaudhari','ami2354',"camit2354","camit2354@gmail.com","9922046714");

                    stmt.setString(1,fnTF.getText() );
                    stmt.setString(2,lnTF.getText() );
                    stmt.setString(3, unTF.getText());
                    stmt.setString(4,passTF.getText() );
                    stmt.setString(5,emailTF.getText() );
                    stmt.setString(6,mnTF.getText() );

                    int count =stmt.executeUpdate();

                    // JOptionPane.showMessageDialog(null,"your registration is complete " ,"registered...",JOptionPane.INFORMATION_MESSAGE);

                    stmt.close();
                    con.close();

                }catch(Exception e)
                { System.out.println(e);}



                int choice =  JOptionPane.showConfirmDialog(null,"YoUR  REGISTRATION IS COMPLETE \n do you want to continue  \n", "REGISTERED ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                switch(choice)
                {
                    case JOptionPane.YES_OPTION :
                        new StartPage();
                        dispose();
                        break;

                    case JOptionPane.NO_OPTION :
                        System.exit(0);
                        break;


                    case JOptionPane.CLOSED_OPTION :
                        System.exit(0);
                        break;

                }






            }
        });




        setTitle("ADMIN-REGISTRATION-PAGE");
        setVisible(true);
        setSize(800,800);
        setPreferredSize(getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        System.out.println(" login page is being called as   ADMIN");
    }
}

