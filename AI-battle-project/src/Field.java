import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Field
{
	Sprite fieldSprite;
	Rock[] rocks;
	Texture fieldTexture, rockTexture;
	float x,y;
	int rockX, rockY, numRock;
	Random rand;
	
	public Field()
	{
		fieldTexture = new Texture(Gdx.files.internal("assets/grass.png"));
		fieldSprite = new Sprite(fieldTexture, GameController.CHARACTER_SIZE, GameController.CHARACTER_SIZE);
		
		

		rand = new Random();

		numRock = 20;

		rocks = new Rock[numRock];
				
		
	}
    public void draw(SpriteBatch batch)
    {
    	x = 0;
    	y = 0;
    	

    	while(y < GameController.CHARACTER_SIZE * 20)
    	{
    		x = 0;
    		while(x < GameController.CHARACTER_SIZE * 30)
    		{
    			fieldSprite.setPosition(x, y);
    			fieldSprite.draw(batch);
        		x = x + fieldSprite.getWidth();        		
    		}
    		y = y + fieldSprite.getHeight();
    	}
    }
    
    public Rock[] getRocks() {
    	return rocks;    	
    }
}
