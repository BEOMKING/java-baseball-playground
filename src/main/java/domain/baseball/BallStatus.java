package domain.baseball;

public enum BallStatus {
	OUT, BALL, STRIKE;
	
	public static boolean isStrike(BallStatus status) {
		return STRIKE.equals(status);
	}
	
	public static boolean isBall(BallStatus status) {
		return BALL.equals(status);
	}
}
