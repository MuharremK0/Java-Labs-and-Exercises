package Package2;

import java.util.Scanner;

public class BinarySearchInARotatedArray {

	public static void main(String[] args) {
		// Q1 -->
		
		Scanner scanner = new Scanner(System.in);

        // Get the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Create an array and take input for its elements
        int[] rotatedArray = new int[n];
        System.out.println("Enter the elements of the rotated sorted array: ");
        for (int i = 0; i < n; i++) {
            rotatedArray[i] = scanner.nextInt();
        }

        // Get the target value to search for
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Perform the search
        int result = search(rotatedArray, target);

        // Output the result
        if (result != -1) {
            System.out.println("Treasure (target) found at index: " + result);
        } else {
            System.out.println("Treasure (target) not found!");
        }

        scanner.close();

	}
	
	public static int search(int[] nums,int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}
	
	private static int binarySearch(int[] nums,int left,int right,int target) {
		if (left > right) {
            return -1; // Target not found
        }

        int mid = left + (right - left) / 2;

        // If the mid element is the target
        if (nums[mid] == target) {
            return mid;
        }

        // Check if the left half is sorted
        if (nums[left] <= nums[mid]) {
            // Check if the target is in the left half
            if (target >= nums[left] && target < nums[mid]) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }
        } else {
            // Otherwise, the right half must be sorted
            if (target > nums[mid] && target <= nums[right]) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
	}

}
