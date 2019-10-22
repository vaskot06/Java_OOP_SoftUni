import Telephony.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = bufferedReader.readLine().split(" ");
        String[] urls = bufferedReader.readLine().split(" ");

        List<String> numbersList = new ArrayList<>(Arrays.asList(numbers));
        List<String> urlsList = new ArrayList<>(Arrays.asList(urls));

        Smartphone smartphone = new Smartphone(numbersList, urlsList);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
