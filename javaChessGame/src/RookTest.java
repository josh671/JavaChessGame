import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    public Rook rook = new Rook(Piece.PieceColor.BLACK );
    public Rook enemyPiece = new Rook(Piece.PieceColor.WHITE );
    public Rook friendlyPiece = new Rook(Piece.PieceColor.BLACK );

    @Test
    void testValidMoveFromLeftToRight(){
        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Square endingPosition = chessBoard[0][5];
        chessBoard[0][0].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[0][0]);

        assertTrue( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testValidMoveFromRightToLeft(){
        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Square endingPosition = chessBoard[0][0];
        chessBoard[0][7].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[0][7]);

        assertTrue( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testValidMoveFromUpToDown(){
        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Square endingPosition = chessBoard[7][0];
        chessBoard[0][7].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[0][0]);

        assertTrue( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testValidMoveFromDownToUp(){
        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Square endingPosition = chessBoard[0][0];
        chessBoard[0][7].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[7][0]);

        assertTrue( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testNotValidMove1(){
        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Square endingPosition = chessBoard[3][7];
        chessBoard[0][7].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[0][0]);

        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testNotValidMove2(){
        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        Square endingPosition = chessBoard[7][3];
        chessBoard[0][7].setOccupyingPiece(rook);
        rook.setCurrentPosition(chessBoard[0][0]);

        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    //stay on same column, go down row-----------------------------------
    @Test
    void testEnemyPieceBetweenStartingRowGoingDownToEndingRow(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][0]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[7][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[5][0].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[5][0]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    //stay on same column, go up row
    @Test
    void testEnemyPieceBetweenStartingRowGoingUpToEndingRow(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[7][0]);
        chessBoard[7][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[5][0].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[5][0]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    //stay on same row, change column going right
    //stay on same column, go down row
    @Test
    void testEnemyPieceBetweenStartingColumnGoingRightToEndingColumn(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][0]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][7];


        //set enemy piece in middle of start/ending positions
        chessBoard[5][0].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[0][5]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    //stay on same column, go down row
    @Test
    void testEnemyPieceBetweenStartingColumnGoingLeftToEndingColumn(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][7]);
        chessBoard[0][7].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[5][0].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[0][5]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }


    //test friendly piece between starting and ending positions
    @Test
    void testFriendlyPieceBetweenStartingRowGoingDownToEndingRow(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][0]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[7][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[5][0].setOccupyingPiece(friendlyPiece);
        friendlyPiece.setCurrentPosition(chessBoard[5][0]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testFriendlyPieceBetweenStartingRowGoingUpToEndingRow(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[7][0]);
        chessBoard[7][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[5][0].setOccupyingPiece(friendlyPiece);
        friendlyPiece.setCurrentPosition(chessBoard[5][0]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testFriendlyPieceBetweenStartingColumnGoingRightToEndingColumn(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][0]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][7];


        //set enemy piece in middle of start/ending positions
        chessBoard[5][0].setOccupyingPiece(friendlyPiece);
        friendlyPiece.setCurrentPosition(chessBoard[0][5]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    //stay on same column, go down row
    @Test
    void testFriendlyPieceBetweenStartingColumnGoingLeftToEndingColumn(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][7]);
        chessBoard[0][7].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[0][5].setOccupyingPiece(friendlyPiece);
        friendlyPiece.setCurrentPosition(chessBoard[0][5]);


        assertFalse( rook.isMoveValid(endingPosition, chessBoard));
    }

    //test for enemy piece on ending position
    @Test
    void testEnemyPieceOnEndingPositionChangeRowsGoingDown(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][0]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[7][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[7][0].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[7][0]);


        assertTrue( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testEnemyPieceOnEndingPositionChangeRowsGoingUp(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[7][0]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[0][0].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[0][0]);


        assertTrue( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testEnemyPieceBetweenStartingColumnGoingGoingRight(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][0]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][7];


        //set enemy piece in middle of start/ending positions
        chessBoard[0][7].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[0][7]);


        assertTrue( rook.isMoveValid(endingPosition, chessBoard));
    }

    @Test
    void testEnemyPieceBetweenStartingColumnGoingGoingLeft(){

        //make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        //set rook to occupy square
        rook.setCurrentPosition(chessBoard[0][7]);
        chessBoard[0][0].setOccupyingPiece(rook);
        //set ending position
        Square endingPosition = chessBoard[0][0];


        //set enemy piece in middle of start/ending positions
        chessBoard[0][0].setOccupyingPiece(enemyPiece);
        enemyPiece.setCurrentPosition(chessBoard[0][0]);


        assertTrue(rook.isMoveValid(endingPosition, chessBoard));
    }
}