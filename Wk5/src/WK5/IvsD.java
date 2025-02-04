package WK5;

import java.util.Arrays;

public class IvsD {

	public static void main(String[] args) {
		
		// Step 1: Count even numbers to determine
		int[] array1 = new int[] {2, 2, 3, 3, 6};
		int count = 0;
		for (int num : array1) {
			if (num % 2 == 0) {
				count++;
			}
		}
		
		// Step 2: Create a new array for even numbers
		int[]evenArray1 = new int[count];
		int index = 0;
		for (int num : array1) {
			if (num % 2 == 0) {
				evenArray1[index++] = num;
			}
		}
		
		// Step 3: Print the result
		System.out.println(Arrays.toString(evenArray1));

		// Find the even numbers sum
		// Declarative programming
		int[] array = new int[] {2, 2, 3, 4, 6};
		int[] evenArray = Arrays.stream(array)
				.filter(a -> a % 2 == 0)
				.toArray();
		System.out.println(Arrays.toString(evenArray));
		
		// More functions
		// Sum of even numbers
		int sumEven = Arrays.stream(evenArray).sum();
		System.out.println("Sum of even numbers: "+sumEven);
		
		//Count the number of even numbers
		long countEven = Arrays.stream(evenArray).count();
		System.out.println("Number of even numbers: "+countEven);
		
		// Sort the even numbers
		Arrays.sort(evenArray);
		System.out.println("Sorted even numbers: " + Arrays.toString(evenArray));
		
		
	}

}