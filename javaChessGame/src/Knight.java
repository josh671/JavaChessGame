public class Knight extends Piece{

    /**
     *
     * @param color     The color of this knight.
     */
    public Knight(PieceColor color) {
        super(color, PieceType.KNIGHT);
    }

    /**
     *
     * @param color             The color of this knight.
     * @param startingPosition  The starting position of this knight.
     */
    public Knight(PieceColor color, Square startingPosition) {
        super(color, PieceType.KNIGHT, startingPosition);
    }

    /**
     *
     * @param endingPosition    The ending position of this knight.
     * @return                  Boolean, whether this move is valid or not.
     */
    public boolean isMoveValid(Square endingPosition) {
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
        }

        // Check to make sure ending position doesn't have a piece of the same color on it.
        if(endingPosition.getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
            validate = false;
        }

        // Check to make sure move in inside the chessboard.
        if(endingColumn > 7 || endingColumn < 0) {
            validate = false;
        } else if(endingRow > 7 || endingRow < 0) {
            validate = false;
        }

        return validate;
    }

}
