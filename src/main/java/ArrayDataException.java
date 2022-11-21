public class ArrayDataException extends NumberFormatException{
    public ArrayDataException(int row, int column, String[][] array) {
        super(String.format("Character \"%s\" cannot be cast to integer, erroneous value in row %d and column %d\n",
                array[row][column], row, column));

    }
}
