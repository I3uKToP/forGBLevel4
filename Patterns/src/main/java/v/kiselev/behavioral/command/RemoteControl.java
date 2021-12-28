package v.kiselev.behavioral.command;

public class RemoteControl {

    void submit(Command command) {
        command.execute();
    }
}
