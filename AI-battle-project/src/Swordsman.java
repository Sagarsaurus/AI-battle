import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Swordsman extends Character{
	protected int x;
	protected int y;
	boolean LIFE = true;
	Texture texture;
	final static int NUM_CHAR_SPACES = 6;
	Sprite sprite;
	int HP;
	
	public Swordsman(){
		texture = new Texture(Gdx.files.internal("assets/swordsman.png"));
		HP = 1;

		sprite = new Sprite(texture, 0, 0, AIBattle.CHARACTER_SIZE, AIBattle.CHARACTER_SIZE);
	}
	
	public void draw(SpriteBatch batch){
			
			sprite.setPosition(100, 100);
			sprite.draw(batch);
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
		System.out.println("The moveForward method called");
		
		x= (x+AIBattle.CHARACTER_SIZE*NUM_CHAR_SPACES);
		y= (y+AIBattle.CHARACTER_SIZE*NUM_CHAR_SPACES);
		
		System.out.println("X and Y are: " + x + " " + y);
	}
}
