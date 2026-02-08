package mazeGame;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Creating Maze class to represent the maze itself
 * Generates a grid with a random exit tile and a specific number of random wall tiles
 */

/*
 * Attributes: Maze size, grid, exit coordinates, list of possible wall coordinates, 
 * list of selected wall coordinates, number of wall tiles
 * Methods: Attribute getters for maze size and tile
 */

public class Maze {
	
	//Defining tile attributes
	private int size; //maze size
	private int wallnum; //number of wall tiles
	private Tile[][] grid; //maze grid
	private int exitX; //exit's x coordinate
	private int exitY; //exit's y coordinate
	private ArrayList<int[]> gridCoords = new ArrayList<>(); //list of all possible wall coordinates
	private ArrayList<int[]> wallCoords = new ArrayList<>(); //list of selected wall coordinates
	
	//Constructor to initialize maze attributes
	//Sets up the maze grid, placed the exit, and generates random walls
	Maze (int size) { //requires maze size as input
		this.size = size; //sets maze size
		System.out.println("A maze of size "+this.size+" has been created."); //prints to signal that the maze has been created
		
		//sets exit coordinates to (0,0)
		this.exitX = 0;
		this.exitY = 0;
		//while condition to generate random exit coordinates that is not (0,0) or the starting position
		while(this.exitX==0 && this.exitY==0) {
			this.exitX = (int)(Math.random()*size);
			this.exitY = (int)(Math.random()*size);
		}
		
		//for loop to list coordinates that is not the starting position or exit
		//gridCoords is the pool of possible coordinates for walls
		for (int i=0; i < this.size; i++) {
			for (int j=0; j < this.size; j++) {
				if ((i==0 && j==0) || (i==exitX && j==exitY)) {
		            continue;
				}
				this.gridCoords.add(new int[] {i,j});
			}
		}
		
		//shuffles the coordinates in gridCoords list
		Collections.shuffle(this.gridCoords);
		
		//sets the number of wall tiles as size-2
		this.wallnum = size-2;
		
		//picks the first n coordinates from gridCoords list to become walls
		//where n = wallnum
		//wallCoords is the list of wall coordinates
		for (int k=0; k < this.wallnum; k++) {
			this.wallCoords.add(this.gridCoords.get(k));
		}
		
		//initializes the grid array
		this.grid = new Tile[size][size];
		
		//for loop to set all tiles to (false,false) or not wall and not exit
		for (int i=0; i < this.size; i++) {
			for (int j=0; j < this.size; j++) {
				this.grid[i][j] = new Tile(false,false);
			}
		}
		
		//places the exit tile into the grid
		this.grid[this.exitX][this.exitY] = new Tile(false, true);
//		System.out.println("Exit placed at " + exitX + "," + exitY); //CHECKER: EXIT LOCATION
		
		//for loop to place the wall tiles into the grid based on the selected coordinates in wallCoords list
		for (int k=0; k < this.wallCoords.size(); k++) {
			int[] coords = this.wallCoords.get(k);
		    int x = coords[0];
		    int y = coords[1];
		    this.grid[x][y] = new Tile(true, false);
//		    System.out.println("Wall placed at " + x + "," + y); //CHECKER: WALL LOCATION
		}		
	} //maze constructor
	
	//Attribute getters
	
	public int getSize() {
		return this.size;
	}
	
	public Tile getTile (int x, int y) {
		return this.grid[x][y];
	}
	
}
