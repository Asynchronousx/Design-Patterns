
import java.util.ArrayList;
import java.util.List;

//Mediator interface
public interface Mediator {
    void sendMessage(User sender, String message);
    void addUser(User user);
}

//Colleague interface
interface User {
    void send(String message);
    void receive(String buffer);
}

//Chat mediator: our concrete mediator
class ChatMediator implements Mediator {
    private List<User> userList = new ArrayList<>();

    @Override
    public void sendMessage(User sender, String message) {
        for(User user: userList) {
            if(!user.equals(sender)) {
                user.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

}

//Chat user: our concrete user
class ChatUser implements User {
    private String nickname;
    private Mediator mediator;

    public ChatUser(String nickname, Mediator mediator) {
        this.nickname = nickname;
        this.mediator = mediator;
    }

    @Override
    public void send(String message) {
        mediator.sendMessage(this, this.getNickname() + ": " + message);
    }

    @Override
    public void receive(String buffer) {
        System.out.println("User::"+getNickname() + "-> " + buffer);
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
