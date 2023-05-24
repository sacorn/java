/**
 * Name: Salvador Cornejo
 * Email: scorne18@calstatela.edu
 * Class: CS2013
 * Assignment: 04
 * Purpose: In this program we use recursion to solve a board with seven tiles. We use recursion and backtracking to shift the
 * tiles where the adjacent of the tiles match all around in the board.
 */
package hw04;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {
   static Hexagon[] board = new Hexagon[7];
   static ArrayList<String> solution = new ArrayList<String>();

   public static void main(String[] args) throws Exception {
       Hexagon[] tileList = new Hexagon[7];
       Scanner in = new Scanner(System.in);

       System.out.println("Enter the path of the file where you have your list of tiles: ");
       String input = in.nextLine();
       File file = new File(input); 
       BufferedReader br = new BufferedReader(new FileReader(file)); 
       int i = 0;
       String st;
       //read in from file
       while ((st = br.readLine()) != null) {
    	   String[] tileColors = st.split(" ");
    	   tileColors[2] = tileColors[2].replaceAll(",", "");
    	   tileList[i] = new Hexagon(tileColors[2], ++i);
       } 

       //calls solve method to solve Hexagon
       solve(tileList, 0);
       if (solution.isEmpty()) {
           System.out.println("No Solutions found");
       } else {

          int k = 0;
           for(String str:solution){
               System.out.println("Solution Number #" + ++k + "---------------------------\n"
               		+ "                      SA  SB  SC  SD  SE  SF \n" +
            		   str +
            		   "---------------------------------------------");
           }
       }

   }

   //method to arrange tiles into board
   public static void solve(Hexagon[] tileList, int tilePosition) {
       if (tilePosition < board.length) {
           for (int i = 0; i < tileList.length; i++) {
               if (tileList[i].position == -1) { //looks for tiles not used
            	   board[tilePosition] = tileList[i];
                   tileList[i].position = tilePosition;
                   if (isSafe()) {
                	   
                       solve(tileList, tilePosition + 1);
                   }

                   for (int j = 0; j < 5; j++) {
                	   if(tilePosition == 0) continue;
                       tileList[i].shiftRight();
                       if (isSafe()) {
                           solve(tileList, tilePosition + 1);
                       }
                   }
                   tileList[i].shiftRight(); //Tiles goes back to original position
                   board[tilePosition] = null;
                   tileList[i].position = -1;
               }
           }
       } else {
           if (isSafe()) {
               StringBuilder str = new StringBuilder();
               for (Hexagon h : board) {
                   str.append(h.toString() + "\n");
               }
               solution.add(str.toString());
           }
       }
   }

   //Method to check if its safe to leave tile where it was placed
   public static boolean isSafe() {
		for(int i = 0; i <= 7; i++) { //board.length = 7
			if(i == 7) {
				if(board[i-7].tile[5] == board[i-1].tile[2] && board[i-6].tile[4] == board[i-1].tile[1] && board[i-2].tile[0] == board[i-1].tile[3]) {
					return true;
				}
				else {
					return false;
				}
			
			}

		    if(board[i] == null) {
		    	
		    	if(i == 1) {
		    		return true;
		    	}

		    	if(i == 2) { // we are not looking at tile number but board position
					if(board[i-2].tile[0] == board[i-1].tile[3]) {
						return true;
					}
					else {
						return false;
					}
					
				}

				if(i == 3) {
					if(board[i-3].tile[1] == board[i-1].tile[4] && board[i-2].tile[2] == board[i-1].tile[5]) {//GOOD
						return true;
					}
					else {
						return false;
					}
				
				}

				if(i == 4) {
					if(board[i-4].tile[2] == board[i-1].tile[5] && board[i-2].tile[3] == board[i-1].tile[0]) {//good
						return true;
					}
					else {
						return false;
					}
				
				}

				if(i == 5) {
					if(board[i-5].tile[3] == board[i-1].tile[0] && board[i-2].tile[4] == board[i-1].tile[1]) {//good
						return true;
					}
					else {
						return false;
					}
				}

				if(i == 6) {
					if(board[i-6].tile[4] == board[i-1].tile[1] && board[i-2].tile[5] == board[i-1].tile[2]) {
						return true;
					}
					else {
						return false;
					}
				}
		    }// if null
		
		}//for
		return false;
   }//isSafe

}//mainBBY