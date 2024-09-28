package Package1;

public class AirlineTickets {
	
	// Q5 ->
	
	public static void main(String[] args) {
        int[] prices = {500, 400, 600, 350, 700};
        int[] discounts = {50, 0, 100, 20, 0};
        System.out.println("Original prices: " + java.util.Arrays.toString(prices));
        mergeSortWithDiscount(prices, discounts, 0, prices.length - 1);
        System.out.println("Sorted prices after discounts: " + java.util.Arrays.toString(prices));
    }
	

	public static void mergeSortWithDiscount(int[] prices, int[] discounts, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortWithDiscount(prices, discounts, left, middle);
            mergeSortWithDiscount(prices, discounts, middle + 1, right);
            applyDiscounts(prices, discounts, left, right);
            merge(prices, left, middle, right);
        }
    }

    public static void applyDiscounts(int[] prices, int[] discounts, int left, int right) {
        for (int i = left; i <= right; i++) {
            prices[i] -= discounts[i];
        }
    }

    public static void merge(int[] prices, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = prices[middle + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }


}
