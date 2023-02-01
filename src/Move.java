//the move object exists to be easily save the information of a turn in the moveList

import pieces.*;

public class Move {
	
	private Piece piece;
	private int oldRow;
	private int oldColumn;
	private int newRow;
	private int newColumn;
	
	public Move(Piece piece,int oldRow, int oldColumn, int newRow, int newColumn  ) {
		setPiece(piece);
		setOldRow(oldRow);
		setOldColumn(oldColumn);
		setNewRow(newRow);
		setNewColumn(newColumn);
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getOldRow() {
		return oldRow;
	}

	public void setOldRow(int oldRow) {
		this.oldRow = oldRow;
	}

	public int getOldColumn() {
		return oldColumn;
	}

	public void setOldColumn(int oldColumn) {
		this.oldColumn = oldColumn;
	}

	public int getNewRow() {
		return newRow;
	}

	public void setNewRow(int newRow) {
		this.newRow = newRow;
	}

	public int getNewColumn() {
		return newColumn;
	}

	public void setNewColumn(int newColumn) {
		this.newColumn = newColumn;
	}
	
}
