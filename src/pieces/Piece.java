/**abstract class from which the different chess pieces will inherit from
 * 
 * @author brian
 *
 */
package pieces;


public abstract class Piece {
	
	private int row ;
	private int column ;
	private boolean color;
	private String name;
	private String pieceName;

	/**
	 *checks if the piece is allowed to move towards the desired location
	 *
	 * @param newRow
	 * @param newColumn
	 * @param pieceBoard
	 * @return
	 */
	public abstract boolean canMove(int newRow, int newColumn, Piece[][] pieceBoard);
	/**
	 * checks if there is no piece at a given location
	 * 
	 * @param row
	 * @param column
	 * @param pieceBoard
	 * @return
	 */
	public static Boolean noCollision(int row, int column, Piece[][] pieceBoard) {
		if(pieceBoard[7-row][column] == null) {
			return true;
		}else return false;
	}
	
	public void setRow(int newRow) {
		row = newRow;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setColumn(int newColumn) {
		column = newColumn;
	}
	
	public int getColumn() {
		return column;
	}
	
	protected void setColor(boolean newColor) {
		color = newColor;
	}
	
	public boolean getColor() {
		return color;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}

	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
}
