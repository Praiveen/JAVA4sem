// Интерфейс для состояния
interface State {
    void handle(Context context);
}

// Класс контекста
class Context {
    private State currentState;

    public Context(State initialState) {
        this.currentState = initialState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this);
    }
}

// Пример конкретного состояния
class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteStateA делает");
        // Меняем состояние контекста
        context.setState(new ConcreteStateB());
    }
}

// Еще одно конкретное состояние
class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteStateB делает");
    }
}