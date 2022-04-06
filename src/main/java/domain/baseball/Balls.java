package domain.baseball;

import java.util.List;

public class Balls {

	List<Integer> answer;
	
	public Balls(List<Integer> answer) {
		this.answer = answer;
	}

	public BallStatus match(int index, int number) {
		return BallStatus.OUT;
	}
	
	
}
