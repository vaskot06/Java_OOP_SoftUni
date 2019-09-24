public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private DiscountType discountType;
    private Season season;

    public PriceCalculator(double pricePerDay, int numberOfDays, DiscountType discountType, Season season) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.discountType = discountType;
        this.season = season;
    }

    public String calculate() {
        double price = (this.pricePerDay * this.season.getValue()) * this.numberOfDays;
        return String.format("%.2f",price - ((price * this.discountType.getValue()) / 100));
    }
}
