import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
	public static char findFirstNonRepeatedCharacter(String str) {
		Map<Character, Integer> charCountMap = new LinkedHashMap<>();
		for (char ch : str.toCharArray())
			charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
		System.out.println("Occurances of characters:"+charCountMap);
		for(Map.Entry<Character, Integer> entry: charCountMap.entrySet())
			if(entry.getValue()!=-1)
				return entry.getKey();
		return '\0';
	}

	public static void main(String[] args) {
		String input = "swiss";
		char result = findFirstNonRepeatedCharacter(input);

		if (result != '\0') {
			System.out.println("The first repeated character is: " + result);
		} else {
			System.out.println("No non-repeated character found.");
		}
	}
}
