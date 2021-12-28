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
        blackBishop.setCurrentPosition(chessBoard[7][0]);
        chessBoard[7][0].setOccupyingPiece(blackBishop);

        System.out.println(blackBishop.isMoveValid(chessBoard[0][7], chessBoard));

        System.out.println("---------------------------------------------------------------");
        //test going up-right diagonal with Enemy in between
        System.out.println("test going up-right diagonal with Enemy in between");
        //validates false, Enemy in between
        blackBishop.setCurrentPosition(chessBoard[7][2]);
        chessBoard[7][2].setOccupyingPiece(blackBishop);

        whiteRook.setCurrentPosition(chessBoard[4][5]);
        chessBoard[4][5].setOccupyingPiece(whiteRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[2][7], chessBoard));

        System.out.println("---------------------------------------------------------------");
        //test going up-right diagonal with friendly in between
        System.out.println("test going up-right Friendly in between");
        //validates false, Enemy in between
        blackBishop.setCurrentPosition(chessBoard[7][2]);
        chessBoard[7][2].setOccupyingPiece(blackBishop);

        blackRook.setCurrentPosition(chessBoard[4][5]);
        chessBoard[4][5].setOccupyingPiece(blackRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[2][7], chessBoard));
        chessBoard[4][5].setOccupyingPiece(null); //remove piece from board
        System.out.println("---------------------------------------------------------------");
        //test going up-right diagonal with Enemy on ending
        System.out.println("test going up-right diagonal with Enemy on ending");
        //validates true, Enemy on ending
        blackBishop.setCurrentPosition(chessBoard[5][0]);
        chessBoard[5][0].setOccupyingPiece(blackBishop);

        whiteRook.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(whiteRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[0][5], chessBoard));

        System.out.println("---------------------------------------------------------------");
        //test going up-right diagonal with Friendly on ending
        System.out.println("test going up-right Friendly on ending");
        //validates false, Friendly on ending
        blackBishop.setCurrentPosition(chessBoard[5][0]);
        chessBoard[5][0].setOccupyingPiece(blackBishop);

        blackRook.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(blackRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[0][5], chessBoard));

        System.out.println("---------------------------------------------------------------");
        //test going up-left diagonal with no Enemy/Friendly in between or on ending
        System.out.println("test going up-left diagonal with no Enemy/Friendly in between or on ending");
        //validates true, no one in between
        blackBishop.setCurrentPosition(chessBoard[5][6]);
        chessBoard[5][6].setOccupyingPiece(blackBishop);



        System.out.println(blackBishop.isMoveValid(chessBoard[0][1], chessBoard));
        System.out.println("---------------------------------------------------------------");
        //test going up-left diagonal with no Enemy  in between or on ending
        System.out.println("test going up-left diagonal with no Enemy  in between or on ending");
        //validates false, Enemy in between
        blackBishop.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(blackBishop);

        whiteRook.setCurrentPosition(chessBoard[3][5]);
        chessBoard[3][5].setOccupyingPiece(whiteRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[1][3], chessBoard));
        System.out.println("---------------------------------------------------------------");
        //test going up-left diagonal with no  Friendly in between or on ending
        System.out.println("test going up-left diagonal with no Friendly in between");
        //validates false, friendly in between
        blackBishop.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(blackBishop);

        blackRook.setCurrentPosition(chessBoard[3][5]);
        chessBoard[3][5].setOccupyingPiece(blackRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[1][3], chessBoard));
        System.out.println("---------------------------------------------------------------");
        //test going up-left diagonal Enemy on ending
        System.out.println("test going up-left diagonal Enemy on ending");
        //validates true, Enemy in ending
        blackBishop.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(blackBishop);

        chessBoard[3][5].setOccupyingPiece(null);

        whiteRook.setCurrentPosition(chessBoard[1][3]);
        chessBoard[1][3].setOccupyingPiece(whiteRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[1][3], chessBoard));
        System.out.println("---------------------------------------------------------------");
        System.out.println("test going up-left diagonal Friendly on ending");
        //validates false, friendly in ending
        blackBishop.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(blackBishop);

        chessBoard[3][5].setOccupyingPiece(null);

        blackRook.setCurrentPosition(chessBoard[1][3]);
        chessBoard[1][3].setOccupyingPiece(blackRook);

        System.out.println(blackBishop.isMoveValid(chessBoard[1][3], chessBoard));
        System.out.println("---------------------------------------------------------------");
        System.out.println("test going down-left diagonal no one in between");
        //test going down-left diagonal no one in between
        blackBishop.setCurrentPosition(chessBoard[2][0]);
        chessBoard[2][0].setOccupyingPiece(blackBishop);
        chessBoard[5][7].setOccupyingPiece(null);


        System.out.println(blackBishop.isMoveValid(chessBoard[6][4], chessBoard));
        System.out.println("---------------------------------------------------------------");
        System.out.println("test going down-left diagonal Enemy in between");
        //test going down-left diagonal Enemy in between

       chessBoard[5][3].setOccupyingPiece(whiteRook);
       whiteRook.setCurrentPosition(chessBoard[5][3]);


       System.out.println(blackBishop.isMoveValid(chessBoard[6][4], chessBoard));
        System.out.println("---------------------------------------------------------------");
        System.out.println("test going down-left diagonal Friendly in between");
        //test going down-left diagonal Friendly in between

        chessBoard[5][3].setOccupyingPiece(whiteRook);
        whiteRook.setCurrentPosition(chessBoard[5][3]);


        System.out.println(blackBishop.isMoveValid(chessBoard[6][4], chessBoard));

        System.out.println("---------------------------------------------------------------");
        System.out.println("test going down-left diagonal Enemy on ending");
        //test going down-left diagonal Enemy on ending

        chessBoard[6][4].setOccupyingPiece(whiteRook);
        whiteRook.setCurrentPosition(chessBoard[6][4]);
        chessBoard[5][3].setOccupyingPiece(null);

        System.out.println(blackBishop.isMoveValid(chessBoard[6][4], chessBoard));
        System.out.println("---------------------------------------------------------------");
        System.out.println("test going down-left diagonal Friendly on ending");
        //test going down-left diagonal Friendly on ending

        chessBoard[6][4].setOccupyingPiece(blackBishop);
        blackBishop.setCurrentPosition(chessBoard[6][4]);


        System.out.println(blackBishop.isMoveValid(chessBoard[6][4], chessBoard));

        //Todo: should pieces have method to check if they are checking king
        //should chessBoard class check if King is in check
    }

}