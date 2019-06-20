public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enQueue(i);
            System.out.println(queue);

            if (i % 3 == 0) {
                queue.deQueue();
                System.out.println(queue);
            }
        }
    }
}
