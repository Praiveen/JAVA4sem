import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human(34, "Иван", "Иванов", LocalDate.of(1900, 1, 2), 50),
                new Human(18, "Петр", "Петров", LocalDate.of(2006, 1, 3), 60),
                new Human(17, "Сергей", "Сергеев", LocalDate.of(2007, 3, 4), 70),
                new Human(23, "Федор", "Федоров", LocalDate.of(2001, 4, 5), 80)
        );
        // Сортировка людей по возрасту
        List<Human> sortedByAge = humans.stream()
                .sorted((human1, human2) -> Integer.compare(human1.getAge(), human2.getAge())) // Сортировка по возрасту
                .collect(Collectors.toList()); // Сохранение отсортированного списка
        System.out.println("По возрасту:");
        sortedByAge.forEach(System.out::println); // Вывод отсортированных людей по возрасту

        // Фильтрация по возрасту меньше 20
        List<Human> ageLessThan20 = humans.stream()
                .filter(human -> human.getAge() < 20) // Фильтрация по возрасту меньше 20
                .collect(Collectors.toList()); // Сохранение отфильтрованного списка
        System.out.println("\nВозраст меньше 20: ");
        ageLessThan20.forEach(System.out::println); // Вывод людей с возрастом меньше 20

        // Фильтрация по е
        List<Human> nameContainsE = humans.stream()
                .filter(human -> human.getFirstName().toLowerCase().contains("е")) // Фильтрация по имени, содержащему 'e'
                .collect(Collectors.toList()); // Сохранение отфильтрованного списка
        System.out.println("\nЕсть е: ");
        nameContainsE.forEach(System.out::println); // Вывод людей с именем, содержащим 'e'

        // Конкатенация первых букв имен
        String initials = humans.stream()
                .map(human -> String.valueOf(human.getFirstName().charAt(0))) // Извлечение первой буквы из имени
                .collect(Collectors.joining()); // Конкатенация первых букв имен
        System.out.println("\nконкатенированных первых букв имен: " + initials); // Вывод конкатенированных первых букв имен
    }
}
