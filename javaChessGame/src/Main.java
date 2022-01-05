public class Main {

    public static void main(String[] args) {



        //creating a new chessBoard
        ChessBoard chessBoard = new ChessBoard();

        //gets black Rook on starting position
        System.out.println(chessBoard.getChessBoard()[0][0].getOccupyingPiece());

        //gets empty square where knight should be
        System.out.println(chessBoard.getChessBoard()[0][1].getOccupyingPiece());

        //checks if black Rook move is valid from (0,0) to (5,0)
        System.out.println(chessBoard.getChessBoard()[0][0].getOccupyingPiece().isMoveValid(chessBoard.getChessBoard()[5][0], chessBoard.getChessBoard()));

        //gets Rooks/Bishops starting positions
        System.out.println(chessBoard.getChessBoard()[0][0].getOccupyingPiece());
        System.out.println(chessBoard.getChessBoard()[0][7].getOccupyingPiece());
        System.out.println(chessBoard.getChessBoard()[7][0].getOccupyingPiece());
        System.out.println(chessBoard.getChessBoard()[7][7].getOccupyingPiece());
        System.out.println(chessBoard.getChessBoard()[0][2].getOccupyingPiece());
        System.out.println(chessBoard.getChessBoard()[0][5].getOccupyingPiece());
        //------------------------------------------------------------------------------

        System.out.println("------------------------------------------------------------");
        System.out.println("Kings current Positions from chessBoard class");
        System.out.println(chessBoard.getWhiteKingsPosition().getOccupyingPiece());
        System.out.println(chessBoard.getBlackKingsPosition().getOccupyingPiece());
        System.out.println("------------------------------------------------------------");
        System.out.println("Moving Rook to end of board killing WRook then WBishop checking each time if WKing is checked)");
        //Moving Rook to end of board killing WRook then moving to (5,0)
        //kills opposing Rook
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[0][0], chessBoard.getChessBoard()[7][0]);
        ///////////////////
        //check if WKing is checked after killing rook with WBishop in between
        System.out.println(chessBoard.getIsWkingChecked());
        //kills opposing Bishop that was in between
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[7][0], chessBoard.getChessBoard()[7][2]);
        //testing if WKing is now in check
        System.out.println("testing is checked after WBishop killed ");
        //should be true
        System.out.println(chessBoard.getIsWkingChecked());
        //testing if WKing is in check when moving Rook away
        System.out.println("testing if WKing is in check when moving Rook away");
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[7][2], chessBoard.getChessBoard()[6][2]);
        System.out.println(chessBoard.getIsWkingChecked());

        System.out.println("------------------------------------------------------------");
        System.out.println("chess board with current occupying pieces");
        for(int i = 0; i <= 7; i++){
            for(int f = 0; f <= 7; f++){
                System.out.println(chessBoard.getChessBoard()[i][f].getOccupyingPiece());
            }
        }

/////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("------------------------------------------------------------");
        System.out.println("test for WKing in check with Bishops ");
        //test for WKing in check with Bishops
        ChessBoard newBoard = new ChessBoard();
        newBoard.killOrMovePiece(newBoard.getChessBoard()[0][5], newBoard.getChessBoard()[4][2]);

        System.out.println("------------------------------------------------------------");
        System.out.println("test for WKing in check with rook blocking bishop ");
        //test for WKing in check with Bishops
        System.out.println("WRook Not Blocking " + newBoard.getIsWkingChecked());
         //select and move WRook up one row,
        newBoard.killOrMovePiece(newBoard.getChessBoard()[7][7], newBoard.getChessBoard()[6][7]);
        //move WRook to block BBishop's check path
        newBoard.killOrMovePiece(newBoard.getChessBoard()[6][7], newBoard.getChessBoard()[6][3]);
        System.out.println("WRook Blocking " + newBoard.getIsWkingChecked());
        newBoard.killOrMovePiece(newBoard.getChessBoard()[6][3], newBoard.getChessBoard()[6][7]);
        System.out.println("WRook moved from Blocking " + newBoard.getIsWkingChecked());
        //move WRook out of way

        System.out.println("------------------------------------------------------------");
        for(int i = 0; i <= 7; i++){
            for(int f = 0; f <= 7; f++){
                System.out.println(newBoard.getChessBoard()[i][f].getOccupyingPiece());
            }
        }

        //Todo: should pieces have method to check if they are checking king
        //should chessBoard class check if King is in check
    }

}