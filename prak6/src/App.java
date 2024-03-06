public class App {
    public static void main(String[] args) {

        // Создание конкретного создателя
        Creator creator = new ConcreteCreator();
        // Вызов метода, который использует фабричный метод
        creator.someOperation();



        // Создание конкретной фабрики
        AbstractFactory factory = new ConcreteFactory1();
        // Создание семейства продуктов A и B
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
        // Вызов операций для продуктов
        productA.operationA();
        productB.operationB();





        Builder builder = new ConcreteBuilder();
        Director director = new Director();// Создание директора и передача ему строителя
        director.setBuilder(builder); 
        director.construct();// Запуск процесса построения продукта
        ProductBuilder product = builder.getProduct(); // Получение готового продукта от строителя
        product.show();// Вывод информации о продукте


        
        Prototype prototype = new Prototype();
        try {
            // Клонирование прототипа
            Prototype clonedPrototype = prototype.clone();
            // Выполнение операции с клонированным прототипом
            clonedPrototype.operation();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



    }
}