public class Knight extends Piece{

    public Knight(PieceColor color, PieceType pieceType) {
        super(color, pieceType);
    }

    public Knight(PieceColor color, PieceType pieceType, Square startingPosition) {
        super(color, pieceType, startingPosition);
    }

    public boolean isMoveValid(Square endingPosition, Square[] chessBoard) {
        boolean validate = true;

        int currentColumn = this.getCurrentPosition().getColumn();
        int endingColumn = endingPosition.getColumn();

        int currentRow = this.getCurrentPosition().getRow();
        int endingRow = endingPosition.getColumn();

        

        return validate;
    }

}
