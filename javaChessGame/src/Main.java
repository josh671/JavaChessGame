public class Main {

    public static void main(String[] args) {
        Piece Bishop = new Piece(Piece.PieceColor.BLACK, Piece.PieceType.BISHOP) {
        };
        Square testSquare = new Square(7,1, Bishop);

//        System.out.println(testSquare.getColumn());
//        System.out.println(testSquare.getRow());
//        System.out.println(testSquare.getOccupation());

    }
}
