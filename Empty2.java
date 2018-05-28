public class Empty2 extends EmpOrGla2
{
    public Empty2(Board2 board, int row, int col)
    {
        super(board, row, col);
    }
    
    public String toString()
    {
        if((yVis && board.one) || (eVis && !board.one))
            return " ";
        return "*";
    }
}
