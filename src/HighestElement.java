import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HighestElement {
	public static void main(String[] args) {
		List<Integer> SampleArray = new ArrayList<>(Arrays.asList(21, 34, 56, 34, 56, 27, 16, 17, 91));
		Optional<Integer> result = SampleArray.stream().sorted(Comparator.reverseOrder()).limit(4).skip(1).findFirst();
		System.out.println("3rd highest element:" + result.get());
		
		int array[] = { 21, 34, 56, 34, 56, 27, 16, 17, 91 };
		int size = array.length;
		Arrays.sort(array);
		System.out.println("sorted Array ::" + Arrays.toString(array));
		int max = array[size - 3];
		System.out.println("3rd highest ::" + max);
	}
}
