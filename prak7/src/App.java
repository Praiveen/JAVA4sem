public class App {
    public static void main(String[] args) {
        
        Subject proxy = new Proxy(); // Создание заместителя
        proxy.request(); // Вызов операции через заместителя
        Client composite = new Client(); // Создание компоновщика
        composite.addComponent(new RealSubject()); // Добавление компонентов в композицию
        composite.addComponent(new RealSubject());
        composite.request(); // Вызов операции для компоновщика




        Component leaf1 = new Leaf("Лист 1");
        Component leaf2 = new Leaf("Лист 2");
        Component leaf3 = new Leaf("Лист 3");
        CompositeComp composite2 = new CompositeComp();// Создание компоновщика и добавление в него листовых компонентов
        composite2.add(leaf1);
        composite2.add(leaf2);
        CompositeComp nestedComposite = new CompositeComp();// Создание вложенного компоновщика
        nestedComposite.add(leaf3);

        composite2.add(nestedComposite);// Добавление вложенного компоновщика в основной компоновщик
        composite2.operation();// Выполнение операции для основного компоновщика для выволнения операции в дочерних 
    }
}
