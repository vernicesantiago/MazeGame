# 🧩 Java Console Maze Game

A strategic, console-based maze navigation game built with Java. The player must navigate a randomly generated grid to find the exit before her energy runs out.

## 🚀 How to Play
1. **Run the program**: Execute the `Main.java` file.
2. **Choose your difficulty**: Enter a maze size (e.g., `8` creates an 8x8 grid).
3. **Navigate**: Use the following keys to move:
   - `W`: Up
   - `S`: Down
   - `A`: Left
   - `D`: Right
4. **Objective**: Reach the **Exit** coordinate.
5. **Challenge**: Avoid **Walls** and manage your **Energy**. Every successful move costs 1 energy point.

## 🛠️ Technical Features
- **Procedural Generation**: Walls and the Exit are placed randomly to ensure every game is different.
- **Collision Detection**: The game "looks ahead" to prevent the player from walking into walls or out of the map boundaries.
- **Object-Oriented Design**:
  - `Maze`: Handles the grid generation and tile storage.
  - `Player`: Manages coordinates and energy consumption.
  - `Tile`: A simple object representing the state (if Wall or Exit) of a specific coordinate.

## 💻 Logic Breakdown
- **Energy System**: Starting energy is calculated as `Size * 2`.
- **Validation**:
  - Confirms the player is still inside the grid before moving to avoid "off-map" errors.
  - Prevents walls from spawning on the player's start position (0,0) or the exit.
