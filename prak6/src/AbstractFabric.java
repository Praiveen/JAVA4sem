// Интерфейс для продукта A
interface AbstractProductA {
    void operationA();
}

// Интерфейс для продукта B
interface AbstractProductB {
    void operationB();
}

// Абстрактная фабрика
interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

// Конкретная реализация продукта A1
class ConcreteProductA1 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("ConcreteProductA1 operation");
    }
}

// Конкретная реализация продукта B1
class ConcreteProductB1 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("ConcreteProductB1 operation");
    }
}

// Конкретная реализация абстрактной фабрики
class ConcreteFactory1 implements AbstractFactory {
    // Реализация создания продукта A1
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    // Реализация создания продукта B1
    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}