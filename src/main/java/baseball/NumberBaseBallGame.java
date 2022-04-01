package baseball;

import java.util.Random;

public class NumberBaseBallGame {
	
	public int userInput;
	
	public int answer;
	
	public void makeAnswer() {
		this.userInput = makeNumber(10) * 100 + makeNumber(10) * 10 + makeNumber(10);
	}
	
	private int makeNumber(int number) {
		Random random = new Random();
		return random.nextInt(1, number);
	}

	public boolean checkHasZero(int input) {
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
	
	public Result checkAnswer() {
		int copyAnswer = answer;
		int copyUserInput = userInput;
		if (userInput == answer) {
			return new Result(0, 3, true);
		}
		return countBallStrike(copyUserInput, copyAnswer);
	}
	
	public Result countBallStrike(int userInput, int answer) {
		int ball = 0;
		int strike = 0;
		for(int i = 0; i < 3; i++) {
			if (userInput % 10 == answer % 10) {
				strike++;
			}
			if (userInput % 10 != answer % 10) {
				ball++;
			}
			userInput /= 10;
			answer /= 10;
		}
		return new Result(ball, strike, false);
	}
	
	class Result {
		int ball, strike;
		boolean result;
		
		public Result(int ball, int strike, boolean result) {
			super();
			this.ball = ball;
			this.strike = strike;
			this.result = result;
		}
		
	}
}
