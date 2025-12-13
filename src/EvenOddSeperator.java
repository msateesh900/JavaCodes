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

	public static void main(String[] args) {
		int[] numbers = { 12, 34, 45, 9, 8, 90, 3 };
		System.out.println("Original array: " + Arrays.toString(numbers));
		separateEvenOddInPlace(numbers);
		System.out.println("Array after segregation: " + Arrays.toString(numbers));
	}
}
