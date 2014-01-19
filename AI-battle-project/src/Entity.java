import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Entity {
    
    protected Texture texture;
    protected Sprite sprite;
    protected int x;
    protected int y;
    protected int hp;
    protected Direction facing;
    
    protected CollisionDetection collisionDetection;
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getX();
    public abstract int getY();
    public abstract String getType(int perspectiveTeam);

    
    public Entity(int x, int y, CollisionDetection collisionDetection)
    {
        this.x = x;
        this.y = y;
        this.collisionDetection = collisionDetection;
        facing = Direction.RIGHT;
    }
    
    public int getLeftEdge()
    {
        return getX() - getWidth() / 2;
    }        int HP;
    
    public int getRightEdge()
    {
        return getX() + getWidth() / 2;
    }
    
    public int getTopEdge()
    {
        return getY() + getHeight() / 2;
    }
    
    public int getBottomEdge()
    {
        return getY() - getHeight() / 2;
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
