package Package1;

import java.util.Arrays;

public class SchoolTestScores {
	// Q1 -> 
	
	public static void main(String[] args) {
        int[] testScores = {88, 92, 79, 85};
        int newScore = 90;
        mergeInsert(testScores, newScore);
    }

	public static void mergeInsert(int[] sortedArray, int newScore) {
        int[] newArray = new int[sortedArray.length + 1];
        System.arraycopy(sortedArray, 0, newArray, 0, sortedArray.length);
        newArray[newArray.length - 1] = newScore;
        mergeSort(newArray, 0, newArray.length - 1);
        System.out.println("Sorted Array with New Score: " + Arrays.toString(newArray));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

	
}
