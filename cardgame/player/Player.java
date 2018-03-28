package player;

import card.Card;
import card.Suite;
import hand.Hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a player playing the game
 *
 * @author ishanjain
 * @since 28/03/18
 */
public class Player {

    private int playerId;

    /**
     * This represents the cards that this player has at any point
     * TODO to save space, we could have a bit set for a card. We also need it sorted.
     */
    private Map<Suite, List<Card>> suiteVsCards;

    /**
     * The number of hands this player has won. Initially 0
     */
    private int numberOfHandsWon = 0;


    public Player() {
        this.suiteVsCards = new HashMap<>();
    }

    public Map<Suite, List<Card>> getSuiteVsCards() {
        return suiteVsCards;
    }

    public void setSuiteVsCards(Map<Suite, List<Card>> suiteVsCards) {
        this.suiteVsCards = suiteVsCards;
    }

    public int getNumberOfHandsWon() {
        return numberOfHandsWon;
    }

    public void setNumberOfHandsWon(int numberOfHandsWon) {
        this.numberOfHandsWon = numberOfHandsWon;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void addCard(Card card) {
        List<Card> cards = suiteVsCards.computeIfAbsent(card.getSuite(), k -> new ArrayList<>());
        cards.add(card);
    }

    public Card playCard(Hand hand, Suite trumpSuite) {
        if (hand.getCurrentSuite() == null) {
            //I decide the current suite
        }

        return null;
    }
}