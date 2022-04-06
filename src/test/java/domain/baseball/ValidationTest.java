package domain.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ValidationTest {

	@Test
	void 숫자가_1과_9사이인지_확인() {
		assertThat(Validation.validNo(1)).isTrue();
		assertThat(Validation.validNo(9)).isTrue();
		assertThat(Validation.validNo(10)).isFalse();
	}
	
	@Test
	void 숫자의_길이가_3인지_확인() {
		assertThat(Validation.validLen(Arrays.asList(1, 2, 3))).isTrue();
		assertThat(Validation.validLen(Arrays.asList(1, 2))).isFalse();
	}
	
	@Test
	void 숫자가_서로_중복되지_않는지() {
		assertThat(Validation.validDuplicate(Arrays.asList(1, 2, 3))).isTrue();
		assertThat(Validation.validDuplicate(Arrays.asList(1, 2, 2))).isFalse();
		assertThat(Validation.validDuplicate(Arrays.asList(4, 2, 4))).isFalse();		
		assertThat(Validation.validDuplicate(Arrays.asList(9, 1, 6))).isTrue();		
	}
	
	@Test
	void 현재_인덱스_숫자와_같은_값을_가지고_있는_수가_있는지() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		boolean result = Validation.validHasDuplicate(0, 3, numbers);
		boolean result2 = Validation.validHasDuplicate(0, 4, numbers);
		assertThat(result).isTrue();
		assertThat(result2).isFalse();
	}

}
