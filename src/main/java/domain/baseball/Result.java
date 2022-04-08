package domain.baseball;

public class Result {

	public int strikeCount;
	public int ballCount;
	
	public void addCountByStatus(BallStatus ballStatus) {
		if (BallStatus.isStrike(ballStatus)) {
			strikeCount++;
		}
		if (BallStatus.isBall(ballStatus)) {
			ballCount++;
		}
	}

	@Override
	public String toString() {
		return "결과는" + ballCount + "볼 " + strikeCount + "스트라이크";
	}
	
	
}
