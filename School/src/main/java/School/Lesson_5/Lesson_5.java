package School.Lesson_5;

import static java.lang.Math.sqrt;

public class Lesson_5 {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        Animal Lassi = new Animal("Lassi");
        Lassi.run(400);
        Lassi.swim(300);
        System.out.println("Кол-во животных: " + Animal.animalCounter);
        Animal Salli = new Animal();

        Animal.Dog boss = new Animal.Dog("boss");
        boss.run(501);
        boss.run(500);
        boss.swim(10);
        boss.swim(11);
        System.out.println("Кол-во собак: " + Animal.Dog.dogCounter);
        Animal.Dog sobb = new Animal.Dog("sobb");
        System.out.println("Кол-во собак: " + Animal.Dog.dogCounter);

        Animal.Cat thomas = new Animal.Cat("Thomas");
        thomas.run(201);
        thomas.run(200);
        thomas.run(199);
        thomas.swim(100);
        System.out.println("Кол-во кошек: " + Animal.Cat.catCounter);
        Animal.Cat barsenik = new Animal.Cat("Barsenik");
        System.out.println("Кол-во кошек: " + Animal.Cat.catCounter);

        Animal.Cat[] bandOfCats = {new Animal.Cat("Bobby"), new Animal.Cat("Dobby"), new Animal.Cat("Goggy")};
        Animal.Cat.checkBowl();
        Animal.Cat.fillBowl(29);

        System.out.println("Сытость котика " + bandOfCats[0].name + " до кормёжки " + bandOfCats[0].satiety);
        bandOfCats[0].feedCat();
        System.out.println("Сытость котика " + bandOfCats[0].name + " после кормёжки " + bandOfCats[0].satiety);

        System.out.println("Сытость котика " + bandOfCats[1].name + " до кормёжки " + bandOfCats[1].satiety);
        bandOfCats[1].feedCat();
        System.out.println("Сытость котика " + bandOfCats[1].name + " после кормёжки " + bandOfCats[1].satiety);

        System.out.println("Сытость котика " + bandOfCats[2].name + " до кормёжки " + bandOfCats[2].satiety);
        bandOfCats[2].feedCat();
        Animal.Cat.fillBowl(1);
        Animal.Cat.checkBowl();
        bandOfCats[2].feedCat();
        System.out.println("Сытость котика " + bandOfCats[2].name + " после кормёжки " + bandOfCats[2].satiety);
        Animal.Cat.checkBowl();
        System.out.println("Кол-во кошек: " + Animal.Cat.catCounter);

