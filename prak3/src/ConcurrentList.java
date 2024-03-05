import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentList<T> {
    private final List<T> list;
    private final Lock lock;

    public ConcurrentList() {
        list = new ArrayList<>();
        lock = new ReentrantLock(); // Используем ReentrantLock для синхронизации
    }

    public void add(T element) {
        lock.lock(); // Получаем блокировку перед добавлением элемента
        try {
            list.add(element);
        } finally {
            lock.unlock(); // Всегда освобождаем блокировку, даже если возникло исключение
        }
    }

    public boolean contains(T element) {
        lock.lock(); // Получаем блокировку перед выполнением операции чтения
        try {
            return list.contains(element);
        } finally {
            lock.unlock(); // Всегда освобождаем блокировку, даже если возникло исключение
        }
    }

    public boolean remove(T element) {
        lock.lock(); // Получаем блокировку перед удалением элемента
        try {
            return list.remove(element);
        } finally {
            lock.unlock(); // Всегда освобождаем блокировку, даже если возникло исключение
        }
    }

    public int size() {
        lock.lock(); // Получаем блокировку перед получением размера списка
        try {
            return list.size();
        } finally {
            lock.unlock(); // Всегда освобождаем блокировку, даже если возникло исключение
        }
    }

    public T get(int index) {
        lock.lock(); // Получаем блокировку перед получением элемента по индексу
        try {
            return list.get(index);
        } finally {
            lock.unlock(); // Всегда освобождаем блокировку, даже если возникло исключение
        }
    }
}
