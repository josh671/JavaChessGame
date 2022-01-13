import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    public Knight knight = new Knight(Piece.PieceColor.BLACK);
    public Knight enemy = new Knight(Piece.PieceColor.BLACK);
    public Knight friendly = new Knight(Piece.PieceColor.BLACK);


    /*
        These tests should return true.
     */
    @Test
    void testValidMoveTwoDownOneLeft() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[1][0].setOccupyingPiece(knight);
        Square endingPosition = board[0][2];
        knight.setCurrentPosition(board[0][2]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }

    @Test
    void testValidMoveTwoDownOneRight() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[1][0].setOccupyingPiece(knight);
        Square endingPosition = board[2][2];
        knight.setCurrentPosition(board[2][2]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }

    @Test
    void testValidMoveTwoUpOneLeft() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[1][7].setOccupyingPiece(knight);
        Square endingPosition = board[0][5];
        knight.setCurrentPosition(board[0][5]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }

    @Test
    void testValidMoveTwoUpOneRight() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[1][7].setOccupyingPiece(knight);
        Square endingPosition = board[2][5];
        knight.setCurrentPosition(board[2][5]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }

    @Test
    void testValidMoveOneDownTwoRight() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[1][0].setOccupyingPiece(knight);
        Square endingPosition = board[3][1];
        knight.setCurrentPosition(board[3][1]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }

    @Test
    void testValidMoveOneDownTwoLeft() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[6][0].setOccupyingPiece(knight);
        Square endingPosition = board[4][1];
        knight.setCurrentPosition(board[4][1]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }

    @Test
    void testValidMoveOneUpTwoRight() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[1][7].setOccupyingPiece(knight);
        Square endingPosition = board[3][6];
        knight.setCurrentPosition(board[3][6]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }

    @Test
    void testValidMoveOneUpTwoLeft() {
        // Make and fill the chessboard
        Square[][] board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i] = new Square(j, i);
            }
        }

        board[6][7].setOccupyingPiece(knight);
        Square endingPosition = board[4][6];
        knight.setCurrentPosition(board[4][6]);

        assertEquals(true, knight.isMoveValid(endingPosition, board));
    }



    /*
        These tests should return false.
     */
    g
}