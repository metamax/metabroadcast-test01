import java.math.BigDecimal;

public class Interval {
    private BigDecimal start;
    private BigDecimal end;

    public Interval(float extremity1, float extremity2) {
        BigDecimal bdExtremity1 = new BigDecimal(Float.toString(extremity1));
        BigDecimal bdExtremity2 = new BigDecimal(Float.toString(extremity2));

        this.start = bdExtremity1.min(bdExtremity2);
        this.end = bdExtremity1.max(bdExtremity2);
    }

    public BigDecimal length() {
        return end.subtract(start).abs();
    }

    public BigDecimal getStart() {
        return start;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public boolean isOverlapped(Interval that) {
        assert (that != null) : "The input interval must be not null";

        boolean startIncluded = this.start.compareTo(that.start) == 1 && this.start.compareTo(that.end) == -1;
        boolean endIncluded = this.end.compareTo(that.start) == 1 && this.end.compareTo(that.end) == -1;
        boolean thisIncludesThat = this.start.compareTo(that.start) <= 0 && this.end.compareTo(that.end) >= 0;

        return startIncluded || endIncluded || thisIncludesThat;
    }

    public void join(Interval that) {
        assert (this.isOverlapped(that)) : "The input interval doesn't overlap";

        this.start = this.start.min(that.start);
        this.end = this.end.max(that.end);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        Interval thatInterval = (Interval) that;

        if (end.compareTo(thatInterval.end) != 0) return false;
        if (start.compareTo(thatInterval.start) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }
}
