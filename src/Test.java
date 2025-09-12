import java.util.stream.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
	
	// global logic coding question wrong answer which tried during interview
	public static boolean arrayTest(int[] arr1, int[] arr2) {
		boolean order=false, result=false;
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr2[j]==arr1[i]&& order==true) {
					order=true;
					i++;
				}else {
					return result;
				}
			}
		}
		return result;
	}

	//global logic coding question answer
	private static boolean subArrayTest(int[] arr1, int[] arr2) {
		// using Two pointer approach
		/*  Arrays.sort(arr1);
			Arrays.sort(arr2);
			int i=0,j=0;
			int m=arr1.length,n=arr2.length;
			while(i<m&&j<n) {
				if(arr1[i]<arr2[j]) {
					i++;
				}else if(arr1[i]==arr2[j]) {
					i++;
					j++;
				}else {
					return false;
				}
			}
			return (j==n);
		*/
		Set<Integer> hashSet = new HashSet<>();
		for(int num:arr1) {
			hashSet.add(num);
		}
		for(int num:arr2) {
			if(!hashSet.contains(num)) {
				return false;
			}
		}
		return true;
	}
	
	// 12/09/2025
    public static void segregateEvenOdd(int[] arr) {
    
    	int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Increment left until an odd number is found
            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }

            // Decrement right until an even number is found
            while (arr[right] % 2 != 0 && left < right) {
                right--;
            }

            // If left < right, swap the elements
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }



	public static void main(String[] args) {

        int[] arr = {12, 34, 45, 9, 8, 90, 3, 7, 10};
        segregateEvenOdd(arr);

        System.out.print("Array after segregation: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

		int[] arr1 = {-1, 2, 7 ,8, 22, 34, 100};
		int[] arr2 = {-1,2,100};
//		subArrayTest(arr1,arr2);
		System.out.print("subArrayTest:"+subArrayTest(arr1,arr2));
		
//		A----> B(load increases) 
		int[] arr3= {1,4,5,6,7,8,9};
		// third largest distinct odd number
		Integer res= Arrays.stream(arr3).boxed().map(i->i).sorted(Comparator.reverseOrder()).filter(i->i%2==1).skip(2).findFirst().get();
		System.out.println("third largest distinct odd number:"+res);

		// even numbers
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 == 0).skip(2)
				.forEach(i -> System.out.print(i + " "));



	}
}