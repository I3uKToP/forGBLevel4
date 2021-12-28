package v.kiselev.behavioral.visitor;

public interface AnimalOperation {
    void visit(Monkey monkey);
    void visit(Lion lion);
    void visit(Dolphin dolphin);
}
