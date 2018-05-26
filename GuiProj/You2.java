import java.util.*;

public class You2 extends MovObj2
{
    boolean almost = false; 
    
    public You2(Board2 board, int row, int col)
    {
        super(board, row, col);
    }
    
    public void check()
    {
        super.check();
        if(Math.abs(board.oRow - row) < board.board.length/2 && Math.abs(board.oCol - col) < board.board.length/2)
        {
            almost = true; 
        }
    }
    
    public String toString()
    {
        if(board.one || eVis)
            return "@";
        return "*";
    }
}
