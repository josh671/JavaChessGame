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
        Square[][] chessBoard = new Square[8][8];


        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        chessBoard[0][0] = A1;

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
        Rook rookWhite = new Rook(Piece.PieceColor.WHITE, Piece.PieceType.ROOK);
        Rook rookBlack = new Rook(Piece.PieceColor.BLACK, Piece.PieceType.ROOK);

        chessBoard[0][5].setOccupyingPiece(rookWhite);
        rookWhite.setCurrentPosition(chessBoard[0][5]);

        System.out.println(rook.isMoveValid(endingPosition, chessBoard));
        //should return true


        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,0 to the right to 0,5 with friendly piece in between");

        chessBoard[0][5].setOccupyingPiece(null);
        chessBoard[0][5].setIsOccupied(false);

        rookBlack.setCurrentPosition(chessBoard[0][1]);
        chessBoard[0][1].setOccupyingPiece(rookBlack);

        System.out.println("here is the piece in between- " + chessBoard[0][1].getOccupyingPiece());
        System.out.println(rook.isMoveValid(endingPosition, chessBoard));
        //should return false

        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,5 to the left to 0,0  ");

        Square endingPosition2 = chessBoard[0][0];

        chessBoard[0][5].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(rook);

        //clear out square 0, 0
        chessBoard[0][0].setOccupyingPiece(null);
        chessBoard[0][1].setOccupyingPiece(null);
        System.out.println(chessBoard[0][5].getOccupyingPiece());

        System.out.println(rook.isMoveValid(endingPosition2, chessBoard));
        //should return true
        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,5 to the left to 0,0 with enemy on ending position ");

        chessBoard[0][0].setOccupyingPiece(rookWhite);
        System.out.println(rook.isMoveValid(endingPosition2, chessBoard));
        //should return true, because enemy is on ending square

        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid from 0,5 to the left to 0,0 with ENEMY(white) in between ");

        //should return false
        System.out.println(chessBoard[0][5].getOccupyingPiece());
        chessBoard[0][1].setOccupyingPiece(rookWhite);
        System.out.println(rook.isMoveValid(endingPosition2, chessBoard));

        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid starting 0,5 - and going down into the 7row,5th column or 7,5 ");

        //should return true. Because there is no one in between 0,5 and 7,5
         Square endingPositionRowGoingDown = chessBoard[7][5];
         System.out.println(rook.isMoveValid(endingPositionRowGoingDown, chessBoard));


        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid starting 0,5 - and going down into the 7row,5th column or 7,5 with enemy on ending");
        //should return false because a piece is blocking path
        chessBoard[7][5].setOccupyingPiece(rookWhite);

        rookWhite.setCurrentPosition(chessBoard[7][5]);
        System.out.println(rook.isMoveValid(endingPositionRowGoingDown, chessBoard));
        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid starting 0,5 - and going down into the 7row,5th column or 7,5 with friendly on ending");
        //should return false because a piece is blocking path
        chessBoard[7][5].setOccupyingPiece(rookBlack);

        rookBlack.setCurrentPosition(chessBoard[7][5]);
        System.out.println(rook.isMoveValid(endingPositionRowGoingDown, chessBoard));
        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid starting 7,5 - and going up into the 0row,5th column or 0,5  ");
        //should print true

        chessBoard[7][5].setOccupyingPiece(rook);
        chessBoard[0][5].setOccupyingPiece(null);
        rook.setCurrentPosition(chessBoard[7][5]);

        System.out.println(chessBoard[7][5].getOccupyingPiece());
        Square endingPositionMoveUp = chessBoard[0][5];
        System.out.println(rook.isMoveValid(endingPositionMoveUp, chessBoard));

        System.out.println("--------------------------------------------------");
        System.out.println("check if move is valid starting 7,5 going up to 0,5 - row 7, column 5 with enemy/friendly in between");
        chessBoard[7][5].setOccupyingPiece(null);
        chessBoard[6][5].setOccupyingPiece(rookBlack); //can change to rookWhite
        rookWhite.setCurrentPosition(chessBoard[6][5]);
        chessBoard[0][5].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[0][5]);
        //should print false
        Square endingPositionMoveDown = chessBoard[7][5];
        System.out.println(rook.isMoveValid(endingPositionMoveDown, chessBoard));




    }

}
