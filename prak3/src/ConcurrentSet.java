import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class ConcurrentSet<T> {
    private final Set<T> set;
    private final Semaphore semaphore;

    public ConcurrentSet() {
        set = new HashSet<>();
        semaphore = new Semaphore(1); // Используем один семафор
    }

    public void add(T element) throws InterruptedException {
        semaphore.acquire(); // Захватываем семафор перед внесением изменений
        try {
            set.add(element);
        } finally {
            semaphore.release(); // Освобождаем семафор после внесения изменений
        }
    }

    public boolean contains(T element) throws InterruptedException {
        semaphore.acquire(); // Захватываем семафор перед чтением из множества
        try {
            return set.contains(element);
        } finally {
            semaphore.release(); // Освобождаем семафор после чтения из множества
        }
    }

    public boolean remove(T element) throws InterruptedException {
        semaphore.acquire(); // Захватываем семафор перед удалением элемента
        try {
            return set.remove(element);
        } finally {
            semaphore.release(); // Освобождаем семафор после удаления элемента
        }
    }

    public int size() throws InterruptedException {
        semaphore.acquire(); // Захватываем семафор перед получением размера множества
        try {
            return set.size();
        } finally {
            semaphore.release(); // Освобождаем семафор после получения размера множества
        }
    }
}
