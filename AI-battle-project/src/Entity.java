import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Entity {
    
    protected Texture texture;
    protected Sprite sprite;
    protected float x;
    protected float y;
    protected int hp;
    protected Direction facing;
    int teamNum;
    
    protected CollisionDetection collisionDetection;
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract float getX();
    public abstract float getY();
    public abstract String getType(int perspectiveTeam);

    
    public Entity(float x, float y, CollisionDetection collisionDetection)
    {
        teamNum = -1;
        this.x = x;
        this.y = y;
        this.collisionDetection = collisionDetection;
        facing = Direction.RIGHT;
        hp = 1;
    }
    
    public float getLeftEdge()
    {
        return getX() - getWidth() / 2;
    }
    
    public float getRightEdge()
    {
        return getX() + getWidth() / 2;
    }
    
    public float getTopEdge()
    {
        return getY() + getHeight() / 2;
    }
    
    public float getBottomEdge()
    {
        return getY() - getHeight() / 2;
    }
    
    public boolean isGone()
    {
        return hp <= 0 || 
               getRightEdge() > GameController.CHARACTER_SIZE * 31 || 
               getLeftEdge() < -GameController.CHARACTER_SIZE ||
               getTopEdge() > GameController.CHARACTER_SIZE * 21 ||
               getBottomEdge() < -GameController.CHARACTER_SIZE;
    }
    public void update() {}
    
    
    
    public void draw(SpriteBatch batch)
    {
        if(sprite != null)
        {
            sprite.setPosition(x - getWidth() / 2, y - getHeight() / 2);
            if(facing == Direction.RIGHT && sprite.isFlipX())
            {
                sprite.flip(true, false);
            }
            else if(facing == Direction.LEFT && !sprite.isFlipX())
            {
                sprite.flip(true, false);
            }
            sprite.draw(batch);
        }
    }

}
