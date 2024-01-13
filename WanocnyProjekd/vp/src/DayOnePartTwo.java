import java.util.HashMap;
import java.util.Map;

public class DayOnePartTwo {

    private Map<String, String> numbers;

    public DayOnePartTwo() {
        numbers = new HashMap<>();
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");
    }

    /**
     * Method for converting text to numbers
     *
     * @param text Input text containing the words you want to convert to numbers
     * @return text with the words you have substituted for the numbers
     */
    public String convertTextToDigits(String text) {
        int index = 10000;
        while (index == 10000) {
            index = 10000;
            String first = "";
            for (Map.Entry<String, String> entry : numbers.entrySet()) {
                int pos = text.indexOf(entry.getKey());
                if (pos != -1 && pos < index) {
                    index = text.indexOf(entry.getKey());
                    first = entry.getKey();
                }
            }
            index = -1;
            if (numbers.containsKey(first)) {
                text = text.replaceFirst(first, numbers.get(first));
                index = 10000;
            }
        }
        return text;
    }

    /**
     * A method to calculate a value from a string
     *
     * @param line An input string containing number
     * @return Calculated value from string
     */
    public int calculateValue(String line) {
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
        return first + last;
    }
}