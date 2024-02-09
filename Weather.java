import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Weather {
    ArrayList<Double> temperatureList = new ArrayList<>();

    public ArrayList<Double> findWeatherF(House aHouse) {
        try {
            URL url = new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                    + aHouse.getLocation()
                    + "/next7days?unitGroup=metric&elements=temp%2Chumidity%2Cwindspeedmean&include=fcst%2Cdays&key=UUTDGXUEZFXQCMJ79SP9ZAKDD&contentType=json");

            HttpURLConnection connecti = (HttpURLConnection) url.openConnection();
            connecti.setRequestMethod("GET");
            connecti.connect();

            int responseCode = connecti.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("code is: " + responseCode);
            } else {
                Scanner scanner = new Scanner(url.openStream());

                StringBuilder gottenInfoString = new StringBuilder();
                while (scanner.hasNext()) {
                    gottenInfoString.append(scanner.nextLine());
                }
                scanner.close();

                JSONObject jsonObject = new JSONObject(gottenInfoString.toString());
                JSONArray daysArray = jsonObject.getJSONArray("days");

                for (int i = 0; i < daysArray.length(); i++) {
                    JSONObject dayObject = daysArray.getJSONObject(i);
                    double temperature = dayObject.getDouble("temp");
                    temperatureList.add(temperature);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temperatureList;
    }

    public Weather(House aHouse) {
        ArrayList<Double> temperatureForecast = findWeatherF(aHouse);
        for (int i = 0; i < temperatureForecast.size(); i++) {
            System.out.println("Day " + (i + 1) + " forecasted temperature: " + temperatureForecast.get(i));
        }
    }

    public ArrayList<Double> returnForecast(House aHouse) {
        ArrayList<Double> temperatureForecast = findWeatherF(aHouse);
        return temperatureForecast;
    }
}