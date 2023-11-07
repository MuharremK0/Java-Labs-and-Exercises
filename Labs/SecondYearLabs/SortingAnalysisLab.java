package secondyear;

import java.util.Arrays;
import java.util.Random;

public class SortingAnalysisLab {

	public static void main(String[] args) {
		runSortingAnalysis();
	}
	//1.
	public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	//2.
	public static void selectionSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minIndex]>arr[j]) {
					minIndex=j;
				}
			}
			int temp=arr[minIndex];
				arr[minIndex]=arr[i];
				arr[i]=temp;
		}
	}
	//3.
	public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
	public static int[] generateRandomArray(int size) {
		Random random=new Random();
		int[] arr=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=random.nextInt(1000);
		}
		return arr;
	}
	
	public static void runSortingAnalysis() {
		int n=10;
		int[] arr1=generateRandomArray(n);
		int[] arr2=new int[n];
		int[] arr3=new int[n];
		int[] arr4=new int[n];
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		
		//for Bubble Sort
		System.out.println(Arrays.toString(arr1));
		double a1=System.currentTimeMillis();
		bubbleSort(arr1);
		System.out.println("Bubble sort:"+(System.currentTimeMillis()-a1));
		System.out.println(Arrays.toString(arr1));
		System.out.println();
		
		//for Selection Sort
		System.out.println(Arrays.toString(arr2));
		double a2=System.currentTimeMillis();
		selectionSort(arr2);
		System.out.println("Selection sort:"+(System.currentTimeMillis()-a2));
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		
		//for Merge Sort
		System.out.println(Arrays.toString(arr3));
		double a3=System.currentTimeMillis();
		mergeSort(arr3);
		System.out.println("Merge sort:"+(System.currentTimeMillis()-a3));
		System.out.println(Arrays.toString(arr3));
		System.out.println();
		
		//for Insertion Sort
		System.out.println(Arrays.toString(arr4));
		double a4=System.currentTimeMillis();
		insertionSort(arr4);
		System.out.println("Insertion sort:"+(System.currentTimeMillis()-a4));
		System.out.println(Arrays.toString(arr4));
		
		
	}
	
	//4. It's not in lab,I tried
	public static void insertionSort(int[] arr) {
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
	}
	

}
