public class Main {
    public static void main(String[] args) {
        MyContainer<String> nameList = new MyContainer<>();
        nameList.add("Giovanni");
        nameList.add("Roberto");
        nameList.add("Alejandro");
        nameList.add("Scalfurio");
        nameList.add("Peppino");

        AbstractIterator it = nameList.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(it.first());
        System.out.println(it.cur());
        System.out.println(it.next());

    }
}
