package School.Lesson_7;
import java.io.*;

public class Lesson_7 {
    public static void main(String[] args) throws MyArraySizeException {
    String[][] testArray1 = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };

    String[][] testArray2 = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "A", "11", "12"},
            {"13", "14", "15", "16"}
    };

    ArraySum forTestArray = new ArraySum();
            System.out.println(forTestArray.setArray(testArray1));
            System.out.println(forTestArray.setArray(testArray2));
    }

}

class ArraySum{
    public int setArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int expectedRows = 4;
        int expectedColumns = 4;

        if (array.length != expectedRows) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != expectedColumns) {
                throw new MyArraySizeException();
            }
        }

        int arraySum = 0;
        for (int i = 0; i < array.length; i++){
            for (int k = 0; k < array[i].length; k++){
                try {
                    arraySum += Integer.parseInt(array[i][k]);
                }
                catch (NumberFormatException exception) {
                    throw new MyArrayDataException("Ошибка преобразования String в int в ячейке: " + "[" + i + "]["+ k +"]: " + array[i][k]);
                }
            }
        }
        return arraySum;
    }
}

class MyArraySizeException extends Throwable {
    MyArraySizeException(){
        System.out.println("Размер массива не соответствует необходимому: [4][4]");
    }
}

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super(message);
    }
}