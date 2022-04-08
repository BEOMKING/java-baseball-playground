package domain.baseball;

public enum BallStatus {
	OUT, BALL, STRIKE;
	
	public boolean isStrike() {
		return this == STRIKE;
	}
	
	public boolean isBall() {
		return this == BALL;
	}
}
