//test for chessboard
public class ChessBoard {
    public Square[][] chessBoard;
    public Square wKingsCurrentPosition;
    public Square bKingsCurrentPosition;
    boolean isBKingChecked;
    boolean isWKingChecked;


    //constructor for ChessBoard
    public ChessBoard() {

        chessBoard = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {

                chessBoard[j][i] = new Square(j, i);
                setPieces(chessBoard[j][i]);

            }
        }


    }

    public Square[][] getChessBoard() {
        return this.chessBoard;
    }

    /**
     * Sets the pieces on the board to their respective starting positions
     *
     * @param startingPositions each pieces possible starting position
     */
    public void setPieces(Square startingPositions) {
        //TODO: finish adding other pieces to board
        setRooks(startingPositions);
        setBishops(startingPositions);
        // setKnights(startingPositions);
        setKings(startingPositions);
        // setQueens(startingPositions);
        // setPawns(startingPositions);
    }


    /**
     * Sets the Rooks for both teams on the board
     *
     * @param startingPosition the square that will house a Rook
     */
    public static void setRooks(Square startingPosition) {
        if (startingPosition.getRow() == 0 && startingPosition.getColumn() == 0 ||
                startingPosition.getRow() == 0 && startingPosition.getColumn() == 7) {
            Rook blackRook = new Rook(Piece.PieceColor.BLACK, startingPosition);
            startingPosition.setOccupyingPiece(blackRook);
        } else if (startingPosition.getRow() == 7 && startingPosition.getColumn() == 0 ||
                startingPosition.getRow() == 7 && startingPosition.getColumn() == 7) {
            Rook whiteRook = new Rook(Piece.PieceColor.WHITE, startingPosition);
            startingPosition.setOccupyingPiece(whiteRook);
        }
    }

    /**
     * Sets the Bishops for both teams on the board
     *
     * @param startingPosition the square that will house a Bishop
     */
    public static void setBishops(Square startingPosition) {
        //set black bishops
        if (startingPosition.getRow() == 0 && startingPosition.getColumn() == 2 ||
                startingPosition.getRow() == 0 && startingPosition.getColumn() == 5) {
            Bishop blackBishop = new Bishop(Piece.PieceColor.BLACK, startingPosition);
            startingPosition.setOccupyingPiece(blackBishop);
        } else //set white bishops
            if (startingPosition.getRow() == 7 && startingPosition.getColumn() == 2 ||
                    startingPosition.getRow() == 7 && startingPosition.getColumn() == 5) {
                Bishop whiteBishop = new Bishop(Piece.PieceColor.WHITE, startingPosition);
                startingPosition.setOccupyingPiece(whiteBishop);
            }
    }

    /**
     * Sets the Kings on the board
     * Sets the Kings current position trackers within ChessBoard class
     * @param startingPosition the square that will house a King
     */
    public  void setKings(Square startingPosition) {
        //set black king
        if (startingPosition.getRow() == 0 && startingPosition.getColumn() == 4) {
            King blackKing = new King(Piece.PieceColor.BLACK, startingPosition);
            startingPosition.setOccupyingPiece(blackKing);
            this.bKingsCurrentPosition  = startingPosition;

        } else //set white King
            if (startingPosition.getRow() == 7 && startingPosition.getColumn() == 4) {
                King whiteKing = new King(Piece.PieceColor.WHITE, startingPosition);
                startingPosition.setOccupyingPiece(whiteKing);
                this.wKingsCurrentPosition  =   startingPosition;
            }

    }
    
        /**
     * Sets the Pawns on the board
     * Sets the Pawns current position trackers within ChessBoard class
     * @param startingPosition the square that will house a Pawn
     */
    public  void setPawns(Square startingPosition) {
        //set black Pawns
        for (int i = 0; i < 8; i++) {
            if (startingPosition.getRow() == 1 && startingPosition.getColumn() == i) 
                Pawn blackPawn = new Pawn(Piece.PieceColor.BLACK, startingPosition);
                startingPosition.setOccupyingPiece(blackPawn);
            } else //set white Pawns
                if (startingPosition.getRow() == 6 && startingPosition.getColumn() == i) {
                    Pawn whitePawn = new Pawn(Piece.PieceColor.WHITE, startingPosition);
                    startingPosition.setOccupyingPiece(whitePawn);
                }

    }



    //ToDo: setKnights
    //ToDo: setQueens
    //ToDo: setPawns


//GET METHODS finish documentation

    public Square getWhiteKingsPosition(){
            return this.wKingsCurrentPosition;
    }

    public Square getBlackKingsPosition(){
            return this.bKingsCurrentPosition;
    }

    public boolean getIsBkingChecked(){
            return this.isBKingChecked;
    }

    public boolean getIsWkingChecked(){
        return this.isWKingChecked;
    }
//Todo: start isChecked()
//Todo: start piece movement
    public void killOrMovePiece(Square startingPosition, Square endingPosition){
        Piece selectedPiece = startingPosition.getOccupyingPiece();
        if(selectedPiece.isMoveValid(endingPosition, chessBoard) == true){
            startingPosition.setOccupyingPiece(null);
            endingPosition.setOccupyingPiece(selectedPiece);
            selectedPiece.setCurrentPosition(endingPosition);
            //TODO: fix checker for when king is checked
            if(endingPosition.isWKingChecked(endingPosition, this.wKingsCurrentPosition, chessBoard)){
                isWKingChecked = true;
            }else {
                isWKingChecked = false;
            }

        }
    }





}




