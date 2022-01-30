import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
	
    public King king = new King(Piece.PieceColor.BLACK);
    public King enemy = new King(Piece.PieceColor.WHITE);
    public Pawn friendly = new Pawn(Piece.PieceColor.BLACK);

    public Square[][] createChessboard(){
    	//make chessBoard
        Square[][] chessBoard = new Square[8][8];
        //fill chessBoard
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <= 7; j++){
                chessBoard[j][i] = new Square(j, i);
            }

        }
        return chessBoard;
    }
    
    @Test
    void testValidMoves(){
    	Square[][] chessBoard = createChessboard();
        //set king to occupy square
        chessBoard[4][4].setOccupyingPiece(king);
        king.setCurrentPosition(chessBoard[4][4]);
        
        assertEquals(true, king.isMoveValid(chessBoard[4][5], chessBoard));//LeftToRight
        assertEquals(true, king.isMoveValid(chessBoard[4][3], chessBoard));//RightToLeft
        assertEquals(true, king.isMoveValid(chessBoard[5][4], chessBoard));//DownToUp
        assertEquals(true, king.isMoveValid(chessBoard[3][4], chessBoard));//UpToDown
        
        assertEquals(true, king.isMoveValid(chessBoard[5][5], chessBoard));//DiagonalUpRight
        assertEquals(true, king.isMoveValid(chessBoard[5][3], chessBoard));//DiagonalUpLeft
        assertEquals(true, king.isMoveValid(chessBoard[3][5], chessBoard));//DiagonalDownRight
        assertEquals(true, king.isMoveValid(chessBoard[3][3], chessBoard));//DiagonalDownLeft
    }

    @Test
    void testInvalidMoves(){
    	Square[][] chessBoard = createChessboard();
        //set king to occupy square
        chessBoard[4][4].setOccupyingPiece(king);
        king.setCurrentPosition(chessBoard[4][4]);
        
        assertEquals(false, king.isMoveValid(chessBoard[4][6], chessBoard));//LeftToTwoRight
        assertEquals(false, king.isMoveValid(chessBoard[4][2], chessBoard));//RightToTwoLeft
        assertEquals(false, king.isMoveValid(chessBoard[6][4], chessBoard));//DownToTwoUp
        assertEquals(false, king.isMoveValid(chessBoard[2][4], chessBoard));//UpToTwoDown
        
        assertEquals(false, king.isMoveValid(chessBoard[6][6], chessBoard));//DiagonalUpTwoRight
        assertEquals(false, king.isMoveValid(chessBoard[6][3], chessBoard));//DiagonalUpTwoLeft
        assertEquals(false, king.isMoveValid(chessBoard[2][6], chessBoard));//DiagonalDownTwoRight
        assertEquals(false, king.isMoveValid(chessBoard[2][2], chessBoard));//DiagonalDownTwoLeft
        
        assertEquals(false, king.isMoveValid(chessBoard[5][6], chessBoard));//MoveOneUpTwoRight
        assertEquals(false, king.isMoveValid(chessBoard[5][2], chessBoard));//MoveOneUpTwoLeft
        assertEquals(false, king.isMoveValid(chessBoard[3][6], chessBoard));//MoveOneDownTwoRight
        assertEquals(false, king.isMoveValid(chessBoard[3][2], chessBoard));//MoveOneDownTwoLeft
    }

    @Test
    void testInvalidMovesWithFriendlyPiece(){
    	Square[][] chessBoard = createChessboard();
        //set king to occupy square
        chessBoard[4][4].setOccupyingPiece(king);
        king.setCurrentPosition(chessBoard[4][4]);
        //set friendly pawn to occupy square
        chessBoard[4][5].setOccupyingPiece(friendly);
        
        assertEquals(false, king.isMoveValid(chessBoard[4][5], chessBoard));

    }
    
    @Test
    void testEnemyPieceAtEndingPosition(){
    	Square[][] chessBoard = createChessboard();
        //set king to occupy square
        king.setCurrentPosition(chessBoard[4][4]);
        //set king enemy to occupy square
        chessBoard[4][5].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[4][5]);

        assertEquals(true, king.isMoveValid(chessBoard[4][5], chessBoard));//LeftToRightWithEnemyAtEndingPosition
        
        //set king enemy to occupy square
        chessBoard[4][3].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[4][3]);

        assertEquals(true, king.isMoveValid(chessBoard[4][3], chessBoard));//RightToLeftWithEnemyAtEndingPosition
        
        
        chessBoard[5][4].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[5][4]);

        assertEquals(true, king.isMoveValid(chessBoard[5][4], chessBoard));//DownToUpWithEnemyAtEndingPosition
        
        
        chessBoard[3][4].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[3][4]);

        assertEquals(true, king.isMoveValid(chessBoard[3][4], chessBoard));//UpToDownWithEnemyAtEndingPosition
        
        chessBoard[5][5].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[5][5]);

        assertEquals(true, king.isMoveValid(chessBoard[5][5], chessBoard));//DiagonalUpTwoRightWithEnemyAtEndingPosition
        
        chessBoard[5][3].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[5][3]);

        assertEquals(true, king.isMoveValid(chessBoard[5][3], chessBoard));//DiagonalUpTwoLeftWithEnemyAtEndingPosition
        
        chessBoard[3][5].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[3][5]);

        assertEquals(true, king.isMoveValid(chessBoard[3][5], chessBoard));//DiagonalDownTwoRightWithEnemyAtEndingPosition
        
        chessBoard[3][3].setOccupyingPiece(enemy);
        enemy.setCurrentPosition(chessBoard[3][3]);

        assertEquals(true, king.isMoveValid(chessBoard[3][3], chessBoard));//DiagonalDownTwoLeftWithEnemyAtEndingPosition
        
    }
}

