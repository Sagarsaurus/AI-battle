
public class TeamOneAI {
    public static void swordsmanAI(Swordsman s)
    {
        
        if(s.canAttack(Direction.FORWARD))
        {
            s.attack(Direction.FORWARD);
        }
        else if(s.canMove(Direction.FORWARD))
        {
           s.moveForward();
        }
        else if(s.canAttack(Direction.UP))
        {
            s.attack(Direction.UP);
        }
        else if(s.canMove(Direction.UP))
        {
            s.moveUp();
        }
                  
    }
    
    public static void archerAI(Archer a) {
    	
    }
}
