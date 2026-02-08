package mazeGame;

/*
 * Creating Player class to represent the player in the maze
 * Tracks position and energy and handles movement logic
 */

/*
 * Attributes: Player's coordinates, Energy Level
 *Methods: Attribute getters, Movements (up, down, left, right)
 */

public class Player {
	
	//Defining player attributes
	private int x; //player's x coordinate
	private int y; //player's y coordinate
	private int energy; //player's energy level
	
	//Constructor to initialize player attributes
	//Sets player position to (0,0) or bottom-left
	Player (int size) { //requires maze size as input for setting energy level
		System.out.println("\nA new player has joined the game."); //prints to signal that a player has been created
		this.x = 0; //sets player's x coordinate to 0
		this.y = 0; //sets player's y coordinate to 0
		this.energy = size*2; //energy level is pre-set to twice the maze's size
	}
	
	//Attribute getters
	
	public int getPlayerX() {
		return this.x;
	}	
	
	public int getPlayerY() {
		return this.y;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	//Movement Methods (up, down, left, right)
	//Each method updates the coordinates and consumes 1 energy
	
	public void moveUp() {
		this.y = this.y + 1;
		this.energy = this.energy -1;
	}
	
	public void moveDown() {
		this.y = this.y - 1;
		this.energy = this.energy -1;
	}
	
	public void moveRight() {
		this.x = this.x + 1;
		this.energy = this.energy -1;
	}
	
	public void moveLeft() {
		this.x = this.x - 1;
		this.energy = this.energy -1;
	}
	
}