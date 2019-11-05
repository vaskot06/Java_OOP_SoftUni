public abstract class Hardware extends Components{
    private int maximumCapacity;
    private int maximumMemory;
    private int overallMemory;
    private int overallCapacity;



    public Hardware(String name, String type, int maximumCapacity, int maximumMemory, int overallMemory, int overallCapacity) {
        super(name, type);
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.overallMemory = overallMemory;
        this.overallCapacity = overallCapacity;
    }

    public int getOverallMemory() {
        return overallMemory;
    }

    public void setOverallMemory(int overallMemory) {
        this.overallMemory = overallMemory;
    }

    public int getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(int overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }
}
