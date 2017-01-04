/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karlsaga;

/**
 *
 * @author OSBORNE
 */
public class Space {
     public int x;
     public int y;
     public Space addedBy;
     
     public Space(){}
     public Space(int x, int y){
         this.x=x;
         this.y=y;
     }
     public boolean equals(Object s){
         return ((Space)s).x == x && ((Space)s).y==y;
     }
     public String toString(){
         return "{"+x+","+y+"}";
     }
}
