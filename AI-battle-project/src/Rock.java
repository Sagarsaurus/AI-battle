import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Rock extends Entity{
    public Rock(float x, float y, CollisionDetection collisionDetection)
    {
        super(x,y, collisionDetection);
        texture = new Texture(Gdx.files.internal("assets/stone.png"));
        sprite = new Sprite(texture, GameController.CHARACTER_SIZE, GameController.CHARACTER_SIZE);
    }
    
    @Override
    public int getWidth() {
        return (int)sprite.getWidth();
    }

    @Override
    public int getHeight() {
        return (int)sprite.getHeight();
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }
    
    public String getType(int perspectiveTeam)
    {
        return "R";
    }
}
