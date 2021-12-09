import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void calculate() {
        String input = "2+3*4/2";
        String inputBlank = "";
        assertThat(calculator.calculate(input)).isEqualTo(10);
        assertThatThrownBy(() -> {
            calculator.calculate(inputBlank);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력 값이 공백인지 확인")
    void CheckInputIsBlankOrIsEmpty() throws Exception {
        String textNull = null;
        String textEmpty = "";
        String text = "abc";
        Method method = calculator.getClass().getDeclaredMethod("isBlank", String.class);
        method.setAccessible(true);
        assertThat((boolean) method.invoke(calculator, textNull)).isTrue();
        assertThat((boolean) method.invoke(calculator, textEmpty)).isTrue();
        assertThat((boolean) method.invoke(calculator, text)).isFalse();
    }

    @Test
    @DisplayName("입력 값 전처리 후 계산")
    void splitAndCalculate() throws Exception {
        String input = "2+3*4/2";
        Method method = calculator.getClass().getDeclaredMethod("splitAndCalulate", String.class);
        method.setAccessible(true);
        assertThat((int) method.invoke(calculator, input)).isEqualTo(10);
    }


}