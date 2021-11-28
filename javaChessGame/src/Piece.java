public class Piece {

    public enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    public enum PieceColor {
        BLACK, WHITE
    }

    private PieceColor pieceColor;
    private PieceType pieceType;


    public Piece(PieceColor color, PieceType pieceType) {
        this.pieceColor = color;
        this.pieceType = pieceType;
         

    }


}