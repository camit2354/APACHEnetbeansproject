import java.awt.Dimension;
import java.sql.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class UserRegisterPage extends JFrame
{   JPanel panel =new JPanel();
    Pattern p ;
    Matcher m ;
    boolean b1,b2,b3,b4,b5,b6;

    JTextField unTF,fnTF,lnTF,emailTF,mnTF,passTF;



    JLabel unlabel,fnlabel,lnlabel,emaillabel,mnlabel,passlabel,mainlabel;
    JButton submit;
       int choice;


    public UserRegisterPage()
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

        mainlabel =new JLabel("USER--REGISTRATION-FORM");
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
            public void actionPerformed(ActionEvent actionEvent)
            {          String error="";

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/demodb","root","camit2354");
                    String query ="INSERT INTO `userdata` (`firstname`,`lastname`,`username`,`password`,`email`,`mobileno`) VALUES (?,?,?,?,?,?)";
                    PreparedStatement stmt=con.prepareStatement(query);

                    //INSERT INTO `userdata` (`firstname`,`lastname`,`username`,`password`,`email`,`mobileno`) VALUES ('amit','chaudhari','ami2354',"camit2354","camit2354@gmail.com","9922046714");

                    String fns=fnTF.getText();
                    p = Pattern.compile("[a-z]+");//. represents single character
                    m = p.matcher(fns);
                    b1 = m.matches();
                    if(!b1)
                    {
                       error= error+"invalid firstname";

                    }


                    String lns = lnTF.getText();
                    p = Pattern.compile("[a-z]+");//. represents single character
                    m = p.matcher(lns);
                    b2 = m.matches();

                    if(!b2)
                    {
                        error= error+"invalid lastname \n";
                    }


                    String uns =  unTF.getText();
                    p = Pattern.compile("[a-z]+");//. represents single character
                    m = p.matcher(uns);
                    b3 = m.matches();

                    if(!b3)
                    {
                        error= error+"invalid username \n";
                    }


                    String passs = passTF.getText();
                    p = Pattern.compile("[a-zA-Z0-9]+");//. represents single character
                    m = p.matcher(passs);
                    b4 = m.matches();
                    if(!b4)
                    {
                        error= error+"invalid password \n";
                    }


                    String emails = emailTF.getText() ;
                    p = Pattern.compile("[a-zA-Z0-9]+[@]{1}[a-z]+.com");//. represents single character
                    m = p.matcher(emails);
                    b5 = m.matches();

                    if(!b5)
                    {
                        error= error+"invalid email \n";

                    }


                    String mns =mnTF.getText();
                    p = Pattern.compile("[0-9]{10}");//. represents single character
                    m = p.matcher(mns);
                    b6 = m.matches();

                    if(!b6)
                    {
                        error= error+"invalid mobileno \n";

                    }



              if(b1&&b2&&b3&&b4&&b5&&b6)
              {
                  stmt.setString(1,fns);
                  stmt.setString(2,lns);
                  stmt.setString(3,uns);
                  stmt.setString(4,passs );
                  stmt.setString(5,emails);
                  stmt.setString(6,mns);

                  int count =stmt.executeUpdate();

                  //  JOptionPane.showMessageDialog(null,"your registration is complete " ,"registered...",JOptionPane.INFORMATION_MESSAGE);





                  choice =  JOptionPane.showConfirmDialog(null,"YoUR  REGISTRATION IS COMPLETE \n do you want to continue  \n", "REGISTERED ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
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
              else
              {
                  choice =  JOptionPane.showConfirmDialog(null," YOU ENTERED  invaliD data \n DO YOU WANT CONTINUE REGISTRATION: "+error, "INCOMPLETE-REGISTEr ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                  switch(choice)
                  {
                      case JOptionPane.YES_OPTION :
                          new AdminRegisterPage2();
                          dispose();
                          break;

                      case JOptionPane.NO_OPTION :
                         new StartPage();
                          break;


                      case JOptionPane.CLOSED_OPTION :
                          System.exit(0);
                          break;
                  }
              }




                    stmt.close();
                    con.close();


                }catch(Exception e)
                     { System.out.println(e);}

            }
        });




        setTitle("USER-REGISTRATION-PAGE");
        setVisible(true); pack();
        setSize(800,800);
        setPreferredSize(getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        System.out.println("register  page is being called by  USER ");
    }

    public static void main(String[] args)
    {
        new UserRegisterPage();
    }

}
