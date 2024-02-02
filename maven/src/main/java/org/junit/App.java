package org.junit;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(Factorial.calculate(5));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, факториал которого необходимо вычислить");
        var input = scanner.nextInt();
        System.out.println("Факториал числа " + input + " равен: " + Factorial.calculate(input));
        var input2 = 22;
        System.out.println("Факториал числа " + input2 + " равен: " + Factorial.calculate(input2));
    }
    public static class Factorial {
        public static int calculate (int number){
            int answer = 1;
            if (number == 0){
                return answer;
            }
            else if (number < 0){
                System.out.println("число должно быть не отрицательным");
                return 0;
            }
            else {
                for (int i = 1; i <= number; i++) {
                    answer = answer * i;
                }
                return answer;
            }
        }
    }
}

