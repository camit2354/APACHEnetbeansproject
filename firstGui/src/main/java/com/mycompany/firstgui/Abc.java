/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firstgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author amitsinh
 */
class Abc extends JFrame
{
    public Abc()
    {
        JLabel label;
       label = new JLabel("This is demo label!",JLabel.RIGHT);
      label.setVerticalAlignment(JLabel.TOP);
      label.setFont(new Font("Verdana", Font.PLAIN, 15));
      label.setPreferredSize(new Dimension(200, 50));      
      Border border = BorderFactory.createLineBorder(Color.BLACK);
      label.setBorder(border);
        add(label);
        setVisible(true);
        setSize(1300,1000);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}