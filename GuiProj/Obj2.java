public class Obj2
{
    boolean yVis;
    boolean eVis;
    public Board2 board;
    public int row;
    public int col;
    
    public Obj2(Board2 board, int row, int col)
    {
        this.board = board;
        this.row = row;
        this.col = col;
    }
    
    public void check()
    {
        yVis = false;
        try
        {
            if(board.get(row-2, col-1) instanceof You2 && board.get(row-1, col-1) instanceof EmpOrGla2 && board.get(row-1, col) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col) instanceof You2 && board.get(row-1, col) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col+1) instanceof You2 && board.get(row-1, col+1) instanceof EmpOrGla2 && board.get(row-1, col) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row-1, col-2) instanceof You2 && board.get(row, col-1) instanceof EmpOrGla2 && board.get(row-1, col-1) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof You2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col) instanceof You2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof You2)
                yVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+2) instanceof You2 && board.get(row, col+1) instanceof EmpOrGla2 && board.get(row-1, col+1) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row, col-2) instanceof You2 && board.get(row, col-1) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col-1) instanceof You2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col) instanceof You2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+1) instanceof You2)
                yVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+2) instanceof You2 && board.get(row, col+1) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-2) instanceof You2 && board.get(row+1, col-1) instanceof EmpOrGla2 && board.get(row, col-1) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col-1) instanceof You2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col) instanceof You2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof You2)
                yVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+2) instanceof You2 && board.get(row+1, col+1) instanceof EmpOrGla2 && board.get(row, col+1) instanceof EmpOrGla2)
                yVis = true; 
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+2, col-1) instanceof You2 && board.get(row+1, col-1) instanceof EmpOrGla2 && board.get(row+1, col) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col) instanceof You2 && board.get(row+1, col) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col+1) instanceof You2 && board.get(row+1, col+1) instanceof EmpOrGla2 && board.get(row+1, col) instanceof EmpOrGla2)
                yVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-1) instanceof You2 && board.get(row+1, col) instanceof Wall2 && board.get(row, col-1) instanceof Wall2)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof You2 && board.get(row+1, col) instanceof Wall2 && board.get(row, col+1) instanceof Wall2)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof You2 && board.get(row-1, col) instanceof Wall2 && board.get(row, col+1) instanceof Wall2)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof You2 && board.get(row-1, col) instanceof Wall2 && board.get(row, col-1) instanceof Wall2)
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        
        
        
        eVis = false; 
        try
        {
            if(board.get(row-2, col-1) instanceof Enemy2 && board.get(row-1, col-1) instanceof Empty2 && board.get(row-1, col) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col) instanceof Enemy2 && board.get(row-1, col) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col+1) instanceof Enemy2 && board.get(row-1, col+1) instanceof Empty2 && board.get(row-1, col) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row-1, col-2) instanceof Enemy2 && board.get(row, col-1) instanceof Empty2 && board.get(row-1, col-1) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof Enemy2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col) instanceof Enemy2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof Enemy2)
                eVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+2) instanceof Enemy2 && board.get(row, col+1) instanceof Empty2 && board.get(row-1, col+1) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row, col-2) instanceof Enemy2 && board.get(row, col-1) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col-1) instanceof Enemy2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col) instanceof Enemy2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+1) instanceof Enemy2)
                eVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+2) instanceof Enemy2 && board.get(row, col+1) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-2) instanceof Enemy2 && board.get(row+1, col-1) instanceof Empty2 && board.get(row, col-1) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col-1) instanceof Enemy2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col) instanceof Enemy2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof Enemy2)
                eVis = true;
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+2) instanceof Enemy2 && board.get(row+1, col+1) instanceof Empty2 && board.get(row, col+1) instanceof Empty2)
                eVis = true; 
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+2, col-1) instanceof Enemy2 && board.get(row+1, col-1) instanceof Empty2 && board.get(row+1, col) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col) instanceof Enemy2 && board.get(row+1, col) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col+1) instanceof Enemy2 && board.get(row+1, col+1) instanceof Empty2 && board.get(row+1, col) instanceof Empty2)
                eVis = true;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-1) instanceof Enemy2 && (board.get(row+1, col) instanceof Wall2 || board.get(row+1, col) instanceof Glass2 || board.get(row+1, col) instanceof You2) && (board.get(row, col-1) instanceof Wall2 || board.get(row, col-1) instanceof Glass2 || board.get(row, col-1) instanceof You2))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof Enemy2 && (board.get(row+1, col) instanceof Wall2 || board.get(row+1, col) instanceof Glass2 || board.get(row+1, col) instanceof You2) && (board.get(row, col+1) instanceof Wall2 || board.get(row, col+1) instanceof Glass2 || board.get(row, col+1) instanceof You2))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof Enemy2 && (board.get(row-1, col) instanceof Wall2 || board.get(row-1, col) instanceof Glass2 || board.get(row-1, col) instanceof You2) && (board.get(row, col+1) instanceof Wall2 || board.get(row, col+1) instanceof Wall2 || board.get(row, col+1) instanceof You2))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof Enemy2 && (board.get(row-1, col) instanceof Wall2 || board.get(row-1, col) instanceof Glass2 || board.get(row-1, col) instanceof You2) && (board.get(row, col-1) instanceof Wall2 || board.get(row, col-1) instanceof Glass2 || board.get(row, col-1) instanceof You2))
                eVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-1) instanceof You2 && (board.get(row+1, col) instanceof Wall2 || board.get(row+1, col) instanceof Enemy2) && (board.get(row, col-1) instanceof Wall2 || board.get(row, col-1) instanceof Enemy2))
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof You2 && (board.get(row+1, col) instanceof Wall2 || board.get(row+1, col) instanceof Enemy2) && (board.get(row, col+1) instanceof Wall2 || board.get(row, col+1) instanceof Enemy2))
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof You2 && (board.get(row-1, col) instanceof Wall2 || board.get(row-1, col) instanceof Enemy2) && (board.get(row, col+1) instanceof Wall2 || board.get(row, col+1) instanceof Enemy2))
                yVis = false;
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof You2 && (board.get(row-1, col) instanceof Wall2 || board.get(row-1, col) instanceof Enemy2) && (board.get(row, col-1) instanceof Wall2 || board.get(row, col-1) instanceof Enemy2))
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
