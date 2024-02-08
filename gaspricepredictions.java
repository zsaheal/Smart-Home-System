import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class gaspricepredictions {

    // public ArrayList
    public static void main(String[] args) throws Exception {

        URL url2 = new URL(
                "https://api.eia.gov/v2/natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&start=2020-01&end=2021-01&offset=0&length=1000&api_key=6iZN8rT3fvuceuf8Qt7YQ57aFGB3ujZ1fNQ1l0Il");
        HttpURLConnection connecti = (HttpURLConnection) url2.openConnection();
        connecti.setRequestMethod("GET");
        connecti.connect();
        System.out.println("got here");

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
        }
    }

    public gaspricepredictions() {

    }
}
