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

	public boolean checkNumberRange(int input) {
		for(int i = 0; i < 3; i++) {
			if (input % 10 == 0) {
				throw new RuntimeException("0이 포함되어있습니다.");
			}
			input /= 10;
		}
		return true;
	}
	
	public boolean checkLengthThree(int input) {
		if (input < 101 || input > 999) {
			throw new RuntimeException("3자리가 아닙니다.");
		}
		return true;
	}
}
