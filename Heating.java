import java.util.ArrayList;

public class Heating {
    Double basicTemp;
    int ogsize = 0;
    ArrayList<Double> weeklyForecast = new ArrayList<>();
    ArrayList<Double> sevenDays = new ArrayList<>();

    public Heating(Weather w1, House h1, Double currentT) {
        basicTemp = currentT;
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
        ArrayList<Double> adjustedList = new ArrayList<>();
        for (int i = 0; i < sevenDays.size(); i++) {
            // System.out.println("here once: " + sevenDays.size() + " first val " +
            // sevenDays.get(i));
            if (sevenDays.get(i) < basicTemp) {
                dailyTemp = basicTemp - sevenDays.get(i) / 3;
            } else if (sevenDays.get(i) == basicTemp) {
                dailyTemp = basicTemp;
            } else {
                dailyTemp = basicTemp + sevenDays.get(i) / 3;
            }
            adjustedList.add(dailyTemp);
            // System.out.println("tommororw: " + dailyTemp);
        }
        return dailyTemp;
    }

    public ArrayList<Double> adjustedlistget() {
        Double dailyTemp = basicTemp;
        ArrayList<Double> adjustedList = new ArrayList<>();
        for (int i = 0; i < sevenDays.size(); i++) {
            // System.out.println("here once: " + sevenDays.size() + " first val " +
            // sevenDays.get(i));
            if (sevenDays.get(i) < basicTemp) {
                dailyTemp = basicTemp - sevenDays.get(i) / 3;
            } else if (sevenDays.get(i) == basicTemp) {
                dailyTemp = basicTemp;
            } else {
                dailyTemp = basicTemp + sevenDays.get(i) / 3;
            }
            adjustedList.add(dailyTemp);
        }
        return adjustedList;
    }
}
