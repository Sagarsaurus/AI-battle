import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Castle extends Entity{
	
	public Castle(float x, float y, CollisionDetection collisionDetection, int teamNum)
	{
	    super(x,y, collisionDetection);
	    this.teamNum = teamNum;
		hp = 100;
		texture = new Texture(Gdx.files.internal("assets/castle.png"));
		sprite = new Sprite(texture, GameController.CHARACTER_SIZE * 2, GameController.CHARACTER_SIZE * 2);
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
        if(perspectiveTeam == teamNum)
        {
            return "FC";
        }
        else
        {
            return "EC";
        }
    }
}
