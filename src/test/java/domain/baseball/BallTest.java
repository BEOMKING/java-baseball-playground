package domain.baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTest {

	public Ball ball;
	
	@BeforeEach
	void setUp() {
		ball = new Ball(2, 4);
	}
	
	@Test
	void 아웃() {
		assertThat(ball.match(new Ball(1, 3))).isEqualTo(BallStatus.OUT);
	}
	
	@Test
	void 볼() {
		assertThat(ball.match(new Ball(1, 4))).isEqualTo(BallStatus.BALL);
	}
	
	@Test
	void 스트라이크() {
		assertThat(ball.match(new Ball(2, 4))).isEqualTo(BallStatus.STRIKE);
	}

}
