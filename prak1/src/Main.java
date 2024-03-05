import java.util.function.Consumer;

public class Main implements Consumer<String> {

    @Override
    public void accept(String str) {
        StringBuilder sb = new StringBuilder();// StringBuilder для хранения результата
        for (int i = 0; i < str.length(); i++) { // Итератор проходит по строке
            if (i % 3 == 2) // Если индекс символа делится на 3 с остатком 2
                sb.append(Character.toUpperCase(str.charAt(i))); // Преобразуем символ в верхний регистр
            else// Добавляем символ без изменений
                sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str = "строка1строка1строка3";
        Main consumer = new Main();
        consumer.accept(str);
    }
}
