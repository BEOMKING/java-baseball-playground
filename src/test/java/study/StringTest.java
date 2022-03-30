package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
	
	private String haveElements;
	private String haveElementOnly;
	private String haveBrackets;
	private String alpha;
	private Set<Integer> numbers;
	
	@BeforeEach
	void setUp() {
		haveElements = "1,2";
		haveElementOnly = "1";
    	haveBrackets = "(1,2)";
    	alpha = "abc";
    	numbers = new HashSet<Integer>();
    	numbers.add(1);
    	numbers.add(2);
    	numbers.add(3);
    	numbers.add(4);
	}
	
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test
    void Split후에_나오는결과() {
    	haveElements = "1,2";
    	haveElementOnly = "1";
    	assertThat(haveElements.split(",")).contains("1", "2");
    	assertThat(haveElementOnly.split(",")).containsExactly("1");
    }
    
    @Test
    void Substring을_이용해_괄호제거() {
    	assertThat(haveBrackets.substring(1, haveBrackets.length() - 1)).isEqualTo("1,2");
    }
    
    @Test
    void charAt을_사용해_결과값_테스트() {
    	assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
    		.isThrownBy(() ->  alpha.charAt(3)
							);
    }
    
    @Test
    void Set의_크기_테스트() {
    	int size = numbers.size();
    	
    	assertThat(size).isEqualTo(4);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void Set의_Elements_테스트(int number) {
    	assertThat(numbers.contains(number)).isTrue();
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:false"}, delimiter = ':')
    void Set의_contains결과값_테스트(int number, boolean result) {
    	assertThat(numbers.contains(number)).isEqualTo(result);
    }
    
}
