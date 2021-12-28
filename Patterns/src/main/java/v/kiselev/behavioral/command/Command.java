package v.kiselev.behavioral.command;

public interface Command {

    void execute();
    void undo();
    void redo();
}
