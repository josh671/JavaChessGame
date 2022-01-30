import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {


    @Test
    public void testBishopConstructor(){
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        assertEquals(Piece.PieceColor.BLACK, bishop.getPieceColor());
        assertEquals(Piece.PieceType.BISHOP, bishop.getPieceType());
    }

    @Test
    public void testisMoveValidWhenInputIsIncorrect(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(bishop);

        assertFalse( bishop.isMoveValid(chessBoard[4][2], chessBoard));
    }

//test directional movement with no one in between
    @Test
    public void testMovementDiagonalDownRight(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(bishop);

        assertTrue( bishop.isMoveValid(chessBoard[2][7], chessBoard));
    }


    @Test
    public void testMovementDiagonalUpRight(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[6][1]);
        chessBoard[6][1].setOccupyingPiece(bishop);

        assertTrue( bishop.isMoveValid(chessBoard[0][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalDownLeft(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(bishop);

        assertTrue( bishop.isMoveValid(chessBoard[4][1], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpLeft(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][4]);
        chessBoard[7][4].setOccupyingPiece(bishop);

        assertTrue( bishop.isMoveValid(chessBoard[4][7], chessBoard));
    }

    //movement with friendly in between
    @Test
    public void testMovementDiagonalDownRightFriendlyInBetween(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[3][5]);
        chessBoard[3][5].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[5][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpRightFriendlyInBetween(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][2]);
        chessBoard[7][2].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[4][5]);
        chessBoard[4][5].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[2][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalDownLeftFriendlyInBetween(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[4][1]);
        chessBoard[4][1].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[5][0], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpLeftFriendlyInBetween(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][5]);
        chessBoard[7][5].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[3][1]);
        chessBoard[3][1].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[2][0], chessBoard));
    }

    //movement with Enemy in between
    @Test
    public void testMovementDiagonalDownRightEnemyInBetween(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.WHITE);
        wRook.setCurrentPosition(chessBoard[3][5]);
        chessBoard[3][5].setOccupyingPiece(wRook);

        assertFalse( bishop.isMoveValid(chessBoard[5][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpRightEnemyInBetween(){
//create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][2]);
        chessBoard[7][2].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.WHITE);
        wRook.setCurrentPosition(chessBoard[4][5]);
        chessBoard[4][5].setOccupyingPiece(wRook);

        assertFalse( bishop.isMoveValid(chessBoard[2][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalDownLeftEnemyInBetween(){
//create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.WHITE);
        bishop.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.BLACK);
        wRook.setCurrentPosition(chessBoard[4][1]);
        chessBoard[4][1].setOccupyingPiece(wRook);

        assertFalse( bishop.isMoveValid(chessBoard[5][0], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpLeftEnemyInBetween(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][5]);
        chessBoard[7][5].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.WHITE);
        wRook.setCurrentPosition(chessBoard[3][1]);
        chessBoard[3][1].setOccupyingPiece(wRook);

        assertFalse( bishop.isMoveValid(chessBoard[2][0], chessBoard));
    }


    //tests for friendly on ending
    @Test
    public void testMovementDiagonalDownRightFriendlyOnEnding(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[5][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpRightFriendlyOnEnding(){
//create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][2]);
        chessBoard[7][2].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[2][7]);
        chessBoard[2][7].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[2][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalDownLeftFriendlyOnEnding(){
//create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[5][0]);
        chessBoard[5][0].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[5][0], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpLeftFriendlyOnEnding(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][5]);
        chessBoard[7][5].setOccupyingPiece(bishop);

        Rook bRook = new Rook(Piece.PieceColor.BLACK);
        bRook.setCurrentPosition(chessBoard[2][0]);
        chessBoard[2][0].setOccupyingPiece(bRook);

        assertFalse( bishop.isMoveValid(chessBoard[2][0], chessBoard));
    }

    //tests for enemy on ending
    @Test
    public void testMovementDiagonalDownRightEnemyOnEnding(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][2]);
        chessBoard[0][2].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.WHITE);
        wRook.setCurrentPosition(chessBoard[5][7]);
        chessBoard[5][7].setOccupyingPiece(wRook);

        assertTrue( bishop.isMoveValid(chessBoard[5][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpRightEnemyOnEnding(){
//create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][2]);
        chessBoard[7][2].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.WHITE);
        wRook.setCurrentPosition(chessBoard[2][7]);
        chessBoard[2][7].setOccupyingPiece(wRook);

        assertTrue( bishop.isMoveValid(chessBoard[2][7], chessBoard));
    }

    @Test
    public void testMovementDiagonalDownLeftEnemyOnEnding(){
//create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[0][5]);
        chessBoard[0][5].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.WHITE);
        wRook.setCurrentPosition(chessBoard[5][0]);
        chessBoard[5][0].setOccupyingPiece(wRook);

        assertTrue( bishop.isMoveValid(chessBoard[5][0], chessBoard));
    }

    @Test
    public void testMovementDiagonalUpLeftEnemyOnEnding(){
        //create a chessboard for testing
        Square[][] chessBoard = new Square[8][8];

        //fill only A1,B1,C1,D1,E1
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Bishop bishop = new Bishop(Piece.PieceColor.BLACK);
        bishop.setCurrentPosition(chessBoard[7][5]);
        chessBoard[7][5].setOccupyingPiece(bishop);

        Rook wRook = new Rook(Piece.PieceColor.WHITE);
        wRook.setCurrentPosition(chessBoard[2][0]);
        chessBoard[2][0].setOccupyingPiece(wRook);

        assertTrue( bishop.isMoveValid(chessBoard[2][0], chessBoard));
    }
}



