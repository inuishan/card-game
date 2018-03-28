package card;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public class Card {

    /**
     * This indicates the value of the card. Ace being one and King being 13
     */
    private final int value;

    /**
     * Represents the suite of the card.
     */
    private final Suite suite;

    public Card(int value, Suite suite) {
        this.value = value;
        this.suite = suite;
    }

    public int getValue() {
        return value;
    }

    public Suite getSuite() {
        return suite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (value != card.value) return false;
        return suite == card.suite;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (suite != null ? suite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("value=").append(value);
        sb.append(", suite=").append(suite);
        sb.append('}');
        return sb.toString();
    }
}