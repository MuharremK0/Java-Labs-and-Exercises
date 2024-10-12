package Package2;

public class MaximumSubarray {

	public static void main(String[] args) {
		// Q4 -->
		
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubarray(arr, 0, arr.length - 1);
        System.out.println("Maximum Subarray Sum: " + maxSum);

	}
	
	// Function to find the maximum subarray sum using divide and conquer
    public static int maxSubarray(int[] arr, int left, int right) {
        // Base case: only one element
        if (left == right) {
            return arr[left];
        }

        // Find the middle point
        int mid = (left + right) / 2;

        // Recursively find the maximum subarray sum in the left half, right half, and across the middle
        int leftMax = maxSubarray(arr, left, mid);
        int rightMax = maxSubarray(arr, mid + 1, right);
        int crossMax = maxCrossingSubarray(arr, left, mid, right);

        // Return the maximum of the three
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    // Function to find the maximum subarray sum that crosses the middle
    public static int maxCrossingSubarray(int[] arr, int left, int mid, int right) {
        // Find the maximum sum on the left half ending at mid
        int leftSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid; i >= left; i--) {
            currentSum += arr[i];
            if (currentSum > leftSum) {
                leftSum = currentSum;
            }
        }

        // Find the maximum sum on the right half starting at mid + 1
        int rightSum = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currentSum += arr[i];
            if (currentSum > rightSum) {
                rightSum = currentSum;
            }
        }

        // Return the sum of the two parts crossing the middle
        return leftSum + rightSum;
    }

}
