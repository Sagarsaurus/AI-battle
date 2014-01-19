import java.util.ArrayList;


public class TeamOneAI {
    public static void swordsmanAI(Swordsman s)
    {
        
        ArrayList<Coordinates> enemies = s.getView().get("ES");
        
        int moveY = 0;
        int moveX = 0;
        if(enemies != null)
        {
            for(Coordinates coords: enemies)
            {
                if(coords.getY() > s.getY() - 32 && coords.getY() < s.getY() + 32)
                {
                    moveY = 1;
                }
                if(coords.getX() > s.getX())
                {
                    moveX = -2;
                }
                
            }
        }
        
        if(s.canAttack(Direction.FORWARD))
        {
            s.attack(Direction.FORWARD);
        }
        else if(s.canAttack(Direction.UP))
        {
            s.attack(Direction.UP);
        }
        else if(s.canAttack(Direction.DOWN))
        {
            s.attack(Direction.DOWN);
        }
        else if(Math.abs(moveY) > Math.abs(moveX))
        {
            if(moveY > 0)
            {
                s.moveDown();
            }
            else
            {
                s.moveUp(); 
            }
        }
        else
        {
            if(moveX > 0)
            {
                s.moveBackward();
            }
            else
            {
                s.moveForward(); 
            }
        }
        
                  
    }
    
    public static void archerAI(Archer a) {
    	System.out.println("got here");
    	a.archerAttack();
    }
}
