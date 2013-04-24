import org.junit.Assert;
import org.junit.Test;

public class CoveredLengthTest {

    private static double delta = 0.000001;

    @Test
    public void testFindCoveredLengthWithNoOverlappedIntervals() {
        Interval[] intervalList = new Interval[2];

        intervalList[0] = new Interval(4.5f, 3.9f);
        intervalList[1] = new Interval(-5.0f, -7.3f);

        Assert.assertEquals(2.9, CoveredLength.findCoveredLength(intervalList), delta);
    }

    @Test
    public void testFindCoveredLengthWithOverlappedIntervals() {
        Interval[] intervalList = new Interval[3];

        intervalList[0] = new Interval(4.5f, 3.9f);
        intervalList[1] = new Interval(-5.0f, -7.3f);
        intervalList[2] = new Interval(4.4f, 6.5f);

        Assert.assertEquals(4.9, CoveredLength.findCoveredLength(intervalList), delta);
    }

    @Test
    public void testFindCoveredLengthWithFullContainedIntervals() {
        Interval[] intervalList = new Interval[2];

        intervalList[0] = new Interval(5.5f, 4.7f);
        intervalList[1] = new Interval(4.4f, 6.5f);

        Assert.assertEquals(2.1, CoveredLength.findCoveredLength(intervalList), delta);
    }

    @Test
    public void testFindCoveredLengthWithSameIntervals() {
        Interval[] intervalList = new Interval[2];

        intervalList[0] = new Interval(6.5f, 4.4f);
        intervalList[1] = new Interval(4.4f, 6.5f);

        Assert.assertEquals(2.1, CoveredLength.findCoveredLength(intervalList), delta);
    }
}
