package mazeGame;

import java.util.Scanner;

/*
 * This code is for a game where the player is trapped in a maze and must reach the exit before running out of energy.
 */


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initializes scanner for manual user input
		Scanner s = new Scanner(System.in);
		
		//gets maze dimensions from the user
		System.out.println("Choose maze size: ");
		int mazeSize = s.nextInt();
		s.nextLine(); //clears the left out ENTER key in the scanner buffer after reading the maze size
		
		//creates the player
		Player p1 = new Player(mazeSize);
		
		//generates the maze with random exit and walls
		Maze w1 = new Maze(mazeSize);
		
		//Main Game Loop which runs as long as the player has energy
		while (p1.getEnergy()>0) {
			
			//prints current player attributes (position and energy)
			System.out.println("\nPlayer position: "+p1.getPlayerX()+","+p1.getPlayerY());
			System.out.println("Energy: "+p1.getEnergy());
			
			//primary game prompt which asks user to choose movement direction
			System.out.print("Move (W/A/S/D): ");
			String playerMove = s.nextLine().toUpperCase(); //accepts both lowercase and uppercase and transforms it to uppercase for consistency
			
			//maximum index in the maze to avoid leaving the grid
			int moveLimit = w1.getSize() - 1;
			
			//Movement Logic: Check boundaries > check if target tile is an exit or wall > move
			
			//Movement: UP / "W"
			if (playerMove.equals("W")) {
				//boundary check: ensures the player is not at the top edge
				if (p1.getPlayerY()>=0 && p1.getPlayerY()<moveLimit) {
					Tile currentTile = w1.getTile(p1.getPlayerX(),p1.getPlayerY()+1); //gets the target tile
					if (currentTile.getIsExit()) { //checks if the target tile is an exit
					    System.out.println("\nYou escaped the maze! You won!");
					    break;
					} else if (currentTile.getIsWall()) { //checks if the target tile is a wall
					    System.out.println("\nYou bumped into a wall!");
					    continue;
					} else { //otherwise allow movement
						p1.moveUp();
					}
				} else {
					System.out.println("\nYou've hit the boundary! Try again!");
				}
			
			//Movement: DOWN / "S"
			} else if (playerMove.equals("S")) {
				//boundary check: ensures the player is not at the bottom edge
				if (p1.getPlayerY()>0 && p1.getPlayerY()<=moveLimit) {
					Tile currentTile = w1.getTile(p1.getPlayerX(),p1.getPlayerY()-1); //gets the target tile
					if (currentTile.getIsExit()) { //checks if the target tile is an exit
					    System.out.println("\nYou escaped the maze! You won!");
					    break;
					} else if (currentTile.getIsWall()) { //checks if the target tile is a wall
					    System.out.println("\nYou bumped into a wall!");
					    continue;
					} else { //otherwise allow movement
						p1.moveDown();
					}
				} else {
					System.out.println("\nYou've hit the boundary! Try again!");
				}
				
			//Movement: RIGHT / "D"
			} else if (playerMove.equals("D")) {
				//boundary check: ensures the player is not at the rightmost edge
				if (p1.getPlayerX()>=0 && p1.getPlayerX()<moveLimit) {
					Tile currentTile = w1.getTile(p1.getPlayerX()+1,p1.getPlayerY()); //gets the target tile
					if (currentTile.getIsExit()) { //checks if the target tile is an exit
					    System.out.println("\nYou escaped the maze! You won!");
					    break;
					} else if (currentTile.getIsWall()) { //checks if the target tile is a wall
					    System.out.println("\nYou bumped into a wall!");
					    continue;
					} else { //otherwise allow movement
						p1.moveRight();
					}
				} else {
					System.out.println("\nYou've hit the boundary! Try again!");
				}
				
			//Movement: LEFT / "A"	
			} else if (playerMove.equals("A")) {
				//boundary check: ensures the player is not at the leftmost edge
				if (p1.getPlayerX()>0 && p1.getPlayerX()<=moveLimit) {
					Tile currentTile = w1.getTile(p1.getPlayerX()-1,p1.getPlayerY()); //gets the target tile
					if (currentTile.getIsExit()) { //checks if the target tile is an exit
					    System.out.println("\nYou escaped the maze! You won!");
					    break;
					} else if (currentTile.getIsWall()) { //checks if the target tile is a wall
					    System.out.println("\nYou bumped into a wall!");
					    continue;
					} else { //otherwise allow movement
						p1.moveLeft();
					}
				} else {
					System.out.println("\nYou've hit the boundary! Try again!");
				}
				
				
			} else {
				System.out.println("\nThat's an invalid input bruh! Try again!");
			}
			
			//checks if energy reached zero after moving
			//breaks the loop if player runs out of energy aka player loses
			if (p1.getEnergy()==0) {
				System.out.println("\nNo more energy left. You lost the game!");
				break;
			}
			
		} //end of while loop

		//closes the scanner
		s.close();
		
	} //main method

} //main class
