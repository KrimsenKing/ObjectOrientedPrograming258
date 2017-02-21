/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;

/**
 *
 * @author scherr3143
 */
public class objPlayer {
    private int intPlayerNum;
    private String strUserName;
    private int intInStart;
    private char charAtHome[] = new char[4];
    
    public objPlayer(){}
    public objPlayer(int PlayerNum,String UserName){
        setIntPlayerNum(PlayerNum);
        setStrUserName(UserName);
        setIntInStart(4);
        char[] array ={'N','N','N','N'};
        setCharAtHome(array);
    }

    /**
     * @return the intPlayerNum
     */
    public int getIntPlayerNum() {
        return intPlayerNum;
    }

    /**
     * @param intPlayerNum the intPlayerNum to set
     */
    public void setIntPlayerNum(int intPlayerNum) {
        this.intPlayerNum = intPlayerNum;
    }

    /**
     * @return the strUserName
     */
    public String getStrUserName() {
        return strUserName;
    }

    /**
     * @param strUserName the strUserName to set
     */
    public void setStrUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    /**
     * @return the intInStart
     */
    public int getIntInStart() {
        return intInStart;
    }

    /**
     * @param intInStart the intInStart to set
     */
    public void setIntInStart(int intInStart) {
        this.intInStart = intInStart;
    }

    /**
     * @return the charAtHome
     */
    public char[] getCharAtHome() {
        return charAtHome;
    }

    /**
     * @param charAtHome the charAtHome to set
     */
    public void setCharAtHome(char[] charAtHome) {
        this.charAtHome = charAtHome;
    }
    
    
    
}
