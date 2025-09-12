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

	private static boolean subArrayTest(int[] arr1, int[] arr2) {
//		Arrays.sort(arr1);
//		Arrays.sort(arr2);
//		int i=0,j=0;
//		int m=arr1.length,n=arr2.length;
//		while(i<m&&j<n) {
//			if(arr1[i]<arr2[j]) {
//				i++;
//			}else if(arr1[i]==arr2[j]) {
//				i++;
//				j++;
//			}else {
//				return false;
//			}
//		}
//		return (j==n);
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


	public static char findFirstNonRepeatedCharacter(String str) {
		Map<Character, Integer> characterCountMap = new LinkedHashMap<>();

//	         Populate the map with character counts
		for (char ch : str.toCharArray()) {
			characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
		}

		System.out.println("map with character counts" + characterCountMap);
//	         Find the first non-repeated character
		for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return 0;

	}

	public static void main(String[] args) {

		int[] arr1 = {-1, 2, 7 ,8, 22, 34, 100};
		int[] arr2 = {-1,2,100};
//		subArrayTest(arr1,arr2);
		System.out.print(subArrayTest(arr1,arr2));
		
//		A----> B(load increases) 
		int[] arr= {1,4,5,6,7,8,9};
		// third largest distinct odd number
		Integer res= Arrays.stream(arr).boxed().map(i->i).sorted(Comparator.reverseOrder()).filter(i->i%2==1).skip(2).findFirst().get();
		System.out.println(res);

		// even numbers
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 == 0).skip(2)
				.forEach(i -> System.out.print(i + " "));

		List<String> g = Arrays.asList("geeks", "for", "geeks");

//     Collect the list as map
//     by groupingBy() method
		Map<String, Long> result2 = g.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//     Print the result
		System.out.println(result2);

		String input = "swiss";
		char result1 = findFirstNonRepeatedCharacter(input);
		if (result1 != '\0') {
			System.out.println("The first non-repeated character is: " + result1);
		} else {
			System.out.println("No non-repeated character found.");
		}
	}
}