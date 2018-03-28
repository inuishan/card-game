package com.ishan.graph.cardgame;

import com.ishan.graph.cardgame.card.Card;
import com.ishan.graph.cardgame.card.Suite;

import java.util.Map;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public class Hand {

    private Suite currentSuite;

    private int maxCardOfCurrentSuite;

    private int maxTrumpCard;

    private String currentlyWinningPlayer;

    private Map<String, Card> playerIdVsCard;

    public Map<String, Card> getPlayerIdVsCard() {
        return playerIdVsCard;
    }

    public void setPlayerIdVsCard(Map<String, Card> playerIdVsCard) {
        this.playerIdVsCard = playerIdVsCard;
    }

    public void addCardToHand(String playerId, Card card, Suite trumpSuite) {
        Suite suite = card.getSuite();
        if (currentSuite == null) {
            this.currentSuite = suite;
        }
        if (currentlyWinningPlayer == null) {
            currentlyWinningPlayer = playerId;
        }
        // If the current turn is a trump & if this card is of trump & higher denomination, this player is the winner
        int value = card.getValue();
        if (currentSuite == trumpSuite && suite.equals(trumpSuite) && value > maxTrumpCard) {
            this.maxTrumpCard = value;
            currentlyWinningPlayer = playerId;
        }
        // If the current turn is not a trump & its not of the current suite, ignore it
        if (currentSuite != trumpSuite && suite != trumpSuite) {
            return;
        }
        // If the current turn is not a trump & its not of the current suite, ignore it
        //TODO complete the logic
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

    public String getCurrentlyWinningPlayer() {
        return currentlyWinningPlayer;
    }

    public void setCurrentlyWinningPlayer(String currentlyWinningPlayer) {
        this.currentlyWinningPlayer = currentlyWinningPlayer;
    }
}