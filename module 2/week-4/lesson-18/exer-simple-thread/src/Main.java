//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NumberGenerator generator1 = new NumberGenerator("Generator 1");
        NumberGenerator generator2 = new NumberGenerator("Generator 2");

        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);

//        thread1.setPriority(Thread.MAX_PRIORITY);
//        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}