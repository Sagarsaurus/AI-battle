import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Field
{
	Sprite fieldSprite;
	Sprite[] rockSpirtes;
	Texture fieldTexture, rockTexture;
	float x,y;
	int rockX, rockY, numRock;
	Random rand;
	
	public Field()
	{
		fieldTexture = new Texture(Gdx.files.internal("assets/grass.png"));
		fieldSprite = new Sprite(fieldTexture, AIBattle.CHARACTER_SIZE, AIBattle.CHARACTER_SIZE);
		
		rockTexture = new Texture(Gdx.files.internal("assets/stone.png"));

		rand = new Random();

		numRock= 20;

		rockSpirtes = new Sprite[numRock];
				
		for(int i = 0; i < numRock; i++)
		{
			rockSpirtes[i] = new Sprite(rockTexture, AIBattle.CHARACTER_SIZE, AIBattle.CHARACTER_SIZE);
			rockSpirtes[i].setPosition(AIBattle.CHARACTER_SIZE*2 + rand.nextInt(800 - AIBattle.CHARACTER_SIZE*4),rand.nextInt(480-AIBattle.CHARACTER_SIZE));
		}
	}
    public void draw(SpriteBatch batch)
    {
    	x = 0;
    	y = 0;
    	

    	while(y < AIBattle.CHARACTER_SIZE * 20)
    	{
    		x = 0;
    		while(x < AIBattle.CHARACTER_SIZE * 30)
    		{
    			fieldSprite.setPosition(x, y);
    			fieldSprite.draw(batch);
        		x = x + fieldSprite.getWidth();        		
    		}
    		y = y + fieldSprite.getHeight();
    	}
    	for(int i = 0; i < numRock; i ++)
    	{
    		rockSpirtes[i].draw(batch);
    	}
    }
    
    public Sprite[] getRocks() {
    	return rockSpirtes;    	
    }
}
