import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class TwoSum {

	public static int NumReverse(int num) {
		long revNum = 0;
		while (num != 0) {
			revNum = revNum * 10 + num % 10;
			num = num / 10;
			if (revNum > Integer.MAX_VALUE || revNum < Integer.MIN_VALUE)
				return 0;
		}
		return (int) revNum;
	}

	public static boolean containsDuplicate(int[] nums) {
		System.out.println(Arrays.toString(nums));
		int left = 0, right = 1;
		while (left <= right) {
			if (nums[left] != nums[right]) {
				right++;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {

		/* Num reverse examples */
		int num1 = 121;
		System.out.println("Number reverse Ex1 result:" + NumReverse(num1));
		int num2 = -123;
		System.out.println("Number reverse Ex2 result:" + NumReverse(num2));
		int num3 = 120;
		System.out.println("Number reverse Ex3 result:" + NumReverse(num3));
		int num4 = 1534236469;
		System.out.println("Number reverse Ex4 result:" + NumReverse(num4));
		
		/* Num reverse examples end */

		String[] words = new String[10];
		Optional<String> checkNull = Optional.ofNullable(words[5]);
		if (checkNull.isPresent()) {
			String word=words[5].toLowerCase();
			System.out.println(word);
		} else
			System.out.print("null");

		Integer[] numbersArray = {1, 2, 3, 4, 5};
        List<Integer> numbersList = Arrays.asList(numbersArray);
        System.out.println("Original List: " + numbersList);

		String a[] = new String[] { "A", "B", "C", "D" };

		List<String> l = Arrays.asList(a);
        System.out.println("" + l);

		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
		Arrays.asList(new int[]{1,2,3,4,5});
	}
}
