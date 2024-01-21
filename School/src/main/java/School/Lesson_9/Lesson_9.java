package School.Lesson_9;
import java.util.*;
import java.util.stream.Collectors;

public class Lesson_9 {
    public static void main(String[] args) {
        Expression func = (n) -> n%2 == 0;
        int [] numbers = {1,2,3,4,5,23412,234,1234};
        System.out.println(numberEven(numbers, func));

        ArrayList <String> stringList = new ArrayList<>();
        ArrayList <String> stringListTwo = new ArrayList<>();
        stringList.add("Highload");
        stringList.add("High");
        stringList.add("Load");
        stringList.add("Highload");
        ExpressionForWords funcTwo = Objects::equals;
        System.out.println(repetitionRate(stringList, funcTwo, "Highload"));

        ExpressionForPosition funcThree = (someStrings, n) -> {
            if (someStrings.isEmpty())
            {
                return "0";
            }
            else {
                return someStrings.get(n);
            }
        };
        System.out.println(funcThree.element(stringList, 0));
        System.out.println(funcThree.element(stringList, stringList.size()-1));
        System.out.println(funcThree.element(stringListTwo, 2));

        List <String> newList = new ArrayList<>();
        newList.add("f10");
        newList.add("a15");
        newList.add("f2");
        newList.add("f4");
        newList.add("f5");
        newList.add("b52");
        newList.add("a16");
        String[] sortedArray = sortAndConvertToArray(newList, customComparator);
        System.out.println(Arrays.toString(sortedArray));

        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );
        System.out.println(averageAge(students));
        conscriptList(students);

        System.out.println("\n");
        LoginReceiver.loginReceive();
    }

    // Определение чётных чисел
    public static int numberEven (int[] numbers, Expression func){
        int result = 0;
        for (int i : numbers)
        {
            if (func.isEqual(i)){
                result ++;
            }
        }
        return result;
    }
    // Сколько раз повторяется слово
    public static int repetitionRate (ArrayList <String> list, ExpressionForWords func, String target){
        int result = 0;
        for (String i : list)
        {
            if (func.isEqual(i, target)){
                result ++;
            }
        }
        return result;
    }
    // Сортировка по алфавиту и цифрам
    static Comparator<String> customComparator = Comparator
            .<String, String>comparing(s -> s.replaceAll("[^a-zA-Z]", ""))
            .thenComparing(s -> Integer.parseInt(s.replaceAll("\\D", "")));
    static <T> T[] sortAndConvertToArray(Collection<T> collection, Comparator<T> comparator) {
        List<T> sortedList = new ArrayList<>(collection);
        Collections.sort(sortedList, comparator);
        return sortedList.toArray((T[]) new String[0]);
    }
    interface Expression {
        boolean isEqual(int n);
    }
    interface ExpressionForWords {
        boolean isEqual(String n, String target);
    }
    interface ExpressionForPosition {
        String element(ArrayList<String> array, int position);
    }
    private enum Gender {
        MAN,
        WOMAN
    }
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;
        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public String getName() {
            return name;
        }
        public Integer getAge() {
            return age;
        }
        public Gender getGender() {
            return gender;
        }
        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
    // Средний возраст студента
    public static double averageAge (Collection<Student> students){
        return students.stream().mapToDouble(student -> student.getAge()).average()
                .orElse(Double.NaN);
    }
    // Список подлежащих призыву
    public static void conscriptList (Collection<Student> students){
        students.stream().filter(student -> student.getAge() < 28 & student.getAge() > 17 & student.getGender() != Gender.WOMAN).forEach(System.out::println);
    }
    // Задание 5
    public static class LoginReceiver {
        static void loginReceive() {
            List<String> loginList = new ArrayList<>();
            System.out.println("Введите логин: ");
            Scanner input = new Scanner(System.in);
            String login = input.nextLine();
            String str = "";
            while (true){
                if (Objects.equals(login, str)){
                    System.out.println("Вывод всех логинов на букву f");
                    loginList.stream().filter(s -> s.startsWith("f"))
                            .forEach(System.out::println);
                    break;
                }
                else {
                    loginList.add(login);
                    System.out.println("Введите ещё 1 логин: ");
                    login = input.nextLine();
                }
            }
        }
    }
}