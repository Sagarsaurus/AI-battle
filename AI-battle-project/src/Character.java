import java.awt.Graphics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


abstract class Character{
	protected int x;
	protected int y;
	int yChange;
	boolean LIFE = true;
	Texture texture;
	Sprite sprite;

	public Character(){
	}
	
	public void draw(SpriteBatch batch){
	}
}