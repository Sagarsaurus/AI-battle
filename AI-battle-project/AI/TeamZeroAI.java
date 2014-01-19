import java.util.ArrayList;
import java.util.Random;


public class TeamZeroAI {
    
    
    public static void swordsmanAI(Swordsman s)
    {
        ArrayList<Coordinates> enemies = s.getView().get("ES");
        int moveY = 0;
        if(enemies != null)
        {
            for(Coordinates coords: enemies)
            {
                if(coords.getY() > s.getY() - 32 && coords.getY() < s.getY() + 32)
                {
                    moveY = 1;
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
        else if(moveY == 1 && s.canMove(Direction.UP))
        {
            s.moveUp();
        }
        else if(moveY == 1 && s.canMove(Direction.DOWN))
        {
            s.moveDown();
        }
        else if(moveY == 1 && s.canMove(Direction.BACKWARD))
        {
            s.moveBackward();
        }
        else if(moveY == 0 && s.canMove(Direction.FORWARD))
        {
            s.moveForward();
        }
        else if(s.getY() > GameController.CHARACTER_SIZE * 10)
        {
            s.moveDown(); 
        }
        else if(s.getY() < GameController.CHARACTER_SIZE * 10)
        {
            s.moveUp(); 
        }
    }
    
    public static void archerAI(Archer a) {
    	Random rand = new Random();
    	int index = rand.nextInt(GameController.entities.size());
    	while(GameController.entities.get(index).teamNum==a.teamNum) {
    		index = rand.nextInt(GameController.entities.size());
    	}
    	
        a.shoot(GameController.entities.get(index).x,GameController.entities.get(index).y);
    }
}
