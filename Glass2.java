public class Glass2 extends EmpOrGla2
{
    public Glass2(Board2 board, int row, int col)
    {
        super(board, row, col);
    }
    
    public String toString()
    {
        if(board.one || eVis)
            return "□";
        return "*";
    }
}
