import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChoosenBook
{
    public ChoosenBook(String s1,String s2,String s3)
    {
        System.out.println(" "+s1+s2+s3);
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb","root","camit2354");
            String query ="select * from bookdata   WHERE `bookname` = ? ";

            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setString(1,s1);
            ResultSet rs=stmt.executeQuery();

            if(rs.next())
            {   JOptionPane.showMessageDialog(null,"book is issued", "issued", JOptionPane.PLAIN_MESSAGE);
                //System.out.println("book issued "+rs.getString(2)+rs.getString(3)+rs.getString(4));

            }
            else
            {  JOptionPane.showMessageDialog(null,"book is not issued", "unavilable-book", JOptionPane.PLAIN_MESSAGE);
                //System.out.println("no book issued\n");
            }



            con.close();
        }catch(Exception e)
           { System.out.println(e);}


    }

//   // public static void main(String[] args)
//    {
//        new ChoosenBook("history","guha","jayho");
//    }

}
