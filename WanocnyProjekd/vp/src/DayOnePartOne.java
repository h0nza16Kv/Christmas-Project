public class DayOnePartOne {


    private int value;

    /**
     * Processes an input string and performs specific operations on the numbers in the string
     *
     * @param line An input line containing numbers
     */
    public void processLine(String line) {
        int first = -1;
        int last = -1;
        for (String a : line.split("")) {
            if (Character.isDigit(a.charAt(0))) {
                if (first == -1) {
                    first = Integer.parseInt(a);
                }
                last = Integer.parseInt(a);
            }
        }
        first *= 10;
        value += first + last;
    }

    /**
     * Returns the current value after processing the input lines
     *
     * @return value(total)
     */
    public int getValue() {
        return value;

    }


}
