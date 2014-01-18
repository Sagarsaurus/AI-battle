import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Swordsman extends Character{
	boolean LIFE = true;
	final static int NUM_CHAR_SPACES = 6;
	int HP;
	
	public Swordsman(){
		this(0,0,0);
		
	}
	
	public Swordsman(int x, int y, int teamNum)
	{
	    super(x,y, teamNum);
	    texture = new Texture(Gdx.files.internal("assets/swordsman.png"));
	    sprite = new Sprite(texture, 0, 0, GameController.CHARACTER_SIZE, GameController.CHARACTER_SIZE);
	    HP = 1;
	}
	
	public boolean canMove(int direction){
		return true;
	}
	
	public boolean isDead(int hp){
		return HP==0;
	}
	
	public int returnHP(){
		return HP;
	}
	
	public void moveForward(){		
		x+=GameController.CHARACTER_SIZE*NUM_CHAR_SPACES * Gdx.graphics.getDeltaTime();
	}

	public Sprite getSprite() {
		return sprite;
	}
}
