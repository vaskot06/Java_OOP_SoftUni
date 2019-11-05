import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflection = Reflection.class;
        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());
        Class<?>[] interfaces = reflection.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object newInstance = reflection.getDeclaredConstructor().newInstance();

        System.out.println(newInstance);

    }
}
