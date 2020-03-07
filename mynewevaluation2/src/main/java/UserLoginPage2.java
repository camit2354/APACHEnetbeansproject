import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginPage2 extends  JFrame
{

    JPanel panel =new JPanel();

    JTextField bnTF,anTF,pnTF;
    JLabel unamelabel,bnlabel,anlabel,pnlabel;
    JButton submit;

   public UserLoginPage2(String s1,String s2)
   {
       Dimension dim1 =new Dimension(100,30);

       panel.setLayout(new GridBagLayout());
       panel.setBorder(new EmptyBorder(10, 10, 10, 10));


       GridBagConstraints c = new GridBagConstraints();
       c.insets= new Insets(5,5,0,5);
       c.fill=GridBagConstraints.HORIZONTAL;

       unamelabel= new JLabel ("WELCOME ********-*******");
       bnlabel= new JLabel("BOOKN-NAME");bnTF= new JTextField("",40);
       anlabel= new JLabel("AUTHOR-NAME");anTF =new JTextField("optional",40);
       pnlabel= new JLabel("PUBLICATION-NAME");pnTF = new JTextField("optional",40);
       submit = new JButton("issue-book");



       try{

           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/demodb","root","camit2354");
           String query ="select * from userdata   WHERE `username` = ? AND `password` = ? ";

           PreparedStatement stmt=con.prepareStatement(query);
           stmt.setString(1,s1);
           stmt.setString(2,s2);
           ResultSet rs=stmt.executeQuery();


           if(rs.next())
           {
               unamelabel= new JLabel ("WELCOME "+rs.getString(2)+"  "+rs.getString(3));
               c.gridx=0;
               c.gridy=0;
               c.anchor=GridBagConstraints.LINE_END;
               panel.add(unamelabel,c);


               c.gridx=0;
               c.gridy=1;
               c.anchor=GridBagConstraints.LINE_END;
               panel.add(bnlabel,c);

               c.gridx=1;
               c.gridy=1;
               c.anchor=GridBagConstraints.LINE_START;
               bnTF.setColumns(20);
               c.weightx = 0.5;
               bnTF.setMinimumSize(dim1);
               bnTF.setPreferredSize(dim1);
               panel.add(bnTF,c);



               c.gridx=0;
               c.gridy=2;
               c.anchor=GridBagConstraints.LINE_END;
               panel.add(anlabel,c);

               c.gridx=1;
               c.gridy=2;
               c.anchor=GridBagConstraints.LINE_START;
               anTF.setColumns(20);
               c.weightx = 0.5;
               anTF.setMinimumSize(dim1);
               anTF.setPreferredSize(dim1);
               panel.add(anTF,c);



               c.gridx=0;
               c.gridy=3;
               c.anchor=GridBagConstraints.LINE_END;
               panel.add(pnlabel,c);

               c.gridx=1;
               c.gridy=3;
               c.anchor=GridBagConstraints.LINE_START;
               pnTF.setColumns(20);
               c.weightx = 0.5;
               pnTF.setMinimumSize(dim1);
               pnTF.setPreferredSize(dim1);
               panel.add(pnTF,c);

               c.gridx=0;
               c.gridy=4;
               c.anchor=GridBagConstraints.LINE_END;
               panel.add(submit,c);



               String bs,as,ps;
               bs = bnTF.getText();
               as = anTF.getText();
               ps = pnTF.getText();




               submit.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent actionEvent) {
                       new ChoosenBook(bs,as,ps);
                   }
                  });

                       add(panel);
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

       setTitle("USER-LOGIN-PAGE2");
       pack();
       setVisible(true);
       setSize(400,400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


   }
}
