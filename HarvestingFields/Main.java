import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();

       Field[] declaredFields = RichSoilLand.class.getDeclaredFields();
//
//        Class richSoil = RichSoilLand.class;
//
//        Field[] interfaces = richSoil.getDeclaredFields();
//        for (Field anInterface : interfaces) {
//            Class modifier = Modifier.class;
//            System.out.println(Modifier.toString(anInterface.getModifiers()));
//        //    System.out.println(anInterface.getType().getSimpleName());
//        }


        while (!line.equals("HARVEST")) {

            if (line.equals("private")) {
                for (Field field : declaredFields) {
                    if (Modifier.isPrivate(field.getModifiers())) {
                        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                    }
                }
            } else if (line.equals("protected")) {
                for (Field field : declaredFields) {
                    if (Modifier.isProtected(field.getModifiers())) {
                        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                    }
                }
            } else if (line.equals("public")) {
                for (Field field : declaredFields) {
                    if (Modifier.isPublic(field.getModifiers())) {
                        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                    }
                }
            } else if (line.equals("all")) {
                for (Field field : declaredFields) {
                    System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                }
            }


            line = bufferedReader.readLine();
        }

    }
}
