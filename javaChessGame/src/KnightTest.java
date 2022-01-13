import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    public Knight knight = new Knight(Piece.PieceColor.BLACK);
    public Knight enemy = new Knight(Piece.PieceColor.BLACK);
    public Knight friendly = new Knight(Piece.PieceColor.BLACK);

    @Test
    void testValidMoveTwoUpOneRight() {
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

}