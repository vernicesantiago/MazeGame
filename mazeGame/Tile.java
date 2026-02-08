package mazeGame;

/*
 * Creating Tile class to represent a single cell within the maze
 * Each cell can be a wall, an exit, or a normal path
 */

/*
 * Attributes: isWall, isExit
 * Methods: Attribute getters
 */

public class Tile {
	
	//Defining tile attributes
	private boolean isWall; //true if a tile is a wall
	private boolean isExit; //true if a tile is an exit
	
	//Constructor to initialize tile attributes
	Tile (boolean isWall, boolean isExit) { //requires boolean inputs for setting tile as wall or exit or neither
		this.isWall = isWall; //sets isWall as true or false from input
		this.isExit = isExit; //sets isExit as true or false from input
	}

	//Attribute getters
	
	public boolean getIsWall() {
		return this.isWall;
	}
	
	public boolean getIsExit() {
		return this.isExit;
	}	
	
}