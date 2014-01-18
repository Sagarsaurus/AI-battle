import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Entity {
    
    protected Texture texture;
    protected Sprite sprite;
    protected int x;
    protected int y;
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getX();
    public abstract int getY();
    public void update() {}
    protected int teamNum;
    
    public Entity(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void draw(SpriteBatch batch)
    {
        if(sprite != null)
        {
            sprite.setPosition(x - getWidth() / 2, y - getHeight() / 2);
            sprite.draw(batch);
        }
    }
}
