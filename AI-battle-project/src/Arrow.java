import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Arrow extends Entity{
	float deltaX, deltaY;
	public Arrow(float x, float y, int teamNum, CollisionDetection collisionDetection, Class aiClass, double rotation)
	{
	    super(x,y, collisionDetection);
	    texture = new Texture(Gdx.files.internal("assets/arrow.png"));
	    sprite = new Sprite(texture, 0, 0, 16, 16);
	    sprite.rotate((float)rotation);
	    hp = 2;
	    this.teamNum = teamNum;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stubcollisionEntity
		return 16;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stubcollisionEntity
		return 16;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public float getY() {
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
		this.x += (int) (32*deltaX* 10 * Gdx.graphics.getDeltaTime());
		this.y += (int) (32*deltaY* 10 * Gdx.graphics.getDeltaTime());
		Entity entity = collisionDetection.collision(this);
		if(entity != null && entity.teamNum != this.teamNum)
		{
		    entity.hp -= 1;
		}
	}
}
