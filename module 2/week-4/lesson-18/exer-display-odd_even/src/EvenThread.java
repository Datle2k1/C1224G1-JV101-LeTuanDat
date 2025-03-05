public class EvenThread implements Runnable{
    private final Thread thread;

    public EvenThread() {
        thread = new Thread(this,"Even Thread");
        System.out.println("Created Even Thread");
    }

    public void start() {
        thread.start();
        System.out.println(thread.getName() + " started");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) System.out.println(thread.getName() + ", Number : " + i);
                Thread.sleep(15);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
