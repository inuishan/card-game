package card;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public enum Suite {
    HEARTS("♥"),
    SPADE("♠"),
    CLUB("♣"),
    DIAMOND("♦");

    private final String displayCode;

    Suite(String displayCode) {
        this.displayCode = displayCode;
    }

    public String getDisplayCode() {
        return displayCode;
    }
}