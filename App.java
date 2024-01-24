import java.lang.Object;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        House testerHouse = new House();
        int insulationScore = testerHouse.getInsulationScore();
        // String locationPost = testerHouse.getLocation();
        Weather weather = new Weather(testerHouse);
        // Testing Testing1 = new Testing(insulationScore);
        Testing Testing2 = new Testing(insulationScore);
    }
}
