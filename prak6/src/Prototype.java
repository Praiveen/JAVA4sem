// Прототип
class Prototype implements Cloneable {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        // Вызов метода клонирования из класса Object
        return (Prototype) super.clone();
    }
    
    // Операция, которую выполняет прототип
    void operation() {
        System.out.println("Prototype operation");
    }
}