import java.util.Arrays;

public class problem_2 {

    public static void main(String[] args) {
        sortNumbers(new int[] { 1, 5, 3, 2, 4 });
        sortNumbers(new int[] { 10, 5, 3, 2, 8, 1 });
        sortNumbers(new int[] { 0, -1, 10, 100, -50 });
        sortNumbers(new int[] { 5, 5, 4, 3, 2, 1 });
        sortNumbers(new int[] {});
    }

    private static void sortNumbers(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
