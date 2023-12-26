package School.Lesson_3;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson_3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Задание 1");
        System.out.println("Необходимо ввести 2 числа");
        System.out.println("Введите первое целое число: ");
        int num1 = in.nextInt();
        System.out.println("Введите второе целое число: ");
        int num2 = in.nextInt();
        System.out.println("Выполняем проверку диапазона суммы чисел: если вывод - true, то сумма числе в диапазоне от 10 до 20 включительно, если false - то сумма чисел не входит в заданный диапазон");
        summInRange(num1, num2);

        System.out.println("Задание 2");
        System.out.println("Введите целое число, знак которого необходимо узнать:");
        int num3 = in.nextInt();
        numberSign (num3);

        System.out.println("Задание 3");
        System.out.print("Введите целое число, если его знак положительный, то вывод будет true, если отрицательный - false: ");
        int num4 = in.nextInt();
        returnSign (num4);

        System.out.println("Задание 4");
        System.out.println("Введите строку, которую необходимо напечатать: ");
        String text = in.nextLine();
        String text1 = in.nextLine();
        System.out.println("Сколько раз необходимо напечатать эту строку ? ");
        int num5 = in.nextInt();
        stringsOutput (text1, num5);

        System.out.println("Задание 5");
        System.out.println("Введите год, если вывод true - год високосный, если false - год не високосный: ");
        int num6 = in.nextInt();
        leapYearOrNot(num6);

        System.out.println("Задание 6");
        int[] massive1 = {0,1,0,0,0,1} ;
        System.out.println("Вывод первоначальных значений массива");
        for (int i = 0; i < massive1.length; i++){
            System.out.print(massive1[i] + " ");
        }

        for (int i = 0; i < massive1.length; i++){
            if (massive1[i] == 0)
            {
                massive1[i] = 1;
            }
            else{
                massive1[i] = 0;
            }
        }
        System.out.println("\n");
        System.out.println("Вывод изменённых значений массива");
        for (int i = 0; i < massive1.length; i++){
            System.out.print(massive1[i] + " ");
        }

        System.out.println("Задание 7");
        int[] massive2 = new int[100];
        for (int i = 0; i < massive2.length; i++){
            massive2[i] = i + 1;
        }
        for (int i = 0; i < massive2.length; i++){
            System.out.print(massive2[i] + " ");
        }

        System.out.println("Задание 8");
        System.out.println("Вывод первоначальных значений массива");
        int[] massive3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1} ;
        for (int i = 0; i < massive3.length; i++){
            System.out.print(massive3[i] + " ");
        }
        for (int i = 0; i < massive3.length; i++){
            if (massive3[i] < 6) {
                massive3[i] *= 2;
            }
        }
        System.out.println("\n");
        System.out.println("Вывод изменённых значений массива");
        for (int i = 0; i < massive3.length; i++){
            System.out.print(massive3[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Задание 9");
        int[][] massive4 = new int[15][15];
        for (int i = 0;i < massive4.length; i++){
            for (int j = 0; j < massive4[i].length; j++){
                if(i==j){
                    massive4[i][j] = 1;
                    System.out.print(massive4[i][j]);
                }
                else if (j == massive4[i].length - i-1){
                    massive4[i][j] = 1;
                    System.out.print(massive4[i][j]);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        System.out.println("Задание 10");
        System.out.println("Введите длинну массива: ");
        int len = in.nextInt();
        System.out.println("Введите число, которым нужно заполнить массив");
        int initialValue = in.nextInt();
        int [] myArray = setArray(len, initialValue);
        for (int i = 0; i < myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
    }

    public static boolean summInRange(int num1, int num2) {
        boolean b = num1 + num2 <= 20 && num1 + num2 >= 10;
        System.out.println(b);
        return b;
    }

    public static void numberSign (int num3){
        if (num3 >= 0) {
            System.out.println("Это положительное число");
        }
        else    {
            System.out.println("Это отрицательное число");
        }
    }

    public static boolean returnSign(int num4) {
        boolean c = num4 >= 0;
        System.out.println(c);
        return c;
    }

    public static void stringsOutput (String text1, int num5){
        if (num5 > 0){
            for (int i = 1; i <= num5; i++){
                System.out.println(text1);
            }
        }
        else {
            System.out.println("Введено неверное число");
        }
    }

    public static boolean leapYearOrNot (int num6){
        boolean d = num6 % 4==0 || num6 % 400==0;
        System.out.println(d);
        return d;
    }

    public static int[] setArray (int len, int initialValue){
        int [] array = new int[len];
        Arrays.fill(array, initialValue);
        return (array);
    }
}
