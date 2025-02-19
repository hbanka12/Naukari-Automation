package jan16;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {12, 35, 1, 10, 34, 1};

        // Call the method to find the second largest element
        System.out.println("Second largest element is: " + findSecondLargest(array));
    }

    public static int findSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}



