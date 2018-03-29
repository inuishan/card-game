package hand;


import card.Card;
import card.Suite;

import java.util.Map;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public class Hand {

    private Suite currentSuite;

    private int maxCardOfCurrentSuite;

    private int maxTrumpCard;

    private Integer currentlyWinningPlayer;

    private Map<String, Card> playerIdVsCard;

    public Map<String, Card> getPlayerIdVsCard() {
        return playerIdVsCard;
    }

    public void setPlayerIdVsCard(Map<String, Card> playerIdVsCard) {
        this.playerIdVsCard = playerIdVsCard;
    }

    public void addCardToHand(int playerId, Card card, Suite trumpSuite) {
        Suite suite = card.getSuite();
        if (currentSuite == null) {
            this.currentSuite = suite;
        }
        if (currentlyWinningPlayer == null) {
            currentlyWinningPlayer = playerId;
        }

        //If the current card is of current suite & there is no trump thrown in and its greater than the current max,
        // this wins
        if (card.getSuite() == currentSuite && maxTrumpCard == 0 && card.getValue() > maxCardOfCurrentSuite) {
            maxCardOfCurrentSuite = card.getValue();
            currentlyWinningPlayer = playerId;
            return;
        }

        // If the current card is a trump & if this card is of trump & higher denomination, this player is the winner
        int value = card.getValue();
        if (currentSuite == trumpSuite && suite.equals(trumpSuite) && value > maxTrumpCard) {
            this.maxTrumpCard = value;
            currentlyWinningPlayer = playerId;
        }
        // If the current card is not a trump & its not of the current suite, ignore it
        if (card.getSuite() != trumpSuite && card.getSuite() != currentSuite) {
            return;
        }
    }

    public Suite getCurrentSuite() {
        return currentSuite;
    }

    public void setCurrentSuite(Suite currentSuite) {
        this.currentSuite = currentSuite;
    }

    public int getMaxCardOfCurrentSuite() {
        return maxCardOfCurrentSuite;
    }

    public void setMaxCardOfCurrentSuite(int maxCardOfCurrentSuite) {
        this.maxCardOfCurrentSuite = maxCardOfCurrentSuite;
    }

    public int getMaxTrumpCard() {
        return maxTrumpCard;
    }

    public void setMaxTrumpCard(int maxTrumpCard) {
        this.maxTrumpCard = maxTrumpCard;
    }

    public Integer getCurrentlyWinningPlayer() {
        return currentlyWinningPlayer;
    }

    public void setCurrentlyWinningPlayer(Integer currentlyWinningPlayer) {
        this.currentlyWinningPlayer = currentlyWinningPlayer;
    }
}