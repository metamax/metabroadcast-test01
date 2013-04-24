import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntervalTest {

    @Test
    public void testIntervalCoverageOnFirstInterval() {
        Interval interval = new Interval(4.5f, 3.9f);
        checkBigDecimalEquality(interval.length(),"0.6");
    }

    @Test
    public void testIntervalCoverageOnSecondInterval() {
        Interval interval = new Interval(4.4f, 6.5f);
        checkBigDecimalEquality(interval.length(), "2.1");
    }

    @Test
    public void testIntervalCoverageOnIntervalWithNegativeNumbers() {
        Interval interval = new Interval(-5.0f, -7.3f);
        checkBigDecimalEquality(interval.length(), "2.3");
    }

    @Test
    public void testIsOverlappedOnOverlappedIntervals() {
        Interval interval = new Interval(4.4f, 6.5f);
        assertTrue(interval.isOverlapped(new Interval(4.5f, 3.9f)));
    }

    @Test
    public void testIsOverlappedOnFullContainedIntervals() {
        Interval interval = new Interval(4.4f, 6.5f);
        assertTrue(interval.isOverlapped(new Interval(7f, 4f)));
    }

    @Test
    public void testIsOverlappedOnNotOverlappedIntervals() {
        Interval interval = new Interval(4.4f, 6.5f);
        assertFalse(interval.isOverlapped(new Interval(-2f, -4f)));
    }

    @Test
    public void testJoin() {
        Interval interval = new Interval(4.4f, 6.5f);
        interval.join(new Interval(4.5f, 3.9f));

        checkBigDecimalEquality(interval.getStart(), "3.9");
        checkBigDecimalEquality(interval.getEnd(), "6.5");
    }

    private void checkBigDecimalEquality(BigDecimal actual, String expected) {
        assertTrue(actual.compareTo(new BigDecimal(expected)) == 0);
    }
}
