package LabAssignments;

import java.util.HashMap;

public class lab_11 {

	public static void main(String[] args) {
		
		
	}	

	//1. --> Indicates the number of triplets greater than the given sum.
	public static int numOfTriplets(int[] arr, int sum) {
		int count = 0;
		int n = arr.length;

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int currentSum = arr[i] + arr[left] + arr[right];
				if (currentSum < sum) {
					count += right - left;
					left++;
				} else {
					right--;
				}
			}
		}

		return count;
	}

	// 4. --> Shows where the small word starts from the big word.
	public static int isSubString(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		if (m > n)
			return -1;

		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (str1.charAt(i + j) != str2.charAt(j))
					break;
			}

			if (j == m)
				return i;
		}

		return -1;
	}

	// 2. -->It arranges the array, and shows kth smallest number.
	public static int kthSmallest(int[] arr, int k) {
		if (k < 1)
			throw new IllegalArgumentException("Invalid input.");
		int min = findMin(arr);
		int max = findMax(arr);

		int[] count = new int[max - min + 1];
		for (int num : arr) {
			count[num - min]++;
		}

		int sum = 0;
		for (int i = 0; i < count.length; i++) {
			sum += count[i];
			if (sum >= k) {
				return i + min;
			}
		}

		throw new IllegalArgumentException("Invalid input.");
	}

	private static int findMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int num : arr) {
			if (num < min) {
				min = num;
			}
		}
		return min;
	}

	private static int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int num : arr) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

	// 5. --> It finds repeating numbers which is greater than n.
	public static void findRepeats(int[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for (int num : map.keySet()) {
			if (map.get(num) > n) {
				System.out.print(num + " ");
			}
		}
	}

	// 3. -->It finds the sequence in ascending order from 0 index.
	public static String subSequence(String str) {
		if (str == null || str.isEmpty()) {
			return "";
		}
		String s = str.charAt(0) + "";
		for (int i = 1; i < str.length(); i++) {
			if (s.charAt(s.length() - 1) < str.charAt(i))
				s += str.charAt(i);
		}
		System.out.println("Time complexity: O(n)");
		return s;
	}

}