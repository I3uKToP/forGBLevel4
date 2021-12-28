package v.kiselev.behavioral.mediator;

import java.time.LocalDateTime;

public class ChatRoom implements ChatRoomMediator{
    @Override
    public void showMessage(User user, String message) {
        LocalDateTime now = LocalDateTime.now();
        String name = user.getName();
        System.out.println(now + " : " + name + " : " + message);
    }
}
