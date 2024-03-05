// ThreadLocal сделан с потоками
// Создаем ThreadLocal переменную типа Singleton.
// При первом вызове getInstance() в каждом потоке создается новый экземпляр Singleton и сохраняется в ThreadLocal.
// При последующих вызовах getInstance() в том же потоке будет возвращаться сохраненный в ThreadLocal экземпляр
public class Singleton {
    // Создаем ThreadLocal переменную, которая будет хранить экземпляр Singleton для каждого потока
    private static final ThreadLocal<Singleton> threadLocalInstance = ThreadLocal.withInitial(Singleton::new);

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    private Singleton() {}

    // Метод, возвращающий экземпляр Singleton для текущего потока
    public static Singleton getInstance() {
        // Получаем экземпляр Singleton из ThreadLocal для текущего потока
        return threadLocalInstance.get();
    }
}