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
			if (validHasDuplicate(i, numbers.get(i), numbers)) {
				return false;
			}
		}
		return true;
	}

	public static boolean validHasDuplicate(int index, int number, List<Integer> numbers) {
		for (int i = index + 1; i < numbers.size(); i++) {
			if (number == numbers.get(i)) {
				return true;
			}
		}
		return false;
	}

}
