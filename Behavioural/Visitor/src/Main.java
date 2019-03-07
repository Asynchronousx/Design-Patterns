public class Main {
    public static void main(String[] args) {
        //Declaring two visitor
        Visitor kellogsStand = new KellogsStand();
        Visitor heinzStand = new HeinzStand();

        //Creating the SuperMarket class and adding the Walmart and Acme market.
        SuperMarket superMarket = new SuperMarket();
        superMarket.superMarketList.add(new Walmart());
        superMarket.superMarketList.add(new AcmeMarket());

        //accepting the visitors and let them doing the operation
        superMarket.accept(kellogsStand);
        superMarket.accept(heinzStand);

    }
}
