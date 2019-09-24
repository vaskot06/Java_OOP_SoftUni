public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);

    int value;

    DiscountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
