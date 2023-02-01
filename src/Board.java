import java.util.ArrayList;
import java.util.Scanner;
import pieces.*;

/**this class handles most of the game logic and information of the game state
 */
public class Board {
	//the gameBoard holds the visual information of the board that can be displayed
	private static final String[][] gameBoard =  {{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", " ♜ ", "|", " ♞ ", "|", " ♝ ", "|", " ♛ ", "|", " ♚ ", "|", " ♝ ", "|", " ♞ ", "|", " ♜ ", "|", "  8"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", " ♟ ", "|", " ♟ ", "|", " ♟ ", "|", " ♟ ", "|", " ♟ ", "|", " ♟ ", "|", " ♟ ", "|", " ♟ ", "|", "  7"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "  6"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "  5"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "  4"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "  3"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", " ♙ ", "|", " ♙ ", "|", " ♙ ", "|", " ♙ ", "|", " ♙ ", "|", " ♙ ", "|", " ♙ ", "|", " ♙ ", "|", "  2"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{"|", " ♖ ", "|", " ♘ ", "|", " ♗ ", "|", " ♕ ", "|", " ♔ ", "|", " ♗ ", "|", " ♘ ", "|", " ♖ ", "|", "  1"},
							{"-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", "---", "-", ""},
							{" ", " A ", " ", " B ", " ", " C ", " ", " D ", " ", " E ", " ", " F ", " ", " G ", " ", " H ", "", ""}}; 
	//creating all piece objects (row, column, color(true is white, false is black))
	static Pawn p0 = new Pawn(1,0,true);
	static Pawn p1 = new Pawn(1,1,true);
	static Pawn p2 = new Pawn(1,2,true);
	static Pawn p3 = new Pawn(1,3,true);
	static Pawn p4 = new Pawn(1,4,true);
	static Pawn p5 = new Pawn(1,5,true);
	static Pawn p6 = new Pawn(1,6,true);
	static Pawn p7 = new Pawn(1,7,true);
	static Pawn P0 = new Pawn(6,0,false);
	static Pawn P1 = new Pawn(6,1,false);
	static Pawn P2 = new Pawn(6,2,false);
	static Pawn P3 = new Pawn(6,3,false);
	static Pawn P4 = new Pawn(6,4,false);
	static Pawn P5 = new Pawn(6,5,false);
	static Pawn P6 = new Pawn(6,6,false);
	static Pawn P7 = new Pawn(6,7,false);
	
	static Rook r0 = new Rook(0,0,true);
	static Rook r1 = new Rook(0,7,true);
	static Rook R0 = new Rook(7,0,false);
	static Rook R1 = new Rook(7,7,false);
	
	static Knight n0 = new Knight(0,1,true);
	static Knight n1 = new Knight(0,6,true);
	static Knight N0 = new Knight(7,1,false);
	static Knight N1 = new Knight(7,6,false);
	
	static Bishop b0 = new Bishop(0,2,true);
	static Bishop b1 = new Bishop(0,5,true);
	static Bishop B0 = new Bishop(7,2,false);
	static Bishop B1 = new Bishop(7,5,false);
	
	static Queen q0 = new Queen (0,3,true);
	static Queen Q0 = new Queen (7,3,false);
	
	static King k0 = new King (0,4,true);
	static King K0 = new King (7,4,false);
	
	//holds the information of the game state
	private static Piece[][] pieceBoard = {{R0,N0,B0,Q0,K0,B1,N1,R1},
									{P0,P1,P2,P3,P4,P5,P6,P7},
									{null,null,null,null,null,null,null,null},
									{null,null,null,null,null,null,null,null},
									{null,null,null,null,null,null,null,null},
									{null,null,null,null,null,null,null,null},
									{p0,p1,p2,p3,p4,p5,p6,p7},
									{r0,n0,b0,q0,k0,b1,n1,r1}};
	//a list of all moves
	//it's needed to check if castling and EnPassant are possible 
	static ArrayList<Move> moveList = new ArrayList<Move>();
	
	public Board() {
		
	}
	
	
	
	
	
	
	public static void movePiece(Pawn p, int row, int column) {
		//checks if the you can move to a given location
		boolean movable = p.canMove(row, column, pieceBoard);
		
		//extra case: checks if enPassant is possible
		if(moveList.size()>1 && !movable) {
			Move lastMove = moveList.get(moveList.size()-1);
			movable = p.canEnPassant(row,column, pieceBoard, lastMove.getPiece(),lastMove.getOldRow(), lastMove.getOldColumn());
			if(movable) {
				pieceBoard[7-lastMove.getNewRow()][lastMove.getNewColumn()] = null;
				deleteOldPosition(lastMove.getNewRow(), lastMove.getNewColumn());
			}			
		}
		//updates the piece, pieceBoard and gameBoard to the new locations
		if(movable) {
			int oldRow = p.getRow();
			int oldColumn = p.getColumn();
			Piece piece = pieceBoard[7-row][column];
			
			
			pieceBoard[7-oldRow][oldColumn] = null;
			
			if((p.getColor() == true && row == 7)||(p.getColor()== false && row == 0)) {
				promote(row, column, p.getColor());	
			}else pieceBoard[7-row][column] = p;
			
			if(checkedOwnKing(p.getColor())) {
				pieceBoard[7-oldRow][oldColumn] = p;
				pieceBoard[7-row][column] = piece;
				System.out.println("Your own king would be under attack!");
			}else {
				moveList.add(new Move(p, oldRow, oldColumn, row, column));
				
				deleteOldPosition(oldRow, oldColumn);
				writeNewPosition(pieceBoard[7-row][column].getName(),row,column);
				p.setRow(row);
				p.setColumn(column);
			}		
		}
	}
	/**asks the player into which piece he wants to promote his pawn and exchanges them
	 * 
	 * @param row
	 * @param column
	 * @param color
	 */
	private static void promote(int row, int column, boolean color) {
		int promo = 0;
		while(promo != 1 && promo != 2 && promo != 3 && promo != 4) {
			System.out.println("To which piece shall the pawn promote to?");
			System.out.println("1:Rook 2:Knight 3:Bishop 4:Queen");
			
			Scanner scan;
			scan = new Scanner(System.in);
			promo = scan.nextInt();
			
			switch(promo) {
				case 1: 
					pieceBoard[7-row][column] = new Rook(row, column, color);
					break;
				case 2: 
					pieceBoard[7-row][column] = new Knight(row, column, color);
					break;
				case 3: 
					pieceBoard[7-row][column] = new Bishop(row, column, color);
					break;
				case 4: 
					pieceBoard[7-row][column] = new Queen(row, column, color);
					break;
				default:
					System.out.println("Please enter a correct number");
					break;
			}
		}
	}






	public static void movePiece(Rook r, int row, int column) {
		boolean movable = r.canMove(row, column, pieceBoard);
		
		if(movable) {
			int oldRow = r.getRow();
			int oldColumn = r.getColumn();
			Piece piece = pieceBoard[7-row][column];
			
			
			pieceBoard[7-oldRow][oldColumn] = null;
			pieceBoard[7-row][column] = r;
			
			if(checkedOwnKing(r.getColor())) {
				pieceBoard[7-oldRow][oldColumn] = r;
				pieceBoard[7-row][column] = piece;
				System.out.println("Your own king would be under attack!");
			}else {
				moveList.add(new Move(r, oldRow, oldColumn, row, column));
				
				deleteOldPosition(oldRow, oldColumn);
				writeNewPosition(r.getName(),row,column);
				r.setRow(row);
				r.setColumn(column);
			}	
		}
	}
	
	public static void movePiece(Knight n, int row, int column) {
		boolean movable = n.canMove(row, column, pieceBoard);
		
		if(movable) {
			int oldRow = n.getRow();
			int oldColumn = n.getColumn();
			Piece piece = pieceBoard[7-row][column];
			
			
			pieceBoard[7-oldRow][oldColumn] = null;
			pieceBoard[7-row][column] = n;
			
			if(checkedOwnKing(n.getColor())) {
				pieceBoard[7-oldRow][oldColumn] = n;
				pieceBoard[7-row][column] = piece;
				System.out.println("Your own king would be under attack!");
			}else {
				moveList.add(new Move(n, oldRow, oldColumn, row, column));
				
				deleteOldPosition(oldRow, oldColumn);
				writeNewPosition(n.getName(),row,column);
				n.setRow(row);
				n.setColumn(column);
			}	
		}		
	}
	
	public static void movePiece(Bishop b, int row, int column) {
		boolean movable = b.canMove(row, column, pieceBoard);
		
		if(movable) {
			int oldRow = b.getRow();
			int oldColumn = b.getColumn();
			Piece piece = pieceBoard[7-row][column];
			
			
			pieceBoard[7-oldRow][oldColumn] = null;
			pieceBoard[7-row][column] = b;
			
			if(checkedOwnKing(b.getColor())) {
				pieceBoard[7-oldRow][oldColumn] = b;
				pieceBoard[7-row][column] = piece;
				System.out.println("Your own king would be under attack!");
			}else {
				moveList.add(new Move(b, oldRow, oldColumn, row, column));
				
				deleteOldPosition(oldRow, oldColumn);
				writeNewPosition(b.getName(),row,column);
				b.setRow(row);
				b.setColumn(column);
			}	
		}		
	}
	
	public static void movePiece(Queen q, int row, int column) {
		boolean movable = q.canMove(row, column, pieceBoard);
		
		if(movable) {
			int oldRow = q.getRow();
			int oldColumn = q.getColumn();
			Piece piece = pieceBoard[7-row][column];
			
			
			pieceBoard[7-oldRow][oldColumn] = null;
			pieceBoard[7-row][column] = q;
			
			if(checkedOwnKing(q.getColor())) {
				pieceBoard[7-oldRow][oldColumn] = q;
				pieceBoard[7-row][column] = piece;
				System.out.println("Your own king would be under attack!");
			}else {
				moveList.add(new Move(q, oldRow, oldColumn, row, column));
				
				deleteOldPosition(oldRow, oldColumn);
				writeNewPosition(q.getName(),row,column);
				q.setRow(row);
				q.setColumn(column);
			}	
		}
	}
	
	public static void movePiece(King k, int row, int column) {
		boolean movable = k.canMove(row, column, pieceBoard);
		
		if(!movable) {
			movable = castle(row, column, k);
		}
		
		if(movable) {
			int oldRow = k.getRow();
			int oldColumn = k.getColumn();
			Piece piece = pieceBoard[7-row][column];
			
			
			pieceBoard[7-oldRow][oldColumn] = null;
			pieceBoard[7-row][column] = k;
			k.setRow(row);
			k.setColumn(column);
			
			if(checkedOwnKing(k.getColor())) {
				pieceBoard[7-oldRow][oldColumn] = k;
				pieceBoard[7-row][column] = piece;
				k.setRow(oldRow);
				k.setColumn(oldColumn);
				System.out.println("Your own king would be under attack!");
			}else {
				moveList.add(new Move(k, oldRow, oldColumn, row, column));
				
				deleteOldPosition(oldRow, oldColumn);
				writeNewPosition(k.getName(),row,column);
				k.setRow(row);
				k.setColumn(column);
			}	
		}
	}
	/**special move for the king, involving 2 pieces
	 * returns true if castling is possible
	 * 
	 * @param row
	 * @param column
	 * @param k
	 * @return
	 */
	private static boolean castle(int row, int column, King k) {
		int oldColumn = k.getColumn();
		if(k.getColor()) {
			//white castling
			if(k.getRow() == 0 && k.getColumn() == 4) {
				if(row == 0 && column == 6) {
					if(r1.getRow() == 0 && r1.getColumn() == 7) {
						if(pieceBoard[7-k.getRow()][k.getColumn()+1] == null && pieceBoard[7-k.getRow()][k.getColumn()+2] == null) {
							boolean unmoved = true;
							for(int i = moveList.size();i>0;i--) {
								if(moveList.get(i-1).getPiece().equals(k0) || moveList.get(i-1).getPiece().equals(r1)) {
									unmoved = false;
								}
							}
							if(unmoved) {								
								if(!checkedOwnKing(k.getColor())) {
									pieceBoard[7-row][oldColumn] = null;
									pieceBoard[7-row][oldColumn+1] = k;
									k.setColumn(oldColumn+1);
									if(!checkedOwnKing(k.getColor())) {
										pieceBoard[7-row][oldColumn] = null;
										pieceBoard[7-row][oldColumn+2] = k;
										k.setColumn(oldColumn+2);
										if(!checkedOwnKing(k.getColor())) {
											pieceBoard[7-r1.getRow()][r1.getColumn()] = null;
											pieceBoard[7-r1.getRow()][5] = r1;
											deleteOldPosition(0,7);
											writeNewPosition(r1.getName(),0,5);
											r1.setColumn(5);
											k.setColumn(oldColumn);
											return true;
										}
									}
								}
							}
							pieceBoard[7-k.getRow()][oldColumn+1] = null;
							pieceBoard[7-k.getRow()][oldColumn+2] = null;
						}
					}
				}else if(row == 0 && column == 2) {
					if(r0.getRow() == 0 && r0.getColumn() == 0) {
						if(pieceBoard[7-k.getRow()][k.getColumn()-1] == null && pieceBoard[7-k.getRow()][k.getColumn()-2] == null && pieceBoard[7-k.getRow()][k.getColumn()-3] == null) {   
							boolean unmoved = true;
							for(int i = moveList.size();i>0;i--) {
								if(moveList.get(i-1).getPiece().equals(k0) || moveList.get(i-1).getPiece().equals(r0)) {
									unmoved = false;
								}
							}
							if(unmoved) {								
								if(!checkedOwnKing(k.getColor())) {
									pieceBoard[7-row][oldColumn] = null;
									pieceBoard[7-row][oldColumn-1] = k;
									k.setColumn(oldColumn-1);
									if(!checkedOwnKing(k.getColor())) {
										pieceBoard[7-row][oldColumn] = null;
										pieceBoard[7-row][oldColumn-2] = k;
										k.setColumn(oldColumn-2);
										if(!checkedOwnKing(k.getColor())) {
											pieceBoard[7-r0.getRow()][r0.getColumn()] = null;
											pieceBoard[7-r0.getRow()][3] = r0;
											deleteOldPosition(0,0);
											writeNewPosition(r0.getName(),0,3);
											r0.setColumn(3);
											k.setColumn(oldColumn);
											return true;
										}
									}
								}
							}
							pieceBoard[7-k.getRow()][oldColumn-1] = null;
							pieceBoard[7-k.getRow()][oldColumn-2] = null;
							pieceBoard[7-k.getRow()][oldColumn-3] = null;
						}
					}
				
				}
			}
		}else {
			//black castling
			if(k.getRow() == 7 && k.getColumn() == 4) {
				if(row == 7 && column == 6) {
					if(R1.getRow() == 7 && R1.getColumn() == 7) {
						if(pieceBoard[7-k.getRow()][k.getColumn()+1] == null && pieceBoard[7-k.getRow()][k.getColumn()+2] == null) {
							boolean unmoved = true;
							for(int i = moveList.size();i>0;i--) {
								if(moveList.get(i-1).getPiece().equals(K0) || moveList.get(i-1).getPiece().equals(R1)) {
									unmoved = false;
								}
							}
							if(unmoved) {								
								if(!checkedOwnKing(k.getColor())) {
									pieceBoard[7-row][oldColumn] = null;
									pieceBoard[7-row][oldColumn+1] = k;
									k.setColumn(oldColumn+1);
									if(!checkedOwnKing(k.getColor())) {
										pieceBoard[7-row][oldColumn] = null;
										pieceBoard[7-row][oldColumn+2] = k;
										k.setColumn(oldColumn+2);
										if(!checkedOwnKing(k.getColor())) {
											pieceBoard[7-R1.getRow()][R1.getColumn()] = null;
											pieceBoard[7-R1.getRow()][5] = R1;
											deleteOldPosition(7,7);
											writeNewPosition(R1.getName(),7,5);
											R1.setColumn(5);
											k.setColumn(oldColumn);
											return true;
										}
									}
								}
							}
							pieceBoard[7-k.getRow()][oldColumn+1] = null;
							pieceBoard[7-k.getRow()][oldColumn+2] = null;
						}
					}
				}else if(row == 7 && column == 2) {
					if(R0.getRow() == 7 && R0.getColumn() == 0) {
						if(pieceBoard[7-k.getRow()][k.getColumn()-1] == null && pieceBoard[7-k.getRow()][k.getColumn()-2] == null && pieceBoard[7-k.getRow()][k.getColumn()-3] == null) {   
							boolean unmoved = true;
							for(int i = moveList.size();i>0;i--) {
								if(moveList.get(i-1).getPiece().equals(K0) || moveList.get(i-1).getPiece().equals(R0)) {
									unmoved = false;
								}
							}
							if(unmoved) {								
								if(!checkedOwnKing(k.getColor())) {
									pieceBoard[7-row][oldColumn] = null;
									pieceBoard[7-row][oldColumn-1] = k;
									k.setColumn(oldColumn-1);
									if(!checkedOwnKing(k.getColor())) {
										pieceBoard[7-row][oldColumn] = null;
										pieceBoard[7-row][oldColumn-2] = k;
										k.setColumn(oldColumn-2);
										if(!checkedOwnKing(k.getColor())) {
											pieceBoard[7-R0.getRow()][R0.getColumn()] = null;
											pieceBoard[7-R0.getRow()][3] = R0;
											deleteOldPosition(7,0);
											writeNewPosition(R0.getName(),7,3);
											R0.setColumn(3);
											k.setColumn(oldColumn);
											return true;
										}
									}
								}
							}
							pieceBoard[7-k.getRow()][oldColumn-1] = null;
							pieceBoard[7-k.getRow()][oldColumn-2] = null;
							pieceBoard[7-k.getRow()][oldColumn-3] = null;
						}
					}
				
				}
			}
		
		}
		
		pieceBoard[7-k.getRow()][oldColumn] = k;
		k.setColumn(oldColumn);
		return false;
	}





	/**exchanges a tile in the gameBoard with a blank string of 3 spaces
	 * 
	 * @param row
	 * @param column
	 */
	public static void deleteOldPosition(int row, int column) {
		
		gameBoard[15-2*row][2*column+1]="   ";
	}
	/**exchanges a tile in the gameBoard with the icon of the piece
	 * 
	 * @param name
	 * @param row
	 * @param column
	 */
	public static void writeNewPosition(String name,int row, int column) {
		
		gameBoard[15-2*row][2*column+1]=name;
	}
	
	/**
	 * prints out the gameBoard in the console
	 */
	public void showGameBoard() {
		for(String[] row : gameBoard) {
			for(String c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public String[][] getGameBoard(){
		return gameBoard;
	}
	/**returns a piece at a given location
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public Piece findPiece(int row, int column) {
		
		if(pieceBoard[7-row][column]!=null) {
			return(pieceBoard[7-row][column]);
		}
		System.out.println("There is no piece at this location");
		return null;
	}
	/**returns if the king of a given color is checked
	 * 
	 * @param color
	 * @return
	 */
	public static boolean checkedOwnKing(boolean color) {
		if(color == true) {
			return inCheck(k0);
		}else {
			return inCheck(K0);
		}
	}
	
	/** determines if the king is in check
	 * 
	 * @param k
	 * @return
	 */
	public static boolean inCheck(King k){
		
		//checks under the king
		for(int i = k.getRow()-1;i >= 0;i--) {
			Piece possibleAttacker = pieceBoard[7-i][k.getColumn()];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Rook" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = -1;
			}
		}
		//checks above the king
		for(int i = k.getRow()+1;i <= 7;i++) {
			Piece possibleAttacker = pieceBoard[7-i][k.getColumn()];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Rook" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = 8;
			}
		}
		//checks left of the king
		for(int i = k.getColumn()-1;i >= 0;i--) {
			Piece possibleAttacker = pieceBoard[7-k.getRow()][i];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Rook" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = -1;
			}
		}
		//checks right of the king
		for(int i = k.getColumn()+1;i <= 7;i++) {
			Piece possibleAttacker = pieceBoard[7-k.getRow()][i];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Rook" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = 8;
			}
		}
		
		//checks top right diagonally
		for(int i = k.getRow()+1, j = k.getColumn()+1;i<= 7 && j<=7;i++,j++) {
			Piece possibleAttacker = pieceBoard[7-i][j];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Bishop" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = 8;
			}
		}
		//checks top left diagonally
		for(int i = k.getRow()+1, j = k.getColumn()-1;i<= 7 && j>=0;i++,j--) {
			Piece possibleAttacker = pieceBoard[7-i][j];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Bishop" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = 8;
			}
		}		
		//checks bottom right diagonally
		for(int i = k.getRow()-1, j = k.getColumn()+1;i>=0 && j<=7;i--,j++) {
			Piece possibleAttacker = pieceBoard[7-i][j];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Bishop" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = -1;
			}
		}
		//checks bottom left diagonally
		for(int i = k.getRow()-1, j = k.getColumn()-1;i>=0 && j>=0;i--,j--) {
			Piece possibleAttacker = pieceBoard[7-i][j];
			if(possibleAttacker != null) {
				if(possibleAttacker.getColor() != k.getColor() && (possibleAttacker.getPieceName() == "Bishop" || possibleAttacker.getPieceName() == "Queen")) {
					return true;
				}else i = -1;
			}
		}
		
		//check for knights
		if(k.getRow()+2 <= 7) {
			//2 up 1 right
			if(k.getColumn()+1 <= 7) {
				if(pieceBoard[7-k.getRow()-2][k.getColumn()+1] != null) {
					if(pieceBoard[7-k.getRow()-2][k.getColumn()+1].getColor() != k.getColor() && pieceBoard[7-k.getRow()-2][k.getColumn()+1].getPieceName() == "Knight") {
						return true;
					}
				}
			}
			//2 up 1 left
			if(k.getColumn()-1 >= 0) {
				if(pieceBoard[7-k.getRow()-2][k.getColumn()-1] != null) {
					if(pieceBoard[7-k.getRow()-2][k.getColumn()-1].getColor() != k.getColor() && pieceBoard[7-k.getRow()-2][k.getColumn()-1].getPieceName() == "Knight") {
						return true;
					}
				}
			}
		}
		
		
		if(k.getRow()+1 <= 7) {
			//1 up 2 right
			if(k.getColumn()+2 <= 7) {
				if(pieceBoard[7-k.getRow()-1][k.getColumn()+2] != null) {
					if(pieceBoard[7-k.getRow()-1][k.getColumn()+2].getColor() != k.getColor() && pieceBoard[7-k.getRow()-1][k.getColumn()+2].getPieceName() == "Knight") {
						return true;
					}
				}
			}
			//1 up 2 left
			if(k.getColumn()-2 >= 0) {
				if(pieceBoard[7-k.getRow()-1][k.getColumn()-2] != null) {
					if(pieceBoard[7-k.getRow()-1][k.getColumn()-2].getColor() != k.getColor() && pieceBoard[7-k.getRow()-1][k.getColumn()-2].getPieceName() == "Knight") {
						return true;
					}
				}
			}
		}
		if(k.getRow()-2 >= 0) {
			//2 down 1 right
			if(k.getColumn()+1 <= 7) {
				if(pieceBoard[7-k.getRow()+2][k.getColumn()+1] != null) {
					if(pieceBoard[7-k.getRow()+2][k.getColumn()+1].getColor() != k.getColor() && pieceBoard[7-k.getRow()+2][k.getColumn()+1].getPieceName() == "Knight") {
						return true;
					}
				}
			}
			//2 down 1 left
			if(k.getColumn()-1 >= 0) {
				if(pieceBoard[7-k.getRow()+2][k.getColumn()-1] != null) {
					if(pieceBoard[7-k.getRow()+2][k.getColumn()-1].getColor() != k.getColor() && pieceBoard[7-k.getRow()+2][k.getColumn()-1].getPieceName() == "Knight") {
						return true;
					}
				}
			}
		}
		if(k.getRow()-1 >= 0) {
			//1 down 2 right
			if(k.getColumn()+2 <= 7) {
				if(pieceBoard[7-k.getRow()+1][k.getColumn()+2] != null) {
					if(pieceBoard[7-k.getRow()+1][k.getColumn()+2].getColor() != k.getColor() && pieceBoard[7-k.getRow()+1][k.getColumn()+2].getPieceName() == "Knight") {
						return true;
					}
				}
			}
			//1 down 2 left
			if(k.getColumn()-2 >= 0) {
				if(pieceBoard[7-k.getRow()+1][k.getColumn()-2] != null) {
					if(pieceBoard[7-k.getRow()+1][k.getColumn()-2].getColor() != k.getColor() && pieceBoard[7-k.getRow()+1][k.getColumn()-2].getPieceName() == "Knight") {
						return true;
					}
				}
			}
		}
		//check for pawn
		if(k.getColor()) {
			if(k.getRow()+1 <= 7) {
				if(k.getColumn()+1 <= 7) {
					if(pieceBoard[7-k.getRow()-1][k.getColumn()+1] != null) {
						if(pieceBoard[7-k.getRow()-1][k.getColumn()+1].getColor() != k.getColor() && pieceBoard[7-k.getRow()-1][k.getColumn()+1].getPieceName() == "Pawn") {
							return true;
						}
					}
				}
				if(k.getColumn()-1 >= 0) {
					if(pieceBoard[7-k.getRow()-1][k.getColumn()-1] != null) {
						if(pieceBoard[7-k.getRow()-1][k.getColumn()-1].getColor() != k.getColor() && pieceBoard[7-k.getRow()-1][k.getColumn()-1].getPieceName() == "Pawn") {
							return true;
						}
					}
				}
			}
		}else {
			if(k.getRow()-1 >= 0) {
				if(k.getColumn()+1 <= 7) {
					if(pieceBoard[7-k.getRow()+1][k.getColumn()+1] != null) {
						if(pieceBoard[7-k.getRow()+1][k.getColumn()+1].getColor() != k.getColor() && pieceBoard[7-k.getRow()+1][k.getColumn()+1].getPieceName() == "Pawn") {
							return true;
						}
					}
				}
				if(k.getColumn()-1 >= 0) {
					if(pieceBoard[7-k.getRow()+1][k.getColumn()-1] != null) {
						if(pieceBoard[7-k.getRow()+1][k.getColumn()-1].getColor() != k.getColor() && pieceBoard[7-k.getRow()+1][k.getColumn()-1].getPieceName() == "Pawn") {
							return true;
						}
					}
				}
			}
		}
		if(k.getColor()) {
			if(Math.abs(k.getRow()-K0.getRow()) <= 1 && Math.abs(k.getColumn()-K0.getColumn()) <= 1) {
				return true;
			}
		}else {
			if(Math.abs(k.getRow()-k0.getRow()) <= 1 && Math.abs(k.getColumn()-k0.getColumn()) <= 1) {
				return true;
			}
		}
		
		return false;
	}




