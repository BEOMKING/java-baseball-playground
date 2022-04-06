package domain.baseball;

import java.util.Objects;

public class Ball {
	
	public int index;
	
	public int no;
	
	public Ball(int index, int no) {
		this.index = index;
		this.no = no;
	}

	public BallStatus match(Ball ball) {
		if (this.equals(ball)) {
			return BallStatus.STRIKE;
		}
		if (matchNo(ball)) {
			return BallStatus.BALL;
		}
		return BallStatus.OUT;
	}
	
	public boolean matchNo(Ball ball) {
		return this.no == ball.no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ball other = (Ball) obj;
		return index == other.index && no == other.no;
	}

	
}
