public class Square {
    private int row;
    private int column;
    private boolean occupied;

    public Square(int row, int column, boolean occupied)
    {
        setRow(row);
        setColumn(column);
        setOccupied(occupied);

    }

    public void setRow(int row)
    {
        testInputsRange(row);
        this.row = row;
    }

    public void setColumn(int column)
    {
        testInputsRange(column);
        this.column = column;
    }

    public void setOccupied(boolean occupation)
    {

        this.occupied = occupation;
    }

    public int getRow()
    {
        return this.row;
    }

    public int getColumn()
    {
        return this.column;
    }

    public boolean getOccupation()
    {
        return this.occupied;
    }

    private void testInputsRange(int input){
        if(input < 0 || input > 7){
            throw new IllegalArgumentException("Squares input must be between 0 and 7");
        }

    }

}
