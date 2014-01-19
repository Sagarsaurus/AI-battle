import java.awt.Graphics;
import java.util.HashMap;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

abstract class Character extends Entity{
        boolean LIFE = true;
        int HP;
        int teamNum;
        
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
	    return collisionDetection.collisionAt(this, direction) == null;
	}
	
	public boolean canAttack(Direction direction)
    {
        return collisionDetection.collisionAt(this, direction) != null;
    }
	
	public void moveUp()
    {
        if((collisionDetection.collisionAt(this, Direction.UP) == null))
        {
            y += GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	public void moveDown()
    {
        if(collisionDetection.collisionAt(this, Direction.DOWN) == null)
        {
            y -= GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	private void moveLeft()
    {
        if(collisionDetection.collisionAt(this, Direction.LEFT) == null)
        {
            x -= GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	private void moveRight()
    {
        if(collisionDetection.collisionAt(this, Direction.RIGHT) == null)
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
	    getView();
	}
	
	public abstract String getType(int perspectiveTeam);
	
	public HashMap<String,ArrayList<Coordinates>> getView(){
	    HashMap<String, ArrayList<Coordinates>> fieldValues = new HashMap<String, ArrayList<Coordinates>>();
		int x = this.x;
		int y = this.y;
		
		int viewTopX = 0;
        int viewTopY = 0;
        
        if(facing == Direction.RIGHT)
        {
            viewTopX = x - (int)(GameController.CHARACTER_SIZE*1.5);
            viewTopY = y + (int)(GameController.CHARACTER_SIZE*2.5);
        }
        else
        {
            viewTopX = (int)(x - GameController.CHARACTER_SIZE*4.5);
            viewTopY = (int)(y + GameController.CHARACTER_SIZE*2.5); 
        }
        
		for(Entity each: GameController.entities){
			int eachX = each.getX();
			int eachY = each.getY();
			
			
			if(eachY < viewTopY && eachY > viewTopY - GameController.CHARACTER_SIZE*5){
				if (eachX > viewTopX && eachX < viewTopX + GameController.CHARACTER_SIZE*6){
					String sample = each.toString();
					String assign = determineAssignment(sample, each);	
					
					if(!fieldValues.containsKey(assign)){
						
				        ArrayList<Coordinates> temp = new ArrayList<Coordinates>();
				        temp.add(new Coordinates(eachX,eachY));
				        fieldValues.put(assign,temp);
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
	/**	Set keyset = fieldValues.keySet();
		System.out.println("View");
		for(Object str: keyset)
		{
		    ArrayList<Coordinates> temp = fieldValues.get(str);
		    
		    for(Coordinates cords: temp)
		    {
		        
		        System.out.println(str + " x:" + cords.getX() + " y:" + cords.getY());
		    }
		    System.out.println();
		}**/
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
