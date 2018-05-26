public class Empty extends EmpOrGla
{
    public Empty(Board board, int row, int col)
    {
        super(board, row, col);
    }
    
    public String toString()
    {
        if(super.yVis)
            return " ";
        return "*";
    }
}
