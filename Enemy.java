import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Enemy extends MovObj
{
    private int lastLoc;
    private int timer = 0; 
    
    public Enemy(Board board, int row, int col)
    {
        super(board, row, col);
    }
    
    public ImageIcon getImg()
    {
        if(yVis)
            return new ImageIcon("Enemy.png");
        return new ImageIcon("Fog.png");
    }
    
    public boolean hunt()
    {
        board.check(); 
        if(board.end == 0 || board.end == 1)
        {
            return false;
        }
        if(board.getYou() != null && board.getYou().eVis)
        {
            timer = 2; 
            return chase();
        }
        else
        {
            double e = Math.random();
            if(timer > 0)
            {
                if(e < .25 && row != 0 && lastLoc == 2)
                    up();
                else if(e < .5 && col != board.board.length-1 && lastLoc == 6)
                    right();
                else if(e < .75 && row != board.board.length-1 && lastLoc == 8)
                    down();
                else if(col != 0 && lastLoc == 4)
                    left();
                else
                    hunt();
            }
            else
            {
                if(e < .25 && row != 0)
                    up();
                else if(e < .5 && col != board.board.length-1)
                    right();
                else if(e < .75 && row != board.board.length-1)
                    down();
                else if(col != 0)
                    left();
                else
                    hunt();
            }
            board.check();
            timer--;
        }
        return false;
    }
    
    public boolean chase()
    {
        try
        {
            if(board.get(row-2, col-1) instanceof You && board.get(row-2, col-1).eVis){
                lastLoc = 2; return up();}
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col) instanceof You && board.get(row-2, col).eVis){
                lastLoc = 2; return up();}
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-2, col+1) instanceof You && board.get(row-2, col+1).eVis){
                lastLoc = 2; return up();}
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row-1, col-2) instanceof You && board.get(row-1, col-2).eVis){
                lastLoc = 4; return left();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col-1) instanceof You && board.get(row-1, col-1).eVis){
                lastLoc = 4; return left();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col) instanceof You && board.get(row-1, col).eVis){
                lastLoc = 2; return up();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+1) instanceof You && board.get(row-1, col+1).eVis){
                lastLoc = 2; return up();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row-1, col+2) instanceof You && board.get(row-1, col+2).eVis){
                lastLoc = 6; return right();} 
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row, col-2) instanceof You && board.get(row, col-2).eVis){
                lastLoc = 4; return left();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col-1) instanceof You && board.get(row, col-1).eVis){
                lastLoc = 4; return left();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+1) instanceof You && board.get(row, col+1).eVis){
                lastLoc = 6; return right();}  
        }
        
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row, col+2) instanceof You && board.get(row, col+2).eVis){
                lastLoc = 6; return right();} 
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+1, col-2) instanceof You && board.get(row+1, col-2).eVis){
                lastLoc = 4; return left();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col-1) instanceof You && board.get(row+1, col-1).eVis){
                lastLoc = 8; return down();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col) instanceof You && board.get(row+1, col).eVis){
                lastLoc = 8; return down();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+1) instanceof You && board.get(row+1, col+1).eVis){
                lastLoc = 8; return down();} 
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+1, col+2) instanceof You && board.get(row+1, col+2).eVis){
                lastLoc = 6; return right();}
        }
        catch(IndexOutOfBoundsException e){}
        
        try
        {
            if(board.get(row+2, col-1) instanceof You && board.get(row+2, col-1).eVis){
                lastLoc = 8; return down();}
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col) instanceof You && board.get(row+2, col).eVis){
                lastLoc = 8; return down();}
        }
        catch(IndexOutOfBoundsException e){}
        try
        {
            if(board.get(row+2, col+1) instanceof You && board.get(row+2, col+1).eVis){
                lastLoc = 8; return down();}
        }
        catch(IndexOutOfBoundsException e){}
        return false;
    }
    
    public void check()
    {
        super.check();
        if(board.getYou() == null)
        {
            yVis = true;
        }
    }
    
    public String toString()
    {
        if(super.yVis)
            return "!";
        return "*";
    }
}
