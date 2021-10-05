import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class JoinPoolSum extends RecursiveTask<Integer> {

    private int[] arr;
    private int start;
    private int end;

    public JoinPoolSum(int start, int end, int[] arr) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        final int diff = end - start;
        switch (diff) {
            case 0:
                return 0;
            case 1:
                return arr[start];
            case 2:
                return arr[start] + arr[start + 1];
            default:
                return forkTasksAndGetResult();
        }
    }

    private int forkTasksAndGetResult() {
        final int middle = (end - start) / 2 + start;
        JoinPoolSum task1 = new JoinPoolSum(start, middle, arr);
        JoinPoolSum task2 = new JoinPoolSum(middle, end, arr);
        invokeAll(task1, task2);
        return task1.join() + task2.join();
    }
}
