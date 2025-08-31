import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Programs {

	public static void StringOccurancesUsingJava8Streams(String str) {
		Map<String, Long> strOccurances = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Occurances of each character from:" + str + ":is--->" + strOccurances);
	}

	public static void main(String[] args) {
		/* 1.Find occurrences of each character from String using java 8 streams */
		String str = "ilovejavatechie";
		System.out.println("String we are testing is:" + str);
			
		StringOccurancesUsingJava8Streams(str);

		/* 2.Find duplicate characters from String using java 8 streams */
		List<String> duplicateChars = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

//		System.out.println("Duplicate characters from:" + str + ":" + duplicateChars);

		/* 3.Find unique characters from String using java 8 streams */

		List<String> uniqueChars = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());

//		System.out.println("Unique characters from:" + str + ":" + uniqueChars);

		/* 4.Find First non-repeated character from String using java 8 streams */
		String firstNonRepeatedChar = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(i -> i.getValue() == 1).findFirst().get().getKey();

//		System.out.println("First non-repeated characters from:" + str + ":" + firstNonRepeatedChar);

		/* 5.Find First repeated character from String using java 8 streams */
		String firstRepeatedChar = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(i -> i.getValue() > 1).findFirst().get().getKey();

//		System.out.println("First repeated characters from:" + str + ":" + firstRepeatedChar);

		/* 6.Find Second Highest number from number Array using java 8 streams */
		int[] numbers = { 10, 20, 40, 13, 4, 5 };
//		Arrays.stream(numbers).distinct().collect(Collectors.)
		Integer secondHighestnum = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.get();

//		System.out.println("Second Highest number from Numbers list:" + secondHighestnum);

		/* 7.Find Longest String/word from sentence java 8 streams */
		String sentence = "java techie springboot microservices";
		String longestString = Arrays.stream(sentence.split(" "))
				.reduce((word1, word2) -> (word1.length() > word2.length()) ? word1 : word2).get();

//		System.out.println("Longest String from sentence is:" + longestString);

		/* 8.Find numbers starts with 1 using java 8 streams */

		List<String> startsWith1 = Arrays.stream(numbers).boxed().map(s -> s + "").filter(i -> i.startsWith("1"))
				.collect(Collectors.toList());

//		System.out.println("Numbers starts with 1 from numbers is:" + startsWith1);

		/* 9.String.join in java 8 */
		List<String> nos = Arrays.asList("1", "2", "3", "4", "5");
		String result = String.join("-", nos);
//		System.out.println(result);

		/* 10.skip,limit in java 8 */
		IntStream.rangeClosed(1, 10).skip(0).limit(9).forEach(System.out::print);
	}

}
