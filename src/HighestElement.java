import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HighestElement {
	public static void main(String[] args) {
		List<Integer> SampleArray = new ArrayList<>(Arrays.asList(10, 20, 96, 35, 49, 59, 66, 34));
		List<Integer> numbers = Arrays.asList(10, 20, 96, 35, 49, 59, 66, 34);
		Optional<Integer> numberResult = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(2)
				.findFirst();
		System.out.println("2nd Highest element:" + numberResult.get());
		Optional<Integer> result = SampleArray.stream().sorted(Comparator.reverseOrder()).skip(3).findFirst();
		System.out.println("3rd highest element:" + result.get());

	}
}
