import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CustomExecutorService implements ExecutorService {
    private final ThreadPoolExecutor executor; // Поле для хранения пула потоков

    // Конструктор класса, принимает количество потоков в пуле
    public CustomExecutorService(int numThreads) { // Создание фиксированного пула потоков с заданным количеством потоков
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);
    }

    // Переопределение методов интерфейса ExecutorService

    // Завершает работу пула потоков
    @Override
    public void shutdown() {
        executor.shutdown();
    }

    // Принудительно завершает работу пула потоков, возвращает список невыполненных задач
    @Override
    public List<Runnable> shutdownNow() {
        return executor.shutdownNow();
    }

    // Проверяет, завершена ли работа пула потоков
    @Override
    public boolean isShutdown() {
        return executor.isShutdown();
    }

    // Проверяет, завершена ли работа всех потоков пула
    @Override
    public boolean isTerminated() {
        return executor.isTerminated();
    }

    // Ожидает завершения работы пула потоков в течение указанного времени
    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executor.awaitTermination(timeout, unit);
    }

    // Отправляет задачу на выполнение в пул потоков и возвращает Future для получения результата
    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    // Отправляет задачу на выполнение в пул потоков с возможностью получить результат
    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return executor.submit(task, result);
    }

    // Отправляет задачу на выполнение в пул потоков без возможности получить результат
    @Override
    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }

    // Выполняет набор задач и возвращает список Future с результатами
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return executor.invokeAll(tasks);
    }

    // Выполняет набор задач и возвращает список Future с результатами с ограничением времени
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return executor.invokeAll(tasks, timeout, unit);
    }

    // Выполняет одну из задач и возвращает результат
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return executor.invokeAny(tasks);
    }

    // Выполняет одну из задач с ограничением времени и возвращает результат
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return executor.invokeAny(tasks, timeout, unit);
    }

    // Отправляет задачу на выполнение в пул потоков
    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }
}
