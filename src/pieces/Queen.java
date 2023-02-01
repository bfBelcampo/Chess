package pieces;

public class Queen extends Piece {

	public Queen(int row, int column, boolean color) {
		setRow(row);
		setColumn(column);
		setColor(color);
		if(color) {
			setName(" ♕ ");
		} else setName(" ♛ ");
		setPieceName("Queen");
	}
	
	
	public boolean canMove(int newRow, int newColumn, Piece[][] pieceBoard) {
		if(this.getRow() != newRow && this.getColumn() != newColumn) {

			if(Math.abs(this.getRow()-newRow) == Math.abs(this.getColumn()-newColumn)) {
				
				if(newRow>this.getRow()) {
					//up right
					if(newColumn>this.getColumn()) {
						for(int i = Math.abs(newColumn-this.getColumn())-1 ;i>0;i--) {
							if(!noCollision(this.getRow()+i,this.getColumn()+i, pieceBoard)) {
								return false;
							}
						}
					}
					//up left
					if(newColumn<this.getColumn()) {
						for(int i = Math.abs(newColumn-this.getColumn())-1 ;i>0;i--) {
							if(!noCollision(this.getRow()+i,this.getColumn()-i, pieceBoard)) {
								return false;
							}
						}
					}
				
				}else {
					//down right 
					if(newColumn>this.getColumn()) {
						for(int i = Math.abs(newColumn-this.getColumn())-1 ;i>0;i--) {
							if(!noCollision(this.getRow()-i,this.getColumn()+i, pieceBoard)) {
								return false;
							}
						}
					}
					//down left 
					if(newColumn<this.getColumn()) {
						for(int i = Math.abs(newColumn-this.getColumn())-1 ;i>0;i--) {
							if(!noCollision(this.getRow()-i,this.getColumn()-i, pieceBoard)) {
								return false;
							}
						}
					}
				}
				if(noCollision(newRow, newColumn, pieceBoard)) {
					return true;
				}else if(this.getColor() != pieceBoard[7-newRow][newColumn].getColor()) {
					return true;
				}
				
			}
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