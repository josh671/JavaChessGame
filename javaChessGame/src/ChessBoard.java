import java.util.ArrayList;


public class ChessBoard {
    private Square[][] chessBoard;
    private Square wKingsCurrentPosition;
    private Square bKingsCurrentPosition;
    private boolean isBKingChecked;
    private boolean isWKingChecked;

    private ArrayList <Piece> AlivePieceList = new ArrayList<>();
    private ArrayList <Piece> DeadPieceList = new ArrayList<>();

    //constructor for ChessBoard
    public ChessBoard() {

        chessBoard = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {

                chessBoard[j][i] = new Square(j, i);
                setPieces(chessBoard[j][i]);

            }
        }
        setPieceList(chessBoard);

    }

    public Square[][] getChessBoard() {
        return chessBoard;
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
            if (startingPosition.getRow() == 1) {
                Pawn blackPawn = new Pawn(Piece.PieceColor.BLACK, startingPosition);
                startingPosition.setOccupyingPiece(blackPawn);
            } else //set white Pawns
                if (startingPosition.getRow() == 6) {
                    Pawn whitePawn = new Pawn(Piece.PieceColor.WHITE, startingPosition);
                    startingPosition.setOccupyingPiece(whitePawn);
                }

    }



    //ToDo: setKnights
    //ToDo: setQueens
    //ToDo: setPawns


//GET METHODS finish documentation
    /** gets the wKings position
     * @return Square current wKings Position
     */
    public Square getWhiteKingsPosition(){
            return this.wKingsCurrentPosition;
    }

    /** gets the bKings position
     * @return Square current bKings Position
     */
    public Square getBlackKingsPosition(){
            return this.bKingsCurrentPosition;
    }

    /** Boolean value depending on whether king is checked
     * @return boolean true if bKing is checked
     */
    public boolean getIsBkingChecked(){
            return this.isBKingChecked;
    }

    /** Boolean value depending on whether king is checked
     * @return boolean true if wKing is checked
     */
    public boolean getIsWkingChecked(){
        return this.isWKingChecked;
    }

    /** Set method for when wking is/isnot checked
     * @param isORIsNotChecked value based if wking is/isnot checked
     */
    public void setIsWKingChecked(boolean isORIsNotChecked){
        this.isWKingChecked = isORIsNotChecked;
    }

    /** Set method for when bking is/isnot checked
     * @param isORIsNotChecked value based if bking is/isnot checked
     */
    public void setIsBKingChecked(boolean isORIsNotChecked){
        this.isBKingChecked = isORIsNotChecked;
    }


    /** Select a square that has a piece on it and moves it to ending position
     * @param startingPosition selected pieces current position
     * @param endingPosition selected pieces desired ending position
     */
    public void killOrMovePiece(Square startingPosition, Square endingPosition){
        if(!startingPosition.isOccupied){
            //change to message but for now break this shit
            throw new IllegalArgumentException("this square is empty, move invalid ");
        }
        Piece selectedPiece = startingPosition.getOccupyingPiece();
        //get selected piece
        int alivePieceIndex = AlivePieceList.indexOf(selectedPiece);

        //if piece's moveIsValid() then move piece to selected square
        if(startingPosition.getOccupyingPiece().isMoveValid(endingPosition, this.chessBoard)){
                //remove piece from starting square
             this.chessBoard[startingPosition.getRow()][startingPosition.getColumn()].setOccupyingPiece(null);

                //set piece's tracker to the selected ending position if moveIsValid() is true
            selectedPiece.setCurrentPosition(endingPosition);

                //set square's occupying piece for ending position to the selected piece
            this.chessBoard[endingPosition.getRow()][endingPosition.getColumn()].setOccupyingPiece(selectedPiece);

            //update selected pieces position in the AlivePieceList
            AlivePieceList.get(alivePieceIndex).setCurrentPosition(endingPosition);
            //System.out.println(  AlivePieceList.get(alivePieceIndex).getCurrentPosition().getOccupyingPiece());
        }else {
            //if moveIsValid() is false let the player know
            System.out.println("Move is invalid");
        }

       //check if WKing is in check after each Bpiece's move// check if king is in check
        checkIfWKingIsChecked();




    }


//Methods to check if kings are checked

    private void checkIfWKingIsChecked( ){
        for(Piece item : AlivePieceList){
            if(item.getPieceColor() == Piece.PieceColor.BLACK &&
                    !item.isMoveValid(wKingsCurrentPosition, this.chessBoard)){
                System.out.println(item.getPieceType() + " : " + item.isMoveValid(wKingsCurrentPosition, this.chessBoard));
                setIsWKingChecked(false);
            }
        }

        for(Piece item : AlivePieceList){
            if(item.getPieceColor() == Piece.PieceColor.BLACK &&
                    item.isMoveValid(wKingsCurrentPosition, this.chessBoard)){
                System.out.println(item.getPieceType() + " : " + item.isMoveValid(wKingsCurrentPosition, this.chessBoard));
                setIsWKingChecked(true);
            }
        }

    }

    //check if WKing is in check
    private void checkIfBKingIsChecked( ){
        for(Piece item : AlivePieceList){
            if(item.getPieceColor() == Piece.PieceColor.WHITE &&
                    !item.isMoveValid(bKingsCurrentPosition, this.chessBoard)){
                System.out.println(item.getPieceType() + " : " + item.isMoveValid(bKingsCurrentPosition, this.chessBoard));
                setIsBKingChecked(false);
            }
        }

        for(Piece item : AlivePieceList){
            if(item.getPieceColor() == Piece.PieceColor.WHITE &&
                    item.isMoveValid(bKingsCurrentPosition, this.chessBoard)){
                System.out.println(item.getPieceType() + " : " + item.isMoveValid(bKingsCurrentPosition, this.chessBoard));
                setIsBKingChecked(true);
            }
        }

    }


//TODO: AlivePieceList methods


    public void setPieceList(Square[][] chessBoard){
       for(int i = 0; i < chessBoard.length; i++){
           for(int j = 0; j < chessBoard.length; j++){
               if(chessBoard[i][j].getIsOccupied()){
                   Piece currentPiece = chessBoard[i][j].getOccupyingPiece();
                   if(currentPiece != null){
                       AlivePieceList.add(currentPiece);
                   }
               }

           }

       }

    }

    public String getListOFItems(){
        String items = "";
        for(int i = 0; i < AlivePieceList.size(); i++){
            items += AlivePieceList.get(i) + "\n";

        }
        return items;
    }
}




