import java.util.Random;

public class Car {

    private String carName;

    public Car(String carName) {
        if (carName == null) {
            throw new NullPointerException("null값은 입력은 수 없어요");
        }
        if (carName.trim().length() == 0) {
            throw new IllegalArgumentException("공백은 입력할 수 없어요");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("5자를 초과할 수 없어요");
        }
        this.carName = carName;
    }

    public int move(int rand) {

        if (rand >= 4) return 1;
        else return 0;
    }

    public static int create() {
        return new Random().nextInt(10);
    }

    public String getCarName() {
        return carName;
    }
}