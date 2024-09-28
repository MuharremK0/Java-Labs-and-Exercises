package Package1;

public class LibraryBooks {
	
	// Q3 ->
	
	public static void main(String[] args) {
        int[] books = {35, 20, 50, 10, 40, 30};
        System.out.println("Original Shelf: " + java.util.Arrays.toString(books));
        mergeSort(books, 0, books.length - 1);
        System.out.println("Sorted Shelf: " + java.util.Arrays.toString(books));
    }
	
	public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            mergeInPlace(array, left, middle, right);
        }
    }

    private static void mergeInPlace(int[] array, int left, int middle, int right) {
        int start1 = left;
        int start2 = middle + 1;

        while (start1 <= middle && start2 <= right) {
            if (array[start1] <= array[start2]) {
                start1++;
            } else {
                int value = array[start2];
                int index = start2;

                while (index > start1) {
                    array[index] = array[index - 1];
                    index--;
                }
                array[start1] = value;
                start1++;
                middle++;
                start2++;
            }
        }
    }
	
}
