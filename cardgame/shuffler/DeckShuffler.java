package com.ishan.graph.cardgame.shuffler;

import com.ishan.graph.cardgame.Player;
import com.ishan.graph.cardgame.deck.Deck;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public interface DeckShuffler {

    void shuffle(Deck deck, Player[] players);
}