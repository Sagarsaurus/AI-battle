
public class TeamZeroAI {
    public static void swordsmanAI(Swordsman s)
    {
        s.moveForward();
        s.attack(Direction.FORWARD);
    }
    
    public static void archerAI(Archer a) {
    	a.archerAttack();
    }
}
