public class Main {

    public static void main(String[] args) throws InterruptedException {

        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {

                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
