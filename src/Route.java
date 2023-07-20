import java.util.ArrayList;
import java.util.List;

public class Route{
    private String routeNumber;
    private List<Bus> buses;

    public Route(String routeNumber) {
        this.routeNumber = routeNumber;
        this.buses = new ArrayList<>();
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void removeBus(Bus bus) {
        buses.remove(bus);
    }

    public List<Bus> getBuses() {
        return buses;
    }
}
