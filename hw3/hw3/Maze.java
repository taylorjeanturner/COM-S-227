package hw3;

import maze.MazeObserver;
import maze.Status;

/**
 * A Maze consists of MazeCells arranged in a 2D grid.
 * 
 * @author Taylor Turner
 * 
 */
public class Maze {

	/**
	 * Observer to be notified in case of changes to cells in this maze.
	 */
	private MazeObserver observer;
	/**
	 * The number of rows
	 */
	private int rows;
	/**
	 * The number of columns
	 */
	private int columns;
	/**
	 * Where the maze begins
	 */
	private MazeCell start;
	/**
	 * The goal of the maze
	 */
	private MazeCell goal;
	/**
	 * The 2D array that holds the maze cells
	 */
	private MazeCell myMaze[][];

	/**
	 * Constructs a maze based on a 2D grid. The given strings, rows, represent rows
	 * of a maze, where '#' represents a wall, a blank represents a possible path,
	 * 'S' represents the starting cell, and '$' represents the goal cell. The maze
	 * must be rectangular, which means the Strings in the given rows must have the
	 * same length. Also, there must be only one start cell and one goal cell in the
	 * maze. For each MazeCell in the maze, set its owner to be the current maze,
	 * its status as GOAL if it is the goal cell, UNVISITED if it is not the goal
	 * nor the wall. For each MazeCell that is accessible (not a wall), its
	 * accessible neighbors MUST be added in the order of top, left, bottom, right.
	 * Cells on the boundary of the maze or near a wall will have fewer accessible
	 * neighbors.
	 * 
	 * @param rows The maze
	 */
	public Maze(java.lang.String[] rows) {
		this.rows = rows.length;
		columns = rows[0].length();
		myMaze = new MazeCell[this.rows][columns];
		setObserver(observer);
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < columns; j++) {
				MazeCell m = new MazeCell(i, j);
				myMaze[i][j] = m;
				m.setOwner(this);
			}
		}

		for (int k = 0; k < this.rows; k++) {
			for (int l = 0; l < columns; l++) {
				if (rows[k].charAt(l) == 'S') {
					start = myMaze[k][l];
					start.setStatus(Status.UNVISITED);
					start.setOwner(this);
				}
				if (rows[k].charAt(l) == '$') {
					goal = myMaze[k][l];
					goal.setOwner(this);
					goal.setStatus(Status.GOAL);
				}
				if (rows[k].charAt(l) == ' ') {
					MazeCell path = myMaze[k][l];
					path.setStatus(Status.UNVISITED);
					path.setOwner(this);
				}
				if (rows[k].charAt(l) == '#') {
					MazeCell wall = myMaze[k][l];
					wall.setStatus(Status.WALL);
					wall.setOwner(this);
				}
			}
		}

		for (int x = 0; x < this.rows; x++) {
			for (int y = 0; y < columns; y++) {

				if (x != 0 && !myMaze[x - 1][y].getStatus().equals(Status.WALL)) {
					if (!myMaze[x][y].getNeighbors().contains(myMaze[x - 1][y])) {
						myMaze[x][y].addNeighbor(myMaze[x - 1][y]);
					}
				}

				if (y != 0 && !myMaze[x][y - 1].getStatus().equals(Status.WALL)) {
					if (!myMaze[x][y].getNeighbors().contains(myMaze[x][y - 1])) {
						myMaze[x][y].addNeighbor(myMaze[x][y - 1]);
					}
				}

				if (x != this.rows - 1 && !myMaze[x + 1][y].getStatus().equals(Status.WALL)) {
					if (!myMaze[x][y].getNeighbors().contains(myMaze[x + 1][y])) {
						myMaze[x][y].addNeighbor(myMaze[x + 1][y]);
					}
				}

				if (y != columns - 1 && !myMaze[x][y + 1].getStatus().equals(Status.WALL)) {
					if (!myMaze[x][y].getNeighbors().contains(myMaze[x][y + 1])) {
						myMaze[x][y].addNeighbor(myMaze[x][y + 1]);
					}
				}
			}
		}
	}

	/**
	 * Returns the cell at the given position.
	 * 
	 * @param row The Row
	 * @param col The column
	 * @return The cell at given row and column
	 */
	public MazeCell getCell(int row, int col) {
		return myMaze[row][col];
	}

	/**
	 * Returns the number of rows in this maze.
	 * 
	 * @return Row number
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Returns the number of columns in this maze.
	 * 
	 * @return Column number
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Returns the start cell for this maze.
	 * 
	 * @return The maze cell
	 */
	public MazeCell getStart() {
		return start;
	}

	/**
	 * Returns the goal cell for this maze.
	 * 
	 * @return The goal cell
	 */
	public MazeCell getGoal() {
		return goal;
	}

	/**
	 * Sets the observer for the cells of this maze.
	 * 
	 * @param obs
	 */
	public void setObserver(MazeObserver obs) {
		observer = obs;
	}

	/**
	 * Notifies the observer that the given cell's status has changed.
	 * 
	 * @param cell A given cell in the maze
	 */
	public void updateStatus(MazeCell cell) {
		if (observer != null) {
			observer.updateStatus(cell);
		}
	}

}