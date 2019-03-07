import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void update(Integer update);
    Integer getState();
    void setState(Integer state);
}

interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void update();
    Integer getState();
    void setState(Integer state);
}

class Auctioneer implements Observable {
    private Integer highestBid = 0;
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        this.observerList.add(observer);
        System.out.println("Adding new bidder. His bid: " + observer.getState() + ", Best bid: " + highestBid);
        if(observer.getState() > highestBid) {
            highestBid = observer.getState();
            System.out.println("New Highest Bid! -> " + observer.getState());
        }
    }

    @Override
    public void remove(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void update() {
        for(Observer o: observerList) {
            o.update(getState());
        }
    }

    @Override
    public Integer getState() {
        return highestBid;
    }

    @Override
    public void setState(Integer highestBid) {
        if(highestBid > this.highestBid) {
            System.out.println("New highest bid! Last: " + this.highestBid + ", Current: " + highestBid);
            this.highestBid = highestBid;
            update();
        }
    }

}

class Bidders implements Observer {
    private Integer highestBid;
    private Integer myBid;
    private Observable auctioneer;

    public Bidders(Integer myBid) {
        this.myBid = myBid;
    }

    public void setState(Integer myBid) {
        if(auctioneer.getState().compareTo(myBid) > 0) {
            System.out.println("You must bid more than " + myBid +  ". Current highest bid: " + auctioneer.getState());
        } else {
            this.myBid = myBid;
            auctioneer.setState(myBid);
        }
    }

    public void setAuctioner(Observable auctioneer) {
        this.auctioneer = auctioneer;
    }

    @Override
    public void update(Integer update) {
        this.highestBid = update;
    }

    @Override
    public Integer getState() {
        return myBid;
    }
}
