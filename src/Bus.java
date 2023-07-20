import java.util.ArrayList;
import java.util.List;

class Bus {
    private String driverName;
    private int busNumber;

    public Bus(String driverName, int busNumber) {
        this.driverName = driverName;
        this.busNumber = busNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getBusNumber() {
        return busNumber;
    }
}

