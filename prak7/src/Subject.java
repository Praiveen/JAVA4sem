import java.util.ArrayList;
import java.util.List;

// Интерфейс для общего поведения компонентов
interface Subject {
    void request();
}

// Реальный объект
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Да");
    }
}

// Заместитель
class Proxy implements Subject {
    private RealSubject realComponent;

    @Override
    public void request() {
        // Создание реального объекта при первом вызове
        if (realComponent == null) {
            realComponent = new RealSubject();
        }
        realComponent.request();// Выполнение операции через реальный объект
    }
}

// Компоновщик
class Client implements Subject {
    private List<Subject> components = new ArrayList<>();

    // Метод для добавления компонента в композицию
    void addComponent(Subject component) {
        components.add(component);
    }

    @Override
    public void request() {
        // Выполнение операции для всех компонентов в композиции
        for (Subject component : components) {
            component.request();
        }
    }
}
