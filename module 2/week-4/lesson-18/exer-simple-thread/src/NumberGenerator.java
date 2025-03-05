public class NumberGenerator implements Runnable{
    private final String name;

    public NumberGenerator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ": Number ; " + i);
                Thread.sleep(500);
                System.out.println(name + ": HashCode : " + this.hashCode());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
