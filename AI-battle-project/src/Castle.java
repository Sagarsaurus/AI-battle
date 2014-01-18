import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Castle {
	Sprite sprite;
	Texture texture;
	float x,y;
	int hp;
	
	public Castle(float x, float y)
	{
		hp = 500;
		texture = new Texture(Gdx.files.internal("assets/castle.png"));
		sprite = new Sprite(texture, AIBattle.CHARACTER_SIZE * 2, AIBattle.CHARACTER_SIZE * 2);
		sprite.setPosition(x, y);
	}

	public void draw(SpriteBatch batch)
	{
		sprite.draw(batch);
	}
}
