import java.lang.Object;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
    public static void main(String[] args) throws Exception {

        House testerHouse = new House();
        int insulationScore = testerHouse.getInsulationScore();
        String locationPost = testerHouse.getLocation();
        // Testing Testing1 = new Testing(insulationScore);

        // URL url = new URL(
        // "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
        // + locationPost
        // + "?unitGroup=metric&key=UUTDGXUEZFXQCMJ79SP9ZAKDD&contentType=json");

        // https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/london%20islington/next7days?unitGroup=metric&elements=temp%2Chumidity%2Cwindspeedmean&key=YOUR_API_KEY&contentType=json
        URL url = new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                + locationPost
                + "/next7days?unitGroup=metric&elements=temp%2Chumidity%2Cwindspeedmean&include=fcst%2Cdays&key=UUTDGXUEZFXQCMJ79SP9ZAKDD&contentType=json");
        HttpURLConnection connecti = (HttpURLConnection) url.openConnection();
        connecti.setRequestMethod("GET");
        connecti.connect();

        int responseCode = connecti.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("code is: " + responseCode);
        } else {
            StringBuilder gottenInfoString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                gottenInfoString.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println("info: " + gottenInfoString);
            JSONObject json = (JSONObject) JSONSerializer.toJSON(gottenInfoString);
            double todaysTemp = json.getDouble("temp");
        }

        Testing Testing2 = new Testing(insulationScore);
    }
}
