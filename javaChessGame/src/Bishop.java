public class Bishop extends Piece {
    public Bishop(PieceColor color) {
        super(color, PieceType.BISHOP);
    }

    public Bishop(PieceColor color, Square startingPosition) {
        super(color, PieceType.BISHOP, startingPosition);
    }

    /**
     * checks weather the movie from BISHOPS current position to ending position is a valid BISHOPS move
     *
     * @param endingPosition The selected ending position the rook will go
     * @param chessBoard     The chessboard we are currently playing on
     * @return boolean     returns true if move is valid, false if there is enemy/friendly in between start/finish positions
     * or if there is a friendly piece on the ending position
     */
    @Override
    public boolean isMoveValid(Square endingPosition, Square[][] chessBoard) {
        boolean validate = true;
        int currentRow = this.getCurrentPosition().getRow();
        int currentColumn = this.getCurrentPosition().getColumn();

        int endingRow = endingPosition.getRow();
        int endingColumn = endingPosition.getColumn();


        if(Math.abs((currentRow - endingRow)/(currentColumn - endingColumn)) != 1){

            validate = false;
        }else{// (diagonal: down-right)
        if (currentColumn < endingColumn && currentRow < endingRow) {
            for (int i = currentColumn + 1; i <= endingColumn; i++) {
                //check if there is enemy/friendly piece in between
                if (chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i] != endingPosition ||
                        chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {

                    validate = false;
                }
                //System.out.println(chessBoard[currentRow + 1][i] + " + " + chessBoard[currentRow + 1][i].getOccupyingPiece());

                currentRow += 1;
            }
        } else //(diagonal: up-right)
            if (currentColumn < endingColumn && currentRow > endingRow) {
                for (int i = currentColumn + 1; i <= endingColumn; i++) {

                    if (chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i] != endingPosition ||
                            chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
                        validate = false;
                    }
                    //System.out.println(chessBoard[currentRow - 1][i] + " + " + chessBoard[currentRow - 1][i].getOccupyingPiece());
                    currentRow -= 1;
                }
            } else //(diagonal: up-left)
                if (currentColumn > endingColumn && currentRow > endingRow) {
                    for (int i = currentColumn - 1; i >= endingColumn; i--) {

                        if (chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i] != endingPosition ||
                                chessBoard[currentRow - 1][i].getIsOccupied() == true && chessBoard[currentRow - 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
                            validate = false;
                        }
                        //System.out.println(chessBoard[currentRow - 1][i] + " + " + chessBoard[currentRow - 1][i].getOccupyingPiece());
                        currentRow -= 1;
                    }
                } else //(diagonal: down-left)
                    if (currentColumn > endingColumn && currentRow < endingRow) {
                        for (int i = currentColumn - 1; i >= endingColumn; i--) {

                            if (chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i] != endingPosition ||
                                    chessBoard[currentRow + 1][i].getIsOccupied() == true && chessBoard[currentRow + 1][i].getOccupyingPiece().getPieceColor() == this.getPieceColor()) {
                                validate = false;
                            }
                            //System.out.println(chessBoard[currentRow + 1][i] + " + " + chessBoard[currentRow + 1][i].getOccupyingPiece());
                            currentRow += 1;
                        }


                    }
        }
        return validate;
    }
}