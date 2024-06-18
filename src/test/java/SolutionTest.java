import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[] power = {1,1,3,4};
        long expected= 6;
        long actual = new Solution().maximumTotalDamage(power);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int[] power = {1,3,4, 7 , 10};
        long expected = 22;
        long actual = new Solution().maximumTotalDamage(power);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test3() {
        int[] power = {2, 1, 4, 3, 1, 1, 1, 5};
        long expected = 9;
        long actual = new Solution().maximumTotalDamage(power);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test4() {
        int[] power = {5,1,5,7,3,5,6,10,9};
        long expected = 26;
        long actual = new Solution().maximumTotalDamage(power);

        Assert.assertEquals(expected, actual);
    }
}
