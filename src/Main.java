import java.util.List;

class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus("Biraj", 123);
        Bus bus2 = new Bus("Manoj", 456);

        Route route1 = new Route("A");
        route1.addBus(bus1);
        System.out.println("route1:"+"Dhading to Chainpur");

        Route route2 = new Route("B");
        route2.addBus(bus2);
        System.out.println("route2:"+"Dhading to Kathmandu");

        BusManagementSystem system = new BusManagementSystem();
        system.addRoute(route1);
        system.addRoute(route2);

        List<Route> routes = system.getRoutes();
        for (Route route : routes) {
            System.out.println("Route: " + route.getRouteNumber());
            List<Bus> buses = route.getBuses();
            for (Bus bus : buses) {
                System.out.println("Bus Number: " + bus.getBusNumber());
                System.out.println("Driver Name: " + bus.getDriverName());
            }
            System.out.println();
        }
    }
}
