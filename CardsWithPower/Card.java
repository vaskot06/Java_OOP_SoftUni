public class Card {
    private CardRanks cardRanks;
    private CardSuits cardSuits;

    Card(CardRanks cardRanks, CardSuits cardSuits){
        this.cardRanks = cardRanks;
        this.cardSuits = cardSuits;
    }

    public CardRanks getCardRanks() {
        return cardRanks;
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                getCardRanks(),
                getCardSuits(),
                getCardRanks().getValue() + getCardSuits().getValue());
    }
}
