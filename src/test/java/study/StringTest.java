package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("입력 값 ,로 나누고 contains로 검증")
    void splitAndVerifyContains() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    @DisplayName("입력 값 ,로 나누고 containsExactly로 검증")
    void splitAndVerifyContainsExactly() {
        String[] actual = "1,".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("입력 값 substring 사용해서 () 없애고 결과 확인")
    void substringAndVerifyEqual() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("입력 값 charAt 사용해서 위치 가져오고 예외 처리 Exception Of Type")
    void charAtAndHandlingIOOBException() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                actual.charAt(4);
            }).withMessageContaining("range: %d", 4);
    }

    @Test
    @DisplayName("입력 값 charAt 사용해서 위치 가져오고 예외 처리 Thrown By")
    void charAtAndHandling() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> {
            actual.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("range: %d", 4);
    }
}
