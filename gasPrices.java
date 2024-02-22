import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class gasPrices {

    public static void main(String[] args) throws Exception {

        String _clientKey = "guest:guest";
        String url = "https://api.tradingeconomics.com/markets/commodities?c=67f4df46bf32411:nwryywvcogdbfqa";
        String base_url = "http://api.tradingeconomics.com";
        String auth = base_url + "?c=" + "67f4df46bf32411:nwryywvcogdbfqa";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());
    }

}
