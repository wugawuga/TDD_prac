public class Car {

    private String carName;

    public Car(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("5자를 초과할 수 없습니다");
        }
    }
}