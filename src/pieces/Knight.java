package pieces;

public class Knight extends Piece {

	public Knight(int row, int column, boolean color) {
		setRow(row);
		setColumn(column);
		setColor(color);
		if(color) {
			setName(" ♘ ");
		} else setName(" ♞ ");
		setPieceName("Knight");
	}
	
	
	public boolean canMove(int newRow, int newColumn, Piece[][] pieceBoard) {
		if((Math.abs(newRow-this.getRow()) == 2 && Math.abs(newColumn-this.getColumn()) == 1) || (Math.abs(newRow-this.getRow()) == 1 && Math.abs(newColumn-this.getColumn()) == 2)) {
			if(noCollision(newRow, newColumn, pieceBoard)) {
				return true;
			} else if(this.getColor() != pieceBoard[7-newRow][newColumn].getColor()) {
				return true;
			}
		}
		return false;
	}
}