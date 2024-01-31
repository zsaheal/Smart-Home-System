import java.util.Scanner;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//JSONObject json = (JSONObject) JSONSerializer.toJSON(gottenInfoString);
// double todaysTemp = json.getDouble("temp");
public class House {
    private int yearMade = 0;
    private int insulationScore = 0;
    private String enteredLocation;

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

    public String getHouseLocation() {

        System.out.println("what is your postcode? (where the device is being installed): ");
        Scanner scanner = new Scanner(System.in);
        enteredLocation = scanner.nextLine();

        return enteredLocation;

        // Scanner scanner = new Scanner(System.in);
        // String enteredLocation = scanner.nextLine();
        // if (enteredLocation.length() > 6 || enteredLocation.length() < 5) {
        // System.out.println("please enter a valid postcode");
        // }
    }

    public int calcInsulationScore(int yearMade) {

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

    public int getWindowInfo() {
        System.out.println("how many windows are there ");
        Scanner scanner = new Scanner(System.in);
        String windowNum = scanner.nextLine();
        int windows = 0;
        try {
            windows = Integer.valueOf(windowNum);
        } catch (Exception e) {
            System.out.println("please enter a valid number (integer) ");
        }
        return windows;
    }

    public House() {
        yearMade = getHouseYear();
        insulationScore = calcInsulationScore(yearMade);
        enteredLocation = getHouseLocation();
    }

    public int getInsulationScore() {
        return insulationScore;
    }

    public String getLocation() {
        return enteredLocation;
    }
    // getters
    // setters
}