public class Ferrari implements Car {
    private String driverName;
    private static final String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;

    }

    public String Ferrari() {
        return MODEL;
    }


    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        String format = "%s/%s/%s/%s";
        return String.format(
                format,
                MODEL,
                this.brakes(),
                this.gas(),
                this.driverName
        );
    }
}