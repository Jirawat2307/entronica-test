import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem_3 {

    public static void main(String[] args) {
        findPairs(new int[] { 1, 2, 3, 4, 5 }, 6);
        findPairs(new int[] { 1, 2, 3, 4, 5 }, 8);
        findPairs(new int[] { 1, 1, 2, 2, 3, 3 }, 4);
        findPairs(new int[] { -2, -1, 0, 1, 2, 3 }, 1);
    }

    private static void findPairs(int[] arr, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        Arrays.sort(arr);

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            int sum = arr[leftIndex] + arr[rightIndex];

            if (sum == target) {
                pairs.add(Arrays.asList(arr[leftIndex], arr[rightIndex]));
                leftIndex++;
                rightIndex--;
            } else if (sum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        System.out.println(pairs);
    }
}
