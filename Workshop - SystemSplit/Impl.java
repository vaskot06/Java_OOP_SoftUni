import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Impl {
    private LinkedHashMap<Hardware, List<Software>> hardBySoft;
    private int totalCapacity;
    private int totalMemory;

    public Impl(LinkedHashMap<Hardware, List<Software>> hardBySoft, int totalCapacity, int totalMemory) {
        this.hardBySoft = hardBySoft;
        this.totalCapacity = totalCapacity;
        this.totalMemory = totalMemory;
    }

    public void setHardBySoft(LinkedHashMap<Hardware, List<Software>> hardBySoft) {
        this.hardBySoft = hardBySoft;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    private LinkedHashMap<Hardware, List<Software>> getHardBySoft() {
        return hardBySoft;
    }

    public PowerHardware registerPowerHardware(String name, String type, int maxCapacity, int maxMemory, int overallMemory, int overallCapacity) {
        PowerHardware powerHardware = new PowerHardware(name, type, maxCapacity, maxMemory, overallMemory, overallCapacity);
        return powerHardware;
    }

    public HeavyHardware registerHeavyHardware(String name, String type, int maxCapacity, int maxMemory, int overallMemory,int overallCapacity) {
        HeavyHardware heavyHardware = new HeavyHardware(name, type, maxCapacity, maxMemory, overallMemory,overallCapacity);
        return heavyHardware;
    }

    public LightSoftware registerLightSoftware(String name, String type, int capacityConsumption, int memoryConsumption, String softwareType) {
        LightSoftware lightSoftware = new LightSoftware(name, type, capacityConsumption, memoryConsumption, softwareType);
        return lightSoftware;
    }

    public ExpressSoftware registerExpressSoftware(String name, String type, int capacityConsumption, int memoryConsumption,String softwareType) {
        ExpressSoftware expressSoftware = new ExpressSoftware(name, type, capacityConsumption, memoryConsumption, softwareType);
        return expressSoftware;
    }

    public void registerSoftwareOntoHardware(Hardware hardware, Software software, LinkedHashMap<Hardware, List<Software>> hardBySoft) {
        String hwName = hardware.getName();
        String swName = software.getName();
        if (hwName.equals(swName)) {
            if (hardware.getMaximumCapacity() - software.getCapacityConsumption() >= 0) {
                if (hardware.getMaximumMemory() - software.getMemoryConsumption() >= 0) {
                    hardware.setMaximumMemory(hardware.getMaximumMemory() - software.getMemoryConsumption());
                    hardware.setMaximumCapacity(hardware.getMaximumCapacity() - software.getCapacityConsumption());

                    if (!hardBySoft.containsKey(hardware)) {
                        hardBySoft.put(hardware, new ArrayList<>());
                        hardBySoft.get(hardware).add(software);
                    } else {
                        List<Software> softwares = hardBySoft.get(hardware);
                        softwares.add(software);
                        hardBySoft.put(hardware, softwares);
                    }
                }
            }
        }
    }

    private void releaseSWComponent(String hwComp, String swComp, LinkedHashMap<Hardware, List<Software>> hardBySoft) {

        for (Map.Entry<Hardware, List<Software>> entry : hardBySoft.entrySet()) {
            Hardware hardware = entry.getKey();
            List<Software> softwares = entry.getValue();


            for (Software software : softwares) {
                if (hardware.getName().equals(hwComp) && software.getType().equals(swComp)) {
                    softwares.remove(software);
                    hardBySoft.put(hardware, softwares);
                }
            }
        }


    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {

        releaseSWComponent(hardwareComponentName, softwareComponentName, this.getHardBySoft());

    }

    public void systemSplit() {

        LinkedHashMap<Hardware, List<Software>> sorted = hardBySoft.entrySet().stream()
                .sorted((h1, h2) -> {
                    if (h1.getKey().getType().equals("Power")) {
                        return h1.getKey().getName().compareTo(h2.getKey().getName());
                    }
                    return 1;
                }).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));



        for (Map.Entry<Hardware, List<Software>> entry : sorted.entrySet()) {
            int memoryUsed = 0;
            int capacityUsed = 0;
            Hardware hardware = entry.getKey();
            List<Software> softwares = entry.getValue();
            System.out.println("Hardware Component - " + hardware.getName());
            int light = 0;
            int express = 0;
            for (Software software : softwares) {
                if (software.getSoftwareType().equals("Express")) {
                    express++;
                } else if (software.getSoftwareType().equals("Light")) {
                    light++;
                }
                memoryUsed += software.getMemoryConsumption();
                capacityUsed+= software.getCapacityConsumption();
            }

            System.out.println("Express Software Components - " + express);
            System.out.println("Light Software Components - " + light);
            System.out.println("Memory Usage: " + memoryUsed + " / " + hardware.getOverallMemory());
            System.out.println("Capacity Usage: " + capacityUsed + " / " +hardware.getOverallCapacity());
            System.out.println("Type: " + hardware.getType());

            if (softwares.size() == 0) {
                System.out.println("Software Components: None");
            }else {


                System.out.print("Software Components: ");

                int softCounter = 0;
                for (Software software : softwares) {
                    softCounter++;
                    if (softCounter == softwares.size() - 1) {
                        System.out.print(software.getType() + ", ");
                    } else {
                        System.out.print(software.getType());
                    }
                }
                System.out.println();
            }
        }
    }

    public void analyze() {

        System.out.println("System Analysis");
        int hardwareSize = 0;
        int softwareSize = 0;

        for (Map.Entry<Hardware, List<Software>> entry : hardBySoft.entrySet()) {
            hardwareSize++;

            for (Software software : entry.getValue()) {
                softwareSize++;
            }
        }

        int memoryInUseSum = 0;
        int totalCapacityTaken = 0;
        for (Map.Entry<Hardware, List<Software>> entry : hardBySoft.entrySet()) {
            Hardware hardware = entry.getKey();
            List<Software> softwares = entry.getValue();

            for (Software software : softwares) {
                memoryInUseSum += software.getMemoryConsumption();
                totalCapacityTaken += software.getCapacityConsumption();
            }

        }

        System.out.println("Hardware Components: " + hardwareSize);
        System.out.println("Software Components: " + softwareSize);
        System.out.println("Total Operational Memory: " + memoryInUseSum + " / "  + getTotalMemory());
        System.out.println("Total Capacity Taken: " + totalCapacityTaken + " / " + getTotalCapacity());

    }
}
