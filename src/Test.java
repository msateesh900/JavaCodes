import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

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