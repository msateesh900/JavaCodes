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

	/* 1.Find occurrences of each character from String using java 8 streams */
	public static void strOcc(String str) {
		Map<String, Long> strOccurances = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("1.Occurances of each character from:" + str + ":is--->" + strOccurances);
	}

	/* 2.Find duplicate characters from String using java 8 streams */
	public static void strDupChar(String str) {
		List<String> duplicateChars = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("2.Duplicate characters from:" + str + ":" + duplicateChars);
	}
	
	/* 3.Find unique characters from String using java 8 streams */
	public static void strUniChar(String str) {
		List<String> uniqueChars = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("3.Unique characters from:" + str + ":" + uniqueChars);
	}
	
	/* 4.Find First non-repeated character from String using java 8 streams */
	public static void strFindFirstNonRepChar(String str) {
		String firstNonRepeatedChar = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(i -> i.getValue() == 1).findFirst().get().getKey();
		System.out.println("4.First non-repeated characters from:" + str + ":" + firstNonRepeatedChar);
	}
	
	/* 5.Find First repeated character from String using java 8 streams */
	public static void strFindFirstRepChar(String str) {
		String firstRepeatedChar = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(i -> i.getValue() > 1).findFirst().get().getKey();
		System.out.println("5.First repeated characters from:" + str + ":" + firstRepeatedChar);
	}
	
	/* 6.Find Second Highest number from number Array using java 8 streams */
	public static void intArrFindSecoHighNum(int[] numbers) {
		Integer secondHighestnum = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.get();
		System.out.println("6.Second Highest number from Numbers list:" + secondHighestnum);
	}
	
	/* 7.Find Longest String/word from sentence java 8 streams */
	public static void longWordStr(String sentence) {
		String longestString = Arrays.stream(sentence.split(" "))
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
		System.out.println("7.Longest String from sentence is:" + longestString);
	}
	
	/* 8.Find numbers starts with 1 using java 8 streams */
	public static void intArrFindNumStars1(int[] numbers) {
		List<String> startsWith1 = Arrays.stream(numbers).boxed().map(s -> s + "").filter(i -> i.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println("8.Numbers starts with 1 from numbers is:" + startsWith1);
	}

	public static void main(String[] args) {
		
		/* 1.Find occurrences of each character from String using java 8 streams */
		String str = "ilovejavatechie";
		System.out.println("String we are testing is:" + str);
			
		strOcc(str);

		/* 2.Find duplicate characters from String using java 8 streams */
		strDupChar(str);

		/* 3.Find unique characters from String using java 8 streams */
		strUniChar(str);

		/* 4.Find First non-repeated character from String using java 8 streams */
		strFindFirstNonRepChar(str);

		/* 5.Find First repeated character from String using java 8 streams */
		strFindFirstRepChar(str);
		
		/* 6.Find Second Highest number from number Array using java 8 streams */
		int[] numbers = { 10, 20, 40, 13, 4, 5 };
		intArrFindSecoHighNum(numbers);

		/* 7.Find Longest String/word from sentence java 8 streams */
		String sentence = "java techie springboot microservices";
		longWordStr(sentence);
		
		/* 8.Find numbers starts with 1 using java 8 streams */
		intArrFindNumStars1(numbers);
 
		/* 9.String.join in java 8 */
		List<String> nos = Arrays.asList("1", "2", "3", "4", "5");
		String result = String.join("-", nos);
		System.out.println(result);

		/* 10.skip,limit in java 8 */
		IntStream.rangeClosed(1, 10).skip(0).limit(9).forEach(System.out::print);
	}

}
