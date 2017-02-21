/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;

import java.io.Serializable;

/**
 *
 * @author scherr3143
 */
public class TicTacToe implements Serializable{

    int[][] board;
    private String player1;
    private String player2;
    private String activePlayer;

    public TicTacToe(){
        board = new int[3][3];
    }

    public TicTacToe(int[][] board, String p1, String p2){
        setBoard(board);
        setPlayer1(p1);
        setPlayer2(p2);
        setActivePlayer(p1);
    }
    
    public TicTacToe(String p1, String p2){
        board = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=0;
            }
        }
        setBoard(board);
        setPlayer1(p1);
        setPlayer2(p2);
        setActivePlayer(p1);
    }
    
    public void move(int pos, int player){
        int i=0;
        int j=0;
        if(pos<3){
            i=0;
            j=pos;
        }
        else if(pos<6){
            i=1;
            j=pos-3;
        }
        else if(pos<9){
            i=2;
            j=pos-6;
        }  
        if(player == 1){
            board[i][j]=1;
        }
        else{
            board[i][j]=2;
        }
    }
    
    public void switchActivePlayer(){
        if(activePlayer.equals(player1)){
            activePlayer = player2;
        }
        else{
            activePlayer = player1;
        }
    }
    
    public int[][] getBoard(){
        return board;
    }
    
    public void setBoard(int[][] board){
        this.board = board;
    }

    /**
     * @return the player1
     */
    public String getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    /**
     * @return the player2
     */
    public String getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    /**
     * @return the activePlayer
     */
    public String getActivePlayer() {
        return activePlayer;
    }

    /**
     * @param activePlayer the activePlayer to set
     */
    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }
}
