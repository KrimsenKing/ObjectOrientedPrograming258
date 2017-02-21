/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author scherr3143
 */
public class Trouble implements Serializable {

    private int intCurrentPlayer;
    private objPlayer player1;
    private objPlayer player2;
    private objPlayer player3;
    private objPlayer player4;
    private objTHEGame gamePlayable;
    
    public void Trouble(){}
    
    public void Trouble(int CurrentPlayer,objTHEGame game){
        setIntCurrentPlayer(CurrentPlayer);
        setGamePlayable(game);
    }

    /**
     * @return the intCurrentPlayer
     */
    public int getIntCurrentPlayer() {
        return intCurrentPlayer;
    }

    /**
     * @param intCurrentPlayer the intCurrentPlayer to set
     */
    public void setIntCurrentPlayer(int intCurrentPlayer) {
        this.intCurrentPlayer = intCurrentPlayer;
    }

    /**
     * @return the objTHEGame
     */
    public Object getGamePlayable() {
        return gamePlayable;
    }

    /**
     * @param objTHEGame the objTHEGame to set
     */
    public void setGamePlayable(objTHEGame gamePlayable) {
        this.gamePlayable = gamePlayable;
    }
}
