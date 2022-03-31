package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

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
			.isThrownBy(() -> game.checkNumberRange(100));
		assertThat(game.checkNumberRange(948)).isTrue();
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> game.checkNumberRange(902));
	}
}
