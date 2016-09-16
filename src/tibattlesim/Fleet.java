
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

public abstract class Fleet {
    
    /*
    the ships array stores the amount of each ship in the fleet.
    the extra hitpoint of the dreadnought and the warsun are stored as units
    and referred to as dreadnought2 and warSun2.
    */
    private int[] ships = new int[9];
    
    //these variables are for organizing the order of the units in the ships array
    //and are assigned values 0-7
    private int dreadnoughts2;
    private int warSun2;
    private int carriers2;
    private int fighters;
    private int carriers;
    private int cruisers;
    private int destroyers;
    private int dreadnoughts;
    private int warSun;
   
    private Race race;

    //variables for storing the amount of units present but not in battle
    private int groundForces;
    private int pds;
    private int spaceDocks;
   
    //constructor
    /*
    fighters, pds, and ground forces can further be validated against carrying
    capacity of the fleet:
        if( fighters > warsun * 3 + carriers * 6 + spaceDocks * 3 - pds - groundForces)
            throw new IllegalArgumentException("Fleet has exceeded maximum capacity");
    The only issue with this validation is differentiating between carried pds
    units and active pds units. probably not worth it.
    */
    public Fleet(Race race, int dreadnoughts, int carriers, int cruisers, int destroyers,
                int fighters, int warSun, int groundForces, int pds, int spaceDocks)
    {
        
        this.race = race;

       //for testing purposes only. replace with some logic...probably
       this.dreadnoughts2 = 0;
       this.warSun2 = 1;
       this.carriers2 = 2;
       this.fighters = 3;
       this.carriers = 4;
       this.destroyers = 5;
       this.cruisers = 6;
       this.dreadnoughts = 7;
       this.warSun = 8;

       if(dreadnoughts < 0 || dreadnoughts > 5)
           throw new IllegalArgumentException("Dreadnoughts must be 0-5");
       else{
           ships[this.dreadnoughts] = dreadnoughts;
           ships[this.dreadnoughts2] = dreadnoughts;
            }

       if(carriers < 0 || carriers > 4)
           throw new IllegalArgumentException("Carriers must be 0-4");
       else
           ships[this.carriers] = carriers;

       if(cruisers < 0 || cruisers > 8)
           throw new IllegalArgumentException("Cruisers must be 0-8");
       else
           ships[this.cruisers] = cruisers;

       if(destroyers < 0 || destroyers > 8)
           throw new IllegalArgumentException("Destroyers must be 0-8");
       else
           ships[this.destroyers] = destroyers;

       if(fighters < 0 || fighters > 10)
           throw new IllegalArgumentException("Fighters must be 0-10");
       else
           ships[this.fighters] = fighters;

       if(warSun < 0 || warSun > 2)
           throw new IllegalArgumentException("War Suns must be 0-2");
       else{
           ships[this.warSun] = warSun;
           ships[this.warSun2] = warSun;
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
        return ships[this.dreadnoughts];
    }
    
    public int getDreadnoughts2()
    {
        return ships[dreadnoughts2];
    }

    //return carriers
    public int getCarriers()
    {
        return ships[this.carriers];
    }
    
    public int getCarriers2()
    {
        return ships[carriers2];
    }

    //return cruisers
    public int getCruisers()
    {
        return ships[this.cruisers];
    }

    //return destroyers
    public int getDestroyers()
    {
        return ships[this.destroyers];
    }

    //return fighters
    public int getFighters()
    {
        return ships[this.fighters];
    }

    //return warsun
    public int getWarSun()
    {
        return ships[this.warSun];
    }
    
    public int getWarSun2()
    {
        return ships[warSun2];
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
        int total = 0;
        for(int unit: ships)
            total += unit;

        return total - getWarSun2()- getDreadnoughts2() - getCarriers2();
    }

    public void removeUnits(int hits)
    {
        for(int i = hits; i > 0; i--)
        {
            for(int unit = 0; unit < ships.length; unit ++)
            {
                if(ships[unit] > 0)
                {
                    ships[unit]--;
                    break;
                }
            }
        }
    }//end of removeUnits()
    
    public void removeFighters(int hits)
    {
        for(int i = hits; i > 0; i--)
        {
            if(getFighters() > 0)
                ships[fighters]--;
        }
    }//end of removeFighters
    
    public int rollAntifighterBarrageDice()
    {
        int hits = 0;
        
        for(int i = getDestroyers(); i > 0; i--)
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
