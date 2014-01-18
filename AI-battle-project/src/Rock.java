import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Rock extends Entity{
    public Rock(int x, int y)
    {
        super(x,y);
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
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
