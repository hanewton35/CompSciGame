import java.util.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.*;;
import java.awt.event.*;

public class Main
{
    Scanner sc;
    protected JFrame mainframe = new JFrame("Filler");

    public void mainMenu()
    {
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setLocationRelativeTo(null);
        mainframe.setSize(300, 750);
        GridLayout grid = new GridLayout(10, 10);
        JPanel panel = new JPanel(grid);
        JButton one = new JButton("1-Player");
        one.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
              mainframe.remove(panel);
              oneMenu();
          }
        } );
        panel.add(one);
        JButton two = new JButton("2-Player");
        two.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) {
              mainframe.remove(panel);
              twoMenu();
          } 
        } );
        panel.add(two);
        mainframe.add(panel);
        mainframe.setVisible(true);
    }

    public void oneMenu()
    {
        GridLayout grid = new GridLayout(10, 10);
        JPanel panel = new JPanel(grid);
        JButton one = new JButton("Start");
        final Main th = this;
        one.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
            mainframe.remove(panel);
            Tester b = new Tester(th);
            b.run();
          }
        } );
        panel.add(one);
        JButton two = new JButton("Rules");
        two.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
              System.out.print("\u000C");
            System.out.println("ONE-PLAYER RULES");
            System.out.println("");
            System.out.println("1. Back");
            String a = "10";
            while(true)
            {
                a = sc.next(); 
                if(a.equals("1"))
                    oneMenu();
            }
          } 
        } );
        panel.add(two);
        JButton three = new JButton("Back");
        three.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) {
            mainMenu();
          } 
        } );
        panel.add(three);
        mainframe.add(panel);
        mainframe.setVisible(true);
        System.out.println("Play Again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public void twoMenu()
    {
        System.out.print("\u000C");
        System.out.println("TWO-PLAYER");
        System.out.println("1. Start");
        System.out.println("2. Rules");
        System.out.println("3. Back");
        String a = sc.next();
        if(a.equals("1"))
        {
            System.out.print("\u000C");
            Tester2 b = new Tester2();
            b.run();
        }
        else if(a.equals("2"))
        {
            System.out.print("\u000C");
            System.out.println("TWO-PLAYER RULES");
            System.out.println("");
            System.out.println("1. Back");
            while(true)
            {
                a = sc.next(); 
                if(a.equals("1"))
                    oneMenu();
            }
        }
        else if(a.equals("3"))
        {
            System.out.print("\u000C");
            mainMenu();
        }
        else
        {
            System.out.print("\u000C");
            twoMenu();
        }
        System.out.println("Play Again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        boolean x = false; 
        while(!x)
        {
            a = sc.next();
            if(a.equals("1"))
            {
                x = true; 
                mainMenu();
            }
            else if(a.equals("2"))
            {
                x = true; 
            }
        }
    }
}
