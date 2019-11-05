public abstract class Software extends Components {
    private int capacityConsumption;
    private int memoryConsumption;
    private String softwareType;

    public Software(String hardwareComponentName, String softwareName, int capacityConsumption, int memoryConsumption, String softwareType) {
        super(hardwareComponentName, softwareName);
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
        this.softwareType = softwareType;
    }

    public int getTotalCount(int totalCount) {
        return totalCount;
    }

    public String getSoftwareType() {
        return softwareType;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
