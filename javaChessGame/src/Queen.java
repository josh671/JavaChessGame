public class Queen extends Piece {

    /**
     * Queen constructor.
     *
     * @param color Color of the Queen piece.
     */
    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
    }

    /**
     * Queen constructor.
     *
     * @param color            Color of the queen piece.
     * @param startingPosition Starting position of the queen piece.
     */
    public Queen(PieceColor color, Square startingPosition) {
        super(color, PieceType.QUEEN, startingPosition);
    }

    /**
     * Checks if move is valid.
     *
     * @param endingPosition Starting position of the queen.
     * @param chessBoard     The chessboard being played on.
     * @return Boolean whether the move is valid or not.
     */
    public boolean isMoveValid(Square endingPosition, Square[][] chessBoard) {
        // Set validate to true
        boolean validate = true;

        // Variables for rows and columns of starting and ending positions.
        int currentColumn = this.getCurrentPosition().getColumn();
        int endingColumn = endingPosition.getColumn();
        int currentRow = this.getCurrentPosition().getRow();
        int endingRow = endingPosition.getRow();

        /*
            Checks lateral/horizontal moves first, then diagonal moves
         */
        if (currentColumn < endingColumn && currentRow == endingRow) {    // Lateral Right
            for (int i = currentColumn + 1; i <= endingColumn; i++) {
                // Check for any pieces in path or friendly on ending position
                if (chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i] != endingPosition
                        || chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
                    validate = false;
                }
            }
        } else if (currentColumn > endingColumn && currentRow == endingRow) {    // Lateral Left
            for (int i = currentColumn - 1; i >= endingColumn; i--) {
                // Check for any pieces in path or friendly on ending position
                if (chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i] != endingPosition
                        || chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
                    validate = false;
                }
            }
        } else if (currentColumn == endingColumn && currentRow > endingRow) {  // Horizontal Up
            for (int i = currentRow - 1; i >= endingRow; i--) {
                // Check for any pieces in path or friendly on ending position
                if (chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn] != endingPosition
                        || chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
                    validate = false;

                }
            }
        } else if (currentColumn == endingColumn && currentRow < endingRow) {     // Horizontal Down
            for (int i = currentRow + 1; i <= endingRow; i++) {
                // Check for any pieces in path or friendly on ending position
                if (chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn] != endingPosition
                        || chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
                    validate = false;


                }
            }
        } else if (currentColumn < endingColumn && currentRow < endingRow) {
            for (int i = currentColumn + 1; i <= endingColumn; i++) {
                // Check for piece in path
                if (chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i] != endingPosition
                        || chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {

                    validate = false;
                }
                currentRow ++;
            }
        } else if (currentColumn < endingColumn && endingRow < currentRow) {   // Diagonal Up/Right
            for (int i = currentColumn + 1; i <= endingColumn; i++) {

                if (chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i] != endingPosition
                        || chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {

                    validate = false;
                }
                currentRow --;
            }
        } else if (currentColumn > endingColumn && endingRow > currentRow) {  // Diagonal Down/Right
            for (int i = currentColumn - 1; i >= endingColumn; i--) {

                if (chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i] != endingPosition
                        || chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {

                    validate = false;
                }
                currentRow --;
            }
        } else if (currentColumn > endingColumn && currentRow < endingRow) {    // Diagonal Down/Left
            for (int i = currentColumn - 1; i >= endingColumn; i--) {

                if (chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i] != endingPosition
                        || chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {

                    validate = false;
                }
                currentRow ++;
            }
        }


        // Check to make sure move in inside the chessboard.
        if (endingColumn > 7 || endingColumn < 0) {
            validate = false;
        } else if (endingRow > 7 || endingRow < 0) {
            validate = false;
        }

        return validate;
    }

}
