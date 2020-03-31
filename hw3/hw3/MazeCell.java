package hw3;

import java.awt.Point;
import java.util.ArrayList;

import maze.Status;

/**
 * Implementation of MazeCell that has a location in a 2D plane.
 * 
 * @author Taylor Turner
 */
public class MazeCell {
	/**
	 * the maze to which this MazeCell belongs.
	 */
	private Maze owner;
	/**
	 * Status of this cell.
	 */
	private Status status;
	/**
	 * The row number
	 */
	private int row;
	/**
	 * The column number
	 */
	private int col;
	/**
	 * The time stamp
	 */
	private int timeStamp;
	/**
	 * The parent
	 */
	private MazeCell theParent;
	/**
	 * ArrayList containing the neighbors
	 */
	private ArrayList<MazeCell> neighbors;

	/**
	 * Constructs a maze cell whose location is specified by the given row and
	 * column, whose status is WALL by default, and whose parent is null. The cell
	 * initially has no neighbors. Its initial time stamp is 0.
	 * 
	 * @param row The row number
	 * @param col The column number
	 */
	public MazeCell(int row, int col) {
		status = Status.WALL;
		this.row = row;
		this.col = col;
		timeStamp = 0;
		theParent = null;
		neighbors = new ArrayList<MazeCell>();
	}

	/**
	 * Adds an observer for changes in this cell's status.
	 * 
	 * @param maze The maze to which this cell belongs
	 */
	public void setOwner(Maze maze) {
		owner = maze;
	}

	/**
	 * Returns this cell's location as a point, which contains its row and column.
	 * 
	 * @return The location
	 */
	public java.awt.Point getLocation() {
		Point p = new Point(row, col);
		return p;
	}

	/**
	 * Adds a neighbor to this cell.
	 * 
	 * @param m The maze cell
	 */
	public void addNeighbor(MazeCell m) {
			neighbors.add(m);
	}

	/**
	 * Returns the neighbors of the current cell. If a cell has no neighbor, the
	 * method must still return an ArrayList, which is empty.
	 * 
	 * @return neighbors
	 */
	public java.util.ArrayList<MazeCell> getNeighbors() {
		return neighbors;
	}

	/**
	 * Update the status of this cell and notifies the owner that this current
	 * cell's status has changed
	 * 
	 * @param s The updated status
	 */
	public void setStatus(Status s) {
		status = s;
		if (owner != null) {
			owner.updateStatus(this);
		}
	}

	/**
	 * return the status of the current the status
	 * 
	 * @return status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Returns a string representation of this cell's row and column numbers
	 * enclosed by a pair of parenthesis, e.g., (3, 4), or (10, 0).
	 * 
	 * @Override toString in class java.lang.Object
	 */
	public java.lang.String toString() {
		return "(" + row + ", " + col + ")";
	}

	/**
	 * Gets the parent of this cell. This method returns null if the current cell
	 * has no parent.
	 * 
	 * @return Parent cell
	 */
	public MazeCell getParent() {
		if (theParent != null) {
			return theParent;
		}
		else {
			return null;
		}
	}

	/**
	 * Sets the parent of this cell with the given parent.
	 * 
	 * @param parent The parent cell
	 */
	public void setParent(MazeCell parent) {
		theParent = parent;
	}

	/**
	 * Returns the time stamp of this cell
	 * 
	 * @return The time stamp
	 */
	public int getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the time stamp of this cell
	 * 
	 * @param time Time Stamp
	 */
	public void setTimeStamp(int time) {
		timeStamp = time;
	}

	/**
	 * Computes the Manhattan distance between this cell and other cell. The
	 * distance between two points measured along axes at right angles. In a plane
	 * with p1 at (x1, y1) and p2 at (x2, y2), it is |x1 - x2| + |y1 - y2|.
	 * 
	 * @param other The other cell
	 * @return The Manhattan Distance
	 */
	public int distance(MazeCell other) {
		return Math.abs(other.row - this.row) + Math.abs(other.col - this.col);
	}

}
