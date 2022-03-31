package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberBaseBallGameTest {

	NumberBaseBallGame game = new NumberBaseBallGame();
	
	@Test
	public void 입력값이_3자리인지_확인() {
		assertThat(game.checkLengthThree(123)).isTrue();
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> game.checkLengthThree(1000));
	}
}
