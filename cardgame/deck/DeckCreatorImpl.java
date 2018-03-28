package com.ishan.graph.cardgame.deck;

import com.ishan.graph.cardgame.card.Card;
import com.ishan.graph.cardgame.card.Suite;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public class DeckCreatorImpl implements DeckCreator {

    /**
     * @return Returns a Random {@link Deck}
     * @implSpec This creates a cardgame by picking up a random number and a random suite, if that already exists, it
     * discards it and continues
     */
    @Override
    public Deck createRandomDeck() {
        Set<Card> cardsCreated = new LinkedHashSet<>(52);
        Random random = new Random(System.currentTimeMillis());
        while (cardsCreated.size() != 52) {
            Card card = createRandomCard(random);
            if (!cardsCreated.contains(card)) {
                //This is a new card, lets add it to the set
                cardsCreated.add(card);
            }
        }
        return new Deck(new ArrayList<>(cardsCreated));
    }

    private Card createRandomCard(Random random) {
        int value = 1 + random.nextInt(13);
        int suiteInt = random.nextInt(4);
        Suite suite = Suite.values()[suiteInt];
        return new Card(value, suite);
    }
}