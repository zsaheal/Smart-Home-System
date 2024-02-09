import java.util.ArrayList;

import javax.sound.midi.Soundbank;

public class DailyTemp {

    public int houseInsulation = 0;
    public double wantedTemp = 14;

    Weather w1;
    Heating heat;
    ArrayList<Double> tempAList = new ArrayList<>();

    boolean yesor = false;
    double missingT = 0.0;

    public DailyTemp(int insulationScore, Weather weather, Heating heat) {
        houseInsulation = insulationScore;
        w1 = weather;
        heat = heat;
        tempAList = heat.adjustedlistget();
        System.out.println("\n");
        for (int i = 0; i < tempAList.size(); i++) {
            System.out.println("expected indoor temperature day " + i + " : " + tempAList.get(i));
        }
        System.out.println("\n");
        for (int j = 0; j < tempAList.size(); j++) {
            yesor = startChecks(tempAList.get(j), wantedTemp);
            missingT = howMuchMissing(yesor, wantedTemp, tempAList.get(j));
            Double dailyGas = dailyHeatingNeeded(missingT);
            System.out.println("hours of heeting needed on day " + j + " is: " + dailyGas);
        }
    }

    public boolean startChecks(double houseTemp, double wantedTemp) {
        if (wantedTemp > houseTemp) {
            return true;
        } else {
            return false;
        }
    }

    public Double howMuchMissing(boolean start, double wantedTemp, double houseTemp) {
        if (start == true) {
            missingT = wantedTemp - houseTemp;
            return missingT;
        }
        return 0.0;
    }

    public Double dailyHeatingNeeded(double missingTemp) {
        if (missingTemp == 0.0) {
            System.out.println("desired temp for the day will require no heating");
            return 0.0;
        } else {
            double fortyfivers = (missingTemp - 1);
            double mutipliedforty = (fortyfivers * 0.75);
            double total = mutipliedforty + 1;
            return total;
        }
    }
}
