import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    public Square startingPosition= new Square(0, 0);
    public Piece Bishop = new Piece(Piece.PieceColor.BLACK, Piece.PieceType.BISHOP, startingPosition) {};

    @Test
    void getPieceColor() {
        assertEquals(Piece.PieceColor.BLACK,    Bishop.getPieceColor());
    }

    @Test
    void getPieceType() {
        assertEquals(Piece.PieceType.BISHOP,    Bishop.getPieceType() );
    }

    @Test
    void getCurrentPosition() {
        assertEquals(startingPosition, Bishop.getCurrentPosition());
    }

    @Test
    void setCurrentPosition() {
        Square newPosition= new Square(1, 0);
        Bishop.setCurrentPosition(newPosition);

        assertEquals(newPosition, Bishop.getCurrentPosition());
    }
}