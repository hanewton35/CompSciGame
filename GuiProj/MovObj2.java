import javax.swing.ImageIcon;
import java.awt.Image;

public class MovObj2 extends Obj2
{
    public MovObj2(Board2 board, int row, int col)
    {
        super(board, row, col);
    }
    
    public boolean up()
    {
        if(board.get(row-1, col) instanceof You2)
        {
            board.place(new Empty2(board, row-1, col), row-1, col);
            board.end(false);
        }
        else if(!(board.get(row-1, col) instanceof Empty2))
        {
            board.swap(row, col, row-1, col);
            return true;
        }
        board.swap(row, col, row-1, col);
        return false;
    }
    
    public boolean right()
    {
        if(board.get(row, col+1) instanceof You2)
        {
            board.place(new Empty2(board, row, col+1), row, col+1);
            board.end(false);
        }
        else if(!(board.get(row, col+1) instanceof Empty2))
        {
            board.swap(row, col, row, col+1);
            return true;
        }
        board.swap(row, col, row, col+1);
        return false;
    }
    
    public boolean down()
    {
        if(board.get(row+1, col) instanceof You2)
        {
            board.place(new Empty2(board, row+1, col), row+1, col);
            board.end(false);
        }
        else if(!(board.get(row+1, col) instanceof Empty2))
        {
            board.swap(row, col, row+1, col);
            return true;
        }
        board.swap(row, col, row+1, col);
        return false;
    }
     
    public boolean left()
    {
        if(board.get(row, col-1) instanceof You2)
        {
            board.place(new Empty2(board, row, col-1), row, col-1);
            board.end(false);
        }
        else if(!(board.get(row, col-1) instanceof Empty2))
        {
            board.swap(row, col, row, col-1);
            return true;
        }
        board.swap(row, col, row, col-1);
        return false;
    }
}
