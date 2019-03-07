import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creating the observable (Subject)
        Observable newsAgency = new NewsAgency();
        List<NewsChannel> newsChannels = new ArrayList<>();

        //Creating 3 observer
        newsChannels.add(new NewsChannel("Channel 1"));
        newsChannels.add(new NewsChannel("Channel 2"));
        newsChannels.add(new NewsChannel("Channel 3"));

        //adding them to the Observable object
        newsChannels.forEach((n) -> newsAgency.add(n));

        //Setting a news
        newsAgency.setState("Asynchronousx learned Observer pattern!");

        //Displaying the news from channels:
        newsChannels.forEach((n) -> n.printNews());

    }
}
