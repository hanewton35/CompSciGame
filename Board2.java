import java.util.*;
import java.util.concurrent.TimeUnit;
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

public class Board2
{
    Obj2[][] board;
    Scanner sc = new Scanner(System.in);
    boolean one;
    int oRow;
    int oCol;
    int end = -1; 
    
    public Board2(int size)
    {
        one = true;
        board = new Obj2[size][size];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                place(new Empty2(this, i, j), i, j); 
            }
        }
        double i = Math.random(); 
        double j = Math.random();
        double k = Math.random();
        if(i < .25)
        {
            place(new You2(this, 0, 0), 0, 0); 
            if(j < .33)
                place(new Enemy2(this, 0, board.length-1), 0, board.length-1); 
            else if(j < .66)
                place(new Enemy2(this, board.length-1, board.length-1), board.length-1, board.length-1); 
            else
                place(new Enemy2(this, board.length-1, 0), board.length-1, 0); 
            if(k < .33)
            {
                oRow = 0; oCol = board.length-1;
            }
            else if(k < .66)
            {
                oRow = board.length-1; oCol = board.length-1;
            }
            else
            {
                oRow = board.length-1; oCol = 0;
            }
        }
        else if(i < .5)
        {
            place(new You2(this, 0, board.length-1), 0, board.length-1);
            if(j < .33)
                place(new Enemy2(this, 0, 0), 0, 0); 
            else if(j < .66)
                place(new Enemy2(this, board.length-1, board.length-1), board.length-1, board.length-1); 
            else
                place(new Enemy2(this, board.length-1, 0), board.length-1, 0); 
            if(k < .33)
            {
                oRow = 0; oCol = 0;
            }
            else if(k < .66)
            {
                oRow = board.length-1; oCol = board.length-1;
            }
            else
            {
                oRow = board.length-1; oCol = 0;
            }
        }
        else if(i < .75)
        {
            place(new You2(this, board.length-1, board.length-1), board.length-1, board.length-1);
            if(j < .33)
                place(new Enemy2(this, 0, board.length-1), 0, board.length-1); 
            else if(j < .66)
                place(new Enemy2(this, 0, 0), 0, 0); 
            else
                place(new Enemy2(this, board.length-1, 0), board.length-1, 0); 
            if(k < .33)
            {
                oRow = 0; oCol = board.length-1;
            }
            else if(k < .66)
            {
                oRow = 0; oCol = 0;
            }
            else
            {
                oRow = board.length-1; oCol = 0;
            }
        }
        else
        {
            place(new You2(this, board.length-1, 0), board.length-1, 0);
            if(j < .33)
                place(new Enemy2(this, 0, board.length-1), 0, board.length-1); 
            else if(j < .66)
                place(new Enemy2(this, board.length-1, board.length-1), board.length-1, board.length-1); 
            else
                place(new Enemy2(this, 0, 0), 0, 0); 
            if(k < .33)
            {
                oRow = 0; oCol = board.length-1;
            }
            else if(k < .66)
            {
                oRow = board.length-1; oCol = board.length-1;
            }
            else
            {
                oRow = 0; oCol = 0;
            }
        }
    }
    
    public void place(Obj2 obj, int row, int col)
    {
        board[row][col] = obj;
    }
    
    public void swap(int row1, int col1, int row2, int col2)
    {
        Obj2 o = board[row1][col1];
        o.row = row2;
        o.col = col2;
        board[row1][col1] = board[row2][col2];
        board[row1][col1].row = row1;
        board[row1][col1].col = col1;
        board[row2][col2] = o;
    }
    
    public void clear(int row, int col)
    {
        board[row][col] = new Empty2(this, row, col);
    }
    
    public Obj2 get(int row, int col)
    {
        return board[row][col];
    }
    
    public You2 getYou2()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] instanceof You2)
                {
                    return (You2) board[i][j];
                }
            }
        } 
        return null;
    }
    
    public Enemy2 getEne()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] instanceof Enemy2)
                {
                    return (Enemy2) board[i][j];
                }
            }
        } 
        return null;
    }
    
    public void build()
    {
        System.out.println("OBJECTIVE: " + (oRow+1) + ", " + (oCol+1));
        ArrayList<Double> arr = new ArrayList<Double>();
        for(int i = 0; i < board.length/2; i++)
        {
            arr.add(Math.random());
        }
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
                if(-1 < c && c < board.length+1 && -1 < d && d < board.length+1 && !(c == 0 && d == 0) && !(c == board.length-1 && d == 0) && !(c == 0 && d == board.length-1) && !(c == board.length-1 && d == board.length-1) && board[c][d] instanceof Empty2)
                {
                    place(new Wall2(this, c, d), c, d);
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
                if(-1 < c && c < board.length+1 && -1 < d && d < board.length+1 && !(c == 0 && d == 0) && !(c == board.length-1 && d == 0) && !(c == 0 && d == board.length-1) && !(c == board.length-1 && d == board.length-1) && board[c][d] instanceof Empty2)
                {
                    place(new Glass2(this, c, d), c, d);
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
    }
    
    public void run()
    {
        one = true;
        check();
        System.out.print(this);
        String c = sc.next();
        if(c.equals("w") && getYou2().getRow() != 0 && board[getYou2().getRow()-1][getYou2().getCol()] instanceof Empty2)
        {
            getYou2().up();
        }
        else if(c.equals("d") && getYou2().getCol() != board.length-1  && board[getYou2().getRow()][getYou2().getCol()+1] instanceof Empty2)
        {
            getYou2().right();
        }
        else if(c.equals("s") && getYou2().getRow() != board.length-1  && board[getYou2().getRow()+1][getYou2().getCol()] instanceof Empty2)
        {
            getYou2().down();
        }
        else if(c.equals("a") && getYou2().getCol() != 0  && board[getYou2().getRow()][getYou2().getCol()-1] instanceof Empty2)
        {
            getYou2().left();
        }
        else if(c.equals("pw") && getYou2().getRow() != 0 && board[getYou2().getRow()-1][getYou2().getCol()] instanceof Empty2)
        {
            place(new Glass2(this, getYou2().getRow()-1, getYou2().getCol()), getYou2().getRow()-1, getYou2().getCol());
        }
        else if(c.equals("pd") && getYou2().getCol() != board.length-1  && board[getYou2().getRow()][getYou2().getCol()+1] instanceof Empty2)
        {
            place(new Glass2(this, getYou2().getRow()-1, getYou2().getCol()+1), getYou2().getRow(), getYou2().getCol()+1);
        }
        else if(c.equals("ps") && getYou2().getRow() != board.length-1  && board[getYou2().getRow()+1][getYou2().getCol()] instanceof Empty2)
        {
            place(new Glass2(this, getYou2().getRow()+1, getYou2().getCol()), getYou2().getRow()+1, getYou2().getCol());
        }
        else if(c.equals("pa") && getYou2().getCol() != 0  && board[getYou2().getRow()][getYou2().getCol()-1] instanceof Empty2)
        {
            place(new Glass2(this, getYou2().getRow(), getYou2().getCol()-1), getYou2().getRow(), getYou2().getCol()-1);
        }
        else if(c.equals("rw") && getYou2().getRow() != 0 && (board[getYou2().getRow()-1][getYou2().getCol()] instanceof Wall2 || board[getYou2().getRow()-1][getYou2().getCol()] instanceof Glass2))
        {
            place(new Empty2(this, getYou2().getRow()-1, getYou2().getCol()), getYou2().getRow()-1, getYou2().getCol());
        }
        else if(c.equals("rd") && getYou2().getCol() != board.length-1  && (board[getYou2().getRow()][getYou2().getCol()+1] instanceof Wall2 || board[getYou2().getRow()][getYou2().getCol()+1] instanceof Glass2))
        {
            place(new Empty2(this, getYou2().getRow()-1, getYou2().getCol()+1), getYou2().getRow(), getYou2().getCol()+1);
        }
        else if(c.equals("rs") && getYou2().getRow() != board.length-1  && (board[getYou2().getRow()+1][getYou2().getCol()] instanceof Wall2 || board[getYou2().getRow()+1][getYou2().getCol()] instanceof Glass2))
        {
            place(new Empty2(this, getYou2().getRow()+1, getYou2().getCol()), getYou2().getRow()+1, getYou2().getCol());
        }
        else if(c.equals("ra") && getYou2().getCol() != 0  && (board[getYou2().getRow()][getYou2().getCol()-1] instanceof Wall2 || board[getYou2().getRow()][getYou2().getCol()-1] instanceof Glass2))
        {
            place(new Empty2(this, getYou2().getRow(), getYou2().getCol()-1), getYou2().getRow(), getYou2().getCol()-1);
        }
        check();
        System.out.print("\u000C");
        System.out.print(this);
    }
    
    public void run2()
    {
        if(end == 0 || end == 1)
        {
        }
        else
        {
        System.out.print("\u000C");
        one = false;
        if(getYou2().almost)
        {
            for(int i = 0; i < board.length/3; i++)
            {
                System.out.print("\u000C");
                System.out.print("MOVES LEFT: " + (board.length/3-i));
                System.out.print(this);
                String c = sc.next();
                if(c.equals("w") && getEne().getRow() != 0)
                {
                    if(getEne().up())
                    {
                        i = board.length;
                    }
                }
                else if(c.equals("d") && getEne().getCol() != board.length-1)
                {
                    if(getEne().right())
                    {
                        i = board.length;
                    }
                }
                else if(c.equals("s") && getEne().getRow() != board.length-1)
                {
                    if(getEne().down())
                    {
                        i = board.length;
                    }
                }
                else if(c.equals("a") && getEne().getCol() != 0)
                {
                    if(getEne().left())
                    {
                        i = board.length;
                    }
                }
                check();
            }
        }
        else
        {
            for(int i = 0; i < board.length/4; i++)
            {
                System.out.print("\u000C");
                System.out.print("MOVES LEFT: " + (board.length/4-i));
                System.out.print(this);
                String c = sc.next();
                if(c.equals("w") && getEne().getRow() != 0)
                {
                    if(getEne().up())
                    {
                        i = board.length;
                    }
                }
                else if(c.equals("d") && getEne().getCol() != board.length-1)
                {
                    if(getEne().right())
                    {
                        i = board.length;
                    }
                }
                else if(c.equals("s") && getEne().getRow() != board.length-1)
                {
                    if(getEne().down())
                    {
                        i = board.length;
                    }
                }
                else if(c.equals("a") && getEne().getCol() != 0)
                {
                    if(getEne().left())
                    {
                        i = board.length;
                    }
                }
                check();
            }
        }
        System.out.print("\u000C");
        System.out.print(this);
    }
    }
    
    public void end(boolean p)
    {
        System.out.print("\u000C");
        System.out.print(this);
        if(p)
        {
            end = 1;
        }
        else
        {
            end = 2;
        }
    }
    
    public void check()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                board[i][j].check(); 
            }
        }
        if(!(getYou2() instanceof You2))
        {
            end(false);
        }
        if(getYou2() != null && getYou2().getRow() == oRow && getYou2().getCol() == oCol)
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
