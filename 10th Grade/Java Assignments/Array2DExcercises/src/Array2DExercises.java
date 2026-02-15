public class Array2DExercises
{
    /**
     * @param arr a 2D array of ints
     * @return the maximum value in the 2D parameter array
     */
    public static int max(int[][] arr) {
        int maxValue = arr[0][0];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > maxValue)
                    maxValue = arr[i][j];
            }
        }
        return maxValue;
    }

    /**
     * @return the sum of the elements in row r of arr.
     * @param arr a 2D array of ints
     * @param r the row index
     */
    public static int rowSum(int[][] arr, int r) {
        int sum = 0;
        for(int i = 0; i < arr[r].length; i++) {
            sum += arr[r][i];
        }
        return sum;
    }

    /**
     *  @return the sum of the elements in column c of arr (careful with rows of different lengths!)
     *  @param arr a 2D array of ints
     *  @param c the column index
     */
    public static int columnSum(int[][] arr, int c) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(c < arr[i].length)
                sum += arr[i][c];
        }
        return sum;
    }

    /**
     * @return an array of the row sums. Note: index i of the return array contains the sum
     * of elements in row i.
     * @param arr a 2D array of ints
     */
    public static int[] allRowSums(int[][] arr) {
        int[] rowSums = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            rowSums[i] = rowSum(arr, i);
        }
        return rowSums;
    }

    /**
     * @return an array of the column sums. Note: index i of the return array contains the sum
     * of elements in column i.
     * @param arr a 2D array of ints
     */
    public static int[] allColumnSums(int[][] arr) {
        int[] columnSums = new int[arr[0].length];
        for(int i = 0; i < arr[0].length; i++) {
            columnSums[i] = columnSum(arr, i);
        }
        return columnSums;
    }

    /**
     *     checks if an array is row-magic (this means that every row has the same row sum).
     *     @return true if arr is row-magic; false otherwise
     *     @param arr a 2D array of ints
     */
    public static boolean isRowMagic(int[][] arr) {
        int[] rowSums = allRowSums(arr);
        int firstElement = rowSums[0];
        for(int element : rowSums) {
            if(element != firstElement) {
                return false;
            }
        }
        return true;
    }

    /**
     * checks if a rectangular array is column-magic (this means that every column has the same column sum).
     * pre-condition: arr is rectangular 2-D array
     * @return true if arr is column-magic; false otherwise
     * @param arr a rectangular 2D array of ints
     *
     */
    public static boolean isColumnMagic(int[][] arr) {
        int[] columnSums = allColumnSums(arr);
        int firstElement = columnSums[0];
        for(int element : columnSums) {
            if(element != firstElement) {
                return false;
            }
        }
        return true;
    }

    /**
     * checks if the array is square (i.e. every row has the same length as a itself).
     * @param arr a 2D array of ints
     * @return true if arr is square; false otherwise
     */
    public static boolean isSquare(int[][] arr) {
        if(arr.length == arr[0].length)
            return true;
        return false;
    }

    /**
     * Checks if the array is a magic square. This means that it must be square,
     * and that all row sums, all column sums, and the two diagonal-sums must all be equal.
     * @param arr a 2D array of ints
     * @return true if arr is a magic square; false otherwise
     */
    public static boolean isMagic(int[][] arr) {
        if(!isSquare(arr))
            return false;
        if(!isRowMagic(arr))
            return false;
        if(!isColumnMagic(arr))
            return false;

        int firstDiagSum = 0;
        int secondDiagSum = 0;
        for(int i = 0; i < arr.length; i++) {
            firstDiagSum += arr[i][i];
            secondDiagSum += arr[arr.length-1-i][i];
        }
        if(firstDiagSum != secondDiagSum)
            return false;
        return true;
    }



}