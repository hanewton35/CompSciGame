import java.awt.Image;
import javax.swing.ImageIcon;

public class Obj
{
    boolean yVis;
    boolean eVis;
    public Board board;
    public int row;
    public int col;
    
    public Obj(Board board, int row, int col)
    {
        this.board = board;
        this.row = row;
        this.col = col;
    }
    
    public ImageIcon getImg()
    {
        return null;
    }
    
    public void check()
    {
        yVis = false;
        try
        {
            if(board.get(row-2, col-1) instanceof You && board.get(row-1, col-1) instanceof EmpOrGla && board.get(row-1, col) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col) instanceof You && board.get(row-1, col) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col+1) instanceof You && board.get(row-1, col+1) instanceof EmpOrGla && board.get(row-1, col) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row-1, col-2) instanceof You && board.get(row, col-1) instanceof EmpOrGla && board.get(row-1, col-1) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof You)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col) instanceof You)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof You)
                yVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+2) instanceof You && board.get(row, col+1) instanceof EmpOrGla && board.get(row-1, col+1) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row, col-2) instanceof You && board.get(row, col-1) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col-1) instanceof You)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col) instanceof You)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+1) instanceof You)
                yVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+2) instanceof You && board.get(row, col+1) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-2) instanceof You && board.get(row+1, col-1) instanceof EmpOrGla && board.get(row, col-1) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col-1) instanceof You)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col) instanceof You)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof You)
                yVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+2) instanceof You && board.get(row+1, col+1) instanceof EmpOrGla && board.get(row, col+1) instanceof EmpOrGla)
                yVis = true; 
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+2, col-1) instanceof You && board.get(row+1, col-1) instanceof EmpOrGla && board.get(row+1, col) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col) instanceof You && board.get(row+1, col) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col+1) instanceof You && board.get(row+1, col+1) instanceof EmpOrGla && board.get(row+1, col) instanceof EmpOrGla)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-1) instanceof You && board.get(row+1, col) instanceof Wall && board.get(row, col-1) instanceof Wall)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof You && board.get(row+1, col) instanceof Wall && board.get(row, col+1) instanceof Wall)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof You && board.get(row-1, col) instanceof Wall && board.get(row, col+1) instanceof Wall)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof You && board.get(row-1, col) instanceof Wall && board.get(row, col-1) instanceof Wall)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        
        
        
        eVis = false; 
        try
        {
            if(board.get(row-2, col-1) instanceof Enemy && board.get(row-1, col-1) instanceof Empty && board.get(row-1, col) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col) instanceof Enemy && board.get(row-1, col) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col+1) instanceof Enemy && board.get(row-1, col+1) instanceof Empty && board.get(row-1, col) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row-1, col-2) instanceof Enemy && board.get(row, col-1) instanceof Empty && board.get(row-1, col-1) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof Enemy)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col) instanceof Enemy)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof Enemy)
                eVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+2) instanceof Enemy && board.get(row, col+1) instanceof Empty && board.get(row-1, col+1) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row, col-2) instanceof Enemy && board.get(row, col-1) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col-1) instanceof Enemy)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col) instanceof Enemy)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+1) instanceof Enemy)
                eVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+2) instanceof Enemy && board.get(row, col+1) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-2) instanceof Enemy && board.get(row+1, col-1) instanceof Empty && board.get(row, col-1) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col-1) instanceof Enemy)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col) instanceof Enemy)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof Enemy)
                eVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+2) instanceof Enemy && board.get(row+1, col+1) instanceof Empty && board.get(row, col+1) instanceof Empty)
                eVis = true; 
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+2, col-1) instanceof Enemy && board.get(row+1, col-1) instanceof Empty && board.get(row+1, col) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col) instanceof Enemy && board.get(row+1, col) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col+1) instanceof Enemy && board.get(row+1, col+1) instanceof Empty && board.get(row+1, col) instanceof Empty)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-1) instanceof Enemy && (board.get(row+1, col) instanceof Wall || board.get(row+1, col) instanceof Glass || board.get(row+1, col) instanceof You) && (board.get(row, col-1) instanceof Wall || board.get(row, col-1) instanceof Glass || board.get(row, col-1) instanceof You))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof Enemy && (board.get(row+1, col) instanceof Wall || board.get(row+1, col) instanceof Glass || board.get(row+1, col) instanceof You) && (board.get(row, col+1) instanceof Wall || board.get(row, col+1) instanceof Glass || board.get(row, col+1) instanceof You))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof Enemy && (board.get(row-1, col) instanceof Wall || board.get(row-1, col) instanceof Glass || board.get(row-1, col) instanceof You) && (board.get(row, col+1) instanceof Wall || board.get(row, col+1) instanceof Wall || board.get(row, col+1) instanceof You))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof Enemy && (board.get(row-1, col) instanceof Wall || board.get(row-1, col) instanceof Glass || board.get(row-1, col) instanceof You) && (board.get(row, col-1) instanceof Wall || board.get(row, col-1) instanceof Glass || board.get(row, col-1) instanceof You))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-1) instanceof You && (board.get(row+1, col) instanceof Wall || board.get(row+1, col) instanceof Enemy) && (board.get(row, col-1) instanceof Wall || board.get(row, col-1) instanceof Enemy))
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof You && (board.get(row+1, col) instanceof Wall || board.get(row+1, col) instanceof Enemy) && (board.get(row, col+1) instanceof Wall || board.get(row, col+1) instanceof Enemy))
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof You && (board.get(row-1, col) instanceof Wall || board.get(row-1, col) instanceof Enemy) && (board.get(row, col+1) instanceof Wall || board.get(row, col+1) instanceof Enemy))
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof You && (board.get(row-1, col) instanceof Wall || board.get(row-1, col) instanceof Enemy) && (board.get(row, col-1) instanceof Wall || board.get(row, col-1) instanceof Enemy))
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
    }
    
    public void setRow(int r)
    {
        row = r;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public void setCol(int c)
    {
        col = c;
    }
    
    public int getCol()
    {
        return col;
    }
}
