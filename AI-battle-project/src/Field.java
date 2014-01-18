import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Field
{
	Sprite sprite;
	Texture texture;
	float x,y;
	
	public Field()
	{
		texture = new Texture(Gdx.files.internal("assets/grass.png"));
		sprite = new Sprite(texture,20,20);
	}
    public void draw(SpriteBatch batch)
    {
    	x = 0;
    	y = 0;
    	
    	while(y < 480)
    	{
    		x = 0;
    		while(x < 800)
    		{
    			sprite.setPosition(x, y);
        		sprite.draw(batch);
        		x = x + sprite.getWidth();        		
    		}
    		y = y + sprite.getHeight();
    	}
    }
}