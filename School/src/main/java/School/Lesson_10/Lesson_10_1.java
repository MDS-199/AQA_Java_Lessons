package School.Lesson_10;

import java.util.ArrayList;
import java.util.List;

public class Lesson_10 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println(appleBox.calculateWeight());
        System.out.println(orangeBox.calculateWeight());
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(appleBox2));

        appleBox.sprinkleFruit(appleBox, appleBox2);
        System.out.println(appleBox.calculateWeight());
        System.out.println(appleBox2.calculateWeight());
    }
}
abstract class Fruit {
    public abstract float getWeight();
}
class Apple extends Fruit{
    public float getWeight() {
        return weight;
    }
    static float weight = 1.0f;
}
class Orange extends Fruit{
    public float getWeight() {
        return weight;
    }
    static float weight = 1.5f;
}
class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }
    public T getFruitType() {
        if (!fruits.isEmpty()) {
            return fruits.get(0);
        } else {
            return null;
        }
    }
    public boolean compare(Box<?> otherBox) {
        float weight1 = calculateWeight();
        float weight2 = otherBox.calculateWeight();
        return weight1 == weight2;
    }
    public float calculateWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }
    public void sprinkleFruit (Box<T> from, Box<T> to){
        for (int i = 0; i < from.fruits.size(); i++){
            to.addFruit(from.getFruitType());
        }
        from.fruits.clear();
    }
}