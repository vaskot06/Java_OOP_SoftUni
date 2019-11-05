public class ExpressSoftware extends Software{


    public ExpressSoftware(String hardwareComponentName, String softwareName, int capacityConsumption, int memoryConsumption, String softwareType) {
        super(hardwareComponentName, softwareName, capacityConsumption, memoryConsumption, softwareType);

        super.setMemoryConsumption(getMemoryConsumption() * 2);
    }

    @Override
    public int getTotalCount(int totalCount){
        return totalCount;
    }
}
