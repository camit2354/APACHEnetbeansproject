import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginPage2
{



   public UserLoginPage2(String s1,String s2)
   {





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
               new IssueBook();

           }
           else
           {
               int choice =  JOptionPane.showConfirmDialog(null,"You are not registered user --\n do uou want to register \n", "invalid user ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
               switch(choice)
               {
               case JOptionPane.YES_OPTION :
                   new UserRegisterPage();

                   break;

               case JOptionPane.NO_OPTION :
                   System.exit(0);

                   break;


               case JOptionPane.CLOSED_OPTION :
                   new StartPage();

                   break;
               }

           }

           con.close();
       }catch(Exception e)
       { System.out.println(e);}




   }
}
