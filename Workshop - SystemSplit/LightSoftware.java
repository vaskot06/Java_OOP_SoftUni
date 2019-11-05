public class LightSoftware extends Software{
    public LightSoftware(String hardwareComponentName, String softwareName, int capacityConsumption, int memoryConsumption, String softwareType) {
        super(hardwareComponentName, softwareName, capacityConsumption, memoryConsumption, softwareType);

        super.setCapacityConsumption(getCapacityConsumption() + (int)(getCapacityConsumption() * 0.50));
        super.setMemoryConsumption(getMemoryConsumption() - (int)(getMemoryConsumption() * 0.50));
    }



    @Override
    public int getTotalCount(int totalCount){
        return totalCount;
    }
}
