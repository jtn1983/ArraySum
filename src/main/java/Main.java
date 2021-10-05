import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000000];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
            //System.out.println(arr[i]);
        }

        JoinPoolSum joinPoolSum = new JoinPoolSum(0, arr.length, arr);

        System.out.println(System.currentTimeMillis());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(joinPoolSum));
        System.out.println(System.currentTimeMillis());


        System.out.println(System.currentTimeMillis());
        System.out.println(new IterSum(arr).sumIter());
        System.out.println(System.currentTimeMillis());
    }

//    public static int sumRec(int i, int[] arr) {
//        if (i == arr.length - 1) {
//            return arr[i];
//        }
//        return arr[i] + sum(i + 1, arr);
//    }


}
