// реализации паттерна Singleton называется проверка блокировки дважды.
//  Он является эффективным способом ленивой инициализации Singleton с минимальным влиянием на производительность.

public class Singleton3 {
    // Объявляем volatile переменную, чтобы гарантировать видимость переменной instance для всех потоков
    private static volatile Singleton3 instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    private Singleton3() {}

    // Метод, возвращающий экземпляр Singleton
    public static Singleton3 getInstance() {
        // Первая проверка на null для улучшения производительности
        if (instance == null) {
            // Синхронизация для потокобезопасности только при первом вызове
            synchronized (Singleton3.class) {
                // Проверка instance на null внутри синхронизированного блока
                if (instance == null) {
                    // Создаем экземпляр Singleton только если его еще нет
                    instance = new Singleton3();
                }
            }
        }
        // Возвращаем экземпляр Singleton
        return instance;
    }
}
