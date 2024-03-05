// паттерна Singleton называется Предварительная инициализация
// непосредственно при загрузке класса, а не при первом вызове метода getInstance()
public class Singleton2 {
    // Статическая переменная, в которой хранится единственный экземпляр Singleton
    private static final Singleton2 instance = new Singleton2();

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    private Singleton2() {}

    // Метод, возвращающий экземпляр Singleton
    public static Singleton2 getInstance() {
        // Просто возвращаем предварительно созданный экземпляр Singleton
        return instance;
    }
}
