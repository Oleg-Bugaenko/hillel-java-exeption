public class ArrayValueCalculator {
    public static void main(String[] args) {
        String[][] array = {
                {"2", "4", "6", "56"},
                {"7", "35", "86", "1"},
                {"48", "4FGQ", "53", "56"},
                {"28", "5", "9", "32"},
        };
        int totalValue;

        try {
            totalValue = doCalc(array);
            System.out.println("Sum of matrix values " + totalValue);
        } catch (ArrayDataException | ArraySizeException e) {
            e.printStackTrace();
        }

    }

    public static int doCalc(String[][] array) throws ArrayDataException, ArraySizeException {
        //verification of compliance with the requirements for the dimension of the input array 4*4
        if (array.length != 4) {
            throw new ArraySizeException("The number of rows in the array does not match the required value 4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new ArraySizeException(String.format("Line %d contains %d columns instead of the required 4", i, array[i].length));
            }
        }

        //converting array elements and calculating their sum
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    counter += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(i, j, array);
                }
            }
        }
        return counter;
    }
}
