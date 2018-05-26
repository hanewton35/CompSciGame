import javax.swing.ImageIcon;

public class Wall extends Obj
{   
    public Wall(Board board, int row, int col)
    {
        super(board, row, col);
    }
    
    public String toString()
    {
        return "█";
    }
}
