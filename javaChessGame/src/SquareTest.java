import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    public void testSquareConstructor(){
        Square testSquare = new Square(7,1, false);
        assertEquals(7, testSquare.getRow());
        assertEquals(1, testSquare.getColumn());
        assertEquals(false, testSquare.getOccupation());
    }


    @org.junit.jupiter.api.Test
    void setRow() {
        Square testSquare = new Square(7,1, false);
        testSquare.setRow(2);
        assertEquals(2, testSquare.getRow());

    }

    @org.junit.jupiter.api.Test
    void setColumn() {
        Square testSquare = new Square(7,1, false);
        testSquare.setColumn(2);
        assertEquals(2, testSquare.getColumn());
    }

    @org.junit.jupiter.api.Test
    void setOccupied() {
        Square testSquare = new Square(7,1, false);
        testSquare.setOccupied(true);
        assertEquals(true, testSquare.getOccupation());
    }

    @org.junit.jupiter.api.Test
    void testBadValueRow1(){
        assertThrows(IllegalArgumentException.class, () -> new Square(-1,1, false));
    }

    @org.junit.jupiter.api.Test
    void testBadValueRow2(){
        assertThrows(IllegalArgumentException.class, () -> new Square(8,1, false));
    }

    @org.junit.jupiter.api.Test
    void testBadValueColumn1(){
        assertThrows(IllegalArgumentException.class, () -> new Square(1,-1, false));
    }

    @org.junit.jupiter.api.Test
    void testBadValueColumn2(){
        assertThrows(IllegalArgumentException.class, () -> new Square(8,8, false));
    }
}