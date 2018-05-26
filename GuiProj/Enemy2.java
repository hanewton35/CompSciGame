public class Enemy2 extends MovObj2
{
    public Enemy2(Board2 board, int row, int col)
    {
        super(board, row, col);
    }
    
    public void check()
    {
        super.check();
        if(board.getYou2() == null)
        {
            yVis = true;
        }
    }
    
    public String toString()
    {
        if(yVis || !board.one)
            return "!";
        return "*";
    }
}
