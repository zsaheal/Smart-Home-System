import java.lang.*;
import java.net.SocketTimeoutException;

public class Testing {

    public static int ans = 7;

    public Testing() {
        int wantedT = 23;
        int currentT = 18;
        boolean start = precheck(wantedT, currentT);
        int missing = missingTemp(wantedT, currentT, start);
        calculations(missing);
        posornot(ans, start);
    }

    public boolean precheck(int wantedT, int currentT) {
        boolean goahead = false;
        if (wantedT > currentT) {
            goahead = true;
            return goahead;
        } else {
            goahead = false;
            return goahead;
        }
    }

    public int missingTemp(int wantedT, int currentT, boolean yes) {
        if (yes == true) {
            int missing = wantedT - currentT;
            return missing;
        } else {
            return 0;
        }

    }

    public double calculations(int missing) {
        if (missing == 0) {
            System.out.println("Temp is hot enough (no heating needed)");
        } else {
            double fortyfivers = (missing - 1);
            double mutipliedforty = (fortyfivers * 0.75);
            double total = mutipliedforty + 1;
            System.out.println("total: " + total);
        }
        return 0;
    }

    public boolean posornot(int a, boolean yes) {
        if (yes == true) {
            boolean outp = false;
            if (a > 0) {
                outp = true;
                System.out.println("its possible");
            } else {
                System.out.println(
                        "your budget is not enough to heat house to this temperature, lower required temp or increase budget");
            }
            return outp;
        } else {
            System.out.println("temp is already heated");
            return yes;
        }
    }

}