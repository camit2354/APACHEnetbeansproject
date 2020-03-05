/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evaluation2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class StartPage extends JFrame 
{  JPanel panel =new JPanel();
    JTextField unameTextField,passTextField;
    
    JButton signB,registerB;
    JLabel unameJlabel,passJlabel,userTypeJlabel;
    JComboBox<String> userType;

    public StartPage()
    {
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        
        unameTextField= new JTextField();
        passTextField = new JTextField();
        signB =new JButton("SIGN-IN");
        registerB = new JButton("REGISTER");
        unameJlabel = new JLabel("USERNAME");
        passJlabel = new JLabel("PASSWORD");
        String[] userString = new String[] {"ADMIN", "USER"};
        
         Dimension dim1 =new Dimension(100,30);
        
        userTypeJlabel = new JLabel("USERTYPE");
        
        userType = new JComboBox<String>(userString);
       
       
       GridBagConstraints c = new GridBagConstraints();
       c.insets= new Insets(5,5,0,5);
       c.fill=GridBagConstraints.HORIZONTAL;
       c.fill=GridBagConstraints.VERTICAL;
       
         c.gridx=0;
       c.gridy=0;
       c.anchor=GridBagConstraints.LINE_END;
        panel.add(userTypeJlabel,c);
        
         c.gridx=1;
       c.gridy=0;
       c.anchor=GridBagConstraints.LINE_START;
       userType.setMinimumSize(dim1);
       userType.setPreferredSize(dim1);
        panel.add(userType,c);
       
       c.gridx=0;
       c.gridy=1;
       c.anchor=GridBagConstraints.LINE_END;
        panel.add(unameJlabel,c);
        
        
          c.gridx=1;
       c.gridy=1;
       c.anchor=GridBagConstraints.LINE_START;
        unameTextField.setColumns(20);
         c.weightx = 0.5;
        unameTextField.setMinimumSize(dim1);
         unameTextField.setPreferredSize(dim1);
        panel.add(unameTextField,c);

        
           c.gridx=0;
        c.gridy=2;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(passJlabel,c);

        c.gridx=1;
        c.gridy=2;
        c.anchor=GridBagConstraints.LINE_START;
        passTextField.setColumns(20);
         passTextField.setMinimumSize(dim1);
         passTextField.setPreferredSize(dim1);
        panel.add(passTextField,c);
        
      

        

        c.gridx=0;
        c.gridy=3;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(signB,c);

       

        c.gridx=1;
        c.gridy=3;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(registerB,c);
        
        add(panel);

        
       signB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    String privilage = (String)userType.getSelectedItem();
                    
                    if(privilage=="USER")
                    {
                        
                        new UserLoginPage(unameTextField.getText(),passTextField.getText());
                        dispose();
                    }
                    else
                    {
                       
                        new AdminLoginPage(unameTextField.getText(),passTextField.getText());
                         dispose();
                    }
                }
            });
        
       registerB.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent actionEvent) {
                String privilage = (String)userType.getSelectedItem();
                   
                    
                     if(privilage=="USER")
                    {
                         
                         new UserRegisterPage();
                          dispose();
                    }
                    else
                    {
                         
                         new AdminRegisterPage();
                          dispose();
                    }
                     
              
           }
       });


       
        //panel.setVisible(true);
        pack();
        setTitle("STARTPAGE OF WEBSITE");
       //  setResizable(false);
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }

   //To change body of generated methods, choose Tools | Templates.

    
    

}
