import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Swordsman extends Character{
	protected int x;
	protected int y;
	int yChange;
	boolean LIFE = true;
	Texture texture;
	Sprite sprite;

	public Swordsman(){
		texture = new Texture(Gdx.files.internal("assets/swordsman.png"));
		sprite = new Sprite(texture, 0, 0, 32, 32);
	}
	
public void draw(SpriteBatch batch){
		
		sprite.setPosition(10, 10);
		sprite.draw(batch);
	}
}