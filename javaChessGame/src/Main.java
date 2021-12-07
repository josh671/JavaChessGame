public class Main {

    public static void main(String[] args) {
       //create square
        Square A1 = new Square(0, 0);
        //check if square is occupied
        System.out.println(A1); //returns Row: 0, Column: 0
        System.out.println(A1.getIsOccupied()); //returns false
        //Square is not occupied
        System.out.println("--------------------------------------------------");

        //Create Rook Piece
        Rook rook = new Rook(Piece.PieceColor.BLACK, Piece.PieceType.ROOK);
        //check rooks info
        System.out.println(rook);//returns ROOK : BLACK  Current Position: null
        //rook is not on a square
        System.out.println("--------------------------------------------------");

        //place the rook on the A1 square
        rook.setCurrentPosition(A1);
        A1.setOccupyingPiece(rook);
        //check if A1 is occupied
        //check if rook has a starging position
        System.out.println("starging position");
        System.out.println(A1.getIsOccupied());
        System.out.println(A1.getOccupyingPiece());
        System.out.println(rook.getCurrentPosition());

        //sets the rooks position to the square and the square's occupying piece to the rook
        System.out.println("--------------------------------------------------");


        //create a chessboard for testing
        Square[][] chessBoard = new Square[7][7];
        chessBoard[0][0] = A1;

        //fill only A1,B1,C1,D1,E1
        for(int i = 1; i < 6; i++){
            chessBoard[0][i] = new Square(0, i);
        }
        //check if rook is in the A1 spot
        System.out.println(chessBoard[0][0].getIsOccupied()); //returns true
        //check if A2 - A5 is empty
        for(int i = 0; i < 6; i++){
           System.out.println( chessBoard[0][i].getIsOccupied());
        }
        Square endingPosition = chessBoard[0][5];
        //todo: fix movement
        //Square[row][column]


        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,0 to the right to 0,5 with nothing in between");
        System.out.println(rook.isMoveValid(endingPosition, chessBoard));
        //should return true

        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,0 to the right to 0,5 with enemy piece on the ending square");
        Rook rook2 = new Rook(Piece.PieceColor.WHITE, Piece.PieceType.ROOK);
        chessBoard[0][5].setOccupyingPiece(rook2);
        rook2.setCurrentPosition(chessBoard[0][5]);
        System.out.println(rook.isMoveValid(endingPosition, chessBoard));
        //should return true


        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,0 to the right to 0,5 with enemy piece in between");

        chessBoard[0][5].setOccupyingPiece(null);
        chessBoard[0][5].setIsOccupied(false);

        rook2.setCurrentPosition(chessBoard[0][1]);
        chessBoard[0][1].setOccupyingPiece(rook2);

        System.out.println("here is the piece in between- " + chessBoard[0][1].getOccupyingPiece());
        System.out.println(rook.isMoveValid(endingPosition, chessBoard));
        //should return false

        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,5 to the left to 0,0  ");

        Square endingPosition2 = chessBoard[0][0];

        chessBoard[0][5].setOccupyingPiece(rook);
        chessBoard[0][5].setIsOccupied(false);

        rook.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(rook);
        //clear out square 0, 0
        chessBoard[0][0].setOccupyingPiece(null);
        chessBoard[0][1].setOccupyingPiece(null);
        System.out.println(chessBoard[0][5].getOccupyingPiece());

        System.out.println(rook.isMoveValid(endingPosition2, chessBoard));
        //should return true

        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,5 to the left to 0,0 with piece in between ");




        rook.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(rook);
        //clear out square 0, 0
        chessBoard[0][0].setOccupyingPiece(null);
        chessBoard[0][1].setOccupyingPiece(rook2);
        rook2.setCurrentPosition(chessBoard[0][1]);
        System.out.println(chessBoard[0][5].getOccupyingPiece());

        System.out.println(rook.isMoveValid(endingPosition2, chessBoard));
        //should return true
    }

}
