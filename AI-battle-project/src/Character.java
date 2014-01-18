import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


abstract class Character{
	Texture texture;
	Sprite sprite;
	int HP;

	public Character(){
	}
	
	public void draw(SpriteBatch batch){
	}
}