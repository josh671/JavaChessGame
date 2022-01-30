public class Rook extends Piece{


    //changes to rook constructor to set piece type automatically
    public Rook(PieceColor color ) {
        super(color, Piece.PieceType.ROOK);
    }

    public Rook(PieceColor color , Square startingPosition) {
        super(color, Piece.PieceType.ROOK, startingPosition);
    }

    /**
     * checks weather the movie from ROOK current position to ending position is a valid ROOK move
     * @param endingPosition     The selected ending position the rook will go
     * @param chessBoard         The chessboard we are currently playing on
     *
     *  @return boolean     returns true if move is valid, false if there is enemy/friendly in between start/finish positions
     *                      or if there is a friendly piece on the ending position
     */
    @Override
    public boolean isMoveValid(Square endingPosition, Square[][] chessBoard) {
        //create variables to track row/column of ending positions
        boolean validate = true;
        int currentColumn = this.getCurrentPosition().getColumn();
        int endingColumn = endingPosition.getColumn();
        int currentRow = this.getCurrentPosition().getRow();
        int endingRow = endingPosition.getRow();


         //(lateral: right)
        if(currentColumn < endingColumn && currentRow == endingRow){
           for(int i = currentColumn + 1; i <= endingColumn; i++){
               //check if squares are occupied in between by friendly/enemy or if friendly on ending position
               if(chessBoard[currentRow][i].getIsOccupied() && chessBoard[currentRow][i] != endingPosition ||
                  chessBoard[currentRow][i].getIsOccupied() && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()){

                   validate = false;



               }
           }
        }// (lateral: left)
        else if(currentColumn > endingColumn && currentRow == endingRow){
            for(int i = currentColumn - 1; i >= endingColumn; i--){
                    //check if squares are occupied in between by friendly/enemy or friendly on ending position
                    if(chessBoard[currentRow][i].getIsOccupied() && chessBoard[currentRow][i] != endingPosition ||
                       chessBoard[currentRow][i].getIsOccupied() && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()
                    ){
                        validate = false;

                    }
            }
        } else//(horizontal: down)
         if(currentColumn == endingColumn && currentRow < endingRow){
            for(int i = currentRow + 1; i <= endingRow; i++){
                    //check if squares are occupied in between by friendly/enemy or friendly on ending position
                if(chessBoard[i][currentColumn].getIsOccupied() && chessBoard[i][currentColumn] != endingPosition   ||
                   chessBoard[i][currentColumn].getIsOccupied() && chessBoard[i][currentColumn].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                    validate = false;


                }
            }
        }else //(horizontal: up)
            if(currentColumn == endingColumn && currentRow > endingRow){
            for(int i = currentRow - 1; i >= endingRow; i--){
                //check if squares are occupied in between by friendly/enemy or friendly on ending position
                if(chessBoard[i][currentColumn].getIsOccupied() && chessBoard[i][currentColumn] != endingPosition   ||
                   chessBoard[i][currentColumn].getIsOccupied() && chessBoard[i][currentColumn].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                    validate = false;

                }
            }
        }else if(currentColumn != endingColumn || currentRow != endingRow){
                validate = false;
            }


        return validate;

    }




    }

