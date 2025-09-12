
public class LeetCode {

	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		System.out.println(search(nums, target));
	}
}
