import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Castle extends Entity{
	private int hp;
	protected int teamNum;
	
	public Castle(int x, int y, int teamNum)
	{
	    super(x,y);
	    this.teamNum = teamNum;
		hp = 500;
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
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
