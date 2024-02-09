import java.lang.Object;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static Double currentTemp = 16.0;

    public static void main(String[] args) throws Exception {

        House testerHouse = new House();
        int insulationScore = testerHouse.getInsulationScore();
        // String locationPost = testerHouse.getLocation();

        Weather weather = new Weather(testerHouse);
        Heating heating = new Heating(weather, testerHouse, currentTemp);

        // Testing Testing = new Testing(insulationScore, heating, weather);
        DailyTemp dt = new DailyTemp(insulationScore, weather, heating);
    }
}
