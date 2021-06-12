import java.util.LinkedList;

public class PC {

    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 5;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {

                while (list.size() == capacity) {
                    System.out.println("Queue limit reached. Waiting for consumer\n\n");
                    wait();
                }

                System.out.println("Producer produced - " + value);

                list.add(value++);
                notify();

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    System.out.println("Queue is Empty. Waiting for \n\n");
                    wait();
                }

                int val = list.removeFirst();
                System.out.println("Consumer consumed - " + val);

                notify();
                Thread.sleep(1000);
            }
        }
    }
}