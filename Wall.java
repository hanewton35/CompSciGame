import javax.swing.ImageIcon;

public class Wall extends Obj
{   
    public Wall(Board board, int row, int col)
    {
        super(board, row, col);
    }
    
    public ImageIcon getImg()
    {
        if(yVis)
            return new ImageIcon("Empty.png");
        return new ImageIcon("Fog.png");
    }
    
    public String toString()
    {
        return "█";
    }
}
