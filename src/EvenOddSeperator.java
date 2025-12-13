import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

public class EvenOddSeperator {
	
	public static void separateEvenOddInPlace(int[] numbers) {
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			while (numbers[left] % 2 == 0 && left < right)
				left++;
			while (numbers[right] % 2 != 0 && left < right)
				right--;
			if (left < right) {
				int temp = numbers[left];
				numbers[left] = numbers[right];
				numbers[right] = temp;
				left++;
				right--;
			}
		}
	}
	
	public static void seperateEvenOddStreams(List<Integer> streamNumbers) {
		
        // Method 1: Using partitioningBy (creates a map)
        Map<Boolean, List<Integer>> partitioned = streamNumbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evens = partitioned.get(true);
        List<Integer> odds = partitioned.get(false);

        System.out.println("Even numbers: " + evens);
        System.out.println("Odd numbers: " + odds);
        
        // Method 2: Using two separate filter streams
        List<Integer> evensFiltered = streamNumbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        
        List<Integer> oddsFiltered = streamNumbers.stream()
            .filter(n -> n % 2 != 0)
            .collect(Collectors.toList());
        
        System.out.println("Even numbers using filters: " + evensFiltered);
        System.out.println("Odd numbers using filters: " + oddsFiltered);
        
	}

	public static void main(String[] args) {
		int[] numbers = { 12, 34, 45, 9, 8, 90, 3 };
		System.out.println("Original array: " + Arrays.toString(numbers));
		separateEvenOddInPlace(numbers);
		System.out.println("Array after segregation: " + Arrays.toString(numbers));
		
		List<Integer> streamNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		seperateEvenOddStreams(streamNumbers);
		
	}
}
