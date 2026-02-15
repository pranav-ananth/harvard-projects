public class Matrix {
    private int[][] mat;

    public Matrix(int[][] m) {
            mat = m;
    }

    public void reverseAllRows() {
        for(int i = 0; i < mat.length; i++) {
            ArrayUtil.reverseArray(mat[i]);
        }
    }

    public void reverseMatrix() {
        reverseAllRows();
        for(int i = 0; i < mat.length/2; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[mat.length - i - 1][j];
                mat[mat.length - i - 1][j] = temp;
            }
        }
    }
}
