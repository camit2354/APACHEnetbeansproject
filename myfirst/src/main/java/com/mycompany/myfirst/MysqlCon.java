package com.mycompany.myfirst;

import java.sql.*;  

class MysqlCon{  
    
public static void main(String args[])
{  
    
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/demodb","root","camit2354");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from  cats");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
con.close();  
}catch(Exception e)
{ System.out.println(e);}  

   }  

}  