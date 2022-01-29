public class King extends Piece{
    public King(PieceColor color ) {
        super(color, Piece.PieceType.KING);
    }

    public King(PieceColor color , Square startingPosition) {
        super(color, Piece.PieceType.KING, startingPosition);
    }
    /**
     * checks weather the movie from pieces current position to ending position is a valid move
     * @param endingPosition     The selected ending position the king will go
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
        // TODO: Check if ending position is threatened

        // if ending row and ending column are not within 1 square from the current row and column, the move is invalid
        if (Math.abs(endingColumn - currentColumn) <= 1 && Math.abs(endingRow - currentRow) <= 1) {
            //Missing the step to see if the ending position is already threatened by another piece 
        	//invalid if ending position is the beginning position
        	if (Math.abs(endingColumn - currentColumn) == 0 && Math.abs(endingRow - currentRow) == 0) {
        		validate = false;
 //       	} else if (chessBoard[endingRow][endingColumn].isThreatened() == true) {
 //               validate = false;
 //           } else if (chessBoard[endingRow][endingColumn].isThreatened() == false) {
            
        	} if(endingPosition.getOccupyingPiece() != null && endingPosition.getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
        		validate = false;
            } else {
        		validate = true;
        	}
        } else {
        	validate = false;
        }
        return validate;

    }
    }
