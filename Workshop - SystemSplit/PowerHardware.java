public class PowerHardware extends Hardware {

    public PowerHardware(String name, String type, int maximumCapacity, int maximumMemory, int overallMemory, int overallCapacity) {
        super(name, type, maximumCapacity, maximumMemory, overallMemory, overallCapacity);
        super.setMaximumCapacity((getMaximumCapacity() - (int) (super.getMaximumCapacity() * 0.75)));
        super.setMaximumMemory((getMaximumMemory() + (int) (super.getMaximumMemory() * 0.75)));
        super.setOverallCapacity((getOverallCapacity() - (int) (super.getOverallCapacity() * 0.75)));
        super.setOverallMemory((getOverallMemory() + (int) (super.getOverallMemory() * 0.75)));
    }


}
