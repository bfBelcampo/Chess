import java.util.Scanner;
import pieces.*;

public class Engine extends Board {

	public static void main(String[] args) {
				
		Board board = new Board();
		
		while(true) {
			//gives the player information about the game state (who is allowed to move, which turn is it, how does the boar look)
			System.out.println("Turn "+(Board.moveList.size()+1));
			if((Board.moveList.size()%2) == 0) {
				System.out.println("White moves");
			} else {
				System.out.println("Black moves");
			}
			board.showGameBoard();

			//gets the piece the player wants to move by writing it in the console
			System.out.println("Enter the pieces location");
			Piece movingPiece = getPieceToMove(board);
			//checks if the targeted piece is yours
			if(movingPiece != null) {
				if((movingPiece.getColor() == true && Board.moveList.size()%2 == 1) || (movingPiece.getColor() == false && Board.moveList.size()%2 == 0)) {
					System.out.println("This is not your piece");
					movingPiece = null;
				}
			}
			if(movingPiece != null) {
				
				//get the tile you want to move your piece to
				System.out.println("Where should the "+movingPiece.getPieceName()+" move to?");
				Coordinate newTile = getPlaceToMoveTo();
				
				moveCast(board, movingPiece, newTile.row, newTile.column);
			}
		}
	}
	
	/**asks which piece should be moved and returns it
	 * 
	 * @param board
	 * @return
	 */
	public static Piece getPieceToMove(Board board) {
				
		int row = 8;
		int column = 8;
		Piece movingPiece = null;

		while(row == 8 || column == 8) {
			
			
			String pos = getInput();
			
			column = checkLetter(pos);
			row = checkNumber(pos);
			if(row!= 8 && column != 8) {
			} else System.out.println("not a correct input");		
		}
		
		movingPiece = board.findPiece(row, column);
		
		return movingPiece;
	}
	
	/**asks the player where he wants to move to and returns the location
	 * 
	 * @return
	 */
	public static Coordinate getPlaceToMoveTo() {
		
		
		int row = 8;
		int column = 8;
		
		while(row == 8 || column == 8) {
			String pos = getInput();
			row = checkNumber(pos);
			column = checkLetter(pos);
			if(row!= 8 && column != 8) {
			} else System.out.println("not a correct input");	
		}
		
		Coordinate coordinate = new Coordinate(row,column);
		
		
		return coordinate;
	}
	
	
	
	/**converts the console input to a column on the board
	 * 
	 * @param input
	 * @return
	 */
	public static int checkLetter(String input) {
		if(input.length()==2) {
			switch (input.charAt(0)) {
				case 'A':
					return 0;
				case 'a':
					return 0;
				case 'B':
					return 1;
				case 'b':
					return 1;
				case 'C':
					return 2;
				case 'c':
					return 2;
				case 'D':
					return 3;
				case 'd':
					return 3;
				case 'E':
					return 4;
				case 'e':
					return 4;
				case 'F':
					return 5;
				case 'f':
					return 5;
				case 'G':
					return 6;
				case 'g':
					return 6;
				case 'H':
					return 7;
				case 'h':
					return 7;
				default:
					break;		
			}
		}
		return 8;
	}
	/**converts the console input to a row on the board
	 * 
	 * @param input
	 * @return
	 */
	public static int checkNumber(String input) {
		if(input.length()==2) {
			switch (input.charAt(1)) {
				case '1':
					return 0;
				case '2':
					return 1;
				case '3':
					return 2;
				case '4':
					return 3;
				case '5':
					return 4;
				case '6':
					return 5;
				case '7':
					return 6;
				case '8':
					return 7;
				default:
					break;		
			}
		}
		return 8;
	}
	
	/**performs a type cast before calling the corresponding movePiece method for the piece
	 * 
	 * @param board
	 * @param piece
	 * @param row
	 * @param column
	 */
	public static void moveCast(Board board, Piece piece, int row, int column) {
		String type = piece.getName();
		if(type.equals(" ♙ ") || type.equals(" ♟ ")) {	
			Board.movePiece((Pawn)piece, row,column);
		}else if(type.equals(" ♖ ") || type.equals(" ♜ ")) {
			Board.movePiece((Rook)piece, row, column);
		}else if(type.equals(" ♘ ") || type.equals(" ♞ ")) {
			Board.movePiece((Knight)piece, row, column);
		}else if(type.equals(" ♗ ") || type.equals(" ♝ ")) {
			Board.movePiece((Bishop)piece, row, column);
		}else if(type.equals(" ♕ ") || type.equals(" ♛ ")) {
			Board.movePiece((Queen)piece, row, column);
		}else if(type.equals(" ♔ ") || type.equals(" ♚ ")) {
			Board.movePiece((King)piece, row, column);
		}else System.out.println("The Piece doesn't have a name");
	}
	/**reads the console input
	 * 
	 * @return
	 */
	public static String getInput(){
		Scanner scan;
		scan = new Scanner(System.in);
		String pos = scan.nextLine();
		return pos;
	}
	
}
