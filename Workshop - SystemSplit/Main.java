import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //TODO implement Analysys method if needed
        //TODO implement •	ReleaseSoftwareComponent and SystemSplit


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();


        List<Hardware> hardwares = new ArrayList<>();
        List<Software> softwares = new ArrayList<>();

        LinkedHashMap<Hardware, List<Software>> softwareImplementedOnHardware = new LinkedHashMap<>();
        Impl implementations = new Impl(softwareImplementedOnHardware, 0, 0);
        int lightCounter = 0;
        int expressCounter = 0;
        int maximumMemory = 0;
        int maximumCapacity = 0;

        while (true) {

            if (line.equals("System Split")) {
                implementations.systemSplit();
                break;
            }
            int firstIndexOfBracket = line.indexOf("(");
            String command = line.substring(0, firstIndexOfBracket);

            if (command.equals("Analyze")) {

                implementations.analyze();
                //TODO Implement logic for Analyze

                line = bufferedReader.readLine();
                continue;
            }
            String tokens = line.substring(firstIndexOfBracket + 1, line.length() - 1);
            String[] components = tokens.split(", ");

            if (command.equals("RegisterPowerHardware")) {
                Hardware powerHardware = implementations.registerPowerHardware(components[0], "Power",
                        Integer.parseInt(components[1]), Integer.parseInt(components[2]), Integer.parseInt(components[2]), Integer.parseInt(components[1]));
                hardwares.add(powerHardware);
                maximumCapacity += powerHardware.getMaximumCapacity();
                maximumMemory += powerHardware.getMaximumMemory();
                implementations.setTotalCapacity(maximumCapacity);
                implementations.setTotalMemory(maximumMemory);
                softwareImplementedOnHardware.put(powerHardware, new ArrayList<>());
            } else if (command.equals("RegisterHeavyHardware")) {
                Hardware heavyHardware = implementations.registerHeavyHardware(components[0], "Heavy",
                        Integer.parseInt(components[1]), Integer.parseInt(components[2]), Integer.parseInt(components[2]),Integer.parseInt(components[1]));
                hardwares.add(heavyHardware);
                maximumCapacity += heavyHardware.getMaximumCapacity();
                maximumMemory += heavyHardware.getMaximumMemory();
                implementations.setTotalCapacity(maximumCapacity);
                implementations.setTotalMemory(maximumMemory);
                softwareImplementedOnHardware.put(heavyHardware, new ArrayList<>());
            } else if (command.equals("RegisterLightSoftware")) {
                Software lightSoftware = implementations.registerLightSoftware(components[0], components[1],
                        Integer.parseInt(components[2]), Integer.parseInt(components[3]), "Light");
                for (Hardware hardware : hardwares) {
                    implementations.registerSoftwareOntoHardware(hardware, lightSoftware, softwareImplementedOnHardware);
                    lightCounter++;
                    lightSoftware.getTotalCount(lightCounter);
                }
            } else if (command.equals("RegisterExpressSoftware")) {
                Software expressSoftware = implementations.registerExpressSoftware(components[0], components[1],
                        Integer.parseInt(components[2]), Integer.parseInt(components[3]), "Express");
                for (Hardware hardware : hardwares) {
                    implementations.registerSoftwareOntoHardware(hardware, expressSoftware, softwareImplementedOnHardware);
                    expressCounter++;
                    expressSoftware.getTotalCount(expressCounter);
                }
            } else if (command.equals("ReleaseSoftwareComponent")) {
                implementations.releaseSoftwareComponent(components[0], components[1]);
            }


            line = bufferedReader.readLine();
        }
    }
}
