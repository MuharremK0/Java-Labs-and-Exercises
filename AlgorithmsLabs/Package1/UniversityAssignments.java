package Package1;

public class UniversityAssignments {
	
	// Q2 ->
	
	public static void main(String[] args) {
        int[] deadlines = {40, 10, 30, 50, 20};
        shellSort(deadlines);
        System.out.println("Sorted Deadlines: " + java.util.Arrays.toString(deadlines));
    }
	
	public static void gappedInsertionSort(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                array[j] = array[j - gap];
            }
            array[j] = temp;
        }
    }

    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            gappedInsertionSort(array, gap);
        }
    }


}
