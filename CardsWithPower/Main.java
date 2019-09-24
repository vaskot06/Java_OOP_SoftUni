import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String secondLine = scanner.nextLine();

        Card card = new Card(CardRanks.valueOf(line), CardSuits.valueOf(secondLine));

        System.out.println(card);

    }
}
