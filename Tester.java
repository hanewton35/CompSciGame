import java.util.*;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.*;;
import java.awt.event.*;

import java.text.MessageFormat;


public class Tester
{
    Main par;
    Board b;
    
    public Tester(Main parent)
    {
        par = parent;
    }
    
    public void run()
    {
        GridLayout grid = new GridLayout(10, 10);
        JPanel panel = new JPanel(grid);
        TextField tf = new TextField();
        panel.add(tf);
        JButton size = new JButton("Enter Size (GREATER THAN 4)");
        panel.add(size);
        par.mainframe.add(panel);
        par.mainframe.setVisible(true);
        size.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
            if(Integer.parseInt(tf.getText()) > 4)
            {
                par.mainframe.remove(panel);
                b = new Board(Integer.parseInt(tf.getText()), par);
                run2();
            }
            else
            {
                par.mainframe.remove(panel);
                run();
            }
          }
        } );
    }
    
    public void run2()
    {
        b.build();
        /*b.check();
        b.start();
        while(b.end == -1)
        {
            System.out.print(b);
            b.run();
        }
        System.out.print(b);
        if(b.end == 1)
        {
            System.out.println("YOU WIN");
        }
        else
        {
            System.out.println("YOU LOSE");
        }*/
    }
}