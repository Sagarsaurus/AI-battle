import java.awt.Graphics;
import java.util.HashMap;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

abstract class Character extends Entity{
        boolean LIFE = true;
        int HP;
        int teamNum;
        HashMap<String, ArrayList<Coordinates>> fieldValues;
        ArrayList<Coordinates> coordinates;
        
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
	
	public abstract String getType(int perspectiveTeam);
	
	public HashMap<String,ArrayList<Coordinates>> getView(){
		int x = this.x;
		int y = this.y;
		for(Entity each: GameController.entities){
			int eachX = each.getX();
			int eachY = each.getY();
			
			if(eachY<y+GameController.CHARACTER_SIZE*2|y>eachY+GameController.CHARACTER_SIZE*2){	
				if (eachX<=x+GameController.CHARACTER_SIZE*4|x>eachX+GameController.CHARACTER_SIZE){
					String sample = each.toString();
					String assign = determineAssignment(sample, each);	
					
					if(!fieldValues.containsKey(assign)){
						
				        Coordinates coord = new Coordinates(eachX,eachY);						
				        fieldValues.put(assign,new ArrayList<Coordinates>());
					}
					else{
						coordinates = fieldValues.get(assign);
						Coordinates coord = new Coordinates(eachX, eachY);
						coordinates.add(coord);
						fieldValues.put(assign, coordinates);
					}
				}	
			}
			
		}
		return fieldValues;
	}
	
	public String determineAssignment(String s, Entity e){
		int at = s.indexOf("@");
		String s2 = s.substring(0, at);
		
		return e.getType(teamNum);
	}
	private class Pair<E, A>{
		public final E e;
		public final A a;
		
		public Pair(A a, E e){
			this.a = a ;
			this.e = e;
		}
	}
}
