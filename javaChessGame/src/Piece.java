public abstract class Piece {


    public enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    public enum PieceColor {
        WHITE, BLACK
    }


    private PieceColor pieceColor;
    private PieceType pieceType;
    private Square startingPosition;

    /**
     * Constructor for Pieces of the Game
     * @param color          Which color the chess piece is
     * @param pieceType      Type of piece
     * @param pieceType      Where on the board the piece will start
     */
    public Piece(PieceColor color, PieceType pieceType) {
        this.pieceColor = color;
        this.pieceType = pieceType;
        this.startingPosition = null;

    }

    public Piece(PieceColor color, PieceType pieceType, Square startingPosition) {
        this.pieceColor = color;
        this.pieceType = pieceType;
        setCurrentPosition(startingPosition);

    }

    /**
     * returns the Pieces Color
     */
    public PieceColor getPieceColor() {
        return pieceColor;
    }

    /**
     * returns the Pieces Type
     */
    public PieceType getPieceType(){
        return this.pieceType;
    }

    /**
     * gets pieces Current Position
     */
    public Square getCurrentPosition(){
        return this.startingPosition;
    }

    /**
     * Sets the Pieces current position on the board
     * @param   aSquare     Spot on the board we wish to move the piece
     */
    public void setCurrentPosition(Square aSquare){
        //once changed from null cannot change back
        if(aSquare.getColumn() < 0 || aSquare.getColumn() > 7 || aSquare.getRow() < 0 || aSquare.getRow() > 7){
            throw new IllegalArgumentException("This square is not on the board");
        }
        //set square so that it is occupied
        aSquare.setIsOccupied(true);



        this.startingPosition = aSquare;
    }
    //Todo: write test case for isMoveValid() in each piece;
    public boolean isMoveValid(Square endingPosition, Square[][] chessBoard){
        return true;
    }

    /**
     * Returns the Pieces information
     */
    @Override
    public String toString(){
        return String.format("%s : %s  Current Position: %s", getPieceType(), getPieceColor(), getCurrentPosition());
    }


}