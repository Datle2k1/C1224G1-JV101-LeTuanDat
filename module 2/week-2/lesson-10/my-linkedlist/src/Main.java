//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinked = new MyLinkedList<>();

        System.out.println("Add '32' isSuccess: " + myLinked.add(32));
        System.out.println("Add 'str' isSuccess: " + myLinked.add("str"));
        System.out.println("Size : " + myLinked.size());
        myLinked.getAll();  // null , 32 , str

        System.out.println("\n---------------------");
        myLinked.add(1,12);
        myLinked.add(0,"first");
        myLinked.add(myLinked.size(),"last");
        myLinked.getAll();   // first , null , 12 , 32 , str , last

        System.out.println("\n---------------------");
        System.out.println("Remove element : " + myLinked.remove(3));
        myLinked.getAll(); // first , null , 12 , str , last
        System.out.println("Remove element : " + myLinked.remove(4));
        myLinked.getAll(); // first , null , 12 , str
        boolean isSuccess = myLinked.remove((Object) 12);
        System.out.println("Remove element : " + isSuccess);
        myLinked.getAll(); // first , null , 12 , str

        System.out.println("\n---------------------");
        System.out.println("Get with index " + myLinked.get(2));
//        System.out.println("Get with index " + myLinked.get(3));
        System.out.println("Get First : " + myLinked.getFirst());
        System.out.println("Get Last : " + myLinked.getLast());

        System.out.println("\n---------------------");
        System.out.println("Clear linked list");
        myLinked.clear();
    }
}