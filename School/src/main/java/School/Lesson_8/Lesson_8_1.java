package School.Lesson_8;
import java.util.*;

public class Lesson_8_1 {
    public static void main(String[] args) {
        String[] newArray = {"Апельсин", "Танжерин", "Помело", "Апельсин", "Апельсин", "Мандарин", "Помело", "Грейпфрут", "Апельсин", "Просто цитрус", "Лимон", "Кумкват", "Лайм", "Померанец", "Цитрон", "Клементин"};
        WordsCounter.findUniqueWords(newArray);
        System.out.println("\n");

        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.add("Васнецов", 88005553535L);
        newPhoneBook.get("Васнецов");
        newPhoneBook.add("Кузнецов", 89005553535L);
        newPhoneBook.add("Васнецов", 87005553535L);
        newPhoneBook.get("Кузнецов");
        newPhoneBook.get("Васнецов");
        newPhoneBook.get("Иванов");
    }

    static class WordsCounter {
        static void findUniqueWords(String[] wordsArray) {
            ArrayList<String> fromArray = new ArrayList<>(Arrays.asList(wordsArray));
            Collections.sort(fromArray);
            Set<String> uniqueSet = new HashSet<>(fromArray);
            System.out.println("Вывод коллекции, состоящей только из уникальных слов массива:");
            System.out.println(uniqueSet);
            System.out.println("\n");

            System.out.println("Вывод расчёта, сколько раз повторяется каждое слово в массиве");
            List<String> list = fromArray;
            ListIterator<String> iter = list.listIterator();
            String current = null;
            int counter = 1;
            while (iter.hasNext()) {
                String next = iter.next();
                if (current != null && current.equals(next)) {
                    counter++;
                } else {
                    if (current != null) {
                        System.out.println(current + ", количество повторений: " + counter);
                    }
                    counter = 1;
                    current = next;
                }
            }
            if (current != null) {
                System.out.println(current + ", количество повторений: " + counter);
            }
        }
    }

    public static class PhoneBook {
        HashMap<String, List<Long> > phoneBook = new HashMap<>();
        List<Long> personNumbers = new ArrayList<>();
        Long current = null;
        void add(String name, Long number){
            if (phoneBook.containsKey(name) && personNumbers.contains(number)) {
                System.out.println("Данный номер: " + number + " уже внесён в справочник");
                return;
            } else if (phoneBook.containsKey(name)) {
                List<Long> thisPersonNumbers = phoneBook.get(name);
                personNumbers.addAll(thisPersonNumbers);
                personNumbers.add(number);
                phoneBook.put(name, personNumbers);
            } else {
                List<Long> personNumbers = new ArrayList<>();
                personNumbers.add(number);
                phoneBook.put(name, personNumbers);
            };
        }

        void get (String name){
            if (phoneBook.containsKey(name)) {
                System.out.println("Список номеров по фамилии " + name + ":" + phoneBook.get(name));
            }
            else {
                System.out.println("Данная фамилия отсутствует в телефонном справочнике");
            }
        }
    }
}