import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] indexes = {"1,3-5", "2", "3-4"};
        String[] resultAfterMethod1 = Port.sequencesOfNumbers(indexes);
        System.out.println(Arrays.toString(resultAfterMethod1));
        int[][] resultAfterMethod2 = Port.permutationsToArrInt(resultAfterMethod1);
        System.out.println(Arrays.deepToString(resultAfterMethod2));
    }
}
