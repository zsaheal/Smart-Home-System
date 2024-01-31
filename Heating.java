import java.util.ArrayList;

public class Heating {
    Double basicTemp = 16.0;
    int ogsize = 0;
    ArrayList<Double> weeklyForecast = new ArrayList<>();
    ArrayList<Double> sevenDays = new ArrayList<>();

    public Heating(Weather w1, House h1) {
        weeklyForecast = w1.findWeatherF(h1);
        // ArrayList<Double> weeklyForecast = w1.returnForecast(h1);
        // System.out.println("HEREEEELOLOLOLOLOFKOIDSJFJNDSFJN===========: " +
        // weeklyForecast.size());
        ogsize = weeklyForecast.size();
        // ArrayList<Double> sevenDays = new ArrayList<>();
        for (int i = 0; i < ogsize / 2 - 1; i++) {
            sevenDays.add(weeklyForecast.get(i));
        }

    }

    public Double adjustCalcF() {
        Double dailyTemp = basicTemp;
        for (int i = 0; i < 16 / 2 - 1; i++) {
            if (sevenDays.get(i) < basicTemp) {
                dailyTemp = basicTemp - sevenDays.get(i) / 3;
            } else if (sevenDays.get(i) == basicTemp) {
                dailyTemp = basicTemp;
            } else {
                dailyTemp = basicTemp + sevenDays.get(i) / 3;
            }
            return dailyTemp;
        }
        return dailyTemp;
    }
}
