
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Day 1, Part 1 and 2
        String textt = "1abc2\n" +
                "pqr3stu8vwx\n" +
                "a1b2c3d4e5f\n" +
                "treb7uchet";

        try {
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            DayOnePartOne lineProcessor = new DayOnePartOne();

            br.lines().forEach(lineProcessor::processLine);

            int val = lineProcessor.getValue();
            System.out.println("Day one part one: \n" + val);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" ");

        String textt2 = "two1nine\n" +
                "eightwothree\n" +
                "abcone2threexyz\n" +
                "xtwone3four\n" +
                "4nineeightseven2\n" +
                "zoneight234\n" +
                "7pqrstsixteen";

        try {
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            DayOnePartTwo numberConverter = new DayOnePartTwo();
            int val = 0;

            for (String line : br.lines().toList()) {
                String convertedLine = numberConverter.convertTextToDigits(line);
                val += numberConverter.calculateValue(convertedLine);
            }

            System.out.println("Day one part two: \n" + val);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" ");

        //Day 6, Part 1 and 2
        String textt3 = "Time:      7  15   30\nDistance:  9  40  200" +
                "Time:        54     70     82     75\n Distance:    239   1142   1295   1253";

        String textt4 = "Time:      71530\nDistance:  940200" +
                "Time:        54708275\n Distance:   239114212951253";

        try {
            BufferedReader br = new BufferedReader(new FileReader("text2.txt"));
            int val = 0;
            long val1 = 0;
            System.out.println("Day six part one: ");
            val = DaySix.numOfTimToBeat(7, 9);
            System.out.println(val);
            val *= DaySix.numOfTimToBeat(15, 40);
            System.out.println(val);
            val *= DaySix.numOfTimToBeat(30, 200);
            System.out.println(val);

            val = DaySix.numOfTimToBeat(54, 239);
            System.out.println(val);
            val *= DaySix.numOfTimToBeat(70, 1142);
            System.out.println(val);
            val *= DaySix.numOfTimToBeat(82, 1295);
            System.out.println(val);
            val *= DaySix.numOfTimToBeat(75, 1253);
            System.out.println("*" + val + "*");

            System.out.println(" ");

            System.out.println("Day six part two: ");
            val1 = DaySix.numOfTimToBeat1(71530, new BigInteger("940200"));
            System.out.println(val1);

            val1 = DaySix.numOfTimToBeat1(54708275, new BigInteger("239114212951253"));
            System.out.println("*" + val1 + "*");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" ");


        //Day 11, Part 1 and 2
        String textt5 = "...#......\n" +
                ".......#..\n" +
                "#.........\n" +
                "..........\n" +
                "......#...\n" +
                ".#........\n" +
                ".........#\n" +
                "..........\n" +
                ".......#..\n" +
                "#...#.....";

        List<DayElevenPartOne> galaxiesPartOne = new ArrayList<>();
        List<DayElevenPartTwo> galaxiesPartTwo = new ArrayList<>();
        int ELEVEN_SIZE = 250;

        try {
            BufferedReader br = new BufferedReader(new FileReader("text3.txt"));
            int x = 0;
            int y = 0;

            int[] ylist = new int[ELEVEN_SIZE];
            int[] xlist = new int[ELEVEN_SIZE];

            for (String line : br.lines().toList()) {
                x = 0;
                for (String a : line.split("")) {
                    if (a.equals("#")) {
                        galaxiesPartOne.add(new DayElevenPartOne(x, y));
                        galaxiesPartTwo.add(new DayElevenPartTwo(x, y));
                        ylist[y]++;
                        xlist[x]++;
                    }
                    x++;
                }
                y++;
            }

            for (DayElevenPartOne g : galaxiesPartOne) {
                g.expand(xlist, ylist);
            }

            for (DayElevenPartTwo g : galaxiesPartTwo) {
                g.expand(xlist, ylist);
            }

            int valPartOne = 0;
            for (int i = 0; i < galaxiesPartOne.size(); i++) {
                for (int j = i; j < galaxiesPartOne.size(); j++) {
                    valPartOne += galaxiesPartOne.get(i).lengthTo(galaxiesPartOne.get(j));
                }
            }
            System.out.println("Day eleven part one: \n" + valPartOne);

            long valPartTwo = 0;
            for (int i = 0; i < galaxiesPartTwo.size(); i++) {
                for (int j = i; j < galaxiesPartTwo.size(); j++) {
                    valPartTwo += galaxiesPartTwo.get(i).lengthTo(galaxiesPartTwo.get(j));
                }
            }

            System.out.println(" ");

            System.out.println("Day eleven part two: \n" + valPartTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
