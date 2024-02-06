
public class DailyTemp {

    public int houseInsulation = 0;
    public int wantedTemp = 21;
    // public int currentTemp = 17;
    Weather w1;
    Heating heat;

    public DailyTemp(int insulationScore, Weather weather, Heating heat) {
        houseInsulation = insulationScore;
        w1 = weather;
        heat = heat;
        Double adjustedTemp1 = heat.adjustCalcF();
        System.out.println("day 1 adjusted temp = " + adjustedTemp1);
        Double adjustTemp2 = heat.adjustCalcF();
        System.out.println("day 2 adjusted temp = " + adjustTemp2);
    }
}
