import java.awt.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


abstract class Character extends Entity{
        boolean LIFE = true;
        int HP;
        int teamNum;

        
	public Character(){
	    this(0,0,0, null);
	}
	
	public Character(int x,int y, int teamNum, CollisionDetection collisionDetection)
	{
	    super(x,y, collisionDetection);
	    this.teamNum = teamNum;
	    if(teamNum == 0)
	    {
	        facing = Direction.RIGHT;
	    }
	    else
	    {
	        facing = Direction.LEFT;
	    }
	}

	public int getHP()
	{
	    return HP;
	}
	
	public int getWidth()
	{
	    return (int)sprite.getWidth();
	}
	
	public int getHeight()
    {
        return (int)sprite.getHeight();
    }
	
	public int getX()
    {
        return x;
    }
	
	public int getY()
    {
        return y;
    }
	
	public boolean canMove(Direction direction)
	{
	    return collisionDetection.collisionAt(this, direction) != null;
	}
	
	public boolean canAttack(Direction direction)
    {
        return collisionDetection.collisionAt(this, direction) != null;
    }
	
	public void moveUp()
    {
        if((collisionDetection.collisionAt(this, Direction.UP) != null))
        {
            y += GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	public void moveDown()
    {
        if(collisionDetection.collisionAt(this, Direction.DOWN) != null)
        {
            y -= GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	private void moveLeft()
    {
        if(collisionDetection.collisionAt(this, Direction.LEFT) != null)
        {
            x -= GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	private void moveRight()
    {
        if(collisionDetection.collisionAt(this, Direction.RIGHT) != null)
        {
            x += GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	public void moveForward()
	{
	    
	    if(facing == Direction.LEFT)
	    {
	        moveLeft();
	    }
	    else
	    {
	        moveRight();
	    }
	}
	
	public void moveBackward()
	{
	    if(facing == Direction.RIGHT)
        {
            moveLeft();
        }
        else
        {
            moveRight();
        }
	}
	
	public void update()
	{
	    moveForward();
	}
}
