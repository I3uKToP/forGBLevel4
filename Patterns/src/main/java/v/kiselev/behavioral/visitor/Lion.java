package v.kiselev.behavioral.visitor;

public class Lion implements Animal{
    public void roar() {
        System.out.println("Roaaar!");
    }
    @Override
    public void accept(AnimalOperation operation) {
        operation.visit(this);
    }
}
