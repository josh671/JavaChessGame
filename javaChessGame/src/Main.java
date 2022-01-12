public class Main {



    public static void main(String[] args) {



        //creating a new chessBoard
        ChessBoard chessBoard = new ChessBoard();

        System.out.println("------------------------------------------------------------");
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[0][0], chessBoard.getChessBoard()[7][0]);
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[7][0], chessBoard.getChessBoard()[7][2]);
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[7][2], chessBoard.getChessBoard()[6][2]);
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[0][5], chessBoard.getChessBoard()[4][1]);
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[4][1], chessBoard.getChessBoard()[5][0]);
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[5][0], chessBoard.getChessBoard()[4][1]);
        chessBoard.killOrMovePiece(chessBoard.getChessBoard()[4][1], chessBoard.getChessBoard()[5][0]);
         System.out.println("here " + chessBoard.getIsWkingChecked());


        System.out.println("------------------------------------------------------------");



        for(int i = 0; i <= 7; i++){
            for(int f = 0; f <= 7; f++){
                System.out.println(chessBoard.getChessBoard()[i][f].getOccupyingPiece());
            }
        }

    }



}
