package school.feetracker;

/**
 * Represents a bus route with an associated fee.
 */
public class BusRoute {
    private String routeId;
    private String routeName;
    private double routeFee;

    /**
     * @param routeId   Internal code for this route
     * @param routeName Human-readable name
     * @param routeFee  Fee in Rwandan Francs
     */
    public BusRoute(String routeId, String routeName, double routeFee) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.routeFee = routeFee;
    }

    /** @return the route’s display name */
    public String getRouteName() {
        return routeName;
    }

    /** @return the fee associated with this route */
    public double getRouteFee() {
        return routeFee;
    }
}
