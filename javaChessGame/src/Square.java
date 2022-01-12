/** Square Documentation 11/27/2021
 * Square class creates Square objects representing each piece on the board
 * The Chess Board is 8x8 and will be represented as a 2-D array with index being 7x7 or [0-7][0-7]
 * Square object will keep track of:
 *      -its column
 *      -its row
 *      -what piece is occupying its position
 *      -whether its position is(ture)/not(false) occupied
 */

public class Square {
    private int column;
    private int row;
    private boolean isOccupied;
    private Piece occupyingPiece;


    public Square(int row, int column){
        setRow(row);
        setColumn(column);
        setOccupyingPiece(null);
    }

    public Square(int row, int column, Piece occupyingPiece)
    {
        setRow(row);
        setColumn(column);
        setOccupyingPiece(occupyingPiece);

    }

    /**
     * Sets the Squares row position
     * @param row       Squares row position on the board
     *
     */
    public void setRow(int row)
    {
        testInputsRange(row);
        this.row = row;
    }

    /**
     * Sets the Squares column position
     * @param column    Squares column position on the board
     *                  sets the Squares column position
     */
    public void setColumn(int column)
    {
        testInputsRange(column);
        this.column = column;
    }

    /**
     * Sets whether the specified element is in the list
     * @param occupation       Sets whether/not square is occupied by chess piece
     *
     */
    public void setIsOccupied(boolean occupation)
    {

        this.isOccupied = occupation;
    }


    /**
     * Sets what Piece Type is occupying this Square
     * @param occupyingPiece       Piece that will occupy this Square
     *
     */
    public void setOccupyingPiece(Piece occupyingPiece){
        if(occupyingPiece != null){
            setIsOccupied(true);
        }else{
            setIsOccupied(false);
        }
        this.occupyingPiece = occupyingPiece;
    }


    /**
     * Retrieves the Squares Row position
     * @return      integer representing which row this square occupies
     */
    public int getRow()
    {
        return this.row;
    }

    /**
     * Retrieves the Squares Column position
     * @return      integer representing which column this square occupies
     */
    public int getColumn()
    {
        return this.column;
    }


    /**
     * Retrieves    whether or not the square is occupied
     * @return      true/false if square is/isNot occupied
     */
    public boolean getIsOccupied()
    {
        return this.isOccupied;
    }

    /**
     * Retrieves    Which piece occupies this position
     * @return      Piece that occupies this position
     */
    public Piece getOccupyingPiece()
    {
       return this.occupyingPiece;
    }

    /**
     * To string method
     * @return      returns current Square data in form of string
     */
    public String toString(){
        return String.format("Row : %s , Column: %s ", getRow(), getColumn() );
    }

    private void testInputsRange(int input){
        if(input < 0 || input > 7){
            throw new IllegalArgumentException("Squares input must be between 0 and 7");
        }

    }

    //////////////////////////
    public boolean isWKingChecked(Square startingPosition, Square kingsCurrentPosition, Square[][] chessBoard){
        boolean isChecked = false;
        if(startingPosition.getOccupyingPiece().isMoveValid(kingsCurrentPosition, chessBoard) == true){
            isChecked = true;
        }else {
            isChecked = false;
        }
        return isChecked;
    }

}

