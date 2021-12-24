package v.kiselev.behavioral.visitor;

public class Speak implements AnimalOperation{
    @Override
    public void visit(Monkey monkey) {
        monkey.shout();
    }

    @Override
    public void visit(Lion lion) {
        lion.roar();
    }

    @Override
    public void visit(Dolphin dolphin) {
        dolphin.speak();
    }
}
