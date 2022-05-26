import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String s) {
        String[] carArr = s.split(",");
        for (int i = 0; i < carArr.length; i++) {
            carArr[i] = carArr[i].strip();
        }
        for (String carNameStrip : carArr) {
            cars.add(new Car(carNameStrip));
        }
    }

    public int moveCount() {
        int rand = new Random().nextInt(10);
        if (rand > 3){ return 1;}
        else return 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String moving() {
        int moveCount = moveCount();
        if (moveCount == 1) {
            return "-";
        } else return "";
    }

    public static void main(String[] args) {
        String asb = "aaa, bbb , ddaf, bdf";
        Cars cjcj = new Cars(asb);

        System.out.println(cjcj.getCars().stream()
            .map(v->v.toString())
            .collect(Collectors.joining(",")));
    }
}
