package ctci.arraystrings;

/*
@author Shambhuraj bhande
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
* */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9, 2, 3, 4}, {5, 0, 7, 8}, {9, 0, 11, 12}, {13, 6, 15, 16}};
        printMatrix(matrix);
        replaceMatrixWithZero(matrix);
        printMatrix(matrix);
    }

    private static void replaceMatrixWithZero(int[][] matrix) {
        boolean rows[] = new boolean[matrix.length];
        boolean column[] = new boolean[matrix.length];
        findRowAndColumnWithZero(matrix, rows, column);
    }

    private static void findRowAndColumnWithZero(int[][] matrix, boolean[] rows, boolean[] column) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    column[j] = true;
                    continue;
                }
            }
        }

        rowsWithZero(rows,matrix);
        columnWithZero(column,matrix);
    }

    private static void rowsWithZero(boolean[] column, int[][] matrix) {
        for (int i = 0; i <column.length ; i++) {
            if (column[i]) {
                replaceMatrixRowsWithZero(matrix, i);
            }
        }
    }

    private static void columnWithZero(boolean[] rows, int[][] matrix) {
        for (int i = 0; i <rows.length ; i++) {
            if (rows[i]) {
                replaceMatrixColumnWithZero(matrix, i);
            }
        }
    }

    private static void replaceMatrixColumnWithZero(int[][] matrix, int i) {
        for (int j = 0; j <matrix.length ; j++) {
            matrix[j][i]=0;
        }
    }

    private static void replaceMatrixRowsWithZero(int[][] matrix, int i) {
        for (int j = 0; j <matrix.length ; j++) {
        matrix[i][j]=0;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}
