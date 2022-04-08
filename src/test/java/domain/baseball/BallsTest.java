package domain.baseball;

import static org.assertj.core.api.Assertions.assertThat;

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
	
	@Test
	void 입력된_리스트_Balls로_변환() {
		List<Ball> balls = answer.answer;
		assertThat(balls.get(0).index).isEqualTo(0);
		assertThat(balls.get(0).no).isEqualTo(2);
		assertThat(balls.get(2).index).isEqualTo(2);
		assertThat(balls.get(2).no).isEqualTo(5);
	}

	@Test
	void 결과값_출력() {
		Result result = answer.makeResult(Arrays.asList(2, 5, 8));
		assertThat(result.strikeCount).isEqualTo(1);
		assertThat(result.ballCount).isEqualTo(1);
	}
}
