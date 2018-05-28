public class Wall2 extends Obj2
{   
    public Wall2(Board2 board, int row, int col)
    {
        super(board, row, col);
    }
    
    public String toString()
    {
        if(board.one || eVis)
            return "█";
        return "*";
    }
}
