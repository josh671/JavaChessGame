import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {
    public Piece Bishop = new Piece(Piece.PieceColor.BLACK, Piece.PieceType.BISHOP) {

    };

    @Test
    public void testSquareConstructor(){
        Square testSquare = new Square(7,1, Bishop);

        assertEquals(7, testSquare.getRow());
        assertEquals(1, testSquare.getColumn());
        assertEquals(Bishop, testSquare.getOccupyingPiece());
    }

    @Test
    public void testSecondSquareConstructor(){
        Square testSquare = new Square(7,1 );

        assertEquals(7, testSquare.getRow());
        assertEquals(1, testSquare.getColumn());
        assertEquals(null, testSquare.getOccupyingPiece());
        assertEquals(false, testSquare.getIsOccupied());
    }


    @org.junit.jupiter.api.Test
    void setRow() {
        Square testSquare = new Square(7,1, Bishop);

        testSquare.setRow(2);
        assertEquals(2, testSquare.getRow());

    }

    @org.junit.jupiter.api.Test
    void setColumn() {

        Square testSquare = new Square(7,1, Bishop);
        testSquare.setColumn(2);
        assertEquals(2, testSquare.getColumn());
    }

    @org.junit.jupiter.api.Test
    void setOccupied() {
        Square testSquare = new Square(7,1, Bishop);

        assertEquals(true, testSquare.getIsOccupied());
    }



    @org.junit.jupiter.api.Test
    void testBadValueRow1(){
        assertThrows(IllegalArgumentException.class, () -> new Square(-1,1, Bishop));
    }

    @org.junit.jupiter.api.Test
    void testBadValueRow2(){
        assertThrows(IllegalArgumentException.class, () -> new Square(8,1, Bishop));
    }

    @org.junit.jupiter.api.Test
    void testBadValueColumn1(){
        assertThrows(IllegalArgumentException.class, () -> new Square(1,-1, Bishop));
    }

    @org.junit.jupiter.api.Test
    void testBadValueColumn2(){
        assertThrows(IllegalArgumentException.class, () -> new Square(8,8, Bishop));
    }



}







