/**
 * Name: Salvador Cornejo
 * Email: scorne18@calstatela.edu
 * Class: CS2013
 * Assignment: 04
 * Purpose: In this program we use recursion to solve a board with seven tiles. We use recursion and backtracking to shift the
 * tiles where the adjacent of the tiles match all around in the board.
 */
package hw04;

public class Hexagon {

	   char[] tile;
	   int position = -1;
	   int tileNum;

	   //constructor
	  public Hexagon() {
		  
	  }

	  //constructor
	   public Hexagon(String colorString, int tileNum){ //constructor
	       tile = colorString.toCharArray(); // tile with all color segments
	       this.tileNum = tileNum;
	   }

	   //Shifts tile to the right once
	   public void shiftRight() {
	       char temp = tile[tile.length - 1];// grabs last value of array
	        for(int i = tile.length - 2; i >= 0 ; i--) {
	        	tile[i + 1] = tile[i];
	        }
			tile[0] = temp;
	   }

	   @Override
	   public String toString() {
		   String tileToString = new String(this.tile);
	       return "Position " + (position + 1) + ": Tile #"  + this.tileNum + ":  " +  tileToString.replace("", "   ").trim();
	   }
}