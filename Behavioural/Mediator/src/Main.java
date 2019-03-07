public class Main {
    public static void main(String[] args) {
        //Defining a common mediator
        Mediator mediator = new ChatMediator();

        //Defining users
        User user1 = new ChatUser("John doe", mediator);
        User user2 = new ChatUser("Apple boy", mediator);
        User user3 = new ChatUser("Test man", mediator);
        User user4 = new ChatUser("Chicko", mediator);

        //Adding user to mediator
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        //Chatting
        user1.send("Hello!");
        user2.send("Hey there!");
        user3.send("User 3 here!");
        user4.send("Nice to meet you.");

    }
}
