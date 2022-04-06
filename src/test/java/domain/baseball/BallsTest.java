package domain.baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallsTest {

	public Balls answer;
	
	@BeforeEach
	void setUp() {
		answer = new Balls(Arrays.asList(2, 4, 5));
	}
	
	@Test
	void 아웃() {
		BallStatus status = answer.match(1, 3);
		assertThat(status).isEqualTo(BallStatus.OUT);
	}
	
	@Test
	void 볼() {
		BallStatus status = answer.match(0, 4);
		assertThat(status).isEqualTo(BallStatus.BALL);
	}
	
	@Test
	void 스트라이크() {
		BallStatus status = answer.match(1, 4);
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}

}
