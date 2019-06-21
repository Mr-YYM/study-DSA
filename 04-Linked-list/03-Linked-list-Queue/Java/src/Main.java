public class Main {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 3; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }

        queue.deQueue();
        System.out.println(queue);


    }

}
