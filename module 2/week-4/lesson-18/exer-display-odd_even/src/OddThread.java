public class OddThread extends Thread{
    private final Thread thread;

    public OddThread() {
        thread = new Thread(this,"Odd Thread");
        System.out.println("Created " + thread.getName());
    }

    public void start() {
        thread.start();
        System.out.println(thread.getName() + " started");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) System.out.println(thread.getName() + ", Number : " + i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
