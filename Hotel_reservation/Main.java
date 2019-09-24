import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        Season season = Season.valueOf(tokens[2]);
        DiscountType discountType = DiscountType.valueOf(tokens[3]);

        PriceCalculator priceCalculator = new PriceCalculator(Double.parseDouble(tokens[0])
                                            , Integer.parseInt(tokens[1]), discountType, season);

        System.out.println(priceCalculator.calculate());
    }
}
