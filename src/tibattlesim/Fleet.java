
package tibattlesim;
/*
Each race has a max of:
5 dreadnaughts
4 carriers
8 cruisers
8 destroyers
10 fighters
2 war suns
12 ground forces
6 PDS
3 space docks
*/

//imports
import java.security.SecureRandom;
import java.util.*;

public class Fleet {

    List<Ship> ships = new ArrayList<Ship>();

    private Race race;

    //variables for storing the amount of units present but not in battle
    private int groundForces;
    private int pds;
    private int spaceDocks;
   
    //constructor
    
    public Fleet(Race race, int dreadnoughts, int carriers, int cruisers, int destroyers,
                int fighters, int warSun, int groundForces, int pds, int spaceDocks)
    {
        
        this.race = race;

       if(dreadnoughts < 0 || dreadnoughts > 5)
           throw new IllegalArgumentException("Dreadnoughts must be 0-5");
       else{
           for(int i = dreadnoughts; i < 0; i--)
               ships.add(new Ship("dreadnought", 2));
            }

       if(carriers < 0 || carriers > 4)
           throw new IllegalArgumentException("Carriers must be 0-4");
       else{
           for(int i = carriers; i > 0; i-- )
               ships.add(new Ship("carrier", 1));
            }
       if(cruisers < 0 || cruisers > 8)
           throw new IllegalArgumentException("Cruisers must be 0-8");
       else
           for(int i = cruisers; i > 0; i--)
               ships.add(new Ship("cruiser", 1));

       if(destroyers < 0 || destroyers > 8)
           throw new IllegalArgumentException("Destroyers must be 0-8");
       else
           for(int i = destroyers; i > 0; i--)
               ships.add(new Ship("destroyer", 1));

       if(fighters < 0 || fighters > 10)
           throw new IllegalArgumentException("Fighters must be 0-10");
       else
           for(int i = fighters; i > 0; i--)
               ships.add(new Ship("fighter", 1));

       if(warSun < 0 || warSun > 2)
           throw new IllegalArgumentException("War Suns must be 0-2");
       else{
           for(int i = warSun; i > 0; i--)
               ships.add(new Ship("warsun", 2));
            }

       if(groundForces < 0 || groundForces > 12)
           throw new IllegalArgumentException("Ground forces must be 0-12");
       else
           this.groundForces = groundForces;

       if(pds < 0 || pds > 6)
           throw new IllegalArgumentException("PDS must be 0-6");
       else
           this.pds = pds;

       //can there be more than 1 space dock in a system??
       if(spaceDocks < 0 || spaceDocks > 3)
           throw new IllegalArgumentException("Space Docks must be 0-3");
       else
           this.spaceDocks = spaceDocks;

    }//end of constructor

    SecureRandom combatDie = new SecureRandom();//new RNG object
    
    //return dreadnoughts
    public int getDreadnoughts()
    {
        int count = 0;
        
        for(Ship thisShip: ships){
            if("dreadnought".equals(thisShip.getID()))
                count++;
        }
        return count;
    }

    //return carriers
    public int getCarriers()
    {
        int count = 0;
        
        for(Ship thisShip: ships){
            if("carrier".equals(thisShip.getID()))
                count++;
        }
        return count;
    }

    //return cruisers
    public int getCruisers()
    {
        int count = 0;
        
        for(Ship thisShip: ships){
            if("cruiser".equals(thisShip.getID()))
                count++;
        }
        return count;
    }

    //return destroyers
    public int getDestroyers()
    {
        int count = 0;
        
        for(Ship thisShip: ships){
            if("cruiser".equals(thisShip.getID()))
                count++;
        }
        return count;
    }

    //return fighters
    public int getFighters()
    {
        int count = 0;
        
        for(Ship thisShip: ships){
            if("fighter".equals(thisShip.getID()))
                count++;
        }
        return count;
    }

    //return warsun
    public int getWarSun()
    {
        int count = 0;
        
        for(Ship thisShip: ships){
            if("warsun".equals(thisShip.getID()))
                count++;
        }
        return count;
    }
    

    //return ground forces
    public int getGroundForces()
    {
        return this.groundForces;
    }

    //return pds
    public int getPDS()
    {
        return this.pds;
    }

    //return space docks
    public int getSpaceDocks()
    {
        return this.spaceDocks;
    }

    //return total ships in ships array
    public int getTotalShips()
    {
        if(ships.isEmpty())
            return 0;
        else
            return ships.size();
    }
    
    
    public void assignFleetDamage(int hits)//temporary- for testing
    {
        for(int i = hits; i > 0; i--)
        {
            if(getTotalShips() > 0)
            {
                for(Ship thisShip: ships)
                    if("dreadnought".equals(thisShip.getID()) && thisShip.getHP() > 1)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("warsun".equals(thisShip.getID()) && thisShip.getHP() > 1)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("carrier".equals(thisShip.getID()) && thisShip.getHP() > 1)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("fighter".equals(thisShip.getID()) && thisShip.getHP() > 0)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("destroyer".equals(thisShip.getID()) && thisShip.getHP() > 0)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("carrier".equals(thisShip.getID()) && thisShip.getHP() > 0)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("cruiser".equals(thisShip.getID()) && thisShip.getHP() > 0)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("dreadnought".equals(thisShip.getID()) && thisShip.getHP() > 0)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else if("warsun".equals(thisShip.getID()) && thisShip.getHP() > 0)
                    {
                        thisShip.takeDamage();
                        break;
                    }
                    else
                    {   
                        break;
                    }
            }
        }//end of outer for loop
        
     
    }//end of assignFleetDamage
    
    public void removeUnits()
    {
        Iterator<Ship> shipCounter = ships.iterator();
            while(shipCounter.hasNext())
            {
               Ship thisShip = shipCounter.next();
               if(thisShip.getHP() == 0)
                   shipCounter.remove();
            }
       
    }//end of removeUnits()
    
    
    
    public int rollAntifighterBarrageDice()
    {
        int hits = 0;
        
        for(int i = getDestroyers() * 2 ; i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getDestroyerCV())
                hits++;
        }
        return hits;
    }//end of antifighterBarrage

    public int rollSpaceBattleDice()
    {
        int hits = 0;

        for(int i = getDreadnoughts(); i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getDreadNoughtCV())
                hits++;
        }

        for(int i = getCarriers(); i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getCarrierCV())
                hits++;
        }

        for(int i = getCruisers(); i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getCruiserCV())
                hits++;
        }

        for(int i = getDestroyers(); i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getDestroyerCV())
                hits++;
        }

        for(int i = getFighters(); i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getFighterCV())
                hits++;
        }

        for(int i = getWarSun() * 3; i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getWarSunCV())
                hits++;
        }

        return hits;
     }//end of spaceBattle()

    public int rollPDSDice()
    {
        int hits = 0;

        for(int i = getPDS(); i > 0; i--)
        {
            if(1 + combatDie.nextInt(10) >= race.getPDSCV())
                hits++;
        }

        return hits;
    }

    @Override
    public String toString()
    {
        return String.format("%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n",
                "Total Ships in fleet: ", getTotalShips(),
                "Dreadnoughts: ", getDreadnoughts(),
                "Carriers: ", getCarriers(),
                "Cruisers: ", getCruisers(),
                "Destroyers: ", getDestroyers(),
                "Fighters: ", getFighters(),
                "War Suns: ", getWarSun(),
                "Ground Forces: ", getGroundForces(),
                "PDS: ", getPDS(),
                "Space Docks: ", getSpaceDocks());
    }
   
}//end of Fleet class
