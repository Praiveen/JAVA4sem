import java.util.ArrayList;
import java.util.List;

// Общий интерфейс для компонентов
interface Component {
    void operation();
}

// Листовой компонент
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + ": выполнение операции");
    }
}

// Компоновщик
class CompositeComp implements Component {
    private List<Component> children = new ArrayList<>();

    // Метод для добавления компонента в композицию
    public void add(Component component) {
        children.add(component);
    }

    // Метод для удаления компонента из композиции
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        // Выполнение операции для каждого компонента в композиции
        for (Component component : children) {
            component.operation();
        }
    }
}

