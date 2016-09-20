/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tibattlesim;

/**
 *
 * @author BoB
 */
public class Ship {

    
    private final String id;
    private int hp;
    private boolean admiral;
    
    public Ship(String id, int hp)
    {
        this.id = id;
        this.hp = hp;
    }
    
    public void setAdmiral()
    {
        this.admiral = true;
    }
    
    public String getID()
    {
        return this.id;
    }
    
    public int getHP()
    {
        return this.hp;
    }
    
    public void takeDamage()
    {
       this.hp--; 
    }
    
}   

