package pieces;

public class Rook extends Piece {

	public Rook(int row, int column, boolean color) {
		setRow(row);
		setColumn(column);
		setColor(color);
		if(color) {
			setName(" ♖ ");
		} else setName(" ♜ ");
		setPieceName("Rook");
	}
	
	
	public boolean canMove(int newRow, int newColumn, Piece[][] pieceBoard) {
		if(this.getRow() != newRow && this.getColumn() != newColumn) {
			return false;
		}else {
			//movement up or down
			if(this.getRow() != newRow) {
				//down movement
				if(this.getRow()>newRow) {
					for(int i = newRow+1; i<this.getRow(); i++ ) {
						if(!noCollision(i, newColumn, pieceBoard)) {
							return false;
						}
					}					
				}
				//up movement
				if(this.getRow()<newRow) {
					for(int i = newRow-1; i>this.getRow(); i-- ) {
						if(!noCollision(i, newColumn, pieceBoard)) {
							return false;
						}
					}					
				}
				//check if the place you want to move to is empty
				if(!noCollision(newRow,newColumn,pieceBoard)) {
					//check if the place you want to move to has an enemy piece on it
					if(this.getColor() != pieceBoard[7-newRow][newColumn].getColor()) {
						return true;
					}
				}else return true;
			}
			
			if(this.getColumn() != newColumn) {
				
				if(this.getColumn()>newColumn) {
					for(int i = newColumn+1; i<this.getColumn(); i++ ) {
						if(!noCollision(newRow, i, pieceBoard)) {
							return false;
						}
					}					
				}
				if(this.getColumn()<newColumn) {
					for(int i = newColumn-1; i>this.getColumn(); i-- ) {
						if(!noCollision(newRow, i, pieceBoard)) {
							return false;
						}
					}					
				}
				if(!noCollision(newRow,newColumn,pieceBoard)) {
					if(this.getColor() != pieceBoard[7-newRow][newColumn].getColor()) {
						return true;
					}
				}else return true;
			}
			
		}
		return false;
	}
}