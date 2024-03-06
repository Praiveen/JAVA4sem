// Интерфейс для создаваемых объектов
interface ProductFabric {
    void operation();
}

// Родительский класс с фабричным методом
abstract class Creator {
    // Фабричный метод, который должны реализовать подклассы
    abstract ProductFabric factoryMethod();
    
    // Метод, использующий фабричный метод для создания объекта
    void someOperation() {
        ProductFabric product = factoryMethod();
        product.operation();
    }
}

// Конкретная реализация продукта
class ConcreteProduct implements ProductFabric {
    @Override
    public void operation() {
        System.out.println("ConcreteProduct operation");
    }
}

// Конкретная реализация создателя
class ConcreteCreator extends Creator {
    // Реализация фабричного метода для создания конкретного продукта
    @Override
    ProductFabric factoryMethod() {
        return new ConcreteProduct();
    }
}