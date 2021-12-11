public class Knight extends Piece{

    /**
     *
     * @param color     The color of this piece.
     * @param pieceType The type of this piece.
     */
    public Knight(PieceColor color, PieceType pieceType) {
        super(color, pieceType);
    }

    /**
     *
     * @param color     The color of this piece.
     * @param pieceType The type of this piece.
     * @param startingPosition  The starting position of this piece.
     */
    public Knight(PieceColor color, PieceType pieceType, Square startingPosition) {
        super(color, pieceType, startingPosition);
    }

    /**
     *
     * @param endingPosition    The ending position of the move.
     * @param chessBoard        The chess board.
     * @return                  Boolean, whether the move is valid or not.
     */
    public boolean isMoveValid(Square endingPosition, Square[] chessBoard) {
        boolean validate = true;

        int currentColumn = this.getCurrentPosition().getColumn();
        int endingColumn = endingPosition.getColumn();

        int currentRow = this.getCurrentPosition().getRow();
        int endingRow = endingPosition.getColumn();

        // Check to make sure move is either two moves horizontal and one move vertical or two vertical and one horizontal
        if(((endingColumn != currentColumn + 2 || endingColumn != currentColumn - 2) &&
                        (endingRow != currentRow + 1 || endingRow != currentRow - 1)) ||
                ((endingColumn != currentColumn + 1 || endingColumn != currentColumn - 1) &&
                        (endingRow != currentRow + 2 || endingRow != currentRow - 2))) {
            validate = false;
        } else if(endingPosition.getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
            validate = false;
        }

        // Check to make sure move in inside the chessboard.
        if(endingColumn > 7 || endingColumn < 0) {
            validate = false;
        } else if(endingRow > 7 || endingRow < 7) {
            validate = false;
        }

        return validate;
    }

}
