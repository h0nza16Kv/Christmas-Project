import java.math.BigInteger;

public class DaySix {

    /**
     * A method that calculates the number of broken records depending on the specified time and record
     *
     * @param time   the time in which you want to measure breaking the record
     * @param record The current record you are trying to beat
     * @return Number of records broken
     */
    public static int numOfTimToBeat(int time, int record) {
        int w = 0;

        for (int i = 0; i < time; ++i) {
            int timeLeft = time - i;
            if (i * timeLeft > record) {
                w++;
            }
        }

        return w;
    }

    /**
     * A method that calculates the number of broken records depending on the specified time and record
     *
     * @param time   the time in which you want to measure breaking the record
     * @param record The current record you are trying to beat
     * @return Number of records broken
     */
    public static long numOfTimToBeat1(long time, BigInteger record) {
        long w = 0;
        for (int i = 0; i < time; i++) {
            BigInteger timeLeft = BigInteger.valueOf(time - i);
            if (timeLeft.multiply(BigInteger.valueOf(i)).compareTo(record) > 0) {
                w++;
            }
        }
        return w;
    }


}