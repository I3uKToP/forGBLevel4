package v.kiselev.behavioral.visitor;

public interface Animal {
    void accept(AnimalOperation operation);
}
