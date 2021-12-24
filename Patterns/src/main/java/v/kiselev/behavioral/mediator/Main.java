package v.kiselev.behavioral.mediator;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User john = new User("John Doe", chatRoom);
        User jane = new User("Jane Doe", chatRoom);
        john.send("Hi there!");
        jane.send("Hey");
    }
}
