public class Count implements Runnable{
    private final Thread thread;

    public Count() {
        thread = new Thread(this, "Runnable count");
        thread.start();;
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < Main.END; i++) {
                System.out.println("Printing the count " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("My thread interrupted");
        }
        System.out.println("My thread run is over");
    }
}
