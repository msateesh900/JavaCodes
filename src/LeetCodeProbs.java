import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCodeProbs {
	
	public static boolean DuplicateCheck(int[] arr) {
		Set<Integer> seen=new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			if(seen.contains(arr[i])) {
				return true;
			}else {
				seen.add(arr[i]);
			}
		}
		return false;
	}
	
	public static int[] twoSum(int[] arr,int target) {
		Map<Integer,Integer> sum= new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
				if(sum.containsKey(target-arr[i])) {
					return new int[] {sum.get(target-arr[i]),i};
				}else {
					sum.put(arr[i], i);
				}
		}
		return new int[] {};
	}
	
	  public static String reverseWords(String s) {
	        String[] arr = s.trim().split("\\s+");
	        int i=0,j=arr.length-1;
	        while(i<j) {
	            String t = arr[i];
	            arr[i] = arr[j];
	            arr[j] = t;
	            i++;
	            j--;
	        }
	        return String.join(" ", arr);
	    }
	  
		public static int[] productExceptSelf(int[] nums) {
			int[] ans = new int[nums.length];
			int leftProduct=1;
			for(int i=0;i<nums.length;i++) {
				ans[i]=leftProduct;
				leftProduct*=nums[i];
			}
			int rightProduct=1;
			for(int i=nums.length-1;i>=0;i--) {
				ans[i]*=rightProduct;
				rightProduct*=nums[i];
			}
			return ans;
		}
		
		public static int[] moveZeros(int[] nums) {
			int initialPosition=0;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]!=0) {
					nums[initialPosition]=nums[i];
					initialPosition++;
				}
			}
			while(initialPosition<nums.length) {
				nums[initialPosition]=0;
				initialPosition++;
			}
			return nums; 
		}
		
		public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	        List<Boolean> kidWtCandies=new ArrayList<>(); 
	        
			return kidWtCandies;
	    }
	
	public static void main(String[] args) {
		
		int[] arr= {2,7,5,6,8};
		int target=9;
		int[] result=twoSum(arr, target);
//		System.out.println("twoSum---" + Arrays.toString(result));
//		System.out.println(DuplicateCheck(arr));
//		System.out.println(reverseWords("Hello World As"));
		
		int[] nums= {1,2,0,0,3,0,4};
//		System.out.println("productExceptSelf:" + Arrays.toString(productExceptSelf(nums)));
//		Input: nums = [1,2,3,4]
//		Output: [24,12,8,6]
		System.out.println("moveZeros:" + Arrays.toString(moveZeros(nums)));
	}
}
