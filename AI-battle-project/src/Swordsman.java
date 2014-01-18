import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Swordsman extends Character{
	protected int x;
	protected int y;
	int yChange;
	boolean LIFE = true;

	public Swordsman(int x, int y)
	{
	    super(x,y);
	    texture = new Texture(Gdx.files.internal("assets/swordsman.png"));
	    sprite = new Sprite(texture, 0, 0, AIBattle.CHARACTER_SIZE, AIBattle.CHARACTER_SIZE);
	}
	
	public Swordsman(){
	    this(0,0);
	}
}