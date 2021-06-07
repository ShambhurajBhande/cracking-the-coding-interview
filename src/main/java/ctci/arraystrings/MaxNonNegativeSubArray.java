package ctci.arraystrings;

/*Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

        The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
        Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
        Find and return the required subarray.

        NOTE:
        If there is a tie, then compare with segment's length and return segment which has maximum length.
        If there is still a tie, then return the segment with minimum starting index.

        Problem Constraints
        1 <= N <= 105
        -109 <= A[i] <= 109

        Input:
            Input 1:   A = [1, 2, 5, -7, 2, 3]
            Input 2:  A = [10, -1, 2, 3, -4, 100]
        Example Output
            Output 1: [1, 2, 5]
            Output 2: [100]
        */
/*
Constraints:
        1.	Max sum sub-array of non negative number
        2.	Subarray should be contiguous
        3.	Tie-> return max segment length array
        4.	Still tie-> max index subarray
        5. 1 <= N <= 10^5
        6. -10^9 <= A[i] <= 10^9
        ---------------------------------
        Idea: [1, 2, 5, -7, 2, 3]
        1. iterate array till negative numer
        2. sum of that number assign to var
        3. add that numbers to new array
        4. if next substring sum is greather ,update new array
        5. if tie -> check length of previous > current -> update current
        6. still tie-> update with current

        time Complexity : O(n)
        space Complexity : O(1)
        ----------------------*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,5,-1,0,8,-4));
        List result=maxset((ArrayList<Integer>) input);

        result.stream().forEach(value->System.out.print(value+" "));

    }
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long tmp_sum = 0, sum = 0;
        int start = -1, end = -1, tmp_start = 0, tmp_end = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                tmp_sum += A.get(i);
                if (tmp_sum > sum) {
                    sum = tmp_sum;
                    start = tmp_start;
                    end = i;
                } else if (tmp_sum == sum && (tmp_end - tmp_start > end - start)) {
                    start = tmp_start;
                    end = i;
                    sum = tmp_sum;
                }
                tmp_end++;
            } else {
                tmp_sum = 0;
                tmp_start = i + 1;
                tmp_end = i + 1;

            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (start == -1) {
            return result;
        }
        for (int i = start; i <= end; i++) {
            result.add(A.get(i));
        }

        return result;
    }
}
