import java.lang.*;
import java.net.SocketTimeoutException;

public class Testing {

    public static int ans = 7;
    public static double budgetPerMonth = 10;
    public double priceOfGasforMon = 2;
    public int houseInsulation = 0;
    // House h1;
    Weather w1;
    Heating heat;

    public Testing(int insulationScore, Heating heat, Weather weather) {
        houseInsulation = insulationScore;
        heat = heat;
        // h1 = myHouse;
        w1 = weather;
        int wantedT = 23;
        Double adjustedTemp = heat.adjustCalcF(); // adjusted daily temp depending on weather
        System.out.println(
                "hfjhfdjhbvfdhbvfdhjb omg its c=gonna be this cold this week at home  EEE: " + adjustedTemp);
        // int currentT = 18;
        boolean start = precheck(wantedT, adjustedTemp);
        Double missing = missingTemp(wantedT, adjustedTemp, start);
        double hoursNeeded = calculations(missing);
        enoughMoney(budgetPerMonth, hoursNeeded, priceOfGasforMon);
    }

    public boolean precheck(int wantedT, Double currentT) {
        boolean goahead = false;
        if (wantedT > currentT) {
            goahead = true;
            return goahead;
        } else {
            goahead = false;
            return goahead;
        }
    }

    public Double missingTemp(int wantedT, Double currentT, boolean yes) {
        if (yes == true) {
            Double missing = wantedT - currentT;
            return missing;
        } else {
            return 0.0;
        }
    }

    public double calculations(Double missing) {
        if (missing == 0) {
            System.out.println("Temp is hot enough (no heating needed)");
            return 0;
        } else {
            double fortyfivers = (missing - 1);
            double mutipliedforty = (fortyfivers * 0.75);
            double total = mutipliedforty + 1;
            System.out.println("total: " + total);
            return total;
        }
    }

    public double enoughMoney(double monthlyBudget, double neededUnits, double priceOfGasforMon) {
        double weeklyBudget = monthlyBudget / 4;
        double totalCost = neededUnits * priceOfGasforMon;
        System.out.println("weekly " + weeklyBudget);
        System.out.println("total Cost: " + totalCost);
        double weeklyCost = totalCost / 4;
        double net = monthlyBudget - totalCost;
        if (net > 0) {
            System.out.println("u can afford to heat to this temperature" + "left over budget = " + net);

        } else if (net <= 0) {
            System.out.println("you dont have enough sorry, please lower temp or increase budget");
        }
        return net;
    }

    public double getWeeklyGasAmount(double monthlyBudget, double priceOfGasforMon) {
        double weeklyBudget = monthlyBudget / 4;
        return weeklyBudget;
    }
}