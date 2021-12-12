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


         //if rows are the same and moving right to different column chessBoard[same][0-7]
        if(currentColumn < endingColumn && currentRow == endingRow){
           for(int i = currentColumn + 1; i <= endingColumn; i++){
               //check if squares are occupied in between
               if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i] != endingPosition){
                   validate = false;

                 System.out.println("There is an enemy/friendly in between starting and ending");
               }else if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                    validate = false;
                 System.out.println("There is an  friendly on the ending");
               }
           }
        }// if row is same but moving left to different column chessBoard[same][7-0]
        else if(currentColumn > endingColumn && currentRow == endingRow){
            for(int i = currentColumn - 1; i >= endingColumn; i--){
                    //check if squares are occupied in between
                    if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i] != endingPosition){
                        validate = false;
                        System.out.println("There is an enemy/friendly in between starting and ending");

                    }else if(chessBoard[currentRow][i].getIsOccupied() == true && chessBoard[currentRow][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                        validate = false;
                        System.out.println("There is an  friendly on the ending");
                    }
            }
        } else//if rook is on same column, and moving down a row chessBoard[0 going 7][same]
         if(currentColumn == endingColumn && currentRow < endingRow){
            for(int i = currentRow + 1; i <= endingRow; i++){
                if(chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn] != endingPosition){
                    validate = false;
                    System.out.println("There is an enemy/friendly in between starting and ending");
                }else if(chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                    validate = false;
                    System.out.println("There is an  friendly on the ending");
                }
            }
        }else //if column is same and moving up rows chessBoard[7 to 0][same]
            if(currentColumn == endingColumn && currentRow > endingRow){
            for(int i = currentRow - 1; i >= endingRow; i--){
                if(chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn] != endingPosition){
                    validate = false;
                    System.out.println("There is an enemy/friendly in between starting and ending");
                }else if(chessBoard[i][currentColumn].getIsOccupied() == true && chessBoard[i][currentColumn].getOccupyingPiece().getPieceColor() == this.getPieceColor()){
                    validate = false;
                    System.out.println("There is an  friendly on the ending");
                }
            }
        }else if(currentColumn != endingColumn || currentRow != endingRow){
                validate = false;
            }
        return validate;

    }

    }

