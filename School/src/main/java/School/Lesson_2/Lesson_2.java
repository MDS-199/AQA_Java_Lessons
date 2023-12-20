package School.Lesson_2;

public class Lesson_2 {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Урок номер 2");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        printThreeWords();

        checkSumSign();

        printColor();

        compareNumbers();
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 10;
        int b = -10;
        if (a+b>=0){
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 1000;
        if (value<=0){
            System.out.println("Красный");
        }
        else if (value>0 & value<=100){
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зелёный");
        }
    }

    private static void compareNumbers() {
        int a = 10;
        int b = 11;
        if (a >= b){
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }
}
