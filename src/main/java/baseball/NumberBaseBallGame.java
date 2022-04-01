package baseball;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseBallGame {
	
	public int userInput;
	
	public int answer;
	
	public void startGame() {
		Scanner sc = new Scanner(System.in);
		int start = 1;
			
		while(start != 2) {
			makeAnswer();
			System.out.print("숫자를 입력해주세요 : ");
			userInput = sc.nextInt();
			checkLengthThree(userInput);
			checkHasZero(userInput);
			
			Result result = checkAnswer();
			if (result.result) {
				correctAnswer(3);
			}
			if (!result.result) {
				wrongAnswer(result.ball, result.strike);
			}
			start = sc.nextInt();
		}
	}
	
	public void correctAnswer(int strike) {
		System.out.println(strike + "스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
	}
	
	public void wrongAnswer(int ball, int strike) {
		if (ball != 0) {
			System.out.print(ball + "볼");
		}
		if (strike != 0) {
			System.out.println(strike + "스트라이크");
		}
		
	}
	
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
	
	public boolean checkDuplicate(int input) {
		boolean[] checked = new boolean[10];
		for(int i = 0; i < 3; i++) {
			if (checked[input % 10]) {
				throw new RuntimeException("같은 숫자가 이미 포함되어 있습니다.");
			}
			checked[input % 10] = true;
			input /= 10;
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
