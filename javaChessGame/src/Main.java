public class Main {

    public static void main(String[] args) {


        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];


        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Rook blackRook = new Rook(Piece.PieceColor.BLACK);
        Rook whiteRook = new Rook(Piece.PieceColor.WHITE);

        Bishop blackBishop = new Bishop(Piece.PieceColor.BLACK);

        System.out.println("---------------------------------------------------------------");
        //test going down-right diagonal on board with no pieces in between
        System.out.println("test going down-right diagonal on board with no pieces in between");
        //validates true
        blackBishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(blackBishop);


        System.out.println(blackBishop.isMoveValid(chessBoard[5][7],chessBoard));

        System.out.println("---------------------------------------------------------------");
        //test going down-right diagonal on board with Enemy piece in between
        System.out.println("test going down-right diagonal on board with Enemy piece in between");
        //validates false, Enemy in between
        blackBishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(blackBishop);

        whiteRook.setCurrentPosition(chessBoard[3][5]);
        chessBoard[3][5].setOccupyingPiece(whiteRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[5][7],chessBoard));
        System.out.println("---------------------------------------------------------------");
        //test going down-right diagonal on board with Friendly piece in between
        System.out.println("test going down-right diagonal on board with Friendly piece in between");
        //validates false, Enemy in between
        blackBishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(blackBishop);

        blackRook.setCurrentPosition(chessBoard[3][5]);
        chessBoard[3][5].setOccupyingPiece(blackRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[5][7],chessBoard));
        System.out.println("---------------------------------------------------------------");
        //test going down-right diagonal on board with Enemy piece on ending
        System.out.println("test going down-right diagonal on board with Enemy piece on ending");
        //validates true, Enemy in between
        blackBishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(blackBishop);

        whiteRook.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(whiteRook);
        //remove black rook
        chessBoard[3][5].setOccupyingPiece(null);

        System.out.println(blackBishop.isMoveValid(chessBoard[5][7], chessBoard));
        System.out.println("---------------------------------------------------------------");
        //test going down-right diagonal on board with Friendly piece on ending
        System.out.println("test going down-right diagonal on board with Friendly piece on ending");
        //validates false, Enemy in between
        blackBishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(blackBishop);

        blackRook.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(blackRook);
        //remove black rook
        chessBoard[3][5].setOccupyingPiece(null);

        System.out.println(blackBishop.isMoveValid(chessBoard[5][7], chessBoard));
        System.out.println("---------------------------------------------------------------");
        //test going up-right diagonal with no one in between
        System.out.println("test going up-right diagonal with no one in between");
        //validates true, no one in between
        blackBishop.setCurrentPosition(chessBoard[7][2]);
        chessBoard[7][2].setOccupyingPiece(blackBishop);


        System.out.println(blackBishop.isMoveValid(chessBoard[2][7], chessBoard));


    }

}