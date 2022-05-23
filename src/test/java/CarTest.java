import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "123456",
        "      ",
        "bkdkdie",
        "1jfdk2id"
    })
    public void 자동차이름_5자초과_예외발생한다(String carName) {

        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("5자를 초과할 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "  ",
        "b",
        "1jf"
    })
    public void 자동차이름_5자이하_예외발생하지않는다(String carName) {

        assertThatCode(() -> new Car(carName))
            .doesNotThrowAnyException();
    }
}