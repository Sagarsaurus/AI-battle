import java.util.ArrayList;


public class CollisionDetection {
    ArrayList<Entity> entities;
    
    public CollisionDetection(ArrayList<Entity> entites)
    {
        this.entities = entites;
    }
    
    public boolean collisionAt(Direction direction)
    {
        int xDir = 0;
        int yDir = 0;
        if(direction == Direction.UP)
        {
            yDir = 1;
        }
        else if(direction == Direction.DOWN)
        {
            yDir = -1;
        }
        else if(direction == Direction.LEFT)
        {
            xDir = -1;
        }
        else if(direction == Direction.RIGHT)
        {
            xDir = 1;
        }
        
        
        
        return false;
    }
}
