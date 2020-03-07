import java.sql.*;

public class DeleteUserPage
{
    public DeleteUserPage(int idd)
    {
       int choice ;

        try{
            Class.forName("com.mysql.jdbc.Driver");


            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb","root","camit2354");
            String query1 ="DELETE FROM `userdata` WHERE id=?";//DELETE FROM `userdata` WHERE id=?;

            PreparedStatement stmt=con.prepareStatement(query1);
            stmt.setInt(1,idd);
            choice =stmt.executeUpdate();



        }catch(Exception e)
        { System.out.println(e);}
    }


}
