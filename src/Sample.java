import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Sample {
	public static void main(String[] args) {
		// System.out.println("Hello World");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// 1.Sum of numbers
		Optional<Integer> sum = list.stream()
				.reduce((a, b) -> a + b);
		System.out.println("Sum of numbers:" + sum.get());

		// 2.Average of numbers
		double avg = list.stream()
						.mapToInt(e -> e)
							.average()
								.getAsDouble();
		System.out.println("Average of numbers:" + avg);

		// Square, Filter and Average of Numbers
		List<Integer> newList = Arrays.asList(1, 10, 20, 30, 15);
		Double SqFilAve = newList.stream()
								  .map(e -> e * e)
									.filter(e -> e > 100)
										.mapToInt(e -> e).average()
											.getAsDouble();
		System.out.println("Square, Filter and Average of Numbers:" + SqFilAve);

		// Find Even and Odd numbers
		
		List<Integer> ls= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> EvenResList = ls.stream()
			.filter(e->e%2==0)
				.collect(Collectors.toList());
		System.out.println("Even numbers"+EvenResList);
		
		Map<Boolean, List<Integer>> response = ls.stream()
		        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("even and odd in same stream"+response);
		
		// Print Numbers Starts With Prefix 2 using Streams
		List<Integer> allNum= Arrays.asList(2,22,345,224,488,24322,82439,2984);
		List<Integer> numWith2 = allNum.stream()
										.map(e->String.valueOf(e))
										.filter(e->e.startsWith("2"))
										.map(Integer::valueOf)
										.collect(Collectors.toList());
		System.out.println("Numbers starts with 2:"+numWith2);
		// Print Duplicate Numbers using Streams
		List<Integer> dupList=Arrays.asList(1,2,3,1,2,3,4,5,7,4,7);
		Set<Integer> onlyDep = dupList.stream()
						.filter(e->Collections.frequency(dupList, e)>1)
							.collect(Collectors.toSet());
		System.out.println("Duplicates:"+onlyDep);
	}
}
