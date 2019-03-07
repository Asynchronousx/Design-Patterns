import java.util.ArrayList;
import java.util.List;

//Observer interface
public interface Observer {
    void update(String update);
}

//Observable interface
interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void update();
    void setState(String state);
}

//News agency is the one who observe the observer object (NewsAgency is then the Observable):
//It does have sense because when the news channel got an updated news (for example, the price of
    //the orange juice went up), it should inform all the observer for this change, to let them display the news.
//We then use Observables object to inform all the observer one, and observer to display the updated news of
//the observable.
class NewsAgency implements Observable {
    //The string news is equal to the state of the observable.
    String news = "";
    List<Observer> channelList = new ArrayList<>();

    @Override
    public void setState(String news) {
        this.news = news;
        update();
    }

    @Override
    public void add(Observer observer) {
        this.channelList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.channelList.remove(observer);
    }

    @Override
    public void update() {
        for(Observer o: channelList) {
            o.update(news);
    }
}

//NewsChannel is the observer, the one who get updated about news by the observable object.
class NewsChannel implements Observer {
    //The string news is equal to the state of the observer.
    private String news = "";
    public String channelName;

    public NewsChannel(String name) {
        this.channelName = name;
    }

    @Override
    public void update(String update) {
        this.news = update;
    }

    public void printNews() {
        System.out.println(channelName + " news: " + news);
    }
}

        }