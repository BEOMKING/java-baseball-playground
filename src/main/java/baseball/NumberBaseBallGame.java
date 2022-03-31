package baseball;

import java.util.Random;

public class NumberBaseBallGame {
	
	
	private int makeAnswer() {
		return makeNumber(10) * 100 + makeNumber(10) * 10 + makeNumber(10);
	}
	
	private int makeNumber(int number) {
		Random random = new Random();
		return random.nextInt(1, number);
	}

	
	public boolean checkLengthThree(int input) {
		if (input < 101 || input > 999) {
			throw new RuntimeException("3자리가 아닙니다.");
		}
		return true;
	}
}
