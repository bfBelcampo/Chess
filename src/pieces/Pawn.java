package pieces;

public class Pawn extends Piece {

	public Pawn(int row, int column, boolean color) {
		setRow(row);
		setColumn(column);
		setColor(color);
		if(color) {
			setName(" ♙ ");
		} else setName(" ♟ ");
		setPieceName("Pawn");
	}
	
	
	public boolean canMove(int newRow, int newColumn, Piece[][] pieceBoard) {
		
		int direction = 1; 
		if(this.getColor()==false) {
			direction = -1;
		}
		
		
		
		//moving up/down
		if(this.getRow()-newRow == -direction && this.getColumn() == newColumn) {
			if(noCollision(newRow, newColumn, pieceBoard)) {
				return true;
			}
		}
		//moving 2 space up/down on first move
		if(this.getRow()-newRow == -direction*2 && this.getColumn() == newColumn && ((this.getRow() == 1 && direction == 1) || (this.getRow() == 6 && direction == -1))) {
			if(noCollision(newRow,newColumn, pieceBoard) && noCollision(newRow-direction,newColumn, pieceBoard)) {
				return true;
			}
		}
		//taking a piece diagonally
		if(this.getRow()-newRow == -direction && this.getColumn()-newColumn == -1 || this.getColumn()-newColumn == 1) {
			if(!noCollision(newRow, newColumn, pieceBoard)) {
				if(this.getColor() != pieceBoard[7-newRow][newColumn].getColor()) {
					return true;
				}
			}
		}
		return false;
	}
	/**special moving method, only available for the pawn
	 * 
	 * @param newRow
	 * @param newColumn
	 * @param pieceBoard
	 * @param piece
	 * @param oldRow
	 * @param oldColumn
	 * @return
	 */
	public boolean canEnPassant(int newRow, int newColumn, Piece[][] pieceBoard, Piece piece, int oldRow, int oldColumn) {
		int direction = 1; 
		if(this.getColor()==false) {
			direction = -1;
		}
		
		if(this.getRow()-newRow == -direction && this.getColumn()-newColumn == -1 || this.getColumn()-newColumn == 1) {
			if(oldRow-piece.getRow() == direction*2&& this.getRow() == piece.getRow() && piece.getPieceName().equals("Pawn")) {
				return true;
			}
		}
		
		return false;
	}
}
