public class HeavyHardware extends Hardware {



    public HeavyHardware(String name, String type, int maximumCapacity, int maximumMemory, int overallMemory,  int overallCapacity) {
        super(name, type, maximumCapacity, maximumMemory, overallMemory, overallCapacity);
        super.setMaximumCapacity(super.getMaximumCapacity() * 2);
        super.setMaximumMemory(getMaximumMemory() - (int) (super.getMaximumMemory() * 0.25));
        super.setOverallCapacity(super.getOverallCapacity() * 2);
        super.setOverallMemory(getOverallMemory() - (int) (super.getOverallMemory() * 0.25));
    }


}
