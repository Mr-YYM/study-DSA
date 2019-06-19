public class Main {
    public static void main(String[] args) {
        // 声明数组变量、开辟数组空间、必须声明数组的大小
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100, 99, 66};
        for (int score : scores) {
            System.out.println(score);
        }

        scores[0] = 98;
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
