
package tibattlesim;

/**
 *
 * @author BoB
 */
public class FederationOfSol extends Fleet{
    
    //constructor
    FederationOfSol(int dreadnoughts, int carriers, int cruisers, int destroyers,
                int fighters, int warSun, int groundForces, int pds, int spaceDocks){
        
        super(dreadnoughts, carriers, cruisers, destroyers, fighters, warSun, 
                groundForces, pds, spaceDocks);
    }
    
    public int rollDice(){
      return super.spaceBattle(5, 9, 7, 9, 9, 3);
    }
}
