import java.util.Scanner;

public class House {
    private int yearMade = 0;
    private int insulationScore = 0;

    public int getHouseYear() {
        System.out.println("what year was your house built or refurbished (in terms of windows & walls)? ");
        Scanner scanner = new Scanner(System.in);
        String yearString = scanner.nextLine();
        try {
            yearMade = Integer.valueOf(yearString);
        } catch (Exception e) {
            System.out.println("please enter a valid (integer) year");
        }
        return yearMade;
    }

    public int calcInsulationScore(int yearMade, int insulationScore) {
        insulationScore = insulationScore;

        if (yearMade < 1800) {
            insulationScore = 1;
        } else if (yearMade < 1900) {
            insulationScore = 2;
        } else if (yearMade < 1940) {
            insulationScore = 3;
        } else if (yearMade < 1960) {
            insulationScore = 4;
        } else if (yearMade < 1990) {
            insulationScore = 5;
        } else if (yearMade < 2000) {
            insulationScore = 6;
        } else if (yearMade < 2010) {
            insulationScore = 7;
        } else {
            insulationScore = 8;
        }

        return insulationScore;
    }

    public House() {
        yearMade = getHouseYear();
        insulationScore = calcInsulationScore(yearMade, insulationScore);
    }

    public int getInsulationScore() {
        return insulationScore;
    }
    // getters
    // setters
}
