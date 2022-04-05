package domain.baseball;

import java.util.List;

public class Validation {

	public static boolean validNo(int number) {
		return number > 0 && number < 10;
	}

	public static boolean validLen(List<Object> numbers) {
		return numbers.size() == 3;
	}

	public static boolean validDuplicate(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				if (numbers.get(i) == numbers.get(j)) return false;
			}
		}
		return true;
	}

}
