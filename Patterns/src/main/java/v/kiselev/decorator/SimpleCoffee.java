package v.kiselev.decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public Integer getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}
