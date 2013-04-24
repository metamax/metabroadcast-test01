public class Test
{
    public static void main (String args[])
    {
        Interval[] intervalList = new Interval[3];

        intervalList[0] = new Interval(4.5f, 3.9f);
        intervalList[1] = new Interval(-5.0f, -7.3f);
        intervalList[2] = new Interval(4.4f, 6.5f);

        double lengthCovered = CoveredLength.findCoveredLength(intervalList);

        System.out.println("Total covered: " + lengthCovered);
    }
}