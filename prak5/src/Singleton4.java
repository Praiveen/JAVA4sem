// Класс MySingleton реализует паттерн Singleton с использованием внутреннего класса SingletonHolder
// Приватный конструктор класса MySingleton гарантирует, что никто извне класса не сможет создать экземпляр этого класса
public class Singleton4 {
    // Приватный конструктор класса
    private Singleton4() {
        // Вывод сообщения при создании экземпляра
        System.out.println("Singleton created!");
    }

    // Внутренний статический класс, который содержит статическое поле с единственным экземпляром Singleton
    private static class SingletonHolder {
        // Статическое поле, инициализированное экземпляром Singleton
        public static final Singleton4 HOLDER_INSTANCE = new Singleton4();
    }

    // Статический метод, предоставляющий глобальную точку доступа к экземпляру Singleton
    public static Singleton4 getInstance() {
        // При первом вызове метода getInstance() будет создан и сохранен экземпляр Singleton в SingletonHolder
        // Последующие вызовы вернут этот сохраненный экземпляр
        return SingletonHolder.HOLDER_INSTANCE;
    }
}