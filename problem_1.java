import java.util.ArrayList;

public class problem_1 {
    public static void main(String[] args) {
        intersectionArrays(new int[] { 1, 2, 3 }, new int[] { 2, 3, 4 });
        intersectionArrays(new int[] { 1, 2, 3 }, new int[] { 1, 2, 5 });
        intersectionArrays(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 });
        intersectionArrays(new int[] {}, new int[] {});
    }

    private static void intersectionArrays(int[] arr1, int[] arr2) {
        ArrayList<Integer> intersectionArray = new ArrayList<Integer>();

        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) {
                    intersectionArray.add(i);
                }
            }
        }

        System.out.println(intersectionArray);
    }
}