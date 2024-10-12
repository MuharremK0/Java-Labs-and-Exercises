package Package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BankTransactionConsolidation {

	public static void main(String[] args) {
		// Q2 -->
		Scanner scanner = new Scanner(System.in);

        // Get the number of intervals
        System.out.print("Enter the number of transaction intervals: ");
        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];

        // Read each interval’s start and end times
        System.out.println("Enter the intervals (start and end times): ");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        // Merge intervals
        List<int[]> mergedIntervals = mergeIntervals(intervals);

        // Output the merged intervals
        System.out.println("Consolidated transaction intervals: ");
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        scanner.close();

	}
	
	// Method to merge overlapping intervals
    public static List<int[]> mergeIntervals(int[][] intervals) {
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Initialize with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check if intervals overlap
            if (nextStart <= currentEnd) {
                // Merge intervals by updating the end time
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Add the new interval and move to it
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged;
    }

}
