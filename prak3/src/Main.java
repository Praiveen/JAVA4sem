public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentList<Integer> safeList = new ConcurrentList<>();

        // Добавляем элементы в список
        safeList.add(1);
        safeList.add(2);
        safeList.add(3);

        // Проверяем наличие элемента
        System.out.println("содержит 3: " + safeList.contains(3));
        System.out.println("содержит 4: " + safeList.contains(4));

        // Удаляем элемент
        System.out.println("удалить 3: " + safeList.remove(3));
        System.out.println("содержит 3: " + safeList.contains(3));

        // Получаем размер списка
        System.out.println("размер " + safeList.size());


        ConcurrentSet<Integer> safeSet = new ConcurrentSet<>();

        safeSet.add(1);
        safeSet.add(2);
        safeSet.add(3);

        // Проверяем наличие элемента
        System.out.println("содержит 3: " + safeSet.contains(3));
        System.out.println("содержит 4: " + safeSet.contains(4));

        // Удаляем элемент
        System.out.println("удалить 3: " + safeSet.remove(3));
        System.out.println("содержит 3: " + safeSet.contains(3));

        // Получаем размер множества
        System.out.println("размер: " + safeSet.size());
    }
}
