package org.thoughtworkers;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 3/18/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaxiMeter {

    private static final double initialDistance = 3d;
    private static final double minPrice = 8d;
    private static final double unitPrice = 2;
    private static final double minPriceInNight = 10d;
    private static final double unitPriceInNight = 3d;
    private Location startLocation;

    public TaxiMeter() {

    }

    public TaxiMeter(Location startLocation) {

        this.startLocation = startLocation;
    }

    public double getPrice(double distance, boolean isNight) {

        if (distance <= initialDistance) {
            return getMinPrice(isNight);
        } else {
            return getMinPrice(isNight) + getUnitPrice(isNight) * (distance - initialDistance);
        }

    }

    private double getUnitPrice(boolean isNight) {
        if (startLocation instanceof Shuangliu){
            return 1.5d;
        }
        if (isNight) {
            return unitPriceInNight;
        }
        return unitPrice;
    }

    private double getMinPrice(boolean isNight) {
        if (startLocation instanceof Shuangliu){
            return 6d;
        }
        if (isNight) {
            return minPriceInNight;
        }
        return minPrice;
    }
}
