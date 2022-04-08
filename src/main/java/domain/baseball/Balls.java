package domain.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	List<Ball> answer;
	
	public Balls(List<Integer> answerList) {
		answer = new ArrayList<>();
		for (int index = 0; index < answerList.size(); index++) {
			answer.add(new Ball(index, answerList.get(index)));
		}
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
		return answer.get(index).no == number;
	}

	private boolean matchNumber(int number) {
		for (int i = 0; i < answer.size(); i++) {
			if (matchIndexAndNumber(i, number)) {
				return true;
			}
		}
		return false;
	}

	public Result makeResult(List<Integer> user) {
		Result result = new Result();
		for (int i = 0; i < user.size(); i++) {
			result.addCountByStatus(match(i, user.get(i)));
		}
		return result;
	}
	

}
