import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CardSuits[] values = CardSuits.values();

        System.out.println("Card Suits:");
        for (CardSuits value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value);
        }

    }
}
