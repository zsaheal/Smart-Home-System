import java.lang.Object;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        House testerHouse = new House();
        int insulationScore = testerHouse.getInsulationScore();
        // Testing Testing1 = new Testing(insulationScore);

        // visual crossing api
        // https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/[location]/[date1]/[date2]?key=UUTDGXUEZFXQCMJ79SP9ZAKDD
        URL url = new URL(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/london%20islington?unitGroup=metric&key=UUTDGXUEZFXQCMJ79SP9ZAKDD&contentType=json");
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
        }

        Testing Testing2 = new Testing(insulationScore);
    }
}
