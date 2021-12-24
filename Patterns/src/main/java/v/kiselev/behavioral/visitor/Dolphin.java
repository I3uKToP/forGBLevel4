package v.kiselev.behavioral.visitor;

public class Dolphin implements Animal {
    public void speak() {
        System.out.println("Tuut tuttu tuutt!");
    }
    @Override
    public void accept(AnimalOperation operation) {
        operation.visit(this);
    }
}