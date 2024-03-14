// Интерфейс для обработчика запроса
interface Handler {
    void handleRequest(Request request);
    void setNextHandler(Handler nextHandler);
}

// Класс запроса
class Request {
    private String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

// Пример конкретного обработчика
class ConcreteHandlerA implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getData().contains("A")) {
            System.out.println("ConcreteHandlerA сделал: " + request.getData());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Некому делать процесс: " + request.getData());
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Еще один конкретный обработчик
class ConcreteHandlerB implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getData().contains("B")) {
            System.out.println("ConcreteHandlerB сделал: " + request.getData());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Некому делать процесс: " + request.getData());
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
