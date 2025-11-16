
public class LeetCode {

	public static int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> hs = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (hs.containsKey(target - nums[i])) {
					return new int[] { hs.get(target - nums[i]), i };
				}
				hs.put(nums[i], i);
			}
			return new int[] {};
		}
	
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

		/* Two Sum examples*/
		int[] arr1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = Solution.twoSum(arr1, target1);
        System.out.println("Array: " + Arrays.toString(arr1) + ", Target: " + target1 + ", Result: " + Arrays.toString(result1)); // Output: [2, 7]

        int[] arr2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = Solution.twoSum(arr2, target2);
        System.out.println("Array: " + Arrays.toString(arr2) + ", Target: " + target2 + ", Result: " + Arrays.toString(result2)); // Output: [2, 4] (after sorting)

        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 10;
        int[] result3 = Solution.twoSum(arr3, target3);
        System.out.println("Array: " + Arrays.toString(arr3) + ", Target: " + target3 + ", Result: " + Arrays.toString(result3)); // Output: []

        int[] arr4 = { 3,3 };
		int target4 = 6;
        int[] result4 = Solution.twoSum(arr4, target4);        
        System.out.println("Array: " + Arrays.toString(arr4) + ", Target: " + target4 + ", Result: " + Arrays.toString(result4)); // Output: [2, 7]
        /* Two Sum examples end*/
        

	}
}
