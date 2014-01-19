import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Arrow extends Entity{
	public Arrow(int x, int y, int teamNum, CollisionDetection collisionDetection, Class aiClass)
	{
	    super(x,y, collisionDetection);
	    texture = new Texture(Gdx.files.internal("assets/arrow.png"));
	    sprite = new Sprite(texture, 0, 0, 16, 16);
	    hp = 2;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(int perspectiveTeam) {
		// TODO Auto-generated method stub
		return null;
	}
}
