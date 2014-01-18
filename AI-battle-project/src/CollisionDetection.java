import java.util.ArrayList;


public class CollisionDetection {
    ArrayList<Entity> entities;
    
    public CollisionDetection(ArrayList<Entity> entities)
    {
        this.entities = entities;
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
                        collisionEntity.getTopEdge() > entity.getBottomEdge() &&
                        collisionEntity.getBottomEdge() + 5 < entity.getTopEdge() &&
                        collisionEntity.getRightEdge()  > entity.getLeftEdge() &&
                        collisionEntity.getLeftEdge() < entity.getRightEdge() ||
                        collisionEntity.getTopEdge() + 5 > GameController.CHARACTER_SIZE * 20)
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
                        collisionEntity.getBottomEdge() - 5< entity.getTopEdge() &&
                        collisionEntity.getRightEdge() > entity.getLeftEdge() &&
                        collisionEntity.getLeftEdge() < entity.getRightEdge() ||
                        collisionEntity.getBottomEdge() - 5 < 0)
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
                        collisionEntity.getLeftEdge() - 5 < entity.getRightEdge() ||
                        collisionEntity.getLeftEdge() - 5 < 0)
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
                   collisionEntity.getLeftEdge() < entity.getRightEdge() || 
                   collisionEntity.getRightEdge() + 5 > GameController.CHARACTER_SIZE * 30)
                   {
                        return entity;
                   }
            }
        }
        
        
        
        
        return null;
    }
}
