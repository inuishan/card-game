package com.ishan.graph.cardgame.deck;

import com.ishan.graph.cardgame.card.Card;

import java.util.List;

/**
 * Represents a random cardgame of cards
 *
 * @author ishanjain
 * @since 28/03/18
 */
public class Deck {

    /**
     * The cards in the cardgame.
     */
    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Deck{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}