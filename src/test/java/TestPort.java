import org.junit.Assert;
import org.junit.Test;

public class TestPort {
    @Test
    public void testMethod1() {
        String[] assertArray = {"1,3,4,5", "2", "3,4"};
        String[] indexes = {"1,3-5", "2", "3-4"};
        String[] resultAfterMethod1 = Port.sequencesOfNumbers(indexes);
        Assert.assertArrayEquals(assertArray, resultAfterMethod1);
    }

    @Test
    public void testMethod2() {
        int[][] assertArray = {{1, 2, 3}, {1, 2, 4}, {3, 2, 3}, {3, 2, 4}, {4, 2, 3}, {4, 2, 4}, {5, 2, 3}, {5, 2, 4}};
        String[] indexes = {"1,3-5", "2", "3-4"};
        int[][] resultAfterMethod2 = Port.permutationsToArrInt(Port.sequencesOfNumbers(indexes));
        Assert.assertArrayEquals(assertArray, resultAfterMethod2);
    }
}
