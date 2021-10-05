public class IterSum {
    private int[] arr;

    public IterSum(int[] arr) {
        this.arr = arr;
    }

    public int sumIter() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;

    }
}
