import java.util.ArrayList;
import java.util.List;

public class BusManagementSystem {
    private List<Route> routes;

    public BusManagementSystem() {
        routes = new ArrayList<>();
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void removeRoute(Route route) {
        routes.remove(route);
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
