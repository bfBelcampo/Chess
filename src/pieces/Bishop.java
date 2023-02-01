package pieces;

public class Bishop extends Piece {

	public Bishop(int row, int column, boolean color) {
		setRow(row);
		setColumn(column);
		setColor(color);
		if(color) {
			setName(" ♗ ");
		} else setName(" ♝ ");
		setPieceName("Bishop");
	}
	
	public boolean canMove(int newRow, int newColumn, Piece[][] pieceBoard) {
		if(this.getRow()!= newRow && this.getColumn() != newColumn) {
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
		}
		return false;
	}
}