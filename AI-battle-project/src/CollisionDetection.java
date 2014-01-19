import java.util.ArrayList;


public class CollisionDetection {
    ArrayList<Entity> entities;
    
    public CollisionDetection(ArrayList<Entity> entities)
    {
        this.entities = entities;
    }
    
    public boolean collisionWall(Entity collisionEntity, Direction direction)
    {
        if(collisionEntity.getTopEdge() + 10 > GameController.CHARACTER_SIZE * 20 && direction == Direction.UP)     
        {
            return true;
        }
        else if(collisionEntity.getBottomEdge() - 10 < 0 && direction == Direction.DOWN)
        {
            return true;
        }
        else if(collisionEntity.getLeftEdge() - 10 < 0 && direction == Direction.LEFT)
        {
            return true;
        }
        else if(collisionEntity.getRightEdge() + 10 > GameController.CHARACTER_SIZE * 30 && direction == Direction.RIGHT) 
        {
            return true;
        }
        
        return false;
    }
    
    public Entity collisionAt(Entity collisionEntity, Direction direction)
    {
        int xDir = 0;
        int yDir = 0;
        if(direction == Direction.UP)
        {
            for(Entity entity: entities)
            {
                if(entity != collisionEntity &&
                        collisionEntity.getTopEdge() + 5 > entity.getBottomEdge() &&
                        collisionEntity.getBottomEdge()  < entity.getTopEdge() &&
                        collisionEntity.getRightEdge()  > entity.getLeftEdge() &&
                        collisionEntity.getLeftEdge() < entity.getRightEdge())
                        {
                             return entity;
                        }  
            }
        }
        else if(direction == Direction.DOWN)
        {
            for(Entity entity: entities)
            {
                if(entity != collisionEntity &&
                        collisionEntity.getTopEdge() > entity.getBottomEdge() &&
                        collisionEntity.getBottomEdge() - 5 < entity.getTopEdge() &&
                        collisionEntity.getRightEdge() > entity.getLeftEdge() &&
                        collisionEntity.getLeftEdge() < entity.getRightEdge())
                        {
                             return entity;
                        } 
            }
        }
        else if(direction == Direction.LEFT)
        {
            for(Entity entity: entities)
            {
                if(entity != collisionEntity &&
                        collisionEntity.getTopEdge() > entity.getBottomEdge() &&
                        collisionEntity.getBottomEdge() < entity.getTopEdge() &&
                        collisionEntity.getRightEdge() > entity.getLeftEdge() &&
                        collisionEntity.getLeftEdge() - 5 < entity.getRightEdge())
                        {
                             return entity;
                        }
            }
        }
        else if(direction == Direction.RIGHT)
        {
            for(Entity entity: entities)
            {
                if(entity != collisionEntity &&
                   collisionEntity.getTopEdge() > entity.getBottomEdge() &&
                   collisionEntity.getBottomEdge() < entity.getTopEdge() &&
                   collisionEntity.getRightEdge() + 5 > entity.getLeftEdge() &&
                   collisionEntity.getLeftEdge() < entity.getRightEdge())
                   {
                        return entity;
                   }
            }
        }
        
        
        
        
        return null;
    }
}
