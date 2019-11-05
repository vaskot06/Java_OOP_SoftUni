import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Method[] declaredMethods = Reflection.class.getDeclaredMethods();
        Field[] declaredFields = Reflection.class.getDeclaredFields();

        Arrays.stream(declaredFields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(e-> System.out.println(String.format("%s must be private!", e.getName())));

        Arrays.stream(declaredMethods)
                .filter(method -> !Modifier.isPublic(method.getModifiers()) && method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e-> System.out.println(String.format("%s have to be public!", e.getName())));


        Arrays.stream(declaredMethods)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()) && method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e-> System.out.println(String.format("%s have to be private!", e.getName())));

    }
}
