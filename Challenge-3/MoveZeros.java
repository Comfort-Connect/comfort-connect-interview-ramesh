import java.util.Arrays;

/**
 * Given an array of integers arr[], move all the zeros to the end of the array
 * while maintaining the relative order of all non-zero elements.
 *
 * Examples:
 *   Input:  [1, 2, 0, 4, 3, 0, 5, 0]
 *   Output: [1, 2, 4, 3, 5, 0, 0, 0]
 *
 *   Input:  [10, 20, 30]
 *   Output: [10, 20, 30]
 *
 *   Input:  [0, 0]
 *   Output: [0, 0]
 */
public class MoveZeros {

    /**
     * Moves all zeros to the end of the array in-place while maintaining
     * the relative order of non-zero elements.
     *
     * @param arr the input array to modify
     */
    public static void moveZerosToEnd(int[] arr) {
        // TODO: Implement your solution here
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println("Input:  " + Arrays.toString(arr1));
        moveZerosToEnd(arr1);
        System.out.println("Output: " + Arrays.toString(arr1));
        System.out.println("Expected: [1, 2, 4, 3, 5, 0, 0, 0]");
        System.out.println();

        // Test Case 2
        int[] arr2 = {10, 20, 30};
        System.out.println("Input:  " + Arrays.toString(arr2));
        moveZerosToEnd(arr2);
        System.out.println("Output: " + Arrays.toString(arr2));
        System.out.println("Expected: [10, 20, 30]");
        System.out.println();

        // Test Case 3
        int[] arr3 = {0, 0};
        System.out.println("Input:  " + Arrays.toString(arr3));
        moveZerosToEnd(arr3);
        System.out.println("Output: " + Arrays.toString(arr3));
        System.out.println("Expected: [0, 0]");
    }
}