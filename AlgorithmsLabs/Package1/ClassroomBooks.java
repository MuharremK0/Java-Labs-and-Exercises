package Package1;

public class ClassroomBooks {
	
	// Q4 ->
	
	public static void main(String[] args) {
        int[] bookHeights = {45, 32, 60, 22, 41};
        System.out.println("Original heights: " + java.util.Arrays.toString(bookHeights));
        insertionSort(bookHeights);
        System.out.println("Sorted heights: " + java.util.Arrays.toString(bookHeights));
    }
	
	public static void insertionSort(int[] heights) {
        for (int i = 1; i < heights.length; i++) {
            int key = heights[i];
            int j = i - 1;

            while (j >= 0 && heights[j] > key) {
                heights[j + 1] = heights[j];
                j--;
            }
            heights[j + 1] = key;
        }
    }


}
