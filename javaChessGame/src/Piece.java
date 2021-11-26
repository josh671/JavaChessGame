public abstract class Piece {

    public enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    public enum PieceColor {
        BLACK, WHITE
    }

    private PieceColor pieceColor;
    private Square piecesPostition;
    private boolean moved;

    public Piece(PieceColor color, Square piecesPostition, boolean moved) {
        this.pieceColor = color;
        this.piecesPostition = piecesPostition;
        this.moved = moved;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public void setPiecesPostition(Square piecesPostition) {
        this.piecesPostition = piecesPostition;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public Square getPiecesPostition() {
        return piecesPostition;
    }

    public boolean isMoved(){
        return this.moved;
    }

    //finish methods from uml
    //re think some methods and how they'll work on a board. 
}