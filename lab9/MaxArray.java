  
package lab9;

public class MaxArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 0, 19, 4, 267, 5};

        System.out.println(arraySum(array));
    }

    public static int arraySum(int[] arr) {
        return max(arr, 0, arr.length - 1);
    }

    private static int max(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftMax = max(arr, start, mid);
            int rightMax = max(arr, mid + 1, end);
            return Math.max(leftMax, rightMax);
        }
    }
}