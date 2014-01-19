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
		this(0,0,0, null);
		
	}
	
	public Swordsman(int x, int y, int teamNum, CollisionDetection collisionDetection)
	{
	    super(x,y, teamNum, collisionDetection);
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
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public String getType(int perspectiveTeam) 
    {
        if(perspectiveTeam == teamNum)
        {
            return "FS";
        }
        else
        {
            return "ES";
        }
    }
}
