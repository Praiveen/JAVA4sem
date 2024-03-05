



public class App {
    public static void main(String[] args) throws Exception {
        // Получаем экземпляр Singleton
        Singleton2 singleton2 = Singleton2.getInstance();

        // Проверяем, что это действительно один и тот же объект
        System.out.println(singleton2);


        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton4 = Singleton3.getInstance();

        // Проверяем, что это действительно один и тот же объект
        System.out.println(singleton3 == singleton4);


        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ": " + singleton);
        };

        // Создаем несколько потоков
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        // Запускаем потоки
        thread1.start();
        thread2.start();

        Singleton4 firstInstance = Singleton4.getInstance();
        System.out.println(firstInstance.getClass());
     }
}
