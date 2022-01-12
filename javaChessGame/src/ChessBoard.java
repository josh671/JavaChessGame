import java.util.ArrayList;


public class ChessBoard {
    public Square[][] chessBoard;
    public Square wKingsCurrentPosition;
    public Square bKingsCurrentPosition;
    public boolean isBKingChecked;
    public boolean isWKingChecked;
    //tiral with BRooks
    public ArrayList <Piece> AlivePieceList = new ArrayList<>();
    public ArrayList <Piece> DeadPieceList = new ArrayList<>();

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

    public void setIsWKingChecked(boolean isORIsNotChecked){
        this.isWKingChecked = isORIsNotChecked;
    }
//Todo: start isChecked()
//Todo: start piece movement/Documentation
    public void killOrMovePiece(Square startingPosition, Square endingPosition){
        Piece selectedPiece = startingPosition.getOccupyingPiece();
        int alivePieceIndex = AlivePieceList.indexOf(selectedPiece);


        if(startingPosition.getOccupyingPiece().isMoveValid(endingPosition, this.chessBoard)){

             this.chessBoard[startingPosition.getRow()][startingPosition.getColumn()].setOccupyingPiece(null);

            selectedPiece.setCurrentPosition(endingPosition);

            this.chessBoard[endingPosition.getRow()][endingPosition.getColumn()].setOccupyingPiece(selectedPiece);
            //need to change item in array
            AlivePieceList.get(alivePieceIndex).setCurrentPosition(endingPosition);
            System.out.println(  AlivePieceList.get(alivePieceIndex).getCurrentPosition().getOccupyingPiece());
        }else {
            System.out.println("Move is invalid");
        }

       //check if WKing is in check
        checkIfWKingIsChecked();




    }
//check if WKing is in check
    private void checkIfWKingIsChecked( ){
        for(Piece item : AlivePieceList){
            if(item.getPieceColor() == Piece.PieceColor.BLACK &&
                    item.isMoveValid(wKingsCurrentPosition, this.chessBoard) == false){
                System.out.println(item.getPieceType() + " : " + item.isMoveValid(wKingsCurrentPosition, this.chessBoard));
                setIsWKingChecked(false);
            }
        }

        for(Piece item : AlivePieceList){
            if(item.getPieceColor() == Piece.PieceColor.BLACK &&
                    item.isMoveValid(wKingsCurrentPosition, this.chessBoard) == true){
                System.out.println(item.getPieceType() + " : " + item.isMoveValid(wKingsCurrentPosition, this.chessBoard));
                setIsWKingChecked(true);
            }
        }

    }


//TODO: AlivePieceList methods
    public ArrayList<Piece> getPieceList(){
        return this.AlivePieceList;
    }

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




