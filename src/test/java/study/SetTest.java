package study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));
    }

    @Test
    @DisplayName("HashSet의 크기를 확인")
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("입력값으로 HashSet의 포함된 요소 확인")
    @ValueSource(ints = {1, 2, 3})
    void checkValues(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("입력값들로 HashSet의 포함, 포함되지 않은 요소 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkValuesInSet(String number, boolean expected) {
        int num = Integer.parseInt(number);
        assertThat(numbers.contains(num)).isEqualTo(expected);

    }

}
