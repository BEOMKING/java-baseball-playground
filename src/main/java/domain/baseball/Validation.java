package domain.baseball;

import java.util.List;

public class Validation {

	public static boolean validNo(int number) {
		return number > 0 && number < 10;
	}

	public static boolean validLen(List<Object> numbers) {
		return numbers.size() == 3;
	}

}
