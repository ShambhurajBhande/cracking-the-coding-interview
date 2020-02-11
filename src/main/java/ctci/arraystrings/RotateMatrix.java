package ctci.arraystrings;
/*
* @author Shambhuraj Bhande
*
*
* Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place? 
*
* */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
        boolean issquareMatix = rotateMatrix(matrix);


    }

    private static boolean rotateMatrix(int[][] matrix) {

        if (matrix.length == 0 && matrix.length != matrix[0].length)
            return false;

        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        printMatrix(matrix);
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}
