
public class Pawn extends Piece{
    public Pawn(PieceColor color ) {
        super(color, Piece.PieceType.PAWN);
    }

    public Pawn(PieceColor color , Square startingPosition) {
        super(color, Piece.PieceType.PAWN, startingPosition);
    }
    /**
     * checks weather the movie from pieces current position to ending position is a valid move
     * @param endingPosition     The selected ending position the pawn will go
     * @param chessBoard         The chessboard we are currently playing on
     *
     *  @return boolean     returns true if move is valid, false if there is enemy/friendly in between start/finish positions
     *                      or if there is a friendly piece on the ending position
     */
    public boolean isMoveValid(Square endingPosition, Square[][] chessBoard) {
        boolean validate = true;

        int currentColumn = this.getCurrentPosition().getColumn();
        int endingColumn = endingPosition.getColumn();

        int currentRow = this.getCurrentPosition().getRow();
        int endingRow = endingPosition.getRow();

        //Square[row][column]
        //Square[0][starts 0 goes to 7]
        //Square[0][0] or row 0 column 0 - is the bottom left square
        
        //if the current piece is black
        if (this.getPieceColor() == Piece.PieceColor.BLACK) {
        	//if the current position is the starting position, movement of the pawn is special
        	if (currentRow == 1 ) {
			if (endingColumn - currentColumn == 0 && endingRow - currentRow <= 2 && endingRow - currentRow >= 1) {
			    if (endingPosition.getIsOccupied() == true) {
				validate = false;
			    } else {
				validate = true;
			    }
			} else if (Math.abs(endingColumn - currentColumn) == 1 && endingRow - currentRow == 1) {   	        	
				if(endingPosition.getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
					validate = false;
				} if(endingPosition.getOccupyingPiece().getPieceColor() != this.getPieceColor()) {
					validate = true;
				} else {
					validate = false;
				}
    	        }
    	    //if the current position is not the starting position 
    	    } else if (currentRow != 1) {
		        if (endingColumn - currentColumn == 0 && endingRow - currentRow == 1) {
		            if (endingPosition.getIsOccupied() == true) {
		            	validate = false;
		            } else {
		            	validate = true;
		            }
		        } else if (Math.abs(endingColumn - currentColumn) == 1 && endingRow - currentRow == 1) {
		        	if(endingPosition.getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
		        		validate = false;
				    } if(endingPosition.getOccupyingPiece().getPieceColor() != this.getPieceColor()) {
		        		validate = true;
		        	} else {
		        		validate = false;
		        	}
	        	} else {
	        		validate = false;
	        	}
	    }
      }
        
        if (this.getPieceColor() == Piece.PieceColor.WHITE) {
        	//if the current position is the starting position, movement of the pawn is special
        	if (currentRow == 6 ) {
			if (currentColumn - endingColumn == 0 && currentRow - endingRow <= 2 && currentRow - endingRow >= 1) {
			    if (endingPosition.getIsOccupied() == true) {
				validate = false;
			    } else {
				validate = true;
			    }
			} else if (Math.abs(endingColumn - currentColumn) == 1 && currentRow - endingRow == 1) {   	        	
				if(endingPosition.getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
					validate = false;
				} if(endingPosition.getOccupyingPiece().getPieceColor() != this.getPieceColor()) {
					validate = true;
				} else {
					validate = false;
				}
			}
    	    //if the current position is not the starting position 
    	    } else if (currentRow != 6) {
		        if (currentColumn - endingColumn == 0 && currentRow - endingRow == 1) {
		            if (endingPosition.getIsOccupied() == true) {
		            	validate = false;
		            } else {
		            	validate = true;
		            }
		        } else if (Math.abs(endingColumn - currentColumn) == 1 && currentRow - endingRow == 1) {
		        	if(endingPosition.getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
		        		validate = false;
				    } if(endingPosition.getOccupyingPiece().getPieceColor() != this.getPieceColor()) {
		        		validate = true;
		        	} else {
		        		validate = false;
		        	}
	        	} else {
	        		validate = false;
	        	}
	    	}
      }
        return validate;
    }
}
