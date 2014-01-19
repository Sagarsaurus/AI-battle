import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Arrow extends Entity{
	int deltaX, deltaY;
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
		return 16;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 16;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public String getType(int perspectiveTeam) {
		// TODO Auto-generated method stub
		if(this.teamNum==perspectiveTeam) {;
			return "FArrow";
		}
		
		return "EArrow";
	}
	
	@Override
	public void update() {
		this.x += (int) (16*deltaX * Gdx.graphics.getDeltaTime());
		this.y += (int) (16*deltaY * Gdx.graphics.getDeltaTime());
	}
}
