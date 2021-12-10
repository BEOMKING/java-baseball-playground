import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorTest {

    Calculator calculator = new Calculator();
    Calculator.NumbersAndOperation numbersAndOperation;
    String inputNull;
    String inputEmpty;
    String input;

    @BeforeEach
    void setUp() {
        inputNull = null;
        inputEmpty = " ";
        input = "2 + 3 * 4 / 2";
    }

    @Test
    void calculate() {
        assertThat(calculator.calculate(input)).isEqualTo(10);
        assertThatThrownBy(() -> calculator.calculate(inputNull)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 공백인지 확인")
    @NullAndEmptySource
    void IsBlankOrIsEmpty(String input) throws Exception {
        Method method = calculator.getClass().getDeclaredMethod("isBlank", String.class);
        method.setAccessible(true);
        assertThatThrownBy(() -> method.invoke(calculator, input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 공백 기준으로 나누기")
    void split() throws Exception {
        Method method = calculator.getClass().getDeclaredMethod("split", String.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(calculator, input);
        assertThat(result.length).isEqualTo(7);
    }

    @Test
    @DisplayName("올바른 입력값인지 확인")
    void validation() throws Exception {
        String[] input = {"2", "2", "+"};
        Method method = calculator.getClass().getDeclaredMethod("validation", String[].class);
        method.setAccessible(true);
        assertThatThrownBy(() -> method.invoke(calculator, input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 전처리 후 계산")
    void splitAndCalculate() throws Exception {
        String[] inpu = {"2", "+", "3", "*", "4", "/", "2"};
        Method method = calculator.getClass().getDeclaredMethod("splitNumbersOperation", String[].class);
        method.setAccessible(true);
        numbersAndOperation = (Calculator.NumbersAndOperation) method.invoke(calculator, (Object) inpu);
        assertThat(numbersAndOperation.number.size()).isEqualTo(4);
        assertThat(numbersAndOperation.operation.size()).isEqualTo(3);
    }


}