        System.out.println("\n");
        System.out.println("Задание 2");
        Rectangle firstTry = new Rectangle(4,10, "green", "blue");
        firstTry.figureInfo();
        Triangle secondTry = new Triangle(4,5, 5,"blue", "red");
        secondTry.figureInfo();
        Circle thirdTry = new Circle(4,"yellow", "purple");
        thirdTry.figureInfo();
    }
    public static class Animal {
        public String name;
        public static int animalCounter = 0;
        public Animal(){
            animalCounter ++;
        }
        public Animal(String name){
            this.name = name;
            animalCounter ++;
        }
        public void run(int distance){
            System.out.println(name + " пробежал " + distance + " м");
        }
        public void swim(int distance){
            System.out.println(name + " проплыл " + distance + " м");
        }

        static class Cat extends Animal {
            public Cat (){
                catCounter ++;
            }
            public Cat(String name){
                this.name = name;
                catCounter ++;
            }
            public static int catCounter = 0;
            public static int contentsOfBowl = 0;
            public static void fillBowl (int feed){
                contentsOfBowl += feed;
                System.out.println("Миска наполнена на " + feed + " единиц корма");
            }
            public void feedCat(){
                if (contentsOfBowl >= 10){
                    contentsOfBowl -= 10;
                    satiety = true;
                    System.out.println("Котик покормлен");
                }
                else {
                    System.out.println("В миске не хватает корма, в ней осталось лишь " + contentsOfBowl + " единиц корма");
                }
            }
            public static void checkBowl (){
                System.out.println("В миске " + contentsOfBowl + " единиц корма");
            }
            boolean satiety = false;
            public void run(int distance){
                if (distance > 0 && distance <= 200) {
                    System.out.println(name + " пробежал " + distance+ " м");
                }
                else {
                    System.out.println(name + " не может пробежать такую дистанцию");
                }
            }
            public void swim(int distance){
                System.out.println("Коты не умеют плавать");
            }
        }

        static class Dog extends Animal {
            public static int dogCounter = 0;
            public Dog (){
                dogCounter ++;
            }
            public Dog(String name){
                this.name = name;
                dogCounter ++;
            }
            public void run(int distance){
                if (distance > 0 && distance <= 500) {
                    System.out.println(name + " пробежал " + distance+ " м");
                }
                else {
                    System.out.println(name + " не может пробежать такую дистанцию");
                }
            }
            public void swim(int distance){
                if (distance > 0 && distance <= 10) {
                    System.out.println(name + " проплыл " + distance + " м");
                }
                else {
                    System.out.println(name + " не может проплыть такую дистанцию");
                }
            }
        }
    }

    public interface Figure {
        default int calculationPerimeter(int lenght, int width){
            int perimeter = 2 * (lenght + width);
            return perimeter;
        }
        default int calculationArea (int lenght, int width){
            int area = lenght * width;
            return area;
        }

        void figureInfo ();

    }

    public static class Rectangle implements Figure{
        int lenght = 1;
        int width = 1;
        String colorFill = null;
        String colorBorder = null;
        Rectangle (int lenght, int width, String colorFill, String colorBorder){
            this.lenght = lenght;
            this.width = width;
            this.colorFill = colorFill;
            this.colorBorder = colorBorder;
        }
        public void figureInfo() {
            System.out.println("Периметр данного прямоугольника = " + calculationPerimeter(lenght, width));
            System.out.println("Площадь данного прямоугольника = " + calculationArea(lenght, width));
            System.out.println("Цвет заливки: " + colorFill);
            System.out.println("Цвет границы: " + colorBorder);
        }
    }
    public static class Triangle implements Figure{
        double firstSide = 1;
        double secondSide = 1;
        double thirdSide = 1;
        String colorFill = "Black";
        String colorBorder = "Black";
        Triangle (double firstSide, double secondSide, double thirdSide, String colorFill, String colorBorder){
            this.firstSide = firstSide;
            this.secondSide = secondSide;
            this.thirdSide = thirdSide;
            this.colorFill = colorFill;
            this.colorBorder = colorBorder;
        }
        double calculationPerimeter (double firstSide, double secondSide, double thirdSide){
            double perimeter = firstSide + secondSide + thirdSide;
            return perimeter;
        }
        double calculationArea (double firstSide, double secondSide, double thirdSide){
            double halfPerimeter = (firstSide + secondSide + thirdSide) / 2;
            if (halfPerimeter <= firstSide || halfPerimeter <= secondSide || halfPerimeter <= thirdSide){
                System.out.println("Полупериметр меньше или равен одной из сторон, стороны треугольника заданы неверно");
                throw new IllegalArgumentException("Invalid triangle sides");
            }
            double area = sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));

            return area;
        }
        public void figureInfo() {
            System.out.println("Периметр данного треугольника = " + calculationPerimeter(firstSide, secondSide, thirdSide));
            System.out.println("Площадь данного треугольника = " + calculationArea(firstSide, secondSide, thirdSide));
            System.out.println("Цвет заливки: " + colorFill);
            System.out.println("Цвет границы: " + colorBorder);
        }
    }
    public static class Circle implements Figure{
        double circleRadius = 1;
        String colorFill = "Black";
        String colorBorder = "Black";
        Circle (double circleRadius, String colorFill, String colorBorder){
            this.circleRadius = circleRadius;
            this.colorFill = colorFill;
            this.colorBorder = colorBorder;
        }
        double calculationPerimeter (double circleRadius){
            double perimeter = 2 * circleRadius * Math.PI;
            return perimeter;
        }
        double calculationArea (double circleRadius){
            double area = Math.pow(circleRadius, 2) * Math.PI;
            return area;
        }
        public void figureInfo() {
            System.out.println("Периметр данного круга = " + calculationPerimeter(circleRadius));
            System.out.println("Площадь данного круга = " + calculationArea(circleRadius));
            System.out.println("Цвет заливки: " + colorFill);
            System.out.println("Цвет границы: " + colorBorder);
        }
    }
}