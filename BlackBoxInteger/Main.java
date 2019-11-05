import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();

        BlackBoxInt blackBoxInt = null;

        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");

        innerValue.setAccessible(true);

        try {
            Constructor ctor = BlackBoxInt.class.getDeclaredConstructor();
            ctor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) ctor.newInstance();
        } catch (NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        while (!line.equals("END")) {
            String[] tokens = line.split("_");

            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            for (Method method : methods) {
                if (method.getName().equals(command)) {
                    method.setAccessible(true);
                    method.invoke(blackBoxInt, value);
                    System.out.println(innerValue.getInt(blackBoxInt));
                }
            }
            line = bufferedReader.readLine();
        }
    }
}
