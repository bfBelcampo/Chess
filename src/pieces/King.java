package pieces;

public class King extends Piece {

	public King(int row, int column, boolean color) {
		setRow(row);
		setColumn(column);
		setColor(color);
		if(color) {
			setName(" ♔ ");
		} else setName(" ♚ ");
		setPieceName("King");
	}
	
	
	public boolean canMove(int newRow, int newColumn, Piece[][] pieceBoard) {
		if(this.getRow() == newRow && this.getColumn() == newColumn) {
			return false;
		}
			if(Math.abs(this.getRow()-newRow) < 2 && Math.abs(this.getColumn()-newColumn)<2) {
				if(noCollision(newRow, newColumn, pieceBoard)) {
					return true;
				}else if(this.getColor() != pieceBoard[7-newRow][newColumn].getColor()) {
					return true;
				}
			}
		
		return false;
	}
}