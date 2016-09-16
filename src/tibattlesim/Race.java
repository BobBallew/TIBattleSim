
package tibattlesim;

/**
 *
 * @author BoB
 */
public enum Race {
    
    FEDERATIONOFSOL(5,9,7,9,9,3,8,6),
    THEBARONYOFLETNEV(5,9,7,9,9,3,8,6),
    THEEMIRATESOFHACAN(5,9,7,9,9,3,8,6),
    SARDAKKNORR(5,9,7,9,9,3,8,6), 
    UNIVERSITIESOFJOLNAR(5,9,7,9,9,3,8,6),
    THEL1Z1XMINDNET(5,9,7,9,9,3,8,6),
    THEMENTAKCOALITION(5,9,7,9,9,3,8,6),
    THENAALUCOLLECTIVE(5,9,7,9,9,3,8,6),
    THEXXCHAKINGDOM(5,9,7,9,9,3,8,6),
    THEYSSARILTRIBES(5,9,7,9,9,3,8,6),
    THEWINNU(5,9,7,9,9,3,8,6),
    EMBERSOFMUAAT(5,9,7,9,9,3,8,6),
    THEYINBROTHERHOOD(5,9,7,9,9,3,8,6),
    THECLANOFSAAR(5,9,7,9,9,3,8,6),
    THEGHOSTSOFCREUSS(5,9,7,9,9,3,8,6),
    THENEKROVIRUS(5,9,7,9,9,3,8,6),
    THEARBOREC(5,9,7,9,9,3,8,6);
    
    private final int dreadnoughtCV;
    private final int carrierCV;
    private final int cruiserCV;
    private final int destroyerCV;
    private final int fighterCV;
    private final int warSunCV;
    private final int groundForceCV;
    private final int pdsCV;
    
    //constructor
    Race(int dreadnoughtCV, int carrierCV, int cruiserCV, int destroyerCV,
       int fighterCV, int warSunCV, int groundForceCV, int pdsCV ){
        
        this.dreadnoughtCV = dreadnoughtCV;
        this.carrierCV = carrierCV;
        this.cruiserCV = cruiserCV;
        this.destroyerCV = destroyerCV;
        this.fighterCV = fighterCV;
        this.warSunCV = warSunCV;
        this.groundForceCV = groundForceCV;
        this.pdsCV = pdsCV;
    
    }//end of constructor
    
    public int getDreadNoughtCV()
    {
        return this.dreadnoughtCV;
    }
    
    public int getCarrierCV()
    {
        return this.carrierCV;
    }
    
    public int getCruiserCV()
    {
        return this.cruiserCV;
    }
    
    public int getDestroyerCV()
    {
        return this.destroyerCV;
    }
    
    public int getFighterCV()
    {
        return this.fighterCV;
    }
    
    public int getWarSunCV()
    {
        return this.warSunCV;
    }
    
    public int getGroundForceCV()
    {
        return this.groundForceCV;
    }
    
    public int getPDSCV()
    {
        return this.pdsCV;
    }
    
}//end of enum Race
