public class Main {
    public static void main(String[] args) {
        //Creating the auctioneer
        Observable auctioneer = new Auctioneer();

        //Creating the bidders
        Observer bidder1 = new Bidders(20);
        Observer bidder2 = new Bidders(15);
        Observer bidder3 = new Bidders(55);

        //Setting the auctioner
        ((Bidders) bidder1).setAuctioner(auctioneer);
        ((Bidders) bidder2).setAuctioner(auctioneer);
        ((Bidders) bidder3).setAuctioner(auctioneer);

        //Adding the bidders to the auctioneer
        auctioneer.add(bidder1);
        auctioneer.add(bidder2);
        auctioneer.add(bidder3);

        //update all the bidder with the best bidder
        auctioneer.update();

        //setting a new bid
        bidder1.setState(100);
        bidder2.setState(95);

    }
}
