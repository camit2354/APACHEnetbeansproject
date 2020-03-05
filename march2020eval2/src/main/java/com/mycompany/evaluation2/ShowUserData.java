/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evaluation2;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 import java.sql.*;  
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
    


public class ShowUserData extends JFrame {
    
    
    public ShowUserData()
   {  
       int noofrows=0;
        ResultSet rs;
       
    try{  
   Class.forName("com.mysql.jdbc.Driver"); 


Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/demodb","root","camit2354");  
  String query1 ="SELECT COUNT(*) FROM userdata";
  
  
  Statement stmt=con.createStatement(); 
   rs=stmt.executeQuery(query1);
      rs.next();
      noofrows = rs.getInt(1);  
  
  String query2 ="select * from userdata";
  rs=stmt.executeQuery(query2);
 
  

  
 

      
       JLabel[] labels=new JLabel[noofrows];
       
       JPanel panel = new JPanel() ;
       panel.setLayout(new GridBagLayout());
      panel.setBorder(new EmptyBorder(20, 20, 20, 20));
      Border border;
        
      
      
       GridBagConstraints c = new GridBagConstraints();
       c.insets= new Insets(5,5,0,5);
       c.fill=GridBagConstraints.HORIZONTAL; 
       
    System.out.println("********************\n"+noofrows+"********************\n");
      int i=0;
       for(i=0;i<noofrows;i++)
       {
           rs.next();
           
           String str = "";//+"--"
           str = str + rs.getNString(2) +"--"+ rs.getNString(3) +"--"+ rs.getNString(4)+"--" + rs.getNString(5)+"--" + rs.getNString(6) +"--"+ rs.getNString(7);
           System.out.println("********************\n"+str+"********************\n");
           
           labels[i] = new JLabel(str);
           
            c.gridx=0;
            c.gridy=i;
           c.anchor=GridBagConstraints.LINE_END;
           border = BorderFactory.createLineBorder(Color.WHITE, 2);
         labels[i].setBorder(border);
           panel.add(labels[i],c);
                
    
        }
    
      add(panel);
      
   con.close();  
   
   }catch(Exception e)
           { System.out.println(e);}  

    
    
    
       setTitle("SHOW-USER-DATA");
        setVisible(true);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    }


}

