public class App {
    public static void main(String[] args) {
        // Создаем контекст и устанавливаем начальное состояние
        Context context = new Context(new ConcreteStateA());

        // Выполняем запросы, которые должны обрабатываться текущим состоянием
        context.request();
        context.request();

        // Состояние, Цепочка обязанностей.



        // Создаем обработчики и устанавливаем их в цепочку
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNextHandler(handlerB);

        // Создаем запросы и отправляем их на обработку
        Request request1 = new Request("A");
        Request request2 = new Request("B");
        Request request3 = new Request("C");

        handlerA.handleRequest(request1);
        handlerA.handleRequest(request2);
        handlerA.handleRequest(request3);
    }
}
