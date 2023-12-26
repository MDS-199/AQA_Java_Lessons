package School.Lesson_4;

public class Lesson_4_1 {
    public static void main(String[] args) {

        class Person {
            String fio, jobTitle, email;
            long phoneNumber;
            double salary;
            int age;

            public Person(){
                this.fio = "Ivanov Ivan Ivanovich";
                this.jobTitle = "Slesar KIPiA";
                this.email = "Ivanov@yandex.ru";
                this.phoneNumber = 8912332660L;
                this.salary = 30000.0;
                this.age = 18;
            }
            public Person(String fio, String jobTitle, String email, long phoneNumber, double salary, int age){
                this.fio = fio;
                this.jobTitle = jobTitle;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.salary = salary;
                this.age = age;
            }

            void showEmploye(){
                System.out.println("ФИО: " + fio);
                System.out.println("Должность: " + jobTitle);
                System.out.println("Email: " + email);
                System.out.println("Номер телефона: " + phoneNumber);
                System.out.println("Зарплата: " + salary);
                System.out.println("Возраст: " + age);
                System.out.println("\n");
            }
        }

        Person[] personArray = new Person[5];
        personArray[0] = new Person();
        personArray[1] = new Person("Petrov Sergei", "Director", "Petrov@mail.ru", 123438437L, 1000000.0, 52);
        personArray[2] = new Person("Ibragimov Radmir", "Zamestitel Directora", "Ibragimov@mail.ru", 891238437L, 100000.0, 42);
        personArray[3] = new Person("Chehov Ignat", "Content Maker", "Chehov@mail.ru", 651238437L, 70000.0, 32);
        personArray[4] = new Person("Malashenko Vladimir", "Marketolog", "Malashenko@mail.ru", 6881238437L, 50000.0, 22);
        personArray[0].showEmploye();
        personArray[1].showEmploye();
        personArray[2].showEmploye();
        personArray[3].showEmploye();
        personArray[4].showEmploye();

        class Park{
            String attractions;
            class Attraction{
                String attractionName, workingTime;
                Double priceAttraction;

                public Attraction(){
                    this.attractionName = "Default Attraction";
                    this.workingTime = "Default Time";
                    this.priceAttraction = 500.0;
                }

                public Attraction(String attractionName, String workingTime, double priceAttraction){
                    this.attractionName = attractionName;
                    this.workingTime = workingTime;
                    this.priceAttraction = priceAttraction;
                }
            }
        }

        Park newPark = new Park();
        newPark.attractions = "Many of them";
        System.out.println(newPark.attractions);
        System.out.println("\n");

        Park.Attraction firstAttraction = new Park().new Attraction();
        System.out.println(firstAttraction.attractionName);
        System.out.println(firstAttraction.workingTime);
        System.out.println(firstAttraction.priceAttraction);

        Park.Attraction secondAttraction = new Park().new Attraction("Good Attraction", "From 8:00 to 17:00", 350.0);
        System.out.println(secondAttraction.attractionName);
        System.out.println(secondAttraction.workingTime);
        System.out.println(secondAttraction.priceAttraction);
    }
}