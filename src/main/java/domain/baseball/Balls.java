package domain.baseball;

import java.util.List;

public class Balls {

	List<Integer> answer;
	
	public Balls(List<Integer> answer) {
		this.answer = answer;
	}

	public BallStatus match(int index, int number) {
		if (matchIndexAndNumber(index, number)) {
			return BallStatus.STRIKE;
		}
		if (matchNumber(number)) {
			return BallStatus.BALL;
		}
		return BallStatus.OUT;
	}

	private boolean matchIndexAndNumber(int index, int number) {
		return answer.get(index) == number;
	}

	private boolean matchNumber(int number) {
		return this.answer.contains(number);
	}
	
	
}
