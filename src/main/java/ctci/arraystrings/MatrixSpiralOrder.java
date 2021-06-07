package ctci.arraystrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
        Example:
        Given the following matrix:
        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]
        You should return
        [1, 2, 3, 6, 9, 8, 7, 4, 5]*/
public class MatrixSpiralOrder {
    public static void main(String[] args) {
        List<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        input.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        input.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));
        List result=spiralOrder(input);

        result.stream().forEach(value->System.out.print(value));

    }
    private static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top = 0, bottom = A.size() - 1, right = A.get(0).size() - 1, left = 0;

        int dir = 0;
        if (bottom == 0) {
            return A.get(0);
        }

        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    result.add(A.get(top).get(i));
                }
                top++;
                dir = 1;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    result.add(A.get(i).get(right));
                }
                right--;
                dir = 2;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(A.get(bottom).get(i));
                }
                bottom--;
                dir = 3;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    result.add(A.get(i).get(left));
                }
                left++;
                dir = 0;
            }
        }
        return result;
    }

}
