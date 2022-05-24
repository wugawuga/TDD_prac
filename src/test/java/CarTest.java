import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "123456",
        "bkdkdie",
        "1jfdk2id"
    })
    public void 자동차이름_5자초과_예외발생한다(String carName) {

        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("5자를 초과할 수 없어요");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "b",
        "1jf"
    })
    public void 자동차이름_5자이하_예외발생하지않는다(String carName) {

        assertThatCode(() -> new Car(carName))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "  ",
        "       ",
        "     "
    })
    public void 공백처리(String carName) {

        assertThatCode(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("공백은 입력할 수 없어요");
    }

    @Test
    public void Null값처리() {

        assertThatCode(() -> new Car(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("null값은 입력은 수 없어요");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "4",
        "5",
        "8"
    })
    public void random값_4이상일때_한칸전진(int rand) {

        Car car = new Car("wuga");
        assertThat(car.move(rand)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1",
        "0",
        "3"
    })
    public void random값_4미만일때_정지(int rand) {

        Car car = new Car("wuga");
        assertThat(car.move(rand)).isEqualTo(0);
    }

    @Test
    public void 난수0_9만출력() {

        for (int i = 0; i < 1000; i++) {
            assertThat(Car.create()).isBetween(0, 9);
        }
    }

    @Test
    public void 이름분류() {

        String s = "aaaa, bbbb, cccc";
        Cars car = new Cars(s);
        assertThat(car.getCars().size()).isEqualTo(3);
    }
}