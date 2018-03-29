package player;

import card.Card;
import card.Suite;
import hand.Hand;

import java.util.*;

/**
 * Represents a player playing the game
 *
 * @author ishanjain
 * @since 28/03/18
 */
public class Player {

    private int numCards = 0;

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
        numCards++;
        List<Card> cards = suiteVsCards.computeIfAbsent(card.getSuite(), k -> new ArrayList<>());
        cards.add(card);
        if (numCards == 13) {
            //Lets sort everything
            for (Suite suite : Suite.values()) {
                List<Card> cardsOfSuite = suiteVsCards.get(suite);
                if (cardsOfSuite != null) {
                    cardsOfSuite.sort((o1, o2) -> -1 * Integer.compare(o1.getValue(), o2.getValue()));
                }
            }
        }
    }

    public Card playCard(Hand hand, Suite trumpSuite) {
        Suite currentSuite = hand.getCurrentSuite();
        if (currentSuite == null) {
            //I decide the current suite
            return playFirstCard(trumpSuite);
        }
        List<Card> currentSuiteCards = suiteVsCards.get(currentSuite);
        if (currentSuiteCards != null && currentSuiteCards.size() > 0) {
            return playCardOfCurrentSuite(hand, currentSuite, currentSuiteCards);

        } else {
            //I do not have cards of the same suite, lets see if I can throw in a trump
            List<Card> trumpCards = suiteVsCards.get(trumpSuite);
            if (trumpCards != null && trumpCards.size() > 0) {
                //I have trump card
                if (hand.getMaxTrumpCard() != 0) {
                    //There is a trump thrown in the hand, Lets find if I have any trump greater than this
                    Card cardToRemove = null;
                    for (int index = trumpCards.size() - 1; index >= 0; index++) {
                        Card card = trumpCards.get(index);
                        if (card.getValue() > hand.getMaxTrumpCard()) {
                            cardToRemove = card;
                            break;
                        }
                    }
                    if (cardToRemove != null) {
                        trumpCards.remove(cardToRemove);
                        return cardToRemove;
                    }
                }
            }
        }
        return null;
    }

    private Card playCardOfCurrentSuite(Hand hand, Suite currentSuite, List<Card> currentSuiteCards) {
        //This means I have cards of same suite, lets see if I can win this hand.
        if (hand.getMaxTrumpCard() != 0) {
            //There is a trump thrown in. Note that if the current hand is of trump, this is not set! So no need
            //to worry about checking for current hand = trump suite
            return playMinOfSuite(currentSuite, true);
        } else {
            //There is no trump thrown in till now, lets see if I can win this
            Card maxCard = playMaxOfSuite(currentSuite, false);
            if (hand.getMaxCardOfCurrentSuite() < maxCard.getValue()) {
                //I have a card which I can play
                currentSuiteCards.remove(maxCard);
                return maxCard;
            } else {
                return playMinOfSuite(currentSuite, true);
            }
        }
    }

    /**
     * There is nothing in the hand. I decide the card to play.
     * <p>
     * Strategy:
     * I cannot play trump if I have any other suite.
     * I put forward the highest card of a random suite.
     * If I only have the trump suite available, then I play highest of trump suite.
     *
     * @return The {@link Card} that I played.
     */
    private Card playFirstCard(Suite trumpSuite) {
        List<Suite> suitsExceptTrumpIHave = new ArrayList<>();
        for (Map.Entry<Suite, List<Card>> entry : suiteVsCards.entrySet()) {
            Suite suite = entry.getKey();
            // I have cards which are not trump
            if (suite != trumpSuite && entry.getValue() != null && entry.getValue().size() > 0) {
                suitsExceptTrumpIHave.add(suite);
            }
        }
        if (suitsExceptTrumpIHave.size() == 0) {
            // I do not have any suite, I need to play trump
            return playMaxOfSuite(trumpSuite, true);
        }
        // Decide a suite randomly
        Random random = new Random(System.currentTimeMillis());
        int randomSuite = random.nextInt(suitsExceptTrumpIHave.size() - 1);
        return playMaxOfSuite(suitsExceptTrumpIHave.get(randomSuite), true);
    }

    /**
     * This plays max of a suite and removes that card from this player.
     *
     * @param suite  The {@link Suite} which I need to play
     * @param remove This also removes the card. Set this as true if you are sure to play this card
     * @return The {@link Card} which I play in the Hand
     */
    private Card playMaxOfSuite(Suite suite, boolean remove) {
        return null;
    }

    /**
     * This plays min of a suite and removes that card from this player.
     *
     * @param suite  The {@link Suite} which I need to play
     * @param remove This also removes the card. Set this as true if you are sure to play this card
     * @return The {@link Card} which I play in the Hand
     */
    private Card playMinOfSuite(Suite suite, boolean remove) {
        return null;
    }
}