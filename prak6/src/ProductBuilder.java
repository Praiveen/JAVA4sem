// Продукт, который строится
class ProductBuilder {
    private String part1;
    
    public void setPart1(String part1) {
        this.part1 = part1;
    }
    
    public void show() {
        System.out.println("Part 1: " + part1);
    }
}

// Интерфейс строителя
interface Builder {
    void buildPart1();
    ProductBuilder getProduct();
}

//строитель
class ConcreteBuilder implements Builder {
    private ProductBuilder product = new ProductBuilder();

    @Override
    public void buildPart1() {
        product.setPart1("Part 1 built"); // Сборка части 1 продукта
    }

    @Override
    public ProductBuilder getProduct() {
        return product; // Возврат готового продукта
    }
}

// Директор, который управляет строителем
class Director {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder; // Установка конкретного строителя
    }
    // Метод для построения продукта
    public void construct() {
        builder.buildPart1();// Вызов методов строителя для сборки продукта
    }
}
