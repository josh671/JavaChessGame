public class Rook extends Piece{
    public Rook(PieceColor color, PieceType pieceType) {
        super(color, pieceType);
    }

    public Rook(PieceColor color, PieceType pieceType, Square startingPosition) {
        super(color, pieceType, startingPosition);
    }

    public boolean isMoveValid(Square endingPosition, Square[][] chessBoard) {
        boolean validate = true;

        int currentColumn = this.getCurrentPosition().getColumn();
        int endingColumn = endingPosition.getColumn();

        int currentRow = this.getCurrentPosition().getRow();
        int endingRow = endingPosition.getRow();

        //Square[row][column]
        //Square[0][starts 0 goes to 7]
        //Square[0][0] or row 0 column 0 - is the bottom left square

        //if the rook moves north ~starting point 0,0
        //todo: rework logic for moving around a rook.
        //if rook stays on the same row, changeing colums from 0 going to 7
        if(currentColumn < endingColumn && currentRow == endingRow){
           for(int i = currentColumn + 1; i <= endingColumn; i++){
               //check if squares are occupied in between
               if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i] != endingPosition){
                   validate = false;

                 System.out.println("inbetween");
               }else if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                    validate = false;

               }
           }
        }// if rook stays on same row, changing columns from 7 going to 0
        else if(currentColumn > endingColumn && currentRow == endingRow){
            for(int i = currentColumn - 1; i >= endingColumn; i--){
                    //check if squares are occupied in between
                    if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i] != endingPosition){
                        validate = false;


                    }else if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                        validate = false;

                    }
            }
        }
        return validate;

    }

    }