//unfinished attempt at game end
	/*
	public boolean gameEnd(boolean color) {
		Piece[][] pieceBoardCopy = pieceBoard.clone();
		for (int i = 0; i < pieceBoardCopy.length; i++) {
			pieceBoardCopy[i] = pieceBoardCopy[i].clone();
		}
		boolean mate = true;
		boolean remi = true;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8;j++) {
				
				if(pieceBoard[7-i][j] != null) {
					if(pieceBoard[7-i][j].getColor() == color) {
						
						switch(pieceBoard[7-i][j].getPieceName()) {
							case "Pawn":
								int direction;
								if(color)direction=1;
								else direction =-1;
								
								if(j != 0) {
									if(pieceBoard[7-i][j].canMove((i+direction), j-1, pieceBoard)) {
										remi = false;
										pieceBoard[7-(i+direction)][j-1] = pieceBoard[7-i][j];
										pieceBoard[7-i][j]=null;
										if(!checkedOwnKing(color)) {
											pieceBoard = pieceBoardCopy.clone();
											System.out.println("the Pawn is allowed to move to the left");
											mate = false;
										}
										pieceBoard = pieceBoardCopy.clone();
									}
								}
								
								if(j != 7) {
									if(pieceBoard[7-i][j].canMove((i+direction), j+1, pieceBoard)) {
										remi = false;
										pieceBoard[7-(i+direction)][j+1] = pieceBoard[7-i][j];
										pieceBoard[7-i][j]=null;
										if(!checkedOwnKing(color)) {
											pieceBoard = pieceBoardCopy.clone();
											System.out.println("the Pawn is allowed to move to the right");

											mate = false;
										}
										pieceBoard = pieceBoardCopy.clone();
									}
								}
								if(pieceBoard[7-i][j].canMove((i+direction), j, pieceBoard)) {
									remi = false;
									pieceBoard[7-(i+direction)][j] = pieceBoard[7-i][j];
									pieceBoard[7-i][j]=null;
									if(!checkedOwnKing(color)) {
										pieceBoard = pieceBoardCopy.clone();
										System.out.println("the Pawn is allowed to move up/down");

										mate = false;
									}
									pieceBoard = pieceBoardCopy.clone();
								}
								
								
								
								break;
							case "Rook":
								break;
							case "Knight":
								break;
							case "Bishop":
								break;
							case "King":
								break;
							case "Queen":
								break;
						}
						
						
					}
				}
			}
		}
		return mate;
	}	
*/
}
