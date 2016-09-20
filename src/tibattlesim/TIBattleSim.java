package tibattlesim;

/**
 *
 * @author BoB
 */
public class TIBattleSim {

    static int attackerWins = 0;
    static int defenderWins = 0;
    static int tie = 0;
    
    public static void main(String[] args) {
    
        
    for(int i = 0; i < 1000; i++) 
    {
        Fleet attacker = new Fleet(Race.FEDERATIONOFSOL, 1,1,1,1,1,0,0,0,0);
        Fleet defender = new Fleet(Race.FEDERATIONOFSOL, 1,1,1,1,1,0,0,0,0);
        attacker.assignFleetDamage(defender.rollPDSDice());
        attacker.removeUnits();
        
        
        while(attacker.getTotalShips() > 0 && defender.getTotalShips() > 0)
        {
            
            int defenderHits = defender.rollSpaceBattleDice();
            int attackerHits = attacker.rollSpaceBattleDice();
            attacker.assignFleetDamage(defenderHits);
            defender.assignFleetDamage(attackerHits);
            attacker.removeUnits();
            defender.removeUnits();
            
        }
        
        if(attacker.getTotalShips() == 0 && defender.getTotalShips() > 0)
            defenderWins++;
        else if(defender.getTotalShips() == 0 && attacker.getTotalShips() > 0)
            attackerWins++;
        else
            tie++;
        
    }//end of for
    
    System.out.print(battleReport());
        
    }//end of main
    
    private static String battleReport()
    {
        return String.format("%n%s%.1f%n%s%.1f%n%s%.1f%n", "Attacker Wins: %", (float)attackerWins/10,
                            "Defender Wins: %", (float)defenderWins/10, "Tie Battle: %", (float)tie/10);
    }
    
}//end of class
