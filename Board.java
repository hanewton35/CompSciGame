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

public class Board
{
    Obj[][] board;
    Scanner sc = new Scanner(System.in);
    int end = -1; 
    boolean done;
    Main par;
    JPanel whole;
    JPanel top;
    JPanel bot;

    public Board(int size, Main parent)
    {
        par = parent;
        GridLayout grid1 = new GridLayout(size, size, 5, 5);
        GridLayout grid2 = new GridLayout(3, 3);
        whole = new JPanel(grid2);
        top = new JPanel(grid1);
        top.setBackground(Color.BLACK);
        bot = new JPanel(grid2);
        whole.add(top);
        whole.add(bot);
        par.mainframe.add(whole);
        board = new Obj[size][size];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                place(new Empty(this, i, j), i, j); 
            }
        }
        place(new You(this, 0, 0), 0, 0);
        check();
        par.mainframe.setVisible(true);
    }

    public void place(Obj obj, int row, int col)
    {
        board[row][col] = obj;
    }

    public void swap(int row1, int col1, int row2, int col2)
    {
        Obj o = board[row1][col1];
        o.row = row2;
        o.col = col2;
        board[row1][col1] = board[row2][col2];
        board[row1][col1].row = row1;
        board[row1][col1].col = col1;
        board[row2][col2] = o;
    }

    public void clear(int row, int col)
    {
        board[row][col] = new Empty(this, row, col);
    }

    public Obj get(int row, int col)
    {
        return board[row][col];
    }

    public You getYou()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] instanceof You)
                {
                    return (You) board[i][j];
                }
            }
        } 
        return null;
    }

    public Enemy getEne()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] instanceof Enemy)
                {
                    return (Enemy) board[i][j];
                }
            }
        } 
        return null;
    }

    public void build()
    {
        ArrayList<Double> arr = new ArrayList<Double>();
        for(int i = 0; i < board.length/2; i++)
        {
            arr.add(Math.random());
        }
        TextField row = new TextField();
        bot.add(row);
        TextField col = new TextField();
        bot.add(col);
        JButton Enter = new JButton("Enter Row and Column");
        bot.add(Enter);
        Enter.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
            if(Integer.parseInt(row.getText()) > 4)
            {
                
            }
            else
            {
                
            }
          }
        } );
        for(int i = 0; i < board.length/2; i++)
        {
        }
        par.mainframe.setVisible(true);
        /*
        for(int i = 0; i < board.length/2; i++)
        {
            System.out.println("PLACEMENTS REMAINING: " + (board.length/2-i));
            System.out.print(this);
            double e = arr.get(i);
            if(e < .5)
            {
                System.out.println("WALL");
                System.out.print("ENTER ROW FOR PLACEMENT");
                int c = sc.nextInt()-1;
                System.out.print("ENTER COLUMN FOR PLACEMENT");
                int d = sc.nextInt()-1;
                if(-1 < c && c < board.length+1 && -1 < d && d < board.length+1 && !(c == 0 && d == 0) && !(c == board.length-1 && d == 0) && !(c == 0 && d == board.length-1) && !(c == board.length-1 && d == board.length-1) && board[c][d] instanceof Empty)
                {
                    place(new Wall(this, c, d), c, d);
                    System.out.print("\u000C");
                }
                else
                { 
                    i--;
                    System.out.print("\u000C");
                    System.out.println("INVALID PLACEMENT");
                }
            }
            else 
            {
                System.out.println("GLASS");
                System.out.print("ENTER ROW FOR PLACEMENT");
                int c = sc.nextInt()-1;
                System.out.print("ENTER COLUMN FOR PLACEMENT");
                int d = sc.nextInt()-1;
                if(-1 < c && c < board.length+1 && -1 < d && d < board.length+1 && !(c == 0 && d == 0) && !(c == board.length-1 && d == 0) && !(c == 0 && d == board.length-1) && !(c == board.length-1 && d == board.length-1) && board[c][d] instanceof Empty)
                {
                    place(new Glass(this, c, d), c, d);
                    System.out.print("\u000C");
                }
                else
                {
                    i--;
                    System.out.print("\u000C");
                    System.out.println("INVALID PLACEMENT");
                }
            }
        }
        */
    }

    public void start()
    {
        int i = (int)(Math.random()*board.length/2)+board.length/2;
        if(Math.random() > .5)
        {
            if(board[board.length-1][i] instanceof Empty)
                place(new Enemy(this, board.length-1, i), board.length-1, i);
            else
                start();
        }
        else
        {
            if(board[board.length-1][i] instanceof Empty)
                place(new Enemy(this, i, board.length-1), i, board.length-1);
            else
                start();
        }
    }

    public void run()
    {
        check();
        String c = sc.next();
        if(c.equals("w") && getYou().getRow() != 0 && board[getYou().getRow()-1][getYou().getCol()] instanceof Empty)
        {
            getYou().up();
        }
        else if(c.equals("d") && getYou().getCol() != board.length-1  && board[getYou().getRow()][getYou().getCol()+1] instanceof Empty)
        {
            getYou().right();
        }
        else if(c.equals("s") && getYou().getRow() != board.length-1  && board[getYou().getRow()+1][getYou().getCol()] instanceof Empty)
        {
            getYou().down();
        }
        else if(c.equals("a") && getYou().getCol() != 0  && board[getYou().getRow()][getYou().getCol()-1] instanceof Empty)
        {
            getYou().left();
        }
        else if(c.equals("pw") && getYou().getRow() != 0 && board[getYou().getRow()-1][getYou().getCol()] instanceof Empty)
        {
            place(new Glass(this, getYou().getRow()-1, getYou().getCol()), getYou().getRow()-1, getYou().getCol());
        }
        else if(c.equals("pd") && getYou().getCol() != board.length-1  && board[getYou().getRow()][getYou().getCol()+1] instanceof Empty)
        {
            place(new Glass(this, getYou().getRow()-1, getYou().getCol()+1), getYou().getRow(), getYou().getCol()+1);
        }
        else if(c.equals("ps") && getYou().getRow() != board.length-1  && board[getYou().getRow()+1][getYou().getCol()] instanceof Empty)
        {
            place(new Glass(this, getYou().getRow()+1, getYou().getCol()), getYou().getRow()+1, getYou().getCol());
        }
        else if(c.equals("pa") && getYou().getCol() != 0  && board[getYou().getRow()][getYou().getCol()-1] instanceof Empty)
        {
            place(new Glass(this, getYou().getRow(), getYou().getCol()-1), getYou().getRow(), getYou().getCol()-1);
        }
        else if(c.equals("rw") && getYou().getRow() != 0 && (board[getYou().getRow()-1][getYou().getCol()] instanceof Wall || board[getYou().getRow()-1][getYou().getCol()] instanceof Glass))
        {
            place(new Empty(this, getYou().getRow()-1, getYou().getCol()), getYou().getRow()-1, getYou().getCol());
        }
        else if(c.equals("rd") && getYou().getCol() != board.length-1  && (board[getYou().getRow()][getYou().getCol()+1] instanceof Wall || board[getYou().getRow()][getYou().getCol()+1] instanceof Glass))
        {
            place(new Empty(this, getYou().getRow()-1, getYou().getCol()+1), getYou().getRow(), getYou().getCol()+1);
        }
        else if(c.equals("rs") && getYou().getRow() != board.length-1  && (board[getYou().getRow()+1][getYou().getCol()] instanceof Wall || board[getYou().getRow()+1][getYou().getCol()] instanceof Glass))
        {
            place(new Empty(this, getYou().getRow()+1, getYou().getCol()), getYou().getRow()+1, getYou().getCol());
        }
        else if(c.equals("ra") && getYou().getCol() != 0  && (board[getYou().getRow()][getYou().getCol()-1] instanceof Wall || board[getYou().getRow()][getYou().getCol()-1] instanceof Glass))
        {
            place(new Empty(this, getYou().getRow(), getYou().getCol()-1), getYou().getRow(), getYou().getCol()-1);
        }
        check();
        if(getYou().almost)
        {
            for(int i = 0; i < board.length/2; i++)
            {
                if(getEne().hunt())
                {
                    i = board.length/3;
                }
                check();
            }
        }
        else
        {
            for(int i = 0; i < board.length/3; i++)
            {
                if(getEne().hunt())
                {
                    i = board.length/4;
                }
                check();
            }
        }
        System.out.print(this);
        System.out.print("\u000C");
    }

    public void end(boolean p)
    {
        System.out.print("\u000C");
        System.out.print(this);
        if(p)
        {
            System.out.println("YOU WIN");
            end = 1;
        }
        else
        {
            System.out.println("YOU LOSE");
            end = 2; 
        }
    }

    public void check()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                ImageIcon icon = board[j][i].getImg();
                JLabel label1 = new JLabel("", icon, JLabel.CENTER);
                top.add(label1);
            }
        }
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                board[i][j].check(); 
            }
        }
        if(!(getYou() instanceof You))
        {
            end(false);
        }
        if(getYou() != null && getYou().getRow() == board.length-1 && getYou().getCol() == board.length-1)
        {
            end(true);
        }
    }

    public String toString() 
    {
        String str = "\n   ";
        for(int i = 0; i < board.length; i++)
        {
            if(i+1 < 10)
                str += i+1 + "  ";
            else
                str += i+1 + " ";
        }
        str += "\n";
        for(int i = 0; i < board.length; i++)
        {
            if(i+1 < 10)
                str += i+1 + "  ";
            else
                str += i+1 + " ";
            for(int j = 0; j < board[0].length; j++)
            { 
                str += board[i][j] + "  ";
            }
            str += "\n";
        }
        return str;
    }
}
