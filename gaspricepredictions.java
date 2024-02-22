import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class gaspricepredictions {

    // public ArrayList
    public static void main(String[] args) throws Exception {

        URL url2 = new URL(
                "https://api.eia.gov/v2/natural-gas/pri/?frequency=monthly&data[0]=value&start=2020-01&end=2021-01&offset=0&length=100&api_key=6iZN8rT3fvuceuf8Qt7YQ57aFGB3ujZ1fNQ1l0Il");
        // "https://api.eia.gov/v2/natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&start=2020-01&end=2021-01&offset=0&length=1&api_key=6iZN8rT3fvuceuf8Qt7YQ57aFGB3ujZ1fNQ1l0Il");
        HttpURLConnection connecti = (HttpURLConnection) url2.openConnection();
        connecti.setRequestMethod("GET");
        connecti.connect();

        int responseCode = connecti.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("code is: " + responseCode);
        } else {
            StringBuilder gottenInfoString = new StringBuilder();
            Scanner scanner = new Scanner(url2.openStream());

            while (scanner.hasNext()) {
                gottenInfoString.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println("infor: " + gottenInfoString);
            // JSONObject json = (JSONObject) JSONSerializer.toJSON(gottenInfoString);
            // double todaysTemp = json.getDouble("temp");
        }
    }

    public gaspricepredictions() {

    }
}
