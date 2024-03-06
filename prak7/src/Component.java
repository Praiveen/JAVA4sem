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

public class CompositePatternExample {
    public static void main(String[] args) {
        // Создание листовых компонентов
        Component leaf1 = new Leaf("Лист 1");
        Component leaf2 = new Leaf("Лист 2");
        Component leaf3 = new Leaf("Лист 3");

        // Создание компоновщика и добавление в него листовых компонентов
        Comp composite = new Comp();
        composite.add(leaf1);
        composite.add(leaf2);

        // Создание вложенного компоновщика
        Comp nestedComposite = new Comp();
        nestedComposite.add(leaf3);

        // Добавление вложенного компоновщика в основной компоновщик
        composite.add(nestedComposite);

        // Выполнение операции для основного компоновщика,
        // что приведет к выполнению операции для всех его дочерних компонентов
        composite.operation();
    }
}
