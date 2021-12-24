package v.kiselev.behavioral.visitor;

public class Jump implements AnimalOperation{
    @Override
    public void visit(Monkey monkey) {
        System.out.println("Jumped 20 feet high! on to the tree!");
    }

    @Override
    public void visit(Lion lion) {
        System.out.println("Jumped 7 feet! Back on the ground!");
    }

    @Override
    public void visit(Dolphin dolphin) {
        System.out.println("Walked on water a little and disappeared");
    }
}
