/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author scherr3143
 */
public class objTHEGame {
    
    private char chrBoard[] = new char[27];
    private Object[] objPlayers;
    
    
    public void objTHEGame(){}
   
    
    //Sets positions for each player as they enter the game
    public void setPlayerPositions(){
        
    }
    //starts a new game with players that are available
    public void StartGame(){
        
        
    }
    //Based on die roll player may move
    public void playerMovement(){
        
        
    }
    //checks if landing on itself or another player
    public void landedOn(){
        
        
    }
    //returns the random die roll
    public int rollDie(){
        return ThreadLocalRandom.current().nextInt(1,6);
    }
    
}
