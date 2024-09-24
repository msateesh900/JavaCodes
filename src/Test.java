import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Test {
	
	 public static char findFirstNonRepeatedCharacter(String str) {
	        Map<Character, Integer> characterCountMap = new LinkedHashMap<>();

	        // Populate the map with character counts
	        for (char ch : str.toCharArray()) {
	            characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
	        }

	        System.out.println("map with character counts"+characterCountMap);
	        // Find the first non-repeated character
	        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
	            if (entry.getValue() == 1) 
	                return entry.getKey();
	        }
			return 0;

	    }

	public static void main(String[] args) {
		
//		List<Integer> array = new ArrayList<>(Arrays.asList(21,34,56,34,56,27,16,17,91));
//
//		Optional<Integer> result1= array.stream().sorted(Comparator.reverseOrder()).limit(4).skip(1).findFirst();
//		System.out.println("3rd highest element:"+ result1.get());
		
//		int array[] = {21,34,56,34,56,27,16,17,91};
//	      int size = array.length;
//	      Arrays.sort(array);
//	      System.out.println("sorted Array ::"+Arrays.toString(array));
//	      int max = array[size-3];
//	      System.out.println("3rd highest ::"+max);
//		
//		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//	    .filter(i -> i % 2 == 0)
//	    .skip(2)
//	    .forEach(i -> System.out.print(i + " "));
		
		
		List<String> g = Arrays.asList("geeks", "for", "geeks");

    // Collect the list as map
    // by groupingBy() method
//	Map<String, Long> result = g.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//    // Print the result
//    System.out.println(result);
    
		String input = "swiss";
        char result = findFirstNonRepeatedCharacter(input);
        if (result != '\0') {
            System.out.println("The first non-repeated character is: " + result);
        } else {
            System.out.println("No non-repeated character found.");
        }
	}
}