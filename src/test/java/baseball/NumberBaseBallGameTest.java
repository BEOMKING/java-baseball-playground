package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

import baseball.NumberBaseBallGame.Result;

public class NumberBaseBallGameTest {

	NumberBaseBallGame game = new NumberBaseBallGame();
	
	@Test
	public void 입력값이_3자리인지_확인() {
		assertThat(game.checkLengthThree(123)).isTrue();
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> game.checkLengthThree(1000));
	}
	
	@Test
	public void 입력값에_1이포함되어_있는지() {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> game.checkHasZero(100));
		assertThat(game.checkHasZero(948)).isTrue();
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> game.checkHasZero(902));
	}
	
	@Test
	public void 입력값과_정답이_같은지() {
		game.userInput = 283;
		game.answer = 293;
		Result result = game.checkAnswer();
		assertThat(result.ball).isEqualTo(1);
		assertThat(result.strike).isEqualTo(2);
		assertThat(result.result).isFalse();
		game.userInput = 253;
		game.answer = 253;
		Result result1 = game.checkAnswer();
		assertThat(result1.ball).isEqualTo(0);
		assertThat(result1.strike).isEqualTo(3);
		assertThat(result1.result).isTrue();
	}
}
