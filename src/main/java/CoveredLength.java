import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CoveredLength {
    public static double findCoveredLength(Interval[] intervals) {
        BigDecimal coveredLength = new BigDecimal(0);

        for (Interval interval: getNotOverlappedIntervals(intervals)) {
            coveredLength = coveredLength.add(interval.length());
        }

        return coveredLength.doubleValue();
    }

    private static Set<Interval> getNotOverlappedIntervals(Interval[] intervals) {
        Set<Interval> notOverlappedIntervals = new HashSet<Interval>();

        for (Interval interval : intervals) {
            notOverlappedIntervals = checkOverlappingAndJoin(notOverlappedIntervals, interval);
        }

        return notOverlappedIntervals;
    }

    private static Set<Interval> checkOverlappingAndJoin(final Set<Interval> intervals, final Interval newInterval) {
        Set<Interval> notOverlappedIntervals = new HashSet<Interval>();

        for (Interval interval: intervals) {
            if (interval.isOverlapped(newInterval)) {
                newInterval.join(interval);
            }
            else {
                notOverlappedIntervals.add(interval);
            }
        }

        notOverlappedIntervals.add(newInterval);

        return notOverlappedIntervals;
    }

}